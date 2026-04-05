package RaizDoBem.test;

import RaizDoBem.controller.AtendimentoController;
import RaizDoBem.view.AtendimentoView;


public class AtendimentoTeste {
    public static void main(String[] args) {
        AtendimentoView view = new AtendimentoView();
        AtendimentoController controller = new AtendimentoController(view);

        controller.listandoTodos();

        controller.adicionar();

        controller.listandoTodos();

//        String cpf = view.inputCpf();
//        controller.listarPorCpf(cpf);


    }
}
