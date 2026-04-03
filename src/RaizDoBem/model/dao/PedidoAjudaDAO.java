package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.PedidoAjuda;
import RaizDoBem.model.vo.Sexo;
import RaizDoBem.model.vo.StatusPedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para a entidade PedidoAjuda, registro inicial que precede o registro de um beneficiário.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos pedidos de ajuda.
 * @author Paulo
 * @since 2026-03
 *
 */
public class PedidoAjudaDAO {
    public PedidoAjuda mapeamento(ResultSet response) throws SQLException{
        String sexoSolicitante = response.getString("sexo");
        Sexo sexo = Sexo.valueOf(sexoSolicitante.toUpperCase());

        String statusPedido = response.getString("status_pedido");
        StatusPedido status = StatusPedido.valueOf(statusPedido);
        return new PedidoAjuda(
                response.getInt("id"),
                response.getString("cpf"),
                response.getString("nome_completo"),
                response.getDate("data_nascimento").toLocalDate(),
                sexo,
                response.getString("telefone"),
                response.getString("email"),
                response.getString("descricao_problema"),
                response.getDate("data_pedido").toLocalDate(),
                status,
                response.getInt("id_dentista"),
                response.getInt("id_endereco")

        );
    }
    public void adicionar(PedidoAjuda pedido){
        String querySql = "INSERT INTO Pedido_Ajuda (id, cpf, nome_completo, data_nascimento, sexo, telefone, email,descricao_problema, data_pedido, status_pedido) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, pedido.getCpf());
            ps.setString(2, pedido.getDescricaoProblema());
            ps.setString(3, pedido.getNomeCompleto());
            ps.setString(4, pedido.getTelefone());
            ps.setString(5, pedido.getEmail());
            ps.setDate(6, Date.valueOf(pedido.getData()));
            ps.setString(7, pedido.getStatus().name());

            ps.executeUpdate();
            System.out.println("Pedido de ajuda criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao criar novo pedido de ajuda: " + exception.getMessage());
        }
    }
    public List<PedidoAjuda> listarTodos(){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, sexo, telefone, email,descricao_problema, data_pedido, status_pedido FROM Pedido_Ajuda";
        List<PedidoAjuda> pedidos = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery()) {

            while(response.next()){
                pedidos.add(mapeamento(response));
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar pedidos de ajuda: " + exception.getMessage());
        }
        return pedidos;
    }
    public PedidoAjuda buscarPorCpf(String cpf){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, sexo, telefone, email,descricao_problema, data_pedido, status_pedido FROM Pedido_Ajuda where cpf = ?";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, cpf);

            try(ResultSet response = ps.executeQuery();){
                if(response.next())
                    return mapeamento(response);
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao encontrar cpf: " + exception.getMessage());
        }
        return null;
    }
    public List<PedidoAjuda> listarPedidosData(LocalDate data){
        String querySql = "SELECT id, cpf, nome_completo, data_nascimento, sexo, telefone, email,descricao_problema, data_pedido, status_pedido FROM Pedido_Ajuda WHERE data = ?";
        List<PedidoAjuda> pedidos = new ArrayList<>();

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setDate(1, Date.valueOf(data));

            try(ResultSet response = ps.executeQuery()) {
                while(response.next()){
                    pedidos.add(mapeamento(response));
                }
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar pedidos de ajuda da data específica: " + exception.getMessage());
        }
        return pedidos;
    }
    public void atualizarPedido(PedidoAjuda pedido, String cpf){
        String querySql = "UPDATE Pedido_Ajuda SET status_pedido = ? WHERE cpf = ?";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setString(1, pedido.getStatus().name());
            ps.setString(2, cpf);

            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao atualizar pedido de ajuda: " + exception.getMessage());
        }
    }
    public void excluirPedido(int id){
        String querySql = "DELETE FROM pedido_ajuda WHERE id = ? ";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir pedido de ajuda: " + exception.getMessage());
        }
    }
}
