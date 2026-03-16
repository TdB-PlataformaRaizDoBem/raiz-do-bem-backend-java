package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
