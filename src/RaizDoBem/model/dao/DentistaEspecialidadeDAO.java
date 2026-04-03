package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.DentistaEspecialidade;
import RaizDoBem.model.vo.Especialidade;

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
    public void adicionar(DentistaEspecialidade dentistaEspecialidade){
        String querySql = "INSERT INTO dentista_especialidade VALUES (?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, dentistaEspecialidade.getIdDentista());
            ps.setInt(2, dentistaEspecialidade.getIdEspecialidade());

            ps.executeUpdate();
            //System.out.println("Adicionada nova relação Dentista - Especialidade !!");
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar relação: " + exception.getMessage());
        }
    }
    public List<DentistaEspecialidade> listarTodos(){
        String querySql = "SELECT de.id_dentista, d.nome_completo, de.id_especialidade, e.especialidade FROM Dentista_Especialidade de, Dentista d, Especialidade e WHERE de.id_dentista = d.id_dentista and de.id_especialidade = e.id_especialidade";
        List<DentistaEspecialidade> lista = new ArrayList<>();
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Dentista dentistaEspecialidade;

            response = ps.executeQuery();
            System.out.println("Listagem dos dentistas: ");
            while(response.next()){
                int idDentista = response.getInt("id_dentista");
                String nomeDentista = response.getString("nome_completo");
                int idEspecialidade = response.getInt("id_especialidade");
                String nomeEspecialidade = response.getString("especialidade");

//              dentistaEspecialidade = new DentistaEspecialidade(idDentista, idEspecialidade);
//              System.out.println(dentistaEspecialidade);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar os dentistas: " + exception.getMessage());
        }
        return lista;
    }
    public List<Especialidade> listarEspecialidadesUnicoDentista(int idDentista){
        List<Especialidade> especialidades = new ArrayList<>();
        return especialidades;
    }
    public List<Dentista> listarDentistasComEspecialidade(String especialidade){
        List<Dentista> dentistas = new ArrayList<>();
        return dentistas;
    }
}
