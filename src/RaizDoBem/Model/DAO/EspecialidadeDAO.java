package RaizDoBem.Model.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Especialidade, que representam as áreas odontológicas.
 * Responsável por realizar apenas operações de listagem, não teriam as outras operações, pois Especialidades seriam mais fixas no sistema.
 * @author Paulo
 * @since 2026-03
 *
 */
public class EspecialidadeDAO {
    public List<Especialidade> listarTodos(){
        String querySql = "SELECT id, descricao FROM especialidade";
        List<Especialidade> especialidades = new ArrayList<Especialidade>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            while(response.next()){
                int id = response.getInt("id");
                String descricao = response.getString("descricao");

                especialidades.add(new Especialidade(id, descricao));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar especialidades:" + exception.getMessage(), exception);
        }
        return especialidades;
    }
}
