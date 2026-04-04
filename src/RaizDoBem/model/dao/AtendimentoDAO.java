package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Atendimento.
 * Responsável por realizar operações de Criação, Leitura, e atualização
 * relacionadas aos atendimentos aos benefciários.
 * 
 * @author Paulo
 * @since 2026-03
 *
 */
public class AtendimentoDAO {
    private Atendimento mapeamento(ResultSet response) throws SQLException {
        return new Atendimento(
                response.getInt("id"),
                response.getString("descricao_inicial"),
                response.getDate("data_inicial").toLocalDate(),
                response.getDate("data_final").toLocalDate(),
                response.getString("solucao_problema"),
                response.getInt("id_beneficiario"),
                response.getInt("id_dentista"),
                response.getInt("id_colaborador"));
    }

    public Atendimento buscarPorCpf(String cpf) {
        String querySql = "SELECT id, descricao_inicial, data_inicial, data_final, solucao_problema,id_beneficiario, id_dentista, id_colaborador FROM Atendimento where id = ?";

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
        String querySql = "SELECT id, descricao_atendimento, data_inicial, data_final, id_beneficiario, id_dentista FROM Atendimento";
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

    public void encontrarAtendimentoBeneficiario() {
    }

    public void encontrarAtendimentosDentista() {
    }
}
