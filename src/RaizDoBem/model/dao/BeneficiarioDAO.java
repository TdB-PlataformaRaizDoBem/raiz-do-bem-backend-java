package RaizDoBem.model.dao;

import RaizDoBem.model.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Beneficiario. Esta classe é responsável por realizar operações de banco de dados relacionadas aos beneficiários, como adicionar um novo beneficiário, listar todos os beneficiários, buscar por CPF, buscar por programa social, listar por cidade, atualizar um beneficiário existente e excluir um beneficiário. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos beneficiários.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - adicionar: Este método recebe um objeto Beneficiario como parâmetro e realiza uma inserção no banco de dados para adicionar um novo beneficiário. Ele utiliza os atributos do objeto Beneficiario para preencher os campos da tabela de beneficiários no banco de dados.
 * 2º Metodo - listarTodos: Este método realiza uma consulta no banco de dados para recuperar todos os beneficiários cadastrados. Ele retorna uma lista de objetos Beneficiario contendo as informações de todos os beneficiários encontrados no banco de dados.
 * 3º Metodo - buscarPorCpf: Este método recebe um CPF como parâmetro e realiza uma consulta no banco de dados para encontrar um beneficiário relacionado a esse CPF. Ele retorna um objeto Beneficiario contendo as informações do beneficiário encontrado ou null se nenhum beneficiário for encontrado.
 * 4º Metodo - buscarPorPrograma: Este método recebe um ID de programa social como parâmetro e realiza uma consulta no banco de dados para encontrar beneficiários relacionados a esse programa social. Ele retorna uma lista de objetos Beneficiario contendo as informações dos beneficiários encontrados ou uma lista vazia se nenhum beneficiário for encontrado.
 * 5º Metodo - listarPorCidade: Este método recebe o nome de uma cidade como parâmetro e realiza uma consulta no banco de dados para encontrar beneficiários relacionados a essa cidade. Ele retorna uma lista de objetos Beneficiario contendo as informações dos beneficiários encontrados ou uma lista vazia se nenhum beneficiário for encontrado.
 * 6º Metodo - atualizar: Este método recebe um CPF e um objeto BeneficiarioDAO como parâmetros e realiza uma atualização no banco de dados para modificar as informações de um beneficiário existente. Ele utiliza os atributos do objeto Beneficiario para preencher os campos da tabela de beneficiários no banco de dados, atualizando o beneficiário correspondente ao CPF fornecido.
 * 7º Metodo - excluir: Este método recebe um CPF como parâmetro e realiza uma exclusão no banco de dados para remover um beneficiário existente. Ele executa uma consulta SQL de exclusão para remover o beneficiário correspondente ao CPF especificado.
 * Esses métodos permitem que a aplicação interaja com a funcionalidade de beneficiário, realizando operações de criação, listagem, busca, atualização e exclusão de beneficiários no banco de dados, e fornecendo os resultados dessas operações para a camada de negócios ou para a interface do usuário conforme necessário.
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
