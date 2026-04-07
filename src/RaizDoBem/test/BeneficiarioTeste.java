package RaizDoBem.test;

import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.view.BeneficiarioView;

/**
 * Testes para a classe BeneficiarioController, onde serão testados os seguintes métodos:
 * 1º Método - Criar um beneficiário, onde o usuário irá inserir os dados do beneficiário e o sistema irá criar um novo beneficiário com esses dados.
 * 2º Método - Listar todos os beneficiários, onde o sistema irá exibirr todos os beneficiários cadastrados no sistema.
 * 3º Método - Buscar por CPF, onde o usuário irá inserir o CPF do beneficiário e o sistema irá exibir as informações do beneficiário correspondente a esse CPF, caso exista.
 * 4º Método - Listar por Programa Social, onde o usuário irá inserir o ID do programa social e o sistema irá exibir uma lista de beneficiários que estão cadastrados nesse programa social.
 * 5º Método - Listar por Cidade, onde o usuário irá inserir o nome da cidade e o sistema irá exibir uma lista de beneficiários que estão cadastrados nessa cidade.
 * 6º Método - Atualizar, onde o usuário irá inserir o CPF do beneficiário que deseja atualizar, e o sistema irá solicitar as novas informações do beneficiário e atualizar os dados do beneficiário correspondente a esse CPF.
 * 7º Método - Excluir, onde o usuário irá inserir o CPF do beneficiário que deseja excluir, e o sistema irá remover o beneficiário correspondente a esse CPF do sistema.
 * Esses testes permitem verificar se os métodos da classe BeneficiarioController estão funcionando corretamente, garantindo que as operações de criação, listagem, busca, atualização e exclusão de beneficiários estão sendo realizadas conforme o esperado, e que os dados dos beneficiários estão sendo manipulados corretamente no sistema.
 * @author Paulo
 */
public class BeneficiarioTeste {
    public static void main(String[] args) {
        BeneficiarioView view = new BeneficiarioView();
        BeneficiarioController controller = new BeneficiarioController(view);

        //1º Metodo - Criação
        controller.criar();

        //2º Metodo - Listar todos
        controller.listandoTodos();
//
//        //3º Metodo - Buscar por Cpf
//        String cpf = view.inputCpf();
//        controller.buscarPorCpf(cpf);
//
//        //4º Metodo - Listar por Programa Social
//        int programaSocial = view.inputPrograma();
//        controller.listarPorPrograma(programaSocial);
//
//        //5º Metodo - Listar por Cidade
//        String cidade = view.inputCidade();
//        controller.listarPorCidade(cidade);
//
//        //6º Metodo - Atualizar
//        cpf = view.inputCpf();
//        controller.atualizar(cpf);

        //6º Metodo - Excluir
//        cpf = view.inputCpf();
//        controller.excluir(cpf);
    }
}