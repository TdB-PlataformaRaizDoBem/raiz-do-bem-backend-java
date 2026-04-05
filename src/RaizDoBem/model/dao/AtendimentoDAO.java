package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Atendimento. Esta classe é responsável por realizar operações de banco de dados relacionadas aos atendimentos, como buscar por CPF, adicionar um novo atendimento, listar todos os atendimentos, atualizar um atendimento existente e encontrar atendimentos relacionados a beneficiários e dentistas. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos atendimentos.
 * @author Paulo
* @since 2026-03
* buscarPorCpf: Este método recebe um CPF como parâmetro e retorna um objeto Atendimento correspondente ao CPF fornecido. Ele executa uma consulta SQL para buscar o atendimento com o CPF especificado e utiliza o método mapeamento para converter o resultado da consulta em um objeto Atendimento.
* adicionar: Este método recebe um objeto Atendimento como parâmetro e adiciona um novo atendimento ao banco de dados. Ele executa uma consulta SQL de inserção para adicionar os dados do atendimento fornecido ao banco de dados.
* listarTodos: Este método retorna uma lista de todos os atendimentos cadastrados no banco de dados. Ele executa uma consulta SQL para recuperar todos os atendimentos e utiliza o método mapeamento para converter cada resultado da consulta em um objeto Atendimento, que é adicionado a uma lista de atendimentos.
* atualizar: Este método recebe um CPF e um objeto Atendimento como parâmetros e atualiza os dados de um atendimento existente no banco de dados com base no CPF fornecido. Ele executa uma consulta SQL de atualização para modificar os dados do atendimento correspondente ao CPF especificado.
* encontrarAtendimentoBeneficiario: Este método é responsável por encontrar os atendimentos relacionados a um beneficiário específico. Ele pode receber um identificador do beneficiário como parâmetro e executar uma consulta SQL para recuperar os atendimentos associados a esse beneficiário.
* encontrarAtendimentosDentista: Este método é responsável por encontrar os atendimentos relacionados a um dentista específico. Ele pode receber um identificador do dentista como parâmetro e executar uma consulta SQL para recuperar os atendimentos associados a esse dentista.
 */
public class AtendimentoDAO {
    private Atendimento mapeamento(ResultSet response) throws SQLException {
        return new Atendimento(
                response.getInt("id_atendimento"),
                response.getString("descricao_inicial"),
                response.getDate("data_inicial").toLocalDate(),
                response.getDate("data_final").toLocalDate(),
                response.getString("solucao_problema"),
                response.getInt("id_beneficiario"),
                response.getInt("id_dentista"),
                response.getInt("id_colaborador"));
    }

    public Atendimento buscarPorCpf(String cpf) {
        String querySql = "SELECT id_atendimento, descricao_inicial, data_inicial, data_final, solucao_problema,id_beneficiario, id_dentista, id_colaborador FROM Atendimento where id = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setString(1, cpf);

            try (ResultSet response = ps.executeQuery();) {
                if (response.next())
                    return mapeamento(response);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao encontrar id: " + exception.getMessage());
        }
        return null;
    }

    public void adicionar(Atendimento atendimento) {
        String querySql = "INSERT INTO Atendimento (descricao_atendimento, data, id_beneficiario, id_dentista) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setString(1, atendimento.getDescricaoInicial());
            ps.setDate(2, Date.valueOf(atendimento.getDataInicial()));
            ps.setDate(3, Date.valueOf(atendimento.getDataFinal()));
            ps.setString(4, atendimento.getSolucaoProblema());
            ps.setInt(5, atendimento.getIdBeneficiario());
            ps.setInt(6, atendimento.getIdDentista());
            ps.setInt(7, atendimento.getIdColaborador());

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Erro ao adicionar novo atendimento: " + exception.getMessage());
        }
    }

    public List<Atendimento> listarTodos() {
        String querySql = "SELECT id_atendimento, descricao_inicial, data_inicial, data_final, solucao_problema, id_beneficiario, id_dentista, id_colaborador FROM Atendimento";
        List<Atendimento> atendimentos = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery();) {

            while (response.next()) {
                atendimentos.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return atendimentos;
    }
    public void atualizar(String cpf, Atendimento atendimento) {
        String querySql = "UPDATE atendimento SET data_final = ?, solucao_problema = ?,id_colaborador = ? WHERE cpf = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setDate(1, Date.valueOf(atendimento.getDataFinal()));
            ps.setString(2, atendimento.getSolucaoProblema());
            ps.setInt(3, atendimento.getIdColaborador());
            ps.setString(4, cpf);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar atendimento: " + exception.getMessage());
        }
    }
//    public void encontrarAtendimentoBeneficiario() {
//    }

    public void encontrarAtendimentosDentista() {
    }
}
