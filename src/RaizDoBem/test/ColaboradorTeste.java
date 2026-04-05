package RaizDoBem.test;

import RaizDoBem.controller.ColaboradorController;
import RaizDoBem.view.ColaboradorView;


public class ColaboradorTeste {
    public static void main(String[] args) {
        ColaboradorView view = new ColaboradorView();
        ColaboradorController controller = new ColaboradorController(view);

        //1º Metodo - Criação
//        controller.criar();

        //2º Metodo - Listando todos
        controller.listandoTodos();

        //3º metodo - buscando pelo cpf
//        String cpf = view.inputCpf();
//        controller.buscarPorCpf(cpf);

        //4º metodo - atualizando
//        String cpf = view.inputCpf();
//        controller.atualizar(cpf);

        //5º metodo - excluindo
//        String cpf = view.inputCpf();
//        controller.excluir(cpf);
    }
}
