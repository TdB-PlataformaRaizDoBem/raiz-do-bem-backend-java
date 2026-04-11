package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsavel pelas operacoes de persistencia e mapeamento de EspecialidadeDAO.
 * Camada: DAO.
 */
public class EspecialidadeDAO {
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Especialidade> listarTodos() {
        String querySql = "SELECT id_especialidade, descricao FROM especialidade";
        List<Especialidade> especialidades = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
                PreparedStatement ps = conexao.prepareStatement(querySql);
                ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                int id = response.getInt("id_especialidade");
                String descricao = response.getString("descricao");

                especialidades.add(new Especialidade(id, descricao));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar especialidades:" + exception.getMessage(), exception);
        }
        return especialidades;
    }
}
