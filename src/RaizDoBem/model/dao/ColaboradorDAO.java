package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados dos Coordenadores da ONG.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete)
 * relacionadas aos coordenadores.
 * 
 * @author Paulo
 * @since 2026-03
 *
 */
public class ColaboradorDAO {
    public Colaborador mapeamento(ResultSet response) throws SQLException {
        return new Colaborador(
                response.getInt("id_colaborador"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                response.getDate("data_contratacao").toLocalDate(),
                response.getString("email"));
    }

    public void adicionar(Colaborador colaborador) {
        String querySql = "INSERT INTO colaborador (cpf, nome_completo, data_nascimento,data_contratacao, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, colaborador.getCpf());
            ps.setString(2, colaborador.getNomeCompleto());
            ps.setDate(3, Date.valueOf(colaborador.getDataNascimento()));
            ps.setDate(4, Date.valueOf(colaborador.getDataContratacao()));
            ps.setString(5, colaborador.getEmail());

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao adicionar colaborador: " + exception.getMessage());
        }
    }

    public List<Colaborador> listarTodos() {
        String querySql = "SELECT id_colaborador, cpf, nome_completo, data_nascimento,data_contratacao, email FROM Colaborador";
        List<Colaborador> colaboradores = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                colaboradores.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar colaboradores: " + exception.getMessage());
        }
        return colaboradores;
    }

    public Colaborador buscarPorCpf(String cpf) {
        String querySql = "SELECT id_colaborador,  cpf, nome_completo, data_nascimento,data_contratacao, email FROM Colaborador WHERE cpf = ?";
        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery();) {
                if (response.next()) {
                    return mapeamento(response);
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar cpf: " + exception.getMessage());
        }
        return null;
    }

    public void atualizar(Colaborador colaborador, String cpf) {
        String querySql = "UPDATE colaborador SET email = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, colaborador.getEmail());
            ps.setString(2, cpf);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar colaborador: " + exception.getMessage());
        }
    }

    public void excluir(String cpf) {
        String querySql = "DELETE FROM colaborador WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir colaborador: " + exception.getMessage());
        }
    }
}
