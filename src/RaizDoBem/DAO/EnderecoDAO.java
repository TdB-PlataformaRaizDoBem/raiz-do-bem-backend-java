package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Endereco;

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
            ps.setInt(6, endereco.getTipoEndereco().getId());

            ps.executeUpdate();
            System.out.println("Endereço criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar endereço: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco";

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
                String tipoEndereco = response.getString("localizacao");

                endereco = new Endereco(id, logradouro, cep, numero, cidade, estado, idTipoEndereco, tipoEndereco);
                System.out.println(endereco);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar endereços:" + exception.getMessage());
        }
    }
    public void listarPorId(int idselecionado){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.cidade, e.estado, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo\n" +
                "WHERE tipo.id = e.id_tipo_endereco AND e.id = " + idselecionado;

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
                String tipoEndereco = response.getString("localizacao");

                endereco = new Endereco(id, logradouro, cep, numero, cidade, estado, idTipoEndereco, tipoEndereco);
                System.out.println(endereco);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar endereços: " + exception.getMessage());
        }
    }
    public void listarPorCidade(String cidadeEscolhida){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco AND e.cidade = '" + cidadeEscolhida + "'";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Endereco endereco;

            response = ps.executeQuery();
            System.out.println("Listagem dos endereços da cidade (" + cidadeEscolhida + "): ");
            while(response.next()){
                int id = response.getInt("id");
                String logradouro = response.getString("logradouro");
                String cep = response.getString("cep");
                String numero = response.getString("numero");
                String cidade = response.getString("cidade");
                String estado = response.getString("estado");
                int idTipoEndereco = response.getInt("id_tipo_endereco");
                String tipoEndereco = response.getString("localizacao");

                endereco = new Endereco(id, logradouro, cep, numero, cidade, estado, idTipoEndereco, tipoEndereco);
                System.out.println(endereco);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar endereços da cidade (" + cidadeEscolhida +  "): " + exception.getMessage());
        }
    }
    public void atualizarEndereco(){

    }
    public void excluirEndereco(int idSelecionado){
        String querySql = "DELETE FROM Endereco WHERE id = " + idSelecionado;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.executeUpdate();
            System.out.println("Endereço ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            System.out.println("Erro ao excluir endereço: " + exception.getMessage());
        }
    }
}
