package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.PedidoAjuda;
import RaizDoBem.model.vo.Sexo;
import RaizDoBem.model.vo.StatusPedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsavel pelas operacoes de persistencia e mapeamento de PedidoAjudaDAO.
 * Camada: DAO.
 */
public class PedidoAjudaDAO {
    /**
     * Mapeia dados de origem para o objeto de dominio correspondente.
     * @param response parametro da operacao.
     * @return resultado da operacao.
     */
    public PedidoAjuda mapeamento(ResultSet response) throws SQLException {
        String sexoSolicitante = response.getString("sexo");
        Sexo sexo = Sexo.valueOf(sexoSolicitante.toUpperCase());

        String statusPedido = response.getString("status_pedido");
        StatusPedido status = StatusPedido.valueOf(statusPedido);
        return new PedidoAjuda(
                response.getInt("id_pedido"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                sexo,
                response.getString("telefone"),
                response.getString("email"),
                response.getString("descricao_problema"),
                response.getDate("data_pedido").toLocalDate(),
                status,
                response.getInt("id_endereco"),
                response.getInt("id_dentista")
        );
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param pedido parametro da operacao.
     */
    public void adicionar(PedidoAjuda pedido) {
        String querySql = "INSERT INTO Pedido_Ajuda (cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, pedido.getCpf());
            ps.setString(2, pedido.getNomeCompleto());
            ps.setDate(3, Date.valueOf(pedido.getDataNascimento()));
            ps.setString(4, pedido.getSexo().name());
            ps.setString(5, pedido.getTelefone());
            ps.setString(6, pedido.getEmail());
            ps.setString(7, pedido.getDescricaoProblema());
            ps.setDate(8, Date.valueOf(pedido.getDataPedido()));
            ps.setString(9, pedido.getStatus().name());
            ps.setInt(10, pedido.getIdEndereco());

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao criar novo pedido de ajuda: " + exception.getMessage());
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<PedidoAjuda> listarTodos() {
        String querySql = "SELECT id_pedido, cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido, id_endereco, id_dentista FROM Pedido_Ajuda";
        List<PedidoAjuda> pedidos = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                pedidos.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar pedidos de ajuda: " + exception.getMessage());
        }
        return pedidos;
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public PedidoAjuda buscarPorCpf(String cpf) {
        String querySql = "SELECT id_pedido, cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido, id_endereco,id_dentista FROM Pedido_Ajuda where cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {
            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery()) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar cpf: " + exception.getMessage());
        }
        return null;
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param id parametro da operacao.
     * @return resultado da operacao.
     */
    public PedidoAjuda buscarPorId(int id) {
        String querySql = "SELECT id_pedido, cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido,id_endereco, id_dentista FROM Pedido_Ajuda where id_pedido = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql)) {
            ps.setInt(1, id);

            try (ResultSet response = ps.executeQuery()) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar id: " + exception.getMessage());
        }
        return null;
    }


    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param data parametro da operacao.
     * @return resultado da operacao.
     */
    public List<PedidoAjuda> listarPedidosData(LocalDate data) {
        String querySql = "SELECT id_pedido, cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido, id_endereco ,id_dentista FROM Pedido_Ajuda WHERE data_pedido = ?";
        List<PedidoAjuda> pedidos = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setDate(1, Date.valueOf(data));

            try (ResultSet response = ps.executeQuery()) {
                while (response.next()) {
                    pedidos.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar pedidos de ajuda da data específica: " + exception.getMessage());
        }
        return pedidos;
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param id parametro da operacao.
     * @param pedido parametro da operacao.
     */
    public void atualizarPedido(int id, PedidoAjuda pedido) {
        String querySql = "UPDATE Pedido_Ajuda SET status_pedido = ?, id_dentista = ? WHERE id_pedido = ?";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, pedido.getStatus().name());
            ps.setInt(2, pedido.getIdDentista());
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar pedido de ajuda: " + exception.getMessage());
        }
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param id parametro da operacao.
     */
    public void excluirPedido(int id) {
        String querySql = "DELETE FROM pedido_ajuda WHERE id_pedido = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir pedido de ajuda: " + exception.getMessage());
        }
    }
}
