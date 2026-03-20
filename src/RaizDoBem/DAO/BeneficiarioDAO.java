package RaizDoBem.DAO;

import RaizDoBem.Model.Beneficiario;
import RaizDoBem.Model.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class BeneficiarioDAO {
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
        String querySql = "SELECT * FROM Beneficiario";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Beneficiario beneficiario;

            response = ps.executeQuery();
            System.out.println("Listagem dos beneficiários: ");
            while(response.next()){
                int id = response.getInt("id");
                String cpf = response.getString("cpf");
                String nomeCompleto = response.getString("nome_completo");
                LocalDate dataNascimento = response.getDate("data_nascimento").toLocalDate();
                String email = response.getString("email");
                int idSexo = response.getInt("id_sexo");
                int idProgramaSocial = response.getInt("id_programa");
                int idEndereco = response.getInt("id_endereco");
                int idPedido = response.getInt("id_pedido_ajuda");
                int idCoordenador = response.getInt("id_coordenador");

                //beneficiario = new Atendimento(id, descricao, dataAtendimento, idBeneficiario, idDentista);
                //System.out.println(beneficiario);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos: " + exception.getMessage());
        }
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
