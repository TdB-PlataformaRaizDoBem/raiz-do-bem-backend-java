package RaizDoBem.test;

import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.view.BeneficiarioView;

/**
 * Classe de teste com main para validar o fluxo de Beneficiario.
 */
public class BeneficiarioTeste {
    public static void main(String[] args) {
        BeneficiarioView view = new BeneficiarioView();
        BeneficiarioController controller = new BeneficiarioController(view);

        //1º Metodo - Criar um beneficiário
        controller.criar();
        //2º Metodo - Listar todos os beneficiários
        controller.listandoTodos();

        //3º Metodo - Buscar beneficiário por Cpf
        String cpf = view.inputCpf();
        controller.buscarPorCpf(cpf);

        //4º Metodo - Listar beneficiários de um Programa Social
        int programaSocial = view.inputPrograma();
        controller.listarPorPrograma(programaSocial);

        //5º Metodo - Listar beneficiários de uma Cidade
        String cidade = view.inputCidade();
        controller.listarPorCidade(cidade);

        //6º Metodo - Atualizar beneficiário
        cpf = view.inputCpf();
        controller.atualizar(cpf);

        //7º Metodo - Excluir beneficiário
        cpf = view.inputCpf();
        controller.excluir(cpf);
    }
}