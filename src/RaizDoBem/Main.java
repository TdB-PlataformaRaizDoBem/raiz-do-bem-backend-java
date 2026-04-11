package RaizDoBem;

import RaizDoBem.controller.AtendimentoController;
import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.controller.EnderecoController;
import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.view.AtendimentoView;
import RaizDoBem.view.BeneficiarioView;
import RaizDoBem.view.EnderecoView;
import RaizDoBem.view.PedidoAjudaView;

public class Main {
    public static void main(String[] args) {
        PedidoAjudaView pedidoView = new PedidoAjudaView();
        PedidoAjudaController pedidoControlller = new PedidoAjudaController(pedidoView);
        BeneficiarioView beneficiarioView = new BeneficiarioView();
        BeneficiarioController beneficiarioController = new BeneficiarioController(beneficiarioView);
        AtendimentoView atendimentoView = new AtendimentoView();
        AtendimentoController atendimentoController = new AtendimentoController(atendimentoView);

        //Criando pedido de ajuda
        pedidoControlller.adicionar();
        //Listando pedidos de ajuda
        pedidoControlller.listandoTodos();
        //Atualizando pedido de ajuda
        int id = pedidoView.inputId();
        pedidoControlller.atualizar(id);
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

//        EnderecoView enderecoView = new EnderecoView();
//        EnderecoController enderecoController =  new EnderecoController(enderecoView);
//        enderecoController.adicionar();
    }
}
