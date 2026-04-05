package RaizDoBem.model.dao;

import RaizDoBem.model.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de acesso a dados relacionadas aos
 * beneficiários da ONG. Contém métodos para adicionar, listar, atualizar e
 * excluir beneficiários no banco de dados.
 * 
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioDAO {
    List<Beneficiario> beneficiarios = new ArrayList<>();

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

    /**
     * O metodo listagemPorCidade() é responsável por recuperar e exibir os
     * registros de beneficiários relacionados a uma cidade específica. Ele executa
     * uma consulta SQL que seleciona os beneficiários onde o id_endereco
     * corresponde ao id do endereço fornecido como parâmetro, e itera sobre os
     * resultados para criar objetos Beneficiario e exibi-los.
     */
    public List<Beneficiario> listarPorCidade(String cidade) {
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

    /**
     * O metodo excluirBeneficiario() é responsável por excluir um beneficiário
     * específico do banco de dados. Ele recebe o id do beneficiário a ser excluído
     * como parâmetro, prepara uma consulta SQL de exclusão e executa a operação
     * para remover o beneficiário do sistema.
     * 
     * @param cpf
     */
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
