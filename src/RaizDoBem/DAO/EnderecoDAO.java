package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {

    public void adicionar(Endereco endereco){
        String querySql = "INSERT INTO Endereco (logradouro, cep, numero, cidade, estado) VALUES (?, ?, ?, ?, ?)";

        try{
            Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);

            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getNumero());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());

            ps.executeUpdate();
            System.out.println("Endereço criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar endereço:" + exception.getMessage());
        }
    }
}
