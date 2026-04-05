package RaizDoBem.test;

import RaizDoBem.controller.ColaboradorController;
import RaizDoBem.view.ColaboradorView;


public class ColaboradorTeste {
    public static void main(String[] args) {
        ColaboradorView view = new ColaboradorView();
        ColaboradorController controller = new ColaboradorController(view);

        controller.criar();

        controller.listandoTodos();

        controller.buscarPorCpf();

        controller.atualizar();

        controller.excluir();
    }
}
