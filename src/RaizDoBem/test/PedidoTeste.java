package RaizDoBem.test;

import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.view.PedidoAjudaView;

import java.time.LocalDate;

public class PedidoTeste {
    public static void main(String[] args) {
        PedidoAjudaView view = new PedidoAjudaView();
        PedidoAjudaController controller = new PedidoAjudaController(view);

//      1º Metodo - Criação
//        controller.adicionar();

//      2º Metodo - Listando todos
        controller.listandoTodos();

//      3º Metodo - Listar por Cpf
//        String cpf = view.inputCpf();
//        controller.listarPorCpf(cpf);

//        int id = view.inputId();
//        controller.buscarPeloId(id);

//      4º Metodo - Listar por Data
//        LocalDate data = view.inputDataNasc();
//        controller.listarPelaData(data);

//      5º Metodo - Alterando
        String cpf = view.inputCpf();
        controller.atualizar(cpf);

//      6º Metodo - Excluindo
//        String cpf = view.inputCpf();
//       controller.deletar(cpf);

//        controller.listandoTodos();

    }
}
