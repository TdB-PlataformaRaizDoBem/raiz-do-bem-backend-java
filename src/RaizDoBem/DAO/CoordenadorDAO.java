package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Coordenador;

import java.sql.*;
import java.time.LocalDate;

public class CoordenadorDAO {
    public void adicionar(Coordenador coord){
        String querySql = "INSERT INTO Coordenador (cpf, nome_completo, data_nascimento, email, id_endereco, data_contratacao, nivel_acesso) VALUES (?, ?, ?, ?, ?, ?, ?)";

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

            ps.executeUpdate();
            System.out.println("Coordenador criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar coordenador: " + exception.getMessage());
        }
    }

    public void listarTodos(){
        String querySql = "SELECT * FROM Coordenador";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;
            Coordenador coordenador;

            response = ps.executeQuery();
            System.out.println("Listagem dos coordenadores: ");
            while(response.next()){
                int id = response.getInt("id");
                String descricao = response.getString("descricao");
                LocalDate dataAtendimento = response.getDate("data").toLocalDate();
                int idBeneficiario = response.getInt("id_beneficiario");
                int idDentista = response.getInt("id_dentista");

                // coordenador = new Coordenador(id, cpf, nomeCompleto, dataNascimento, email, id_endereco, data_contratacao, nivelAcesso)
                //System.out.println(coordenador);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar coordenadores: " + exception.getMessage());
        }
    }
}
