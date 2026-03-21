package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Endereco;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Classe de acesso a dados para a entidade Endereço, que armazena informações das pessoas registradas no sistema da Turma do Bem.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos endereços das pessoas envolvidas na plataforma.
 * @author Paulo
 * @since 2026-03
 *
 *
 */
public class EnderecoDAO {
    List<Endereco> enderecos = new ArrayList<>();
    public Endereco mapeamento(ResultSet response) throws SQLException {
        return new Endereco(
                response.getInt("id"),
                response.getString("logradouro"),
                response.getString("cep"),
                response.getString("numero"),
                response.getString("bairro"),
                response.getString("cidade"),
                response.getString("estado"),
                response.getInt("id_tipo_endereco"),
                response.getString("localizacao")
        );
    }
    public void adicionar(Endereco endereco){
        String querySql = "INSERT INTO Endereco (logradouro, cep, numero, bairro, cidade, estado, id_tipo_endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){

            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getNumero());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getEstado());
            ps.setInt(7, endereco.getTipoEndereco().getId());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar endereço: " + exception.getMessage(), exception);
        }
    }
    public List<Endereco> listarTodos(){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.bairro, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();) {

            while(response.next())
                enderecos.add(mapeamento(response));
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar endereços:" + exception.getMessage());
        }
        return enderecos;
    }
    public Endereco buscarPorId(int id){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.bairro, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco AND e.id = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){
            ps.setInt(1, id);

            try(ResultSet response = ps.executeQuery();){
                if(response.next())
                    return mapeamento(response);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar endereços: " + exception.getMessage());
        }
        return null;
    }
    public List<Endereco> listarPorCidade(String cidade){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.bairro, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco AND e.cidade = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cidade);

            try(ResultSet response = ps.executeQuery();){
                while(response.next())
                    enderecos.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar endereços:" + exception.getMessage());
        }
        return enderecos;
    }
    public void atualizar(int id, Endereco endereco){
        String querySql = "UPDATE Endereco SET logradouro = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, id_tipo_endereco = ? WHERE id = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){

            try(ResultSet response = ps.executeQuery();){
                while(response.next())
                    enderecos.add(mapeamento(response));
            }
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao atualizar endereço: " + exception.getMessage());
        }
    }
    public void excluir(int id){
        String querySql = "DELETE FROM Endereco WHERE id = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir endereço: " + exception.getMessage());
        }
    }
}
