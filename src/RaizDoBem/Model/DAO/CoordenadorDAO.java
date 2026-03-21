package RaizDoBem.Model.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Coordenador;

import java.sql.*;
import java.time.LocalDate;

/**
 * Classe de acesso a dados dos Coordenadores da ONG.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos coordenadores.
 * @author Paulo
 * @since 2026-03
 *
 */
public class CoordenadorDAO {
    /**
     * Metodo para adicionar um novo coordenador ao banco de dados.
     * @param coord Objeto do tipo Coordenador contendo as informações do coordenador a ser adicionado.
     */
    public void adicionar(Coordenador coord){
        String querySql = "INSERT INTO Coordenador (cpf, nome_completo, data_nascimento, email, id_endereco, data_contratacao, nivel_acesso, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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
            System.out.println("Coordenador criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar coordenador: " + exception.getMessage());
        }
    }
    /** O metodo listarTodos() é responsável por recuperar e exibir todos os registros de coordenadores presentes no banco de dados. Ele executa uma consulta SQL para selecionar as colunas relevantes da tabela Coordenador, e itera sobre os resultados para criar objetos Coordenador e exibi-los.
     * */
    public void listarTodos(){
        String querySql = "SELECT * FROM Coordenador";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response = ps.executeQuery();
            System.out.println("Listagem dos coordenadores: ");
            while(response.next()){
                int id = response.getInt("id");
                String cpf = response.getString("cpf");
                String nomeCompleto = response.getString("nome_completo");
                LocalDate dataNascimento = response.getDate("data_nascimento").toLocalDate();
                String email = response.getString("email");
                int idEndereco = response.getInt("id_endereco");
                int idSexo = response.getInt("id_sexo");
                LocalDate dataContratacao = response.getDate("data_contratacao").toLocalDate();
                String nivelAcesso = response.getString("nivel_acesso");
                String senha = response.getString("senha");

                Coordenador coordenador = new Coordenador(
                        id,
                        cpf,
                        nomeCompleto,
                        dataNascimento,
                        email,
                        idEndereco,
                        idSexo,
                        dataContratacao,
                        nivelAcesso,
                        senha
                );
                System.out.println(coordenador);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar coordenadores: " + exception.getMessage());
        }
    }
    /** O metodo listarAdministradores() é responsável por recuperar e exibir os registros de coordenadores que possuem o nível de acesso "ADMIN". Ele executa uma consulta SQL que seleciona os coordenadores onde o campo nivel_acesso é igual a "ADMIN", e itera sobre os resultados para criar objetos Coordenador e exibi-los. */
    public void listarAdministradores(){
        String querySql = "SELECT * FROM Coordenador WHERE nivel_acesso = 'ADMIN'";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Coordenador coordenador;

            response = ps.executeQuery();
            System.out.println("Listagem dos coordenadores administradores: ");
            while(response.next()){
                int id = response.getInt("id");
                String descricao = response.getString("cpf");
                String nomeCompleto = response.getString("nome_completo");
                LocalDate dataNascimento = response.getDate("data_nascimento").toLocalDate();
                String email = response.getString("email");
                int idEndereco = response.getInt("id_endereco");
                LocalDate data_contratacao = response.getDate("data_contratacao").toLocalDate();
                String nivelAcesso = response.getString("nivel_acesso");
                String senha = response.getString("senha");

                //coordenador = new Coordenador(id, cpf, nomeCompleto, dataNascimento, email, id_endereco, data_contratacao, nivelAcesso, senha)
                //System.out.println(coordenador);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar coordenadores administradores: " + exception.getMessage());
        }
    }
    /** O metodo atualizarCoordenador() é responsável por atualizar as informações de um coordenador específico. Ele recebe o id do coordenador a ser atualizado como parâmetro, e pode ser implementado para solicitar as novas informações do coordenador e executar uma consulta SQL de atualização para modificar os dados no banco de dados.
     * @param idSelecionado O id do coordenador a ser atualizado.
     * */
    public void excluirCoordenador(int idSelecionado){
        String querySql = "DELETE FROM coordenador WHERE id = " + idSelecionado;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.executeUpdate();
            System.out.println("Coordenador ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            System.out.println("Erro ao excluir coordenador: " + exception.getMessage());
        }
    }
}
