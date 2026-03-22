package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.Coordenador;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados dos Coordenadores da ONG.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos coordenadores.
 * @author Paulo
 * @since 2026-03
 *
 */
public class CoordenadorDAO {
    public Coordenador mapeamento(ResultSet response) throws SQLException {
        return new Coordenador(
                response.getInt("id_colaborador"),
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
    /**
     * Metodo para adicionar um novo coordenador ao banco de dados.
     * @param coord Objeto do tipo Coordenador contendo as informações do coordenador a ser adicionado.
     */
    public void adicionar(Coordenador coord){
        String querySql = "INSERT INTO Coordenador cpf, nome_completo, data_nascimento, email, id_endereco, data_contratacao, nivel_acesso, senha VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, coord.getCpf());
            ps.setString(2, coord.getNomeCompleto());
            ps.setDate(3, Date.valueOf(coord.getDataNascimento()));
            ps.setString(4, coord.getEmail());
            ps.setInt(5, coord.getEndereco().getId());
            ps.setDate(6, Date.valueOf(coord.getDataContratacao()));
            ps.setString(7, coord.getNivelAcesso());
            ps.setString(8, coord.getSenha());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar coordenador: " + exception.getMessage());
        }
    }
    /** O metodo listarTodos() é responsável por recuperar e exibir todos os registros de coordenadores presentes no banco de dados. Ele executa uma consulta SQL para selecionar as colunas relevantes da tabela Coordenador, e itera sobre os resultados para criar objetos Coordenador e exibi-los.
     * */
    public List<Coordenador> listarTodos(){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, email, id_endereco, id_sexo, data_contratacao, nivel_acesso, senha FROM Coordenador";
        List<Coordenador> coordenadores = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery()){

            while(response.next()){
                coordenadores.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
           throw new RuntimeException("Erro ao listar coordenadores: " + exception.getMessage());
        }
        return coordenadores;
    }

    /** O metodo listarAdministradores() é responsável por recuperar e exibir os registros de coordenadores que possuem o nível de acesso "ADMIN". Ele executa uma consulta SQL que seleciona os coordenadores onde o campo nivel_acesso é igual a "ADMIN", e itera sobre os resultados para criar objetos Coordenador e exibi-los. */
    public List<Coordenador> listarAdministradores(){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, email, id_endereco, id_sexo, data_contratacao, nivel_acesso, senha FROM Coordenador WHERE nivel_acesso = 'ADMIN'";
        //Decidir entre Admin, Administrador, Comum
        List<Coordenador> coordenadores = new ArrayList<>();
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            while(response.next()){
                coordenadores.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar coordenadores administradores: " + exception.getMessage());
        }
        return coordenadores;
    }

    public void atualizar(Coordenador coord, String cpf){
        String querySql = "UPDATE Coordenador SET id_endereco = ?, nivel_acesso = ? WHERE cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            ps.setInt(1, coord.getEndereco().getId());
            ps.setString(2, coord.getNivelAcesso());
            ps.setString(3, cpf);

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao atualizar coordenador: " + exception.getMessage());
        }
    }
    /**
     *
     * @param id
     */
    public void excluir(int id){
        String querySql = "DELETE FROM coordenador WHERE id = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir coordenador: " + exception.getMessage());
        }
    }
}
