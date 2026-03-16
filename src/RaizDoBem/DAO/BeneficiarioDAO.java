package RaizDoBem.DAO;

import RaizDoBem.Model.Beneficiario;
import RaizDoBem.Model.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeneficiarioDAO {
    public void adicionar(Beneficiario beneficiario){
        String querySql = "INSERT INTO Beneficiario (cpf, nome_completo, data_nascimento, id_sexo, id_tipo_beneficiario, id_endereco) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){

            ps.setString(1, beneficiario.getCpfBeneficiario());
            ps.setString(2, beneficiario.getNomeCompleto());
            ps.setDate(3, Date.valueOf(beneficiario.getDataNascimento()));
            ps.setInt(4, beneficiario.getSexo().getIdSexo());
            ps.setInt(5, beneficiario.getTipoBeneficiario().getIdTipoBeneficiario());
            ps.setInt(6, beneficiario.getEndereco().getIdEndereco());

            ps.executeUpdate();
            System.out.println("Beneficiário criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar beneficiário: " + exception.getMessage());
        }
    }
}
