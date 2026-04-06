package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Especialidade;
import RaizDoBem.model.vo.ProgramaSocial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaSocialDAO {
    public List<ProgramaSocial> listarTodos() {
        String querySql = "SELECT id_programa, programa FROM programa_social";
        List<ProgramaSocial> programas = new ArrayList<>();

        try (Connection conexao = Conexao.conectarAoBanco();
             PreparedStatement ps = conexao.prepareStatement(querySql);
             ResultSet response = ps.executeQuery();) {

            while (response.next()) {
                int id = response.getInt("id_programa");
                String programa = response.getString("programa");

                programas.add(new ProgramaSocial(id, programa));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao listar programas sociais:" + exception.getMessage(), exception);
        }
        return programas;
    }
}
