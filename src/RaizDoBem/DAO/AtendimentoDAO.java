package RaizDoBem.DAO;

import RaizDoBem.Model.*;

import java.sql.*;
import java.time.LocalDate;

public class AtendimentoDAO {
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

    public void excluirAtendimento(int idSelecionado){
        String querySql = "DELETE FROM atendimento WHERE id = " + idSelecionado;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.executeUpdate();
            System.out.println("Atendimento ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            System.out.println("Erro ao excluir atendimento: " + exception.getMessage());
        }
    }
}
