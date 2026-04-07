package RaizDoBem.test;

import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.view.PedidoAjudaView;

/**
 * Classe de teste para a funcionalidade de Pedido de Ajuda. Esta classe é responsável por testar as operações relacionadas aos pedidos de ajuda, como criação, listagem, atualização e exclusão. Ela utiliza o PedidoAjudaController para realizar as operações e o PedidoAjudaView para interagir com o usuário e exibir os resultados.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - Criação: Testa a criação de um novo pedido de ajuda, solicitando as informações necessárias ao usuário e utilizando o controller para adicionar o pedido ao sistema.
 * 2º Metodo - Listando todos: Testa a listagem de todos os pedidos de ajuda cadastrados, utilizando o controller para recuperar a lista de pedidos e exibindo-os ao usuário.
 * 3º Metodo - Listar por Cpf: Testa a recuperação de pedidos de ajuda específicos com base no CPF do beneficiário, solicitando o CPF ao usuário e utilizando o controller para buscar e exibir os pedidos correspondentes.
 * 4º Metodo - Listar por Data: Testa a recuperação de pedidos de ajuda com base na data de criação, solicitando a data ao usuário e utilizando o controller para buscar e exibir os pedidos criados na data especificada.
 * 5º Metodo - Alterando: Testa a atualização de um pedido de ajuda existente, solicitando o CPF do beneficiário e as novas informações ao usuário, e utilizando o controller para realizar a atualização no sistema.
 * 6º Metodo - Excluindo: Testa a exclusão de um pedido de ajuda, solicitando o CPF do beneficiário ao usuário e utilizando o controller para remover o pedido do sistema.
 */
public class PedidoTeste {
    public static void main(String[] args) {
        PedidoAjudaView view = new PedidoAjudaView();
        PedidoAjudaController controller = new PedidoAjudaController(view);

//      1º Metodo - Criação
//        controller.adicionar();

//      2º Metodo - Listando todos
        controller.listandoTodos();
//
////      3º Metodo - Listar por Cpf
//        String cpf = view.inputCpf();
//        controller.listarPorCpf(cpf);
//
//        int id = view.inputId();
//        controller.buscarPeloId(id);
//
////      4º Metodo - Listar por Data
//        LocalDate data = view.inputDataNasc();
//        controller.listarPelaData(data);

//      5º Metodo - Alterando
        int id = view.inputId();
        controller.atualizar(id);

////      6º Metodo - Excluindo
//        int id = view.inputId();
//        controller.deletar(id);

        controller.listandoTodos();

    }
}
