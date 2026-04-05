package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.Sexo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Dentista. Esta classe é responsável por realizar operações de banco de dados relacionadas aos dentistas, como adicionar um novo dentista, listar todos os dentistas, buscar um dentista por CPF, atualizar as informações de um dentista e excluir um dentista do sistema. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos dentistas.
 * @author Paulo
 * @since 2026-03
 * adicionar: Este método recebe um objeto Dentista como parâmetro e adiciona um novo dentista ao banco de dados. Ele executa uma consulta SQL de inserção para adicionar os dados do dentista fornecido ao banco de dados.
 * listarTodos: Este método retorna uma lista de todos os dentistas cadastrados no banco de dados. Ele executa uma consulta SQL para recuperar todos os dentistas e utiliza o método mapeamento para converter cada resultado da consulta em um objeto Dentista, que é adicionado a uma lista de dentistas.
 * buscarPorCpf: Este método recebe um CPF como parâmetro e retorna um objeto DentistaDAO correspondente ao CPF fornecido. Ele executa uma consulta SQL para buscar o dentista com o CPF especificado e utiliza o método mapeamento para converter o resultado da consulta em um objeto Dentista.
 * atualizar: Este método recebe um CPF e um objeto Dentista como parâmetros e atualiza os dados de um dentista existente no banco de dados com base no CPF fornecido. Ele executa uma consulta SQL de atualização para modificar os dados do dentista correspondente ao CPF especificado.
 * excluir: Este método recebe um CPF como parâmetro e remove o dentista correspondente a esse CPF do banco de dados. Ele executa uma consulta SQL de exclusão para remover o dentista com o CPF especificado do banco de dados.
 * Esses métodos permitem que o sistema manipule os dados dos dentistas de forma eficiente, realizando operações de criação, leitura, atualização e exclusão conforme necessário, e garantindo a integridade dos dados no banco de dados.
 */
public class DentistaDAO {
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

    public Dentista buscarPorCpf(String cpf) {
        String querySql = "SELECT id_dentista, cro, cpf, nome_completo, sexo, email, telefone, categoria, id_endereco, disponivel FROM Dentista WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery();) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao buscar CPF: " + exception.getMessage());
        }
        return null;
    }

    public void adicionar(Dentista dentista) {
        String querySql = "INSERT INTO Dentista (cro, cpf, nome_completo, sexo, email, telefone, categoria, id_endereco, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
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

    public List<Dentista> listarTodos() {
        String querySql = "SELECT id_dentista, cro, cpf, nome_completo, sexo, email, telefone, categoria, id_endereco, disponivel FROM Dentista";
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery();) {

            while (response.next())
                dentistas.add(mapeamento(response));
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar dentistas: " + exception.getMessage());
        }
        return dentistas;
    }

    public List<Dentista> listarPorCidade(String cidade) {
        String querySql = "SELECT d.id_dentista, d.cro, d.cpf, d.nome_completo, d.sexo, d.email, d.telefone, d.categoria, d.disponivel, d.id_endereco FROM Dentista d, endereco e WHERE e.cidade = ? AND d.id_endereco = e.id_endereco";
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cidade);

            try (ResultSet response = ps.executeQuery();) {
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

    public List<Dentista> listarDisponiveis() {
        String querySql = "SELECT id_dentista, cro, cpf, nome_completo, sexo, email, telefone, categoria, disponivel, id_endereco FROM Dentista WHERE disponivel = 'S'";
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            try (ResultSet response = ps.executeQuery();) {
                while (response.next()) {
                    dentistas.add(mapeamento(response));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar dentistas disponíveis: " + exception.getMessage());
        }
        return dentistas;
    }

    public void atualizar(String cpf, Dentista dentista) {
        String querySql = "UPDATE Dentista SET email = ?, telefone = ?, categoria = ?, disponivel = ?,  id_endereco = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

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

    public void excluir(String cpf) {
        String querySql = "DELETE FROM dentista WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir dentista: " + exception.getMessage());
        }
    }
}
