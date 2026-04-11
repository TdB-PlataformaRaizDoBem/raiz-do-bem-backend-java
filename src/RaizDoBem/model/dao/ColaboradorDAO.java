package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsavel pelas operacoes de persistencia e mapeamento de ColaboradorDAO.
 * Camada: DAO.
 */
public class ColaboradorDAO {
    /**
     * Mapeia dados de origem para o objeto de dominio correspondente.
     * @param response parametro da operacao.
     * @return resultado da operacao.
     */
    public Colaborador mapeamento(ResultSet response) throws SQLException {
        return new Colaborador(
                response.getInt("id_colaborador"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                response.getDate("data_contratacao").toLocalDate(),
                response.getString("email"));
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param colaborador parametro da operacao.
     */
    public void adicionar(Colaborador colaborador) {
        String querySql = "INSERT INTO colaborador (cpf, nome_completo, data_nascimento,data_contratacao, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

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

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
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

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Colaborador buscarPorCpf(String cpf) {
        String querySql = "SELECT id_colaborador,  cpf, nome_completo, data_nascimento,data_contratacao, email FROM Colaborador WHERE cpf = ?";
        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery()) {
                if (response.next()) {
                    return mapeamento(response);
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar cpf: " + exception.getMessage());
        }
        return null;
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param colaborador parametro da operacao.
     * @param cpf parametro da operacao.
     */
    public void atualizar(Colaborador colaborador, String cpf) {
        String querySql = "UPDATE colaborador SET email = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, colaborador.getEmail());
            ps.setString(2, cpf);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar colaborador: " + exception.getMessage());
        }
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluir(String cpf) {
        String querySql = "DELETE FROM colaborador WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir colaborador: " + exception.getMessage());
        }
    }
}
