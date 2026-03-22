package RaizDoBem.view;

import RaizDoBem.model.dao.PedidoAjudaDAO;
import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.util.Scanner;

public class PedidoMenu {
    public void menu() {
        PedidoAjudaDAO pedidoAjudaDAO = new PedidoAjudaDAO();
        PedidoAjuda pedidoAjuda = new PedidoAjuda();
        Scanner sc = new Scanner(System.in);
        int id;
        String cpf = "";
        System.out.println("\n      Gerenciar Pedidos de Ajuda     ");
        System.out.println("\n        1.  Adicionar pedido de ajuda");
        System.out.println("        2.  Listar todos os pedidos de ajuda");
        System.out.println("        3.  Buscar pedido de ajuda por CPF");
        System.out.println("        4.  Buscar pedidos por data");
        System.out.println("        5.  Atualizar pedido de ajuda");
        System.out.println("        6.  Excluir pedido de ajuda");
        System.out.println("        7.  Voltar ao menu principal");
        System.out.println("        0.  Encerrar programa");
        System.out.println("\nSelecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                pedidoAjudaDAO.adicionar(pedidoAjuda);
                break;
            case 2:
                System.out.println("Listagem dos pedidos de ajuda: ");
                pedidoAjudaDAO.listarTodos();
                break;
            case 3:
                pedidoAjudaDAO.buscarPorCpf(cpf);
                break;
            case 4:
                LocalDate data = LocalDate.now();
                pedidoAjudaDAO.listarPedidosData(data);
                break;
            case 5:
                PedidoAjuda pedido = new PedidoAjuda();
                pedidoAjudaDAO.atualizarPedido(pedido, cpf);
                break;
            case 6:
                id = 0;
                pedidoAjudaDAO.excluirPedido(id);
                break;
            case 7:
                System.out.println("Voltando ao menu principal...");
                break;
            case 0:
                System.out.println("Encerrando programa...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
        }
    }
}
