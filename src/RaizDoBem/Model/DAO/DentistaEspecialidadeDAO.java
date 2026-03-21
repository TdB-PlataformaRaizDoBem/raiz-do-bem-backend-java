package RaizDoBem.Model.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Dentista;
import RaizDoBem.Model.DentistaEspecialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ps.setInt(1, dentistaEspecialidade.getDentista().getId());
            ps.setInt(2, dentistaEspecialidade.getEspecialidade().getId());

            ps.executeUpdate();
            System.out.println("Adicionada nova relação Dentista - Especialidade !!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar relação: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT de.id_dentista, d.nome_completo, de.id_especialidade, e.especialidade FROM Dentista_Especialidade de, Dentista d, Especialidade e WHERE de.id_dentista = d.id_dentista and de.id_especialidade = e.id_especialidade";
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
            System.out.println("Erro ao listar os dentistas: " + exception.getMessage());
        }
    }
    public void listarEspecialidadesUnicoDentista(int idDentista){}
    public void listarDentistasComEspecialidade(String especialidade){}
}
