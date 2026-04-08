package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade Atendimento. Esta classe é responsável por realizar operações de banco de dados relacionadas aos atendimentos, como buscar por CPF, adicionar um novo atendimento, listar todos os atendimentos, atualizar um atendimento existente e encontrar atendimentos relacionados a beneficiários e dentistas. Ela utiliza a classe Conexao para estabelecer a conexão com o banco de dados e executa as consultas SQL necessárias para manipular os dados dos atendimentos.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - buscarPorCpf: Este método recebe um CPF como parâmetro e realiza uma consulta no banco de dados para encontrar um atendimento relacionado a esse CPF. Ele retorna um objeto Atendimento contendo as informações do atendimento encontrado ou null se nenhum atendimento for encontrado.
 * 2º Metodo - buscarPorId: Este método recebe um ID de atendimento como parâmetro e realiza uma consulta no banco de dados para encontrar um atendimento relacionado a esse ID. Ele retorna um objeto Atendimento contendo as informações do atendimento encontrado ou null se nenhum atendimento for encontrado.
 * 3º Metodo - adicionar: Este método recebe um objeto Atendimento como parâmetro e realiza uma inserção no banco de dados para adicionar um novo atendimento. Ele utiliza os atributos do objeto Atendimento para preencher os campos da tabela de atendimentos no banco de dados.
 * 4º Metodo - listarTodos: Este método realiza uma consulta no banco de dados para recuperar todos os atendimentos cadastrados. Ele retorna uma lista de objetos Atendimento contendo as informações de todos os atendimentos encontrados no banco de dados.
 * 5º Metodo - atualizar: Este método recebe um ID de atendimento e um objeto AtendimentoDAO como parâmetros e realiza uma atualização no banco de dados para modificar as informações de um atendimento existente. Ele utiliza os atributos do objeto Atendimento para preencher os campos da tabela de atendimentos no banco de dados, atualizando o atendimento correspondente ao ID fornecido.
 * Esses métodos permitem que a aplicação interaja com a funcionalidade de atendimento, realizando operações de busca, criação, listagem e atualização de atendimentos no banco de dados, e fornecendo os resultados dessas operações para a camada de negócios ou para a interface do usuário conforme necessário.
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

    public Atendimento buscarPorCpf(String cpf) {
        String querySql = "SELECT a.id_atendimento, a.prontuario, a.data_inicial, a.data_final, a.id_beneficiario, a.id_dentista, a.id_colaborador FROM Atendimento a, Beneficiario b where b.cpf = ? AND a.id_beneficiario = b.id_beneficiario";

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

    public Atendimento buscarPorId(int id) {
        String querySql = "SELECT id_atendimento, prontuario, data_inicial, data_final, id_beneficiario, id_dentista, id_colaborador FROM Atendimento where id_atendimento = ?";

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

    public void adicionar(Atendimento atendimento) {
        String querySql = "INSERT INTO Atendimento (prontuario, data_inicial, id_beneficiario, id_dentista) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);) {
            ps.setString(1, atendimento.getProntuario());
            ps.setDate(2, Date.valueOf(atendimento.getDataInicial()));
            ps.setInt(3, atendimento.getIdBeneficiario());
            ps.setInt(4, atendimento.getIdDentista());

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao adicionar novo atendimento: " + exception.getMessage());
        }
    }

    public List<Atendimento> listarTodos() {
        String querySql = "SELECT id_atendimento, prontuario, data_inicial, data_final, id_beneficiario, id_dentista, id_colaborador FROM Atendimento";
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
    public void atualizar(int idAtendimento, Atendimento atendimento) {
        String querySql = "UPDATE atendimento SET data_final = ?, prontuario = ?, id_colaborador = ? WHERE id_atendimento = ?";

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql);) {

            ps.setDate(1, Date.valueOf(atendimento.getDataFinal()));
            ps.setString(2, atendimento.getProntuario());
            ps.setInt(3, atendimento.getIdColaborador());
            ps.setInt(4, idAtendimento);

            ps.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao atualizar atendimento: " + exception.getMessage());
        }
    }
}
