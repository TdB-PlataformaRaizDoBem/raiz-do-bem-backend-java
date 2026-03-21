package RaizDoBem.model.dao;

import RaizDoBem.model.vo.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de acesso a dados relacionadas aos beneficiários da ONG. Contém métodos para adicionar, listar, atualizar e excluir beneficiários no banco de dados.
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioDAO {
    List<Beneficiario> beneficiarios = new ArrayList<>();
    /** O beneficiário é a pessoa que recebe os serviços odontológicos prestados pela ONG. Ele possui informações pessoais, como CPF, nome completo, data de nascimento, telefone, email, sexo, programa social ao qual pertence, endereço, pedido de ajuda e coordenador responsável. O coordenador pode criar um beneficiário para registrar uma pessoa que receberá os serviços, listar os beneficiários cadastrados, atualizar as informações de um beneficiário específico e excluir um beneficiário do sistema.
     * Este metodo é responsável por mapear os dados retornados do banco de dados para criar um objeto Beneficiario, facilitando a manipulação dos dados no sistema.
     * @param response ResultSet contendo os dados do beneficiário retornados do banco de dados.
     *
     * @return Objeto Beneficiario criado a partir dos dados do ResultSet.
     * */
    private Beneficiario mapeamento(ResultSet response) throws SQLException {
        return new Beneficiario(
            response.getInt("id"),
            response.getString("cpf"),
            response.getString("nome_completo"),
            response.getDate("data_nascimento").toLocalDate(),
            response.getString("telefone"),
            response.getString("email"),
            response.getInt("id_sexo"),
            response.getInt("id_programa"),
            response.getInt("id_endereco"),
            response.getInt("id_pedido_ajuda"),
            response.getInt("id_coordenador")
        );
    }

    /** O metodo adicionar() é responsável por inserir um novo beneficiário no banco de dados. Ele recebe um objeto Beneficiario como parâmetro, prepara uma consulta SQL de inserção e executa a operação para adicionar o beneficiário ao sistema.
     *
     * @param beneficiario Objeto do tipo Beneficiario contendo as informações do beneficiário a ser adicionado.
     * */
    public void adicionar(Beneficiario beneficiario){
        String querySql = "INSERT INTO Beneficiario (cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa_social, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            ps.setString(1, beneficiario.getCpf());
            ps.setString(2, beneficiario.getNomeCompleto());
            ps.setDate(3, Date.valueOf(beneficiario.getDataNascimento()));
            ps.setString(4, beneficiario.getTelefone());
            ps.setString(5, beneficiario.getEmail());
            ps.setInt(6, beneficiario.getSexo().getId());
            ps.setInt(7, beneficiario.getProgramaSocial().getId());
            ps.setInt(8, beneficiario.getEndereco().getId());

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao adicionar beneficiário: " + exception.getMessage());
        }
    }

    /** O metodo listarTodos() é responsável por recuperar e exibir todos os registros de beneficiários presentes no banco de dados. Ele executa uma consulta SQL para selecionar as colunas relevantes da tabela Beneficiario, e itera sobre os resultados para criar objetos Beneficiario e exibi-los. */
    public List<Beneficiario> listarTodos(){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa, id_endereco, id_pedido_ajuda, id_coordenador FROM Beneficiario";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            while(response.next()){
                beneficiarios.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return beneficiarios;
    }

    /** O metodo buscarPorCpf() é responsável por recuperar e exibir os registros de um beneficiário específico. Ele executa uma consulta SQL que seleciona o beneficiário onde o id corresponde ao id do beneficiário fornecido como parâmetro, e itera sobre os resultados para criar um objeto Beneficiario e exibi-lo. */
    public Beneficiario buscarPorCpf(String cpf){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa, id_endereco, id_pedido_ajuda, id_coordenador FROM Beneficiario WHERE cpf = ?";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setString(1, cpf);

            try(ResultSet response = ps.executeQuery();){
                if(response.next()){
                    return mapeamento(response);
                }
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return null;
    }

    /** O metodo listarPorPrograma() é responsável por recuperar e exibir os registros de beneficiários relacionados a um programa social específico. Ele executa uma consulta SQL que seleciona os beneficiários onde o id_programa corresponde ao id do programa fornecido como parâmetro, e itera sobre os resultados para criar objetos Beneficiario e exibi-los. */
    public List<Beneficiario> buscarPorPrograma(int idPrograma){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa, id_endereco, id_pedido_ajuda, id_coordenador FROM Beneficiario WHERE id_programa = ?";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setInt(1, idPrograma);

            try(ResultSet response = ps.executeQuery();){
                while(response.next()){
                    beneficiarios.add(mapeamento(response));
                }
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return beneficiarios;
    }

    /** O metodo listagemPorCidade() é responsável por recuperar e exibir os registros de beneficiários relacionados a uma cidade específica. Ele executa uma consulta SQL que seleciona os beneficiários onde o id_endereco corresponde ao id do endereço fornecido como parâmetro, e itera sobre os resultados para criar objetos Beneficiario e exibi-los. */
    public List<Beneficiario> listarPorCidade(String cidade){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, telefone, email, id_sexo, id_programa, id_endereco, id_pedido_ajuda, id_coordenador FROM Beneficiario b, Endereco e WHERE e.cidade = ?";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setString(1, cidade);

            try(ResultSet response = ps.executeQuery();){
                while(response.next()){
                    beneficiarios.add(mapeamento(response));
                }
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar atendimentos: " + exception.getMessage());
        }
        return beneficiarios;
    }

    /** O metodo atualizarBeneficiario() é responsável por atualizar as informações de um beneficiário específico no banco de dados. Ele recebe o id do beneficiário a ser atualizado como parâmetro, prepara uma consulta SQL de atualização e executa a operação para modificar os dados do beneficiário no sistema. *
     *
     * @param cpf
     * @param beneficiario
     */
    public void atualizar(String cpf, Beneficiario beneficiario){
        String querySql = "UPDATE Beneficiario SET telefone = ?, email = ?, id_endereco = ? WHERE cpf = ?";


        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            ps.setString(1, beneficiario.getTelefone());
            ps.setString(2, beneficiario.getEmail());
            ps.setInt(3, beneficiario.getEndereco().getId());
            ps.setString(4, beneficiario.getCpf());
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao atualizar Beneficiário: " + exception.getMessage());
        }
    }

    /** O metodo excluirBeneficiario() é responsável por excluir um beneficiário específico do banco de dados. Ele recebe o id do beneficiário a ser excluído como parâmetro, prepara uma consulta SQL de exclusão e executa a operação para remover o beneficiário do sistema.
     * @param cpf
     * */
    public void excluir(String cpf){
        String querySql = "DELETE FROM beneficiario WHERE cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.setString(1, cpf);
            ps.executeUpdate();
            }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir beneficiário: " + exception.getMessage());
        }
    }
}
