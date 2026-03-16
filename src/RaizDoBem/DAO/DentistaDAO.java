package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Coordenador;
import RaizDoBem.Model.Dentista;
import RaizDoBem.Model.Endereco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DentistaDAO {
    public void adicionar(Dentista dentista){
        String querySql = "INSERT INTO Dentista (cpf, nome_completo, data_nascimento, email, id_endereco, cro, disponivel ) VALUES (?, ?, ?, ?, ?, ?, ?)";
//            public Dentista(int idColaborador, String cpf, String nomeCompleto, LocalDate
//        dataNascimento, String email, Endereco endereco, String croDentista boolean isDisponivel) {
//            super(idColaborador, cpf, nomeCompleto, dataNascimento, email, endereco);
//            this.croDentista = croDentista;
//            this.isDisponivel = isDisponivel;

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            //verificar como consertar idColaborador e idCoordenador
            ps.setString(1, dentista.getCpf());
            ps.setString(2, dentista.getNomeCompleto());
            ps.setDate(3, Date.valueOf(dentista.getDataNascimento()));
            ps.setString(4, dentista.getEmail());
            ps.setInt(5, dentista.getEndereco().getIdEndereco());
            ps.setString(6, dentista.getCroDentista());
            ps.setBoolean(7, dentista.isDisponivel());

            ps.executeUpdate();
            System.out.println("Dentista criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao adicionar dentista: " + exception.getMessage());
        }
    }
}
