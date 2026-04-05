package RaizDoBem.model.dao;

import RaizDoBem.model.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    * Classe de acesso a dados para a entidade Beneficiario. Esta classe é responsável por realizar operações de banco de dados relacionadas aos beneficiários, como adicionar, listar, buscar por CPF, listar por programa social, listar por cidade, atualizar e excluir beneficiários. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa consultas SQL para manipular os dados dos beneficiários.
    * @author Paulo
    * @since 2026-03
    * adicionar: Este método recebe um objeto Beneficiario como parâmetro e adiciona um novo beneficiário ao banco de dados. Ele executa uma consulta SQL de inserção para adicionar os dados do beneficiário fornecido ao banco de dados.
    * listarTodos: Este método retorna uma lista de todos os beneficiários cadastrados no banco de dados. Ele executa uma consulta SQL para recuperar todos os beneficiários e utiliza o método mapeamento para converter cada resultado da consulta em um objeto Beneficiario, que é adicionado a uma lista de beneficiários.
    * buscarPorCpf: Este método recebe um CPF como parâmetro e retorna um objeto Beneficiario correspondente ao CPF fornecido. Ele executa uma consulta SQL para buscar o beneficiário com o CPF especificado e utiliza o método mapeamento para converter o resultado da consulta em um objeto Beneficiario.
    * buscarPorPrograma: Este método recebe um ID de programa social como parâmetro e retorna uma lista de beneficiários que fazem parte desse programa. Ele executa uma consulta SQL para buscar os beneficiários associados ao programa social especificado e utiliza o método mapeamento para converter cada resultado da consulta em um objeto Beneficiario, que é adicionado a uma lista de beneficiários.
    * listarPorCidade: Este método recebe uma cidade como parâmetro e retorna uma lista de beneficiários que residem nessa cidade. Ele executa uma consulta SQL para buscar os beneficiários associados à cidade especificada e utiliza o método mapeamento para converter cada resultado da consulta em um objeto Beneficiario, que é adicionado a uma lista de beneficiários.
    * atualizar: Este método recebe um CPF e um objeto Beneficiario como parâmetros e atualiza os dados de um beneficiário existente no banco de dados com base no CPF fornecido. Ele executa uma consulta SQL de atualização para modificar os dados do beneficiário correspondente ao CPF especificado.
    * excluir: Este método recebe um CPF como parâmetro e remove o beneficiário correspondente a esse CPF do banco de dados. Ele executa uma consulta SQL de exclusão para remover o beneficiário com o CPF especificado do banco de dados.
    * Esses métodos permitem que o sistema manipule os dados dos beneficiários de forma eficiente, realizando operações de criação, leitura, atualização e exclusão conforme necessário, e garantindo a integridade dos dados no banco de dados.
 */
public class BeneficiarioDAO {
    private Beneficiario mapeamento(ResultSet response) throws SQLException {
        return new Beneficiario(
                response.getInt("id_beneficiario"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                response.getString("telefone"),
                response.getString("email"),
                response.getInt("id_pedido_ajuda"),
                response.getInt("id_programa_social"),
                response.getInt("id_endereco"));
    }

    public void adicionar(Beneficiario beneficiario) {
        String querySql = "INSERT INTO Beneficiario (cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, beneficiario.getCpf());
            ps.setString(2, beneficiario.getNomeCompleto());
            ps.setDate(3, Date.valueOf(beneficiario.getDataNascimento()));
            ps.setString(4, beneficiario.getTelefone());
            ps.setString(5, beneficiario.getEmail());
            ps.setInt(6, beneficiario.getIdProgramaSocial());
            ps.setInt(7, beneficiario.getIdPedidoAjuda());
            ps.setInt(8, beneficiario.getIdEndereco());

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao adicionar beneficiário: " + exception.getMessage());
        }
    }

    /**
     * O metodo listarTodos() é responsável por recuperar e exibir todos os
     * registros de beneficiários presentes no banco de dados. Ele executa uma
     * consulta SQL para selecionar as colunas relevantes da tabela Beneficiario, e
     * itera sobre os resultados para criar objetos Beneficiario e exibi-los.
     */
    public List<Beneficiario> listarTodos() {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        String querySql = "SELECT id_beneficiario, cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco FROM Beneficiario";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery();) {

            while (response.next()) {
                beneficiarios.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar beneficiários: " + exception.getMessage());
        }
        return beneficiarios;
    }

    public Beneficiario buscarPorCpf(String cpf) {
        String querySql = "SELECT id_beneficiario, cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco FROM Beneficiario WHERE cpf = ?";
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

    public List<Beneficiario> buscarPorPrograma(int idPrograma) {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        String querySql = "SELECT id_beneficiario, cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco FROM Beneficiario WHERE id_programa_social = ?";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setInt(1, idPrograma);

            try (ResultSet response = ps.executeQuery();) {
                while (response.next()) {
                    beneficiarios.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar beneficiários: " + exception.getMessage());
        }
        return beneficiarios;
    }

    public List<Beneficiario> listarPorCidade(String cidade) {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        String querySql = "SELECT b.id_beneficiario, b.cpf, b.nome_completo, b.data_nascimento, b.telefone, b.email, b.id_programa_social, b.id_pedido_ajuda, b.id_endereco, e.cidade FROM Beneficiario b, Endereco e WHERE e.cidade = ? AND b.id_endereco = e.id_endereco";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cidade);

            try (ResultSet response = ps.executeQuery();) {
                while (response.next()) {
                    beneficiarios.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar beneficiários por cidade: " + exception.getMessage());
        }
        return beneficiarios;
    }

    public void atualizar(String cpf, Beneficiario beneficiario) {
        String querySql = "UPDATE Beneficiario SET telefone = ?, email = ?, id_endereco = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, beneficiario.getTelefone());
            ps.setString(2, beneficiario.getEmail());
            ps.setInt(3, beneficiario.getIdEndereco());
            ps.setString(4, cpf);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar beneficiário: " + exception.getMessage());
        }
    }

    public void excluir(String cpf) {
        String querySql = "DELETE FROM beneficiario WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir beneficiário: " + exception.getMessage());
        }
    }
}
