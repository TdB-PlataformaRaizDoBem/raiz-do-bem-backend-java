package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.DentistaPrograma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DentistaProgramaDAO {
    public void adicionar(DentistaPrograma dentistaPrograma){
        String querySql = "INSERT INTO dentista_programa VALUES (?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, dentistaPrograma.getDentista().getId());
            ps.setInt(2, dentistaPrograma.getPrograma().getId());

            ps.executeUpdate();
            System.out.println("Adicionada nova relação Dentista - Programa Social!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar relação: " + exception.getMessage());
        }
    }
    public void listarPublicoDentista(int idDentista){}
    public void listarDentistasPrograma(String programa){}
    public void excluirRelacao(){}
}
