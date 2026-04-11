package RaizDoBem;

import RaizDoBem.controller.AtendimentoController;
import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.view.AtendimentoView;
import RaizDoBem.view.BeneficiarioView;
import RaizDoBem.view.PedidoAjudaView;

/**
 * Fluxo principal integrado da aplicacao: demonstra o encadeamento
 * PedidoAjuda -> Beneficiario -> Atendimento.
 * Para testes detalhados de cada modulo, consulte as classes em src/RaizDoBem/test/.
 */
public class Main {
    public static void main(String[] args) {
        PedidoAjudaView pedidoView = new PedidoAjudaView();
        PedidoAjudaController pedidoController = new PedidoAjudaController(pedidoView);
        BeneficiarioView beneficiarioView = new BeneficiarioView();
        BeneficiarioController beneficiarioController = new BeneficiarioController(beneficiarioView);
        AtendimentoView atendimentoView = new AtendimentoView();
        AtendimentoController atendimentoController = new AtendimentoController(atendimentoView);

        //Criando pedido de ajuda
        pedidoController.adicionar();
        //Listando pedidos de ajuda
        pedidoController.listandoTodos();
        //Atualizando pedido de ajuda
        int id = pedidoView.inputId();
        pedidoController.atualizar(id);
        //Listando os beneficiários para verificar pedido aprovado => beneficiário criado
        beneficiarioController.listandoTodos();
        //Criando atendimento
        atendimentoController.adicionar();
        //Listando atendimentos
        atendimentoController.listandoTodos();
        //Atualizando atendimento
        id = atendimentoView.inputId();
        atendimentoController.atualizar(id);
        //Listando atendimentos
        atendimentoController.listandoTodos();
    }
}
