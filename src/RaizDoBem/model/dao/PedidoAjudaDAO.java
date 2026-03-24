package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.PedidoAjuda;

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
        return new PedidoAjuda(
                response.getInt("id"),
                response.getString("cpf"),
                response.getString("descricao_problema"),
                response.getString("nome_completo"),
                response.getString("telefone"),
                response.getString("email"),
                response.getDate("data").toLocalDate(),
                response.getInt("id_status")
        );
    }
    public void adicionar(PedidoAjuda pedido){
        String querySql = "INSERT INTO Pedido_Ajuda (cpf, descricao_problema, nome_completo, telefone, email, data, id_status_pedido) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, pedido.getCpf());
            ps.setString(2, pedido.getDescricaoProblema());
            ps.setString(3, pedido.getNomeCompleto());
            ps.setString(4, pedido.getTelefone());
            ps.setString(5, pedido.getEmail());
            ps.setDate(6, Date.valueOf(pedido.getData()));
            ps.setInt(7, pedido.getStatus().getId());

            ps.executeUpdate();
            System.out.println("Pedido de ajuda criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao criar novo pedido de ajuda: " + exception.getMessage());
        }
    }
    public List<PedidoAjuda> listarTodos(){
        String querySql = "SELECT id, cpf, descricao_problema, nome_completo, telefone, email, data, id_status_pedido FROM Pedido_Ajuda";
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
        String querySql = "SELECT id, cpf, descricao_problema, nome_completo, telefone, email, data, id_status_pedido FROM Pedido_Ajuda where cpf = ?";

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
        String querySql = "SELECT id, cpf, descricao_problema, nome_completo, telefone, email, data, id_status_pedido FROM Pedido_Ajuda WHERE data = ?";
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
        String querySql = "UPDATE Pedido_Ajuda SET id_status_pedido = ? WHERE cpf = ?";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql)) {

            ps.setInt(1, pedido.getStatus().getId());
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
