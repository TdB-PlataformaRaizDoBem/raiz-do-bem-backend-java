package RaizDoBem.DAO;

import RaizDoBem.Model.Conexao;
import RaizDoBem.Model.Endereco;
import RaizDoBem.Model.PedidoAjuda;

import java.sql.*;

public class PedidoAjudaDAO {
    public void adicionar(PedidoAjuda pedido){
        String querySql = "INSERT INTO Pedido_Ajuda (id, descricao_problema, nome_completo, telefone, email, data, id_coordenador, id_status_pedido) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);
        ){
            ps.setString(1, pedido.getDescricaoProblema());
            ps.setString(2, pedido.getNomeCompleto());
            ps.setString(3, pedido.getTelefone());
            ps.setString(4, pedido.getEmail());
            ps.setDate(5, Date.valueOf(pedido.getDataPedido()));
            ps.setInt(5, pedido.getCoordenador().getIdCoordenador());
            ps.setInt(6, pedido.getStatus().getIdStatus());

            ps.executeUpdate();
            System.out.println("Pedido de ajuda criado e adicionado com sucesso!!");
        }
        catch (SQLException exception){
            System.out.println("Erro ao criar novo pedido de ajuda: " + exception.getMessage());
        }
    }
    public void listarTodos(){
        String querySql = "SELECT * FROM Pedido_Ajuda";
        try(Connection conexao = Conexao.conectarAoBanco();
            PreparedStatement ps = conexao.prepareStatement(querySql);){

            ResultSet response;

            response = ps.executeQuery();
            System.out.println("Listagem dos pedidos de ajuda: ");
            while(response.next()){
                int id = response.getInt("id");
                String descricao = response.getString("descricao_problema");
                String nomeCompleto = response.getString("nome_completo");
                String telefone = response.getString("telefone");
                String email = response.getString("email");
                Date data = response.getDate("data");
                int idCoordenador = response.getInt("id_coordenador");
                int idStatusPedido = response.getInt("id_status_pedido");

//                pedido = new PedidoAjuda(id, descricao, nomeCompleto, telefone, email, data, idCoordenador, idStatusPedido);
//                System.out.println(pedido);
            }
        }
        catch (SQLException exception){
            System.out.println("Erro ao listar pedidos de ajuda: " + exception.getMessage());
        }
    }
}
