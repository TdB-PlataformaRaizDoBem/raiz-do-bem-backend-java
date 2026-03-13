package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Endereco;
import RaizDoBem.Model.TipoEndereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

    public void adicionar(Endereco endereco){
        String querySql = "INSERT INTO Endereco (logradouro, cep, numero, cidade, estado) VALUES (?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){

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
    public void listarTodos(){
        String querySql = "SELECT * FROM Endereco";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Endereco endereco;

            response = ps.executeQuery();
            System.out.println("Listagem dos endereços: ");
            while(response.next()){
                int id = response.getInt("id");
                String logradouro = response.getString("logradouro");
                String cep = response.getString("cep");
                String numero = response.getString("numero");
                String cidade = response.getString("cidade");
                String estado = response.getString("estado");

                endereco = new Endereco(id, logradouro, cep, numero, cidade, estado);
                System.out.println(endereco);
                //TipoEndereco  = response.getString("logradouro");
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar endereço:" + exception.getMessage());
        }
    }
}
