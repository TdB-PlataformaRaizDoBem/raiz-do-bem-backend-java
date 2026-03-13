package RaizDoBem.Controller;

import RaizDoBem.Model.PedidoAjuda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciaPedido implements Gerenciador<PedidoAjuda>{
    private List<PedidoAjuda> pedidos = new ArrayList<>();

    @Override
    public void adicionar(PedidoAjuda pedidoAjuda) {
        pedidos.add(pedidoAjuda);
        System.out.println("Pedido de ajuda adicionado.");
    }

    @Override
    public List<PedidoAjuda> listarTodos() {
        System.out.println("----- Listando pedidos de ajuda: -----");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (PedidoAjuda pedido : pedidos) {
            String dataFormatada = pedido.getDataPedido().format(formato);

            System.out.println("-----------------------------------------");
            System.out.println("ID do pedido: " + pedido.getIdPedido());
            System.out.println("Descrição: " + pedido.getDescricaoProblema());
            System.out.println("Data do pedido: " + dataFormatada);
            System.out.println("Status: " + pedido.getStatusPedido());
        }
        return pedidos;
    }

    @Override
    public void receberSalvarDados() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Adicionar novo pedido de ajuda: -----");

        int idPedido = (pedidos.size() + 1);

        System.out.println("Descrição do pedido de ajuda: ");
        String descricao = sc.nextLine();

        LocalDate dataPedido = LocalDate.now();

        System.out.println("Urgência de pedido: ");
        String urgencia = sc.nextLine();

        System.out.println("Status do pedido: ");
        String statusPedido = sc.nextLine();

        PedidoAjuda pedido = new PedidoAjuda(
                idPedido,
                descricao,
                dataPedido,
                statusPedido
        );

        adicionar(pedido);
    }
}
