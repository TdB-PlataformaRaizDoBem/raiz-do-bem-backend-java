package RaizDoBem.view;

import java.util.List;
import java.util.Scanner;

/**
 * Classe genérica de view para ser utilizada por outras views específicas, como
 * PedidoAjudaView, EnderecoView, etc. Contém métodos comuns de entrada e saída
 * de dados, como inputString, inputId, exibirMensagem, exibir objeto e listar
 * todos os objetos de uma lista.
 *
 * @author Paulo
 * @since 2026-03
 *
 * 1º Metodo - inputString: Recebe uma mensagem como parâmetro, exibe a mensagem para o usuário e retorna a string digitada pelo usuário.
 * 2º Metodo - inputId: Recebe uma mensagem como parâmetro, exibe a mensagem para o usuário, lê um valor inteiro digitado pelo usuário, consome a quebra de linha e retorna o valor inteiro.
 * 3º Metodo - inputCpf: Solicita ao usuário o CPF e retorna a string digitada.
 * 4º Metodo - inputNome: Solicita ao usuário o nome e retorna a string digitada.
 * 5º Metodo - inputCidade: Solicita ao usuário a cidade e retorna a string digitada.
 * 6º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 7º Metodo - exibir: Recebe um objeto genérico e exibe sua representação em string para o usuário.
 * 8º Metodo - listarTodos: Recebe uma lista de objetos genéricos e utiliza o metodo exibir para exibir cada objeto da lista para o usuário.
 * Esses métodos permitem que as views específicas reutilizem a lógica de entrada e saída de dados, tornando o código mais organizado e evitando duplicação de código em diferentes partes da aplicação.
 */
public class GenericView {
    private final Scanner sc;

    public GenericView(Scanner sc) {
        this.sc = sc;
    }

    public String inputString(String msg){
        exibirMensagem(msg);
        return sc.nextLine();
    }

    public int inputId(String msg){
        exibirMensagem(msg);
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public String inputCpf(){
        return inputString("\nDigite o CPF:");
    }

    public String inputNome(){
        return inputString("\nDigite o nome:");
    }

    public String inputCidade(){
        return inputString("\nDigite a cidade:");
    }
    public void exibirMensagem(String msg){
        System.out.println(msg);
    }
    public <T> void exibir(Object objeto){
        exibirMensagem(objeto.toString());
    }
    public <T> void listarTodos(List<T> lista){
        for(T objeto : lista){
            exibir(objeto);
        }
    }
}
