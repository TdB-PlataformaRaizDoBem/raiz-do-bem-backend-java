package RaizDoBem.DAO;

import RaizDoBem.Model.*;

import java.sql.*;
import java.time.LocalDate;

public class DentistaDAO {
    public void adicionar(Dentista dentista){
        String querySql = "INSERT INTO Dentista (cpf, nome_completo, data_nascimento, email, id_endereco, cro, disponivel ) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, dentista.getCpf());
            ps.setString(2, dentista.getNomeCompleto());
            ps.setDate(3, Date.valueOf(dentista.getDataNascimento()));
            ps.setString(4, dentista.getEmail());
            ps.setInt(5, dentista.getEndereco().getId());
            ps.setString(6, dentista.getCroDentista());
            ps.setBoolean(7, dentista.isDisponivel());

            ps.executeUpdate();
            System.out.println("Dentista criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar dentista: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT * FROM Dentista";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Dentista dentista;

            response = ps.executeQuery();
            System.out.println("Listagem dos dentistas: ");
            while(response.next()){
                int id = response.getInt("id");
                String descricao = response.getString("descricao");
                LocalDate dataAtendimento = response.getDate("data").toLocalDate();
                int idBeneficiario = response.getInt("id_beneficiario");
                int idDentista = response.getInt("id_dentista");

                //dentista = new Atendimento(id, descricao, dataAtendimento, idBeneficiario, idDentista);
                //System.out.println(dentista);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos: " + exception.getMessage());
        }
    }
}
