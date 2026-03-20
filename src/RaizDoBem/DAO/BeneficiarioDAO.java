package RaizDoBem.DAO;

import RaizDoBem.Model.Beneficiario;
import RaizDoBem.Model.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeneficiarioDAO {
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
            System.out.println("Beneficiário criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar beneficiário: " + exception.getMessage());
        }
    }

    public void excluirBeneficiario(int idSelecionado){
        String querySql = "DELETE FROM beneficiario WHERE id = " + idSelecionado;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ps.executeUpdate();
            System.out.println("Beneficiario ID - (" + idSelecionado + ") foi excluído do banco de dados");
        }
        catch (SQLException exception){
            System.out.println("Erro ao excluir beneficiário: " + exception.getMessage());
        }
    }
}
