package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
    * Classe de acesso a dados para a entidade Colaborador. Esta classe é responsável por realizar operações de banco de dados relacionadas aos colaboradores, como adicionar um novo colaborador, listar todos os colaboradores, buscar um colaborador por CPF, atualizar as informações de um colaborador e excluir um colaborador do sistema. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos colaboradores.
    * @author Paulo
    * @since 2026-03
    * adicionar: Este método recebe um objeto Colaborador como parâmetro e adiciona um novo colaborador ao banco de dados. Ele executa uma consulta SQL de inserção para adicionar os dados do colaborador fornecido ao banco de dados.
    * listarTodos: Este método retorna uma lista de todos os colaboradores cadastrados no banco de dados. Ele executa uma consulta SQL para recuperar todos os colaboradores e utiliza o método mapeamento para converter cada resultado da consulta em um objeto Colaborador, que é adicionado a uma lista de colaboradores.
    * buscarPorCpf: Este método recebe um CPF como parâmetro e retorna um objeto Colaborador correspondente ao CPF fornecido. Ele executa uma consulta SQL para buscar o colaborador com o CPF especificado e utiliza o método mapeamento para converter o resultado da consulta em um objeto Colaborador.
    * atualizar: Este método recebe um objeto Colaborador e um CPF como parâmetros e atualiza as informações de um colaborador existente no banco de dados com base no CPF fornecido. Ele executa uma consulta SQL de atualização para modificar os dados do colaborador correspondente ao CPF especificado.
    * excluir: Este método recebe um CPF como parâmetro e remove o colaborador correspondente a esse CPF do banco de dados. Ele executa uma consulta SQL de exclusão para remover o colaborador com o CPF especificado do banco de dados.
    * Esses métodos permitem que o sistema manipule os dados dos colaboradores de forma eficiente, realizando operações de criação, leitura, atualização e exclusão conforme necessário, e garantindo a integridade dos dados no banco de dados.
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
