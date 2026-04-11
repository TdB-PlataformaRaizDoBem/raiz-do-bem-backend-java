package RaizDoBem.test;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.view.EnderecoView;

/**
 * Classe de teste com main para validar o fluxo de Endereco.
 */
public class EnderecoTeste {
    public static void main(String[] args) {
        EnderecoView view = new EnderecoView();
        EnderecoController controller = new EnderecoController(view);

        //1º Metodo - Criação
        controller.adicionar();

        //2º Metodo - Listando todos
        controller.listandoTodos();

        //3º Metodo - Listando apenas pelo Id
        int id = view.inputId();
        controller.listarPorId(id);

        //4º Metodo - Listando por cidade
        String cidade = view.entradaCidade();
        controller.listandoPorCidade(cidade);

        //5º Metodo - Atualizando
        id = view.inputId();
        controller.atualizar(id);

          //6º Metodo - Excluindo
        id = view.inputId();
        controller.deletar(id);

        //7º Metodo - Listando novamente para verificar mudanças
        controller.listandoTodos();
    }
}
