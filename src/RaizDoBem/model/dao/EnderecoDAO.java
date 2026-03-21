package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Endereço, que armazena informações das pessoas registradas no sistema da Turma do Bem.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos endereços das pessoas envolvidas na plataforma.
 * @author Paulo
 * @since 2026-03
 *
 *
 */
public class EnderecoDAO {
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
        String querySql = "INSERT INTO Endereco logradouro, cep, numero, bairro, cidade, estado, id_tipo_endereco VALUES (?, ?, ?, ?, ?, ?, ?)";

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
            System.out.println("Endereço criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar endereço: " + exception.getMessage());
        }
    }
    public List<Endereco> listarTodos(){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.bairro, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco";

        List<Endereco> enderecos = new ArrayList<>();

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
    public Endereco buscarPorId(int idselecionado){
        String querySql = "SELECT e.id, e.logradouro, e.cep, e.numero, e.bairro, e.cidade, e.estado, e.id_tipo_endereco, tipo.localizacao FROM Endereco e, Tipo_Endereco tipo WHERE tipo.id = e.id_tipo_endereco AND e.id = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ){
            ps.setInt(1, idselecionado);

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

        List<Endereco> enderecos = new ArrayList<>();

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
    public void atualizar(int idSelecionado, Endereco endereco){
        String querySql = "UPDATE Endereco SET logradouro = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, id_tipo_endereco = ? WHERE id = ?";

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
            ps.setInt(8, idSelecionado);

            ps.executeUpdate();
            System.out.println("Endereço ID - (" + idSelecionado + ") atualizado com sucesso!!");
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
            //System.out.println("Endereço ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir endereço: " + exception.getMessage());
        }
    }
}
