package RaizDoBem.test;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.view.DentistaView;

/**
 * Classe de teste com main para validar o fluxo de Dentista.
 */
public class DentistaTeste {
    public static void main(String[] args) {
        DentistaView view = new DentistaView();
        DentistaController controller = new DentistaController(view);

        //Listando beneficiários
        controller.listandoTodos();

        //1 - Criando dentista
        controller.criar();

        //2 - Buscando um dentista pelo seu Cpf
        String cpf = view.inputCpf();
        controller.buscarPorCpf(cpf);

        //3 - Listando dentistas por Cidade
        String cidade = view.inputCidade();
        controller.listarPorCidade(cidade);

        //4 - Listando dentistas com status disponível
        controller.listarDisponiveis();

        //5 - Atualizando dados de um dentista
        cpf = view.inputCpf();
        controller.atualizar(cpf);

        //6 - Excluindo um dentista
        cpf = view.inputCpf();
        controller.apagar(cpf);

        controller.listandoTodos();
    }
}
