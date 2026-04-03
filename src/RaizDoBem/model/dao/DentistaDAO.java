package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Dentista;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para os dentistas que prestarão serviço a ONG.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos dentistas.
 * @author Paulo
 * @since 2026-03
 *
 */
public class DentistaDAO {
    public Dentista mapeamento(ResultSet response) throws SQLException {
        return new Dentista(
                response.getInt("id"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                response.getString("email"),
                response.getInt("id_endereco"),
                response.getInt("id_sexo"),
                response.getString("cro"),
                response.getString("disponivel").equals("Disponível"));
    }
    public Dentista buscarPorCpf(String cpf){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento,c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero FROM Dentista d, Colaborador c, Sexo s, Endereco e WHERE cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, cpf);

            try(ResultSet response = ps.executeQuery();){
                if(response.next())
                    return mapeamento(response);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao buscar CPF: " + exception.getMessage());
        }
        return null;
    }
    public void adicionar(Dentista dentista){
        String querySql = "INSERT INTO Dentista (cpf, nome_completo, data_nascimento, email, id_endereco, id_sexo, cro, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, dentista.getCpf());
            ps.setString(2, dentista.getNomeCompleto());
            ps.setDate(3, Date.valueOf(dentista.getDataNascimento()));
            ps.setString(4, dentista.getEmail());
            ps.setInt(5, dentista.getEndereco().getId());
            ps.setInt(6, dentista.getSexo().getId());
            ps.setString(7, dentista.getCroDentista());
            ps.setBoolean(8, dentista.isDisponivel());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar dentista: " + exception.getMessage());
        }
    }
    public List<Dentista> listarTodos(){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento,c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero FROM Dentista d, Colaborador c, Sexo s, Endereco e";
        List<Dentista> dentistas = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            while(response.next())
                dentistas.add(mapeamento(response));
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar dentistas: " + exception.getMessage());
        }
        return dentistas;
    }
    public List<Dentista> listarPorCidade(String cidade){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento, c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero FROM Dentista d, Colaborador c, Sexo s, Endereco e WHERE e.cidade  = ?";
        List<Dentista> dentistas = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setString(1, cidade);

            try(ResultSet response = ps.executeQuery();){
                while(response.next()){
                    dentistas.add(mapeamento(response));
                }
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar dentistas da cidade (" + cidade +  "): " + exception.getMessage());
        }
        return dentistas;
    }
    public List<Dentista> listarDisponiveis(){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento, c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero, e.cidade FROM Dentista d, Coordenador c, Endereco e, Sexo s WHERE d.id_coordenador = c.id AND e.disponibilidade = 'Disponível'";
        List<Dentista> dentistas = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            try(ResultSet response = ps.executeQuery();){
                while(response.next()){
                    dentistas.add(mapeamento(response));
                }
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar dentistas disponíveis: " + exception.getMessage());
        }
        return dentistas;
    }
    public void atualizar(String cpf, Dentista dentista){
        String querySql = "UPDATE Dentista SET id_tipo_endereco = ?, disponibilidade = ? WHERE cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            ps.setInt(1, dentista.getEndereco().getId());
            ps.setBoolean(2, dentista.isDisponivel());
            ps.setString(3, dentista.getCpf());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao atualizar dentista: " + exception.getMessage());
        }
    }
    public void excluir(String cpf){
        String querySql = "DELETE FROM dentista WHERE cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setString(1, cpf);
            ps.executeUpdate();
            }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir dentista: " + exception.getMessage());
        }
    }
}
