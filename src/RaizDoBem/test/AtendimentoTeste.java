package RaizDoBem.test;

import RaizDoBem.controller.AtendimentoController;
import RaizDoBem.view.AtendimentoView;

/**
 * Classe de teste com main para validar o fluxo de Atendimento.
 */
public class AtendimentoTeste {
    public static void main(String[] args) {
        AtendimentoView view = new AtendimentoView();
        AtendimentoController controller = new AtendimentoController(view);

        // 1 - Criando atendimento
        controller.adicionar();

        //2 - Listando todos os atendimentos
        controller.listandoTodos();

        //3 - Listando por CPF
        String cpf = view.inputCpf();
        controller.listarPorCpf(cpf);

        //4 - Atualizando um atendimento
        int id = view.inputId();
        controller.atualizar(id);

        //5 - Listando novamente para verificar a atualização
        controller.listandoTodos();
    }
}
