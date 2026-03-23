package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Atendimento.
 * Responsável por realizar operações de Criação, Leitura, e atualização relacionadas aos atendimentos aos benefciários.
 * @author Paulo
 * @since 2026-03
 *
 */
public class AtendimentoDAO {
    private Atendimento mapeamento(ResultSet response) throws SQLException {
        return new Atendimento(
                response.getInt("id"),
                response.getString("descricao_atendimento"),
                response.getDate("data").toLocalDate(),
                response.getInt("id_beneficiario"),
                response.getInt("id_dentista")
        );
    }
    /** O atendimento é o registro de um serviço prestado a um beneficiário, realizado por um dentista, numa data específica. O coordenador pode criar um atendimento para registrar um serviço prestado, listar os atendimentos realizados, e encontrar atendimentos relacionados a um beneficiário ou dentista específico.
     * */
    public Atendimento buscarPorCpf(String cpf){
        String querySql = "SELECT id, descricao_atendimento, data, id_beneficiario, id_dentista FROM Atendimento where cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, cpf);

            try(ResultSet response = ps.executeQuery();){
                if(response.next())
                    return mapeamento(response);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao encontrar cpf: " + exception.getMessage());
        }
        return null;
    }
    public void adicionar(Atendimento atendimento){
        String querySql = "INSERT INTO Atendimento (descricao_atendimento, data, id_beneficiario, id_dentista) VALUES (?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, atendimento.getDescricao());
            ps.setDate(2, Date.valueOf(atendimento.getData()));
            ps.setInt(3, atendimento.getBeneficiario().getId());
            ps.setInt(4, atendimento.getDentista().getId());

            ps.executeUpdate();
            System.out.println("Dentista criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar novo atendimento: " + exception.getMessage());
        }
    }
    /** O metodo listarTodos() é responsável por recuperar e exibir todos os registros de atendimentos presentes no banco de dados. Ele executa uma consulta SQL para selecionar todas as colunas da tabela Atendimento, e itera sobre os resultados para criar objetos Atendimento e exibi-los. */
    public List<Atendimento> listarTodos(){
        String querySql = "SELECT id, descricao_atendimento, data, id_beneficiario, id_dentista FROM Atendimento";
        List<Atendimento> atendimentos = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            while(response.next()){
                atendimentos.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return atendimentos;
    }
    /** O metodo encontrarAtendimentoBeneficiario() é responsável por recuperar e exibir os registros de atendimentos relacionados a um beneficiário específico. Ele executa uma consulta SQL que seleciona os atendimentos onde o id_beneficiario corresponde ao id do beneficiário fornecido como parâmetro, e itera sobre os resultados para criar objetos Atendimento e exibi-los. */
    public void encontrarAtendimentoBeneficiario(){}
    /** O metodo encontrarAtendimentoDentista() é responsável por recuperar e exibir os registros de atendimentos relacionados a um dentista específico. Ele executa uma consulta SQL que seleciona os atendimentos onde o id_dentista corresponde ao id do dentista fornecido como parâmetro, e itera sobre os resultados para criar objetos Atendimento e exibi-los. */
    public void encontrarAtendimentosDentista(){}
}
