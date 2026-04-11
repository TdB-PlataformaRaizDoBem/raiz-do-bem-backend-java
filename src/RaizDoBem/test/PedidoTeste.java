package RaizDoBem.test;

import java.time.LocalDate;

import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.view.PedidoAjudaView;

/**
 * Classe de teste com main para validar o fluxo de Pedido.
 */
public class PedidoTeste {
    public static void main(String[] args) {
        PedidoAjudaView view = new PedidoAjudaView();
        PedidoAjudaController controller = new PedidoAjudaController(view);

        //1º Metodo - Criação
//        controller.adicionar();

        //2º Metodo - Listando todos
        controller.listandoTodos();

        //3º Metodo - Listar por Cpf
        String cpf = view.inputCpf();
        controller.listarPorCpf(cpf);

        //4º Metodo - Listar pedido pelo idPedido
        int id = view.inputId();
        controller.buscarPeloId(id);

        //5º Metodo - Listar pedidos por data
        LocalDate data = view.inputData();
        controller.listarPelaData(data);

        //6º Metodo - Alterando dados de um pedido
        id = view.inputId();
        controller.atualizar(id);

        //7º Metodo - Excluindo um pedido de ajuda
        id = view.inputId();
        controller.deletar(id);

        //8º Metodo - Listando novamente para verificar mudanças
        controller.listandoTodos();

    }
}
