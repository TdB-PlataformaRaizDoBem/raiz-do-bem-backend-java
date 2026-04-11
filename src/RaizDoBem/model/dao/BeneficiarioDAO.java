package RaizDoBem.model.dao;

import RaizDoBem.model.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsavel pelas operacoes de persistencia e mapeamento de BeneficiarioDAO.
 * Camada: DAO.
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

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param beneficiario parametro da operacao.
     */
    public void adicionar(Beneficiario beneficiario) {
        String querySql = "INSERT INTO Beneficiario (cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

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
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Beneficiario> listarTodos() {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        String querySql = "SELECT id_beneficiario, cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco FROM Beneficiario";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                beneficiarios.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar beneficiários: " + exception.getMessage());
        }
        return beneficiarios;
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Beneficiario buscarPorCpf(String cpf) {
        String querySql = "SELECT id_beneficiario, cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco FROM Beneficiario WHERE cpf = ?";
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
     * Realiza a busca de dados conforme o criterio recebido.
     * @param idPrograma parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Beneficiario> buscarPorPrograma(int idPrograma) {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        String querySql = "SELECT id_beneficiario, cpf, nome_completo, data_nascimento, telefone, email, id_programa_social, id_pedido_ajuda, id_endereco FROM Beneficiario WHERE id_programa_social = ?";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setInt(1, idPrograma);

            try (ResultSet response = ps.executeQuery()) {
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
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param cidade parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Beneficiario> listarPorCidade(String cidade) {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        String querySql = "SELECT b.id_beneficiario, b.cpf, b.nome_completo, b.data_nascimento, b.telefone, b.email, b.id_programa_social, b.id_pedido_ajuda, b.id_endereco, e.cidade FROM Beneficiario b, Endereco e WHERE e.cidade = ? AND b.id_endereco = e.id_endereco";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cidade);

            try (ResultSet response = ps.executeQuery()) {
                while (response.next()) {
                    beneficiarios.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar beneficiários por cidade: " + exception.getMessage());
        }
        return beneficiarios;
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     * @param beneficiario parametro da operacao.
     */
    public void atualizar(String cpf, Beneficiario beneficiario) {
        String querySql = "UPDATE Beneficiario SET telefone = ?, email = ?, id_endereco = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

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
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluir(String cpf) {
        String querySql = "DELETE FROM beneficiario WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir beneficiário: " + exception.getMessage());
        }
    }
}
