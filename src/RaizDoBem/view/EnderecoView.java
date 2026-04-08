package RaizDoBem.view;

import RaizDoBem.model.vo.Endereco;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de visualização para a funcionalidade de Endereço. Esta classe é responsável por interagir com o usuário, solicitando as informações necessárias para as operações relacionadas aos endereços, como criação, listagem, atualização e exclusão. Ela também exibe os resultados das operações, como a exibição de um endereço específico ou a listagem de todos os endereços cadastrados.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - entradaCep: Solicita ao usuário o CEP do endereço e retorna a string digitada.
 * 2º Metodo - entradaNumero: Solicita ao usuário o número do endereço e retorna a string digitada.
 * 3º Metodo - entradaCidade: Solicita ao usuário a cidade do endereço e retorna a string digitada.
 * 4º Metodo - entradaId: Solicita ao usuário o ID do endereço e retorna o valor inteiro digitado.
 * 5º Metodo - entradaTipoEndereco: Solicita ao usuário o tipo do endereço (residencial ou profissional) e retorna a opção escolhida como um valor inteiro.
 * 6º Metodo - exibirEndereco: Recebe um objeto Endereco e exibe suas informações formatadas para o usuário.
 * 7º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 8º Metodo - listarTodos: Recebe uma lista de objetos Endereco e utiliza o método exibirEndereco para exibir cada endereço da lista para o usuário.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de endereço, fornecendo as informações necessárias para criar, buscar e atualizar endereços, e visualizando os resultados das operações realizadas.
 */
public class EnderecoView {
    Scanner sc = new Scanner(System.in);
    GenericView view = new GenericView(sc);

    public String entradaCep() {
        return view.inputString("\nDigite o cep (8 dígitos): ");
    }

    public String entradaNumero() {
        return view.inputString("\nDigite o número do endereço: ");
    }

    public String entradaCidade() {
        return view.inputCidade();
    }

    public int inputId() {
        return view.inputId("\nDigite o ID: ");
    }

    public int entradaTipoEndereco() {
        int opc;
        do {
            view.exibirMensagem("Endereço residencial ou Profissional?");
            view.exibirMensagem("1. Residencial");
            view.exibirMensagem("2. Profissional");

            opc = sc.nextInt();
            sc.nextLine();
            if (opc!= 1 && opc!=2) {
                System.out.println("Opção Inválida!!!");
            }
        } while (opc < 1 || opc > 2);

        return opc;
    }

    public void exibirEndereco(Endereco endereco) {
        view.exibir(endereco);
    }

    public void exibirLista(List<Endereco> enderecos) {
        view.listarTodos(enderecos);
    }
}