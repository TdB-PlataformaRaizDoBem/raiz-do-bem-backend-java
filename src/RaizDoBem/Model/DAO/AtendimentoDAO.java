package RaizDoBem.Model.DAO;

import RaizDoBem.Model.*;

import java.sql.*;
import java.time.LocalDate;

/**
 * Classe de acesso a dados para a entidade Atendimento.
 * Responsável por realizar operações de Criação, Leitura, e atualização relacionadas aos atendimentos aos benefciários.
 * @author Paulo
 * @since 2026-03
 *
 */
public class AtendimentoDAO {
    /** O atendimento é o registro de um serviço prestado a um beneficiário, realizado por um dentista, numa data específica. O coordenador pode criar um atendimento para registrar um serviço prestado, listar os atendimentos realizados, e encontrar atendimentos relacionados a um beneficiário ou dentista específico.
     * */
    public void adicionar(Atendimento atendimento){
        String querySql = "INSERT INTO Atendimento (descricao_atendimento, data, id_beneficiario, id_dentista) VALUES (?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, atendimento.getDescricaoAtendimento());
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
    public void listarTodos(){
        String querySql = "SELECT * FROM Atendimento";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Atendimento atendimento;

            response = ps.executeQuery();
            System.out.println("Listagem dos atendimentos: ");
            while(response.next()){
                int id = response.getInt("id");
                String descricaoAtendimento = response.getString("descricao_atendimento");
                LocalDate dataAtendimento = response.getDate("data").toLocalDate();
                int idBeneficiario = response.getInt("id_beneficiario");
                int idDentista = response.getInt("id_dentista");

                //atendimento = new Atendimento(id, descricao, dataAtendimento, idBeneficiario, idDentista);
                //System.out.println(atendimento);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos: " + exception.getMessage());
        }
    }
    /** O metodo encontrarAtendimentoBeneficiario() é responsável por recuperar e exibir os registros de atendimentos relacionados a um beneficiário específico. Ele executa uma consulta SQL que seleciona os atendimentos onde o id_beneficiario corresponde ao id do beneficiário fornecido como parâmetro, e itera sobre os resultados para criar objetos Atendimento e exibi-los. */
    public void encontrarAtendimentoBeneficiario(){}
    /** O metodo encontrarAtendimentoDentista() é responsável por recuperar e exibir os registros de atendimentos relacionados a um dentista específico. Ele executa uma consulta SQL que seleciona os atendimentos onde o id_dentista corresponde ao id do dentista fornecido como parâmetro, e itera sobre os resultados para criar objetos Atendimento e exibi-los. */
    public void encontrarAtendimentosDentista(){}
}
