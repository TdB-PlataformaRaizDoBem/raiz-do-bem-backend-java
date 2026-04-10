package RaizDoBem.model.dao;

import RaizDoBem.model.vo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade DentistaEspecialidade.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas às especialidades dos dentistas.
 * @author Paulo
 * @since 2026-03
 *
 */
public class DentistaEspecialidadeDAO {
    public DentistaEspecialidade mapeamento(ResultSet response) throws SQLException {
        return new DentistaEspecialidade(
                response.getInt("id_dentista"),
                response.getInt("id_especialidade")
        );
    }
    public void adicionar(DentistaEspecialidade dentistaEspecialidade){
        String querySql = "INSERT INTO dentista_especialidade VALUES (?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, dentistaEspecialidade.getIdDentista());
            ps.setInt(2, dentistaEspecialidade.getIdEspecialidade());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar relação: " + exception.getMessage());
        }
    }
    public List<DentistaEspecialidade> listarTodos(){
        String querySql = "SELECT de.id_dentista, d.nome_completo, de.id_especialidade, e.descricao FROM Dentista_Especialidade de, Dentista d, Especialidade e WHERE de.id_dentista = d.id_dentista and de.id_especialidade = e.id_especialidade";
        List<DentistaEspecialidade> dentistaEspecialidades = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){
                
            while(response.next()){
                dentistaEspecialidades.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar os dentistas e suas especialidades: " + exception.getMessage());
        }
        return dentistaEspecialidades;
    }
}
