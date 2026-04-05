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
 * Classe de acesso a dados para a entidade PedidoAjuda. Esta classe é responsável por realizar as operações de banco de dados relacionadas aos pedidos de ajuda, como criação, listagem, busca por CPF, busca por ID, listagem por data, atualização e exclusão. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos pedidos de ajuda.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - mapeamento: Recebe um objeto ResultSet contendo os dados de um pedido de ajuda e realiza o mapeamento desses dados para criar e retornar um objeto PedidoAjuda correspondente.
 * 2º Metodo - adicionar: Recebe um objeto PedidoAjuda e insere seus dados no banco de dados, utilizando uma consulta SQL INSERT.
 * 3º Metodo - listarTodos: Recupera todos os pedidos de ajuda cadastrados no banco de dados, utilizando uma consulta SQL SELECT, e retorna uma lista de objetos PedidoAjuda correspondentes.
 * 4º Metodo - buscarPorCpf: Recebe um CPF e busca no banco de dados o pedido de ajuda correspondente, utilizando uma consulta SQL SELECT com cláusula WHERE, e retorna um objeto PedidoAjuda com os dados encontrados.
 * 5º Metodo - buscarPorId: Recebe um ID de pedido de ajuda e busca no banco de dados o pedido correspondente, utilizando uma consulta SQL SELECT com cláusula WHERE, e retorna um objeto PedidoAjuda com os dados encontrados.
 * 6º Metodo - listarPedidosData: Recebe uma data e busca no banco de dados os pedidos de ajuda criados nessa data, utilizando uma consulta SQL SELECT com cláusula WHERE, e retorna uma lista de objetos PedidoAjuda correspondentes.
 * 7º Metodo - atualizarPedido: Recebe um CPF e um objeto PedidoAjuda com as novas informações, e atualiza os dados do pedido de ajuda correspondente no banco de dados, utilizando uma consulta SQL UPDATE.
 * 8º Metodo - excluirPedido: Recebe um CPF e remove o pedido de ajuda correspondente do banco de dados, utilizando uma consulta SQL DELETE.
 * esses métodos permitem que a aplicação realize as operações necessárias para gerenciar os pedidos de ajuda, garantindo a persistência dos dados e a integridade das informações relacionadas aos pedidos de ajuda cadastrados no sistema.
 */
public class PedidoAjudaDAO {
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

    public void adicionar(PedidoAjuda pedido) {
        String querySql = "INSERT INTO Pedido_Ajuda (cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

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

    public PedidoAjuda buscarPorCpf(String cpf) {
        String querySql = "SELECT id_pedido, cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido, id_endereco,id_dentista FROM Pedido_Ajuda where cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery();) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar cpf: " + exception.getMessage());
        }
        return null;
    }

    public PedidoAjuda buscarPorId(int id) {
        String querySql = "SELECT id_pedido, cpf, nome_completo, data_nascimento, sexo, telefone, email, descricao_problema, data_pedido, status_pedido,id_endereco, id_dentista FROM Pedido_Ajuda where id_pedido = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setInt(1, id);

            try (ResultSet response = ps.executeQuery();) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar id: " + exception.getMessage());
        }
        return null;
    }


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

    public void atualizarPedido(String cpf, PedidoAjuda pedido) {
        String querySql = "UPDATE Pedido_Ajuda SET status_pedido = ?, id_dentista = ? WHERE cpf = ?";
        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, pedido.getStatus().name());
            ps.setInt(2, pedido.getIdDentista());
            ps.setString(3, cpf);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar pedido de ajuda: " + exception.getMessage());
        }
    }

    public void excluirPedido(String cpf) {
        String querySql = "DELETE FROM pedido_ajuda WHERE cpf = ? ";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setString(1, cpf);
            ps.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir pedido de ajuda: " + exception.getMessage());
        }
    }
}
