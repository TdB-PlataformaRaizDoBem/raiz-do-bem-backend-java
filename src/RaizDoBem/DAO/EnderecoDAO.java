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
        String querySql = "INSERT INTO Endereco (logradouro, cep, numero, cidade, estado, id_tipo_endereco) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){

            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getNumero());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setInt(6, endereco.getTipoEndereco().getIdTipoEndereco());

            ps.executeUpdate();
            System.out.println("Endereço criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar endereço: " + exception.getMessage());
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
                int idTipoEndereco = response.getInt("id_tipo_endereco");

                endereco = new Endereco(id, logradouro, cep, numero, cidade, estado, idTipoEndereco);
                System.out.println(endereco);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar endereço:" + exception.getMessage());
        }
    }
}
