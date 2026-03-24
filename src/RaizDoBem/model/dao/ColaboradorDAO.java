package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados dos Coordenadores da ONG.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos coordenadores.
 * @author Paulo
 * @since 2026-03
 *
 */
public class ColaboradorDAO {
    public Colaborador mapeamento(ResultSet response) throws SQLException {
        return new Colaborador(
                response.getInt("id"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                response.getString("email"),
                response.getInt("id_endereco"),
                response.getInt("id_sexo"),
                response.getDate("data_contratacao").toLocalDate(),
                response.getString("nivel_acesso"),
                response.getString("senha")
        );
    }

    public void adicionar(Colaborador colaborador){
        String querySql = "INSERT INTO colaborador cpf, nome_completo, data_nascimento, email, id_endereco, data_contratacao, nivel_acesso, senha VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, colaborador.getCpf());
            ps.setString(2, colaborador.getNomeCompleto());
            //ps.setDate(3, Date.valueOf(colaborador.get()));
            ps.setString(4, colaborador.getEmail());
            ps.setInt(5, colaborador.getEndereco().getId());
            ps.setDate(6, Date.valueOf(colaborador.getDataContratacao()));
            ps.setString(7, colaborador.getNivelAcesso());
            ps.setString(8, colaborador.getSenha());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar coordenador: " + exception.getMessage());
        }
    }
    /** O metodo listarTodos() é responsável por recuperar e exibir todos os registros de coordenadores presentes no banco de dados. Ele executa uma consulta SQL para selecionar as colunas relevantes da tabela Colaborador, e itera sobre os resultados para criar objetos Colaborador e exibi-los.
     * */
    public List<Colaborador> listarTodos(){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, email, id_endereco, id_sexo, data_contratacao, nivel_acesso, senha FROM Coordenador";
        List<Colaborador> colaboradores = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery()){

            while(response.next()){
                colaboradores.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
           throw new RuntimeException("Erro ao listar colaboradores: " + exception.getMessage());
        }
        return colaboradores;
    }


    public void atualizar(Colaborador colaborador, String cpf){
        String querySql = "UPDATE colaborador SET id_endereco = ?, nivel_acesso = ? WHERE cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

//            ps.setInt(1, colaborador.getEndereco().getId());
//            ps.setString(2, colaborador.getNivelAcesso());
//            ps.setString(3, cpf);

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao atualizar colaborador: " + exception.getMessage());
        }
    }

    public void excluir(int id){
        String querySql = "DELETE FROM colaborador WHERE id = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir colaborador: " + exception.getMessage());
        }
    }
}
