package RaizDoBem.model.dao;

import RaizDoBem.model.vo.Conexao;
import RaizDoBem.model.vo.PedidoAjuda;

import java.sql.*;
import java.time.LocalDate;

/**
 * Classe de acesso a dados para a entidade PedidoAjuda, registro inicial que precede o registro de um beneficiário.
 * Responsável por realizar operações de CRUD (Create, Read, Update, Delete) relacionadas aos pedidos de ajuda.
 * @author Paulo
 * @since 2026-03
 *
 */
public class PedidoAjudaDAO {
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
    public void listarTodos(){
        String querySql = "SELECT id, cpf, descricao_problema, nome_completo, telefone, email, data, id_status_pedido FROM Pedido_Ajuda";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response = ps.executeQuery();
            while(response.next()){
                int id = response.getInt("id");
                String cpf = response.getString("cpf");
                String descricaoProblema = response.getString("descricao_problema");
                String nomeCompleto = response.getString("nome_completo");
                String telefone = response.getString("telefone");
                String email = response.getString("email");
                LocalDate data = response.getDate("data").toLocalDate();
                int idStatusPedido = response.getInt("id_status_pedido");

                PedidoAjuda pedido = new PedidoAjuda(
                        id,
                        cpf,
                        descricaoProblema,
                        nomeCompleto,
                        telefone,
                        email,
                        data,
                        idStatusPedido
                );

              System.out.println(pedido);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar pedidos de ajuda: " + exception.getMessage());
        }
    }
    public void buscarPorCpf(String cpf){}
    public void listarPedidosData(LocalDate data){}
    public void atualizarPedido(int idSelecionado, PedidoAjuda pedido){
        String querySql = "UPDATE Pedido_Ajuda SET id_status_pedido = ? WHERE id = ?";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
            ResultSet response = ps.executeQuery();){

            ps.setInt(1, pedido.getStatus().getId());
            ps.setInt(2, pedido.getId());

            if(response.next()){
                ps.executeUpdate();
            }
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao listar pedidos de ajuda: " + exception.getMessage());
        }
    }
    public void excluirPedido(int idSelecionado){
        String querySql = "DELETE FROM pedido_ajuda WHERE id = ? ";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setInt(1, idSelecionado);
            ps.executeUpdate();
        }
        catch (SQLException exception){
            throw new RuntimeException("Erro ao excluir pedido de ajuda: " + exception.getMessage());
        }
    }
}
