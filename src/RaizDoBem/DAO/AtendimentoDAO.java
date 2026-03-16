package RaizDoBem.DAO;

import RaizDoBem.Model.*;

import java.sql.*;
import java.time.LocalDate;

public class AtendimentoDAO {
    public void adicionar(Atendimento atendimento){
        String querySql = "INSERT INTO Atendimento (descricao, data, id_beneficiario, id_dentista) VALUES (?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, atendimento.getDescricao());
            ps.setDate(2, Date.valueOf(atendimento.getDataAtendimento()));
            ps.setInt(3, atendimento.getBeneficiario().getIdBeneficiario());
            ps.setInt(4, atendimento.getDentista().getIdColaborador());

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
                String descricao = response.getString("descricao");
                LocalDate dataAtendimento = response.getDate("data").toLocalDate();
                int idBeneficiario = response.getInt("id_beneficiario");
                int idDentista = response.getInt("id_dentista");

                //atendimento = new Atendimento(id, descricao, dataAtendimento, idBeneficiario, idDentista);
                //System.out.println(atendimento);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos:" + exception.getMessage());
        }
    }
}
