package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Endereco;
import RaizDoBem.Model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialidadeDAO {
    public void adicionar(Especialidade especialidade){
        String querySql = "INSERT INTO Especialidade (descricao) VALUES (?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, especialidade.getDescricao());

            ps.executeUpdate();
            System.out.println("Nova especialidade criada e adicionada com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar nova especialidade: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT id, descricao FROM especialidade";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Especialidade especialidade;

            response = ps.executeQuery();
            System.out.println("Listagem dos endereços: ");
            while(response.next()){
                int id = response.getInt("id");
                String descricao = response.getString("descricao");

                //descricao = new Especialidade(id, descricao);
                System.out.println(descricao);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar endereços:" + exception.getMessage());
        }
    }
}
