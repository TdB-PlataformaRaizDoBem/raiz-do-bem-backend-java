package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.Sexo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsavel pelas operacoes de persistencia e mapeamento de DentistaDAO.
 * Camada: DAO.
 */
public class DentistaDAO {
    /**
     * Mapeia dados de origem para o objeto de dominio correspondente.
     * @param response parametro da operacao.
     * @return resultado da operacao.
     */
    public Dentista mapeamento(ResultSet response) throws SQLException {
        String sexoDentista = response.getString("sexo");
        Sexo sexo = Sexo.valueOf(sexoDentista.toUpperCase());
        String statusDentista = response.getString("disponivel");
        boolean disponivel = statusDentista.equals("S");

        return new Dentista(
                response.getInt("id_dentista"),
                response.getString("cro"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                sexo,
                response.getString("email"),
                response.getString("telefone"),
                response.getString("categoria"),
                response.getInt("id_endereco"),
                disponivel
        );
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Dentista buscarPorCpf(String cpf) {
        String querySql = "SELECT id_dentista, cro, cpf, nome_completo, sexo, email, telefone, categoria, id_endereco, disponivel FROM Dentista WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {
            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery()) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao buscar CPF: " + exception.getMessage());
        }
        return null;
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param dentista parametro da operacao.
     */
    public void adicionar(Dentista dentista) {
        String querySql = "INSERT INTO Dentista (cro, cpf, nome_completo, sexo, email, telefone, categoria, id_endereco, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {
            ps.setString(1, dentista.getCroDentista());
            ps.setString(2, dentista.getCpf());
            ps.setString(3, dentista.getNomeCompleto());
            ps.setString(4, dentista.getSexo().name());
            ps.setString(5, dentista.getEmail());
            ps.setString(6, dentista.getTelefone());
            ps.setString(7, dentista.getCategoria());
            ps.setInt(8, dentista.getIdEndereco());
            ps.setString(9, dentista.isDisponivel());


            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao adicionar dentista: " + exception.getMessage());
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Dentista> listarTodos() {
        String querySql = "SELECT id_dentista, cro, cpf, nome_completo, sexo, email, telefone, categoria, id_endereco, disponivel FROM Dentista";
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery()) {

            while (response.next())
                dentistas.add(mapeamento(response));
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar dentistas: " + exception.getMessage());
        }
        return dentistas;
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param cidade parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Dentista> listarPorCidade(String cidade) {
        String querySql = "SELECT d.id_dentista, d.cro, d.cpf, d.nome_completo, d.sexo, d.email, d.telefone, d.categoria, d.disponivel, d.id_endereco FROM Dentista d, endereco e WHERE e.cidade = ? AND d.id_endereco = e.id_endereco";
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cidade);

            try (ResultSet response = ps.executeQuery()) {
                while (response.next()) {
                    dentistas.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(
                    "Erro ao listar dentistas da cidade (" + cidade + "): " + exception.getMessage());
        }
        return dentistas;
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Dentista> listarDisponiveis() {
        String querySql = "SELECT id_dentista, cro, cpf, nome_completo, sexo, email, telefone, categoria, disponivel, id_endereco FROM Dentista WHERE disponivel = 'S'";
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            try (ResultSet response = ps.executeQuery()) {
                while (response.next()) {
                    dentistas.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar dentistas disponíveis: " + exception.getMessage());
        }
        return dentistas;
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     * @param dentista parametro da operacao.
     */
    public void atualizar(String cpf, Dentista dentista) {
        String querySql = "UPDATE Dentista SET email = ?, telefone = ?, categoria = ?, disponivel = ?,  id_endereco = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, dentista.getEmail());
            ps.setString(2, dentista.getTelefone());
            ps.setString(3, dentista.getCategoria());
            ps.setString(4, dentista.isDisponivel());
            ps.setInt(5, dentista.getIdEndereco());
            ps.setString(6, cpf);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar dentista: " + exception.getMessage());
        }
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluir(String cpf) {
        String querySql = "DELETE FROM dentista WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir dentista: " + exception.getMessage());
        }
    }
}
