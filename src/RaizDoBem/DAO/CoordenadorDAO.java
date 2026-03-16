package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Coordenador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CoordenadorDAO {
    public void adicionar(Coordenador coord){
        String querySql = "INSERT INTO Coordenador (cpf, nome_completo, data_nascimento, email, id_endereco, data_contratacao, nivel_acesso) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, coord.getCpf());
            ps.setString(2, coord.getNomeCompleto());
            ps.setDate(3, Date.valueOf(coord.getDataNascimento()));
            ps.setString(4, coord.getEmail());
            ps.setInt(5, coord.getEndereco().getIdEndereco());
            ps.setDate(6, Date.valueOf(coord.getDataContratacao()));
            ps.setString(7, coord.getNivelAcesso());

            ps.executeUpdate();
            System.out.println("Coordenador criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar coordenador: " + exception.getMessage());
        }
    }
}
