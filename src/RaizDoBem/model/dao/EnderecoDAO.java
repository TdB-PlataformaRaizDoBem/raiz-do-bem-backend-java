package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Endereço. Esta classe é responsável por realizar as operações de banco de dados relacionadas aos endereços, como criação, leitura, atualização e exclusão. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos endereços.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - mapeamento: Recebe um objeto ResultSet contendo os dados de um endereço e realiza o mapeamento desses dados para criar e retornar um objeto Endereco correspondente.
 * 2º Metodo - adicionar: Recebe um objeto Endereco e insere seus dados no banco de dados, utilizando uma consulta SQL INSERT.
 * 3º Metodo - listarTodos: Recupera todos os endereços cadastrados no banco de dados, utilizando uma consulta SQL SELECT, e retorna uma lista de objetos Endereco correspondentes.
 * 4º Metodo - buscarPorId: Recebe um ID de endereço e busca no banco de dados o endereço correspondente, utilizando uma consulta SQL SELECT com cláusula WHERE, e retorna um objeto Endereco com os dados encontrados.
 * 5º Metodo - listarPorCidade: Recebe o nome de uma cidade e busca no banco de dados os endereços localizados nessa cidade, utilizando uma consulta SQL SELECT com cláusula WHERE, e retorna uma lista de objetos Endereco correspondentes.
 * 6º Metodo - atualizar: Recebe um ID de endereço e um objeto Endereco com as novas informações, e atualiza os dados do endereço correspondente no banco de dados, utilizando uma consulta SQL UPDATE.
 * 7º Metodo - excluir: Recebe um ID de endereço e remove o endereço correspondente do banco de dados, utilizando uma consulta SQL DELETE.
 * Esses métodos permitem que a aplicação realize as operações necessárias para gerenciar os endereços, garantindo a persistência dos dados e a integridade das informações relacionadas aos endereços cadastrados no sistema.
 */
public class EnderecoDAO {
    public Endereco mapeamento(ResultSet response) throws SQLException {
        String tipoEndereco = response.getString("tipo_endereco");
        TipoEndereco tipo = TipoEndereco.valueOf(tipoEndereco.toUpperCase());

        return new Endereco(
                response.getInt("id_endereco"),
                response.getString("logradouro"),
                response.getString("cep"),
                response.getString("numero"),
                response.getString("bairro"),
                response.getString("cidade"),
                response.getString("estado"),
                tipo);
    }

    public void adicionar(Endereco endereco) {
        String querySql = "INSERT INTO Endereco (logradouro, cep, numero, bairro, cidade, estado, tipo_endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getNumero());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getEstado());
            ps.setString(7, endereco.getTipo().name());

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao adicionar endereço: " + exception.getMessage(), exception);
        }
    }

    public List<Endereco> listarTodos() {
        String querySql = "SELECT id_endereco, logradouro, cep, numero, bairro, cidade, estado, tipo_endereco FROM Endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery();) {

            while (response.next())
                enderecos.add(mapeamento(response));
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar endereços:" + exception.getMessage());
        }
        return enderecos;
    }

    public Endereco buscarPorId(int id) {
        String querySql = "SELECT id_endereco, logradouro, cep, numero, bairro, cidade, estado, tipo_endereco FROM Endereco WHERE id_endereco = ?";

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

    public List<Endereco> listarPorCidade(String cidade) {
        String querySql = "SELECT id_endereco, logradouro, cep, numero, bairro, cidade, estado, tipo_endereco FROM Endereco WHERE cidade = ?";

        List<Endereco> enderecos = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cidade);

            try (ResultSet response = ps.executeQuery()) {
                while (response.next())
                    enderecos.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar endereços:" + exception.getMessage());
        }
        return enderecos;
    }

    public void atualizar(int id, Endereco endereco) {
        String querySql = "UPDATE Endereco SET logradouro = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, tipo_endereco = ? WHERE id_endereco = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getNumero());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getEstado());
            ps.setString(7, endereco.getTipo().name());
            ps.setInt(8, id);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar endereço: " + exception.getMessage());
        }
    }

    public void excluir(int id) {
        String querySql = "DELETE FROM Endereco WHERE id_endereco = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir endereço: " + exception.getMessage());
        }
    }
}
