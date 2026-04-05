package RaizDoBem.test;

import RaizDoBem.controller.ColaboradorController;
import RaizDoBem.view.ColaboradorView;

/**
 * Testes para a classe ColaboradorController, onde serão testados os seguintes métodos:
 * 1º Método - Criar um colaborador, onde o usuário irá inserir os dados do colaborador e o sistema irá criar um novo colaborador com esses dados.
 * 2º Método - Listar todos os colaboradores, onde o sistema irá exibir todos os colaboradores cadastrados no sistema.
 * 3º Método - Buscar por CPF, onde o usuário irá inserir o CPF do colaborador e o sistema irá exibir as informações do colaborador correspondente a esse CPF, caso exista.
 * 4º Método - Atualizar, onde o usuário irá inserir o CPF do colaborador que deseja atualizar, e o sistema irá solicitar as novas informações do colaborador e atualizar os dados do colaborador correspondente a esse CPF.
 * 5º Método - Excluir, onde o usuário irá inserir o CPF do colaborador que deseja excluir, e o sistema irá remover o colaborador correspondente a esse CPF do sistema.
 * Esses testes permitem verificar se os métodos da classe ColaboradorController estão funcionando corretamente, garantindo que as operações de criação, listagem, busca, atualização e exclusão de colaboradores estão sendo realizadas conforme o esperado, e que os dados dos colaboradores estão sendo manipulados corretamente no sistema.
 * @author Paulo
 */
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
