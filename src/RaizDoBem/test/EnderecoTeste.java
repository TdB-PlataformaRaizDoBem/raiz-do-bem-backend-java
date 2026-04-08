package RaizDoBem.test;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.view.EnderecoView;

/* Classe de teste para a funcionalidade de Endereço. Esta classe é responsável por testar as operações relacionadas aos endereços, como criação, listagem, atualização e exclusão. Ela utiliza o EnderecoController para realizar as operações e o EnderecoView para interagir com o usuário e exibir os resultados.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - Criação: Testa a criação de um novo endereço, solicitando as informações necessárias ao usuário e utilizando o controller para adicionar o endereço ao sistema.
 * 2º Metodo - Listando todos: Testa a listagem de todos os endereços cadastrados, utilizando o controller para recuperar a lista de endereços e exibindo-os ao usuário.
 * 3º Metodo - Listando apenas pelo Id: Testa a recuperação de um endereço específico pelo seu identificador, solicitando o ID ao usuário e utilizando o controller para buscar e exibir as informações do endereço correspondente.
 * 4º Metodo - Listando por cidade: Testa a recuperação de endereços com base na cidade, solicitando o nome da cidade ao usuário e utilizando o controller para buscar e exibir os endereços localizados na cidade especificada.
 * 5º Metodo - Atualizando: Testa a atualização de um endereço existente, solicitando o ID do endereço a ser atualizado e as novas informações ao usuário, e utilizando o controller para realizar a atualização no sistema.
 * 6º Metodo - Excluindo: Testa a exclusão de um endereço, solicitando o ID do endereço a ser excluído ao usuário e utilizando o controller para remover o endereço do sistema.
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

        controller.listandoTodos();
    }
}
