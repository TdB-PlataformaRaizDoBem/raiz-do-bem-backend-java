package RaizDoBem.DAO;

import RaizDoBem.Model.*;

import java.sql.*;
import java.time.LocalDate;

public class DentistaDAO {
    private Dentista mapeamento(ResultSet response) throws SQLException {
        int id = response.getInt("id_colaborador");
        String cpf = response.getString("cpf");
        String nomeCompleto = response.getString("nome_completo");
        LocalDate dataNascimento = response.getDate("data_nascimento").toLocalDate();
        String email = response.getString("email");
        int idEndereco = response.getInt("id_endereco");
        String logradouro = response.getString("logradouro");
        int idSexo = response.getInt("id_sexo");
        String sexo = response.getString("tipo");
        String croDentista = response.getString("cro");
        String disponibilidade = response.getString("disponibilidade");

        return new Dentista(
                id,
                cpf,
                nomeCompleto,
                dataNascimento,
                email,
                idEndereco,
                idSexo,
                croDentista,
                disponibilidade);
    }
    public void adicionar(Dentista dentista){
        String querySql = "INSERT INTO Dentista (cpf, nome_completo, data_nascimento, email, id_endereco, id_sexo, cro, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, dentista.getCpf());
            ps.setString(2, dentista.getNomeCompleto());
            ps.setDate(3, Date.valueOf(dentista.getDataNascimento()));
            ps.setString(4, dentista.getEmail());
            ps.setInt(5, dentista.getEndereco().getId());
            ps.setInt(6, dentista.getSexo().getId());
            ps.setString(7, dentista.getCroDentista());
            ps.setString(8, dentista.getDisponibilidade());

            ps.executeUpdate();
            System.out.println("Dentista criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar dentista: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento,c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero FROM Dentista d, Colaborador c, Sexo s, Endereco e";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            try(ResultSet response = ps.executeQuery();){
                System.out.println("Listagem dos dentistas: ");
                while(response.next()){
                    Dentista dentista = mapeamento(response);
                    System.out.println(dentista);
                }
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos: " + exception.getMessage());
        }
    }
    public void listarPorCidade(String cidadeEscolhida){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento, c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero FROM Dentista d, Colaborador c, Sexo s, Endereco e WHERE e.cidade  = '" + cidadeEscolhida + "'";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            try(ResultSet response = ps.executeQuery();){
                System.out.println("Listagem dos dentistas da cidade: (" + cidadeEscolhida + "): ");
                while(response.next()){
                    Dentista dentista = mapeamento(response);
                    System.out.println(dentista);
                }
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar dentistas da cidade (" + cidadeEscolhida +  "): " + exception.getMessage());
        }
    }
    public void listarDisponiveis(){
        String querySql = "SELECT d.id_colaborador, c.cpf, c.nome_completo, c.data_nascimento, c.email, s.tipo, d.cro, d.disponibilidade, e.logradouro, e.numero, e.cidade FROM Dentista d, Coordenador c, Endereco e, Sexo s WHERE d.id_coordenador = c.id AND e.disponibilidade = 'Sim'";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            try(ResultSet response = ps.executeQuery();){
                System.out.println("Listagem dos dentistas disponíveis: ");
                while(response.next()){
                    Dentista dentista = mapeamento(response);
                    System.out.println(dentista);
                }
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar atendimentos: " + exception.getMessage());
        }
    }
    public void atualizarDentista(int idSelecionado){}
    public void excluirDentista(int idSelecionado){
        String querySql = "DELETE FROM dentista WHERE id = " + idSelecionado;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.executeUpdate();
            System.out.println("Dentista ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            System.out.println("Erro ao excluir dentista: " + exception.getMessage());
        }
    }
}
