package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsavel pelas operacoes de persistencia e mapeamento de AtendimentoDAO.
 * Camada: DAO.
 */
public class AtendimentoDAO {
    private Atendimento mapeamento(ResultSet response) throws SQLException {
        Date dataFim = response.getDate("data_final");
        LocalDate dataFinal;
        if(dataFim != null)
            dataFinal = dataFim.toLocalDate();
        else{
            dataFinal = null;
        }

        return new Atendimento(
                response.getInt("id_atendimento"),
                response.getString("prontuario"),
                response.getDate("data_inicial").toLocalDate(),
                dataFinal,
                response.getInt("id_beneficiario"),
                response.getInt("id_dentista"),
                response.getInt("id_colaborador"));
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Atendimento buscarPorCpf(String cpf) {
        String querySql = "SELECT a.id_atendimento, a.prontuario, a.data_inicial, a.data_final, a.id_beneficiario, a.id_dentista, a.id_colaborador FROM Atendimento a, Beneficiario b where b.cpf = ? AND a.id_beneficiario = b.id_beneficiario";

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
    public Atendimento buscarPorId(int id) {
        String querySql = "SELECT id_atendimento, prontuario, data_inicial, data_final, id_beneficiario, id_dentista, id_colaborador FROM Atendimento where id_atendimento = ?";

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
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param atendimento parametro da operacao.
     */
    public void adicionar(Atendimento atendimento) {
        String querySql = "INSERT INTO Atendimento (prontuario, data_inicial, id_beneficiario, id_dentista) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql)) {
            ps.setString(1, atendimento.getProntuario());
            ps.setDate(2, Date.valueOf(atendimento.getDataInicial()));
            ps.setInt(3, atendimento.getIdBeneficiario());
            ps.setInt(4, atendimento.getIdDentista());

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao adicionar novo atendimento: " + exception.getMessage());
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Atendimento> listarTodos() {
        String querySql = "SELECT id_atendimento, prontuario, data_inicial, data_final, id_beneficiario, id_dentista, id_colaborador FROM Atendimento";
        List<Atendimento> atendimentos = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                atendimentos.add(mapeamento(response));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return atendimentos;
    }
    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param idAtendimento parametro da operacao.
     * @param atendimento parametro da operacao.
     */
    public void atualizar(int idAtendimento, Atendimento atendimento) {
        String querySql = "UPDATE atendimento SET data_final = ?, prontuario = ?, id_colaborador = ? WHERE id_atendimento = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setDate(1, Date.valueOf(atendimento.getDataFinal()));
            ps.setString(2, atendimento.getProntuario());
            ps.setInt(3, atendimento.getIdColaborador());
            ps.setInt(4, idAtendimento);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar atendimento: " + exception.getMessage());
        }
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param id parametro da operacao.
     */
    public void excluir(int id) {
        String querySql = "DELETE FROM atendimento WHERE id_atendimento = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao excluir atendimento: " + exception.getMessage());
        }
    }
}
