package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.DentistaPrograma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade DentistaPrograma.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas à relação entre dentistas e público atendido por ele.
 * @author Paulo
 * @since 2026-03
 *
 */
public class DentistaProgramaDAO {
    public void adicionar(DentistaPrograma dentistaPrograma){
        String querySql = "INSERT INTO dentista_programa VALUES (?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, dentistaPrograma.getDentista().getId());
            ps.setInt(2, dentistaPrograma.getPrograma().getId());

            ps.executeUpdate();
            //System.out.println("Adicionada nova relação Dentista - Programa Social!!");
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar relação: " + exception.getMessage());
        }
    }
    public void listarPublicoDentista(int idDentista){



    }
    public List<Dentista> listarDentistasPrograma(String programa){
        DentistaDAO dao = new DentistaDAO();
        String querySql = "SELECT d.id_colaborador,d.cro, c.cpf, c.nome_completo, c.data_nascimento,c.email, d.disponivel, e.logradouro, e.numero FROM Dentista d, Colaborador c, Endereco e";
        List<Dentista> dentistas = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            while(response.next())
                dentistas.add(dao.mapeamento(response));
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar dentistas: " + exception.getMessage());
        }
        return dentistas;
    }
    public void excluirRelacao(int id){
        String querySql = "DELETE FROM dentista_programa WHERE id = ? ";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir relação: " + exception.getMessage());
        }
    }
}
