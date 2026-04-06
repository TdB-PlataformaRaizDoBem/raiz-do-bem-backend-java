package RaizDoBem.test;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.view.DentistaView;

/**
 * Testes para a classe DentistaController, onde serão testados os seguintes métodos:
 * 1º Metodo - Criar um dentista, onde o usuário irá inserir os dados do dentista e o sistema irá criar um novo dentista com esses dados.
 * 2º Metodo - Listar todos os dentistas, onde o sistema irá exibir todos os dentistas cadastrados no sistema.
 * 3º Metodo - Buscar por CPF, onde o usuário irá inserir o CPF do dentista e o sistema irá exibir as informações do dentista correspondente a esse CPF, caso exista.
 * 4º Metodo - Atualizar, onde o usuário irá inserir o CPF do dentista que deseja atualizar, e o sistema irá solicitar as novas informações do dentista e atualizar os dados do dentista correspondente a esse CPF.
 * 5º Metodo - Excluir, onde o usuário irá inserir o CPF do dentista que deseja excluir, e o sistema irá remover o dentista correspondente a esse CPF do sistema.
 * Esses testes permitem verificar se os métodos da classe DentistaController estão funcionando corretamente, garantindo que as operações de criação, listagem, busca, atualização e exclusão de dentistas estão sendo realizadas conforme o esperado, e que os dados dos dentistas estão sendo manipulados corretamente no sistema.
 * @author Paulo
 */
public class DentistaTeste {
    public static void main(String[] args) {
        DentistaView view = new DentistaView();
        DentistaController controller = new DentistaController(view);

        controller.listandoTodos();

        controller.criar();



//        String cpf = view.inputCpf();
//        controller.buscarPorCpf(cpf);

//        String cidade = view.inputCidade();
//        controller.listarPorCidade(cidade);
//
//        controller.listarDisponiveis();

//        String cpf = view.inputCpf();
//        controller.atualizar(cpf);

//        String cpf = view.inputCpf();
//        controller.apagar(cpf);


        controller.listandoTodos();
    }
}
