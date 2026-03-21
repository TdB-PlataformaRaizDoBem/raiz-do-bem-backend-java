package RaizDoBem.DAO;

import RaizDoBem.Model.Beneficiario;
import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Endereco;

import java.sql.*;
import java.time.LocalDate;

/**
 * Classe responsável por realizar operações de acesso a dados relacionadas aos beneficiários da ONG. Contém métodos para adicionar, listar, atualizar e excluir beneficiários no banco de dados.
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioDAO {
    private Beneficiario mapeamento(ResultSet response) throws SQLException {
        return new Beneficiario(
            response.getString("cpf"),
            response.getString("nome_completo"),
            response.getDate("data_nascimento").toLocalDate(),
            response.getString("telefone"),
            response.getString("email"),
            response.getInt("id_sexo"),
            response.getInt("id_programa"),
            response.getInt("id_endereco"),
            response.getInt("id_pedido_ajuda"),
            response.getInt("id_coordenador")
        );
    }
    public void adicionar(Beneficiario beneficiario){
        String querySql = "INSERT INTO Beneficiario (cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa_social, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            ps.setString(1, beneficiario.getCpf());
            ps.setString(2, beneficiario.getNomeCompleto());
            ps.setDate(3, Date.valueOf(beneficiario.getDataNascimento()));
            ps.setString(4, beneficiario.getTelefone());
            ps.setString(5, beneficiario.getEmail());
            ps.setInt(6, beneficiario.getSexo().getId());
            ps.setInt(7, beneficiario.getProgramaSocial().getId());
            ps.setInt(8, beneficiario.getEndereco().getId());

            ps.executeUpdate();
            System.out.println("Beneficiário criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar beneficiário: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa, id_endereco, id_pedido_ajuda, id_coordenador FROM Beneficiario";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            try(ResultSet response = ps.executeQuery();){
                System.out.println("Listagem dos beneficiários: ");
                while(response.next()){
                    Beneficiario beneficiario = mapeamento(response);
                    System.out.println(beneficiario);
                }
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos: " + exception.getMessage());
        }
    }
    public void listarBeneficiarioUnico(){

    }
    public void listarPorPrograma(){

    }
    public void listarPorCidade(){

    }
    public void atualizarBeneficiario(int idSelecionado){}
    public void excluirBeneficiario(int idSelecionado){
        String querySql = "DELETE FROM beneficiario WHERE id = " + idSelecionado;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.executeUpdate();
            System.out.println("Beneficiario ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            System.out.println("Erro ao excluir beneficiário: " + exception.getMessage());
        }
    }
}
