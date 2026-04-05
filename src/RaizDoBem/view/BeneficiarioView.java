package RaizDoBem.view;

import RaizDoBem.model.vo.Beneficiario;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de visualização para o Beneficiário. Esta classe é responsável por interagir com o usuário, solicitando as informações necessárias para criar, listar e buscar beneficiários. Ela utiliza a classe Scanner para ler as entradas do usuário e exibe mensagens e listas de beneficiários de forma clara e organizada.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - inputCpf: Solicita ao usuário o CPF do beneficiário e retorna a string digitada.
 * 2º Metodo - inputPrograma: Solicita ao usuário o programa da ONG ao qual o beneficiário fará parte e retorna a opção escolhida como um valor inteiro.
 * 3º Metodo - inputId: Solicita ao usuário o ID do pedido de origem para o beneficiário e retorna o valor inteiro digitado.
 * 4º Metodo - inputCidade: Solicita ao usuário a cidade do beneficiário e retorna a string digitada.
 * 5º Metodo - inputTelefone: Solicita ao usuário o telefone do beneficiário e retorna a string digitada.
 * 6º Metodo - inputEmail: Solicita ao usuário o email do beneficiário e retorna a string digitada.
 * 7º Metodo - inputIdEndereco: Solicita ao usuário o ID do endereço do beneficiário e retorna o valor inteiro digitado.
 * 8º Metodo - exibirBeneficiario: Recebe um objeto Beneficiario e exibe suas informações formatadas para o usuário.
 * 9º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 10º Metodo - exibirLista: Recebe uma lista de objetos Beneficiario e utiliza o método exibirBeneficiario para exibir cada beneficiário da lista para o usuário.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de beneficiário, fornecendo as informações necessárias para criar e buscar beneficiários, e visualizando os resultados das operações realizadas.
 */
public class BeneficiarioView {
    Scanner sc = new Scanner(System.in);

    public String inputCpf() {
        System.out.println("\nDigite o CPF do beneficiário: ");
        return sc.nextLine();
    }

    public int inputPrograma() {
        System.out.println("\nEsse beneficiário(a) fará parte de qual programa da ONG?");
        System.out.println("1. Dentista do Bem");
        System.out.println("2. Apolônias do Bem");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }
    public int inputId() {
        System.out.println("\nDigite o id do pedido origem para o beneficiário: ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public String inputCidade() {
        System.out.println("\nDigite a cidade: ");
        return sc.nextLine();
    }

    public String inputTelefone() {
        System.out.println("\nDigite o novo telefone do beneficiário: ");
        return sc.nextLine();
    }

    public String inputEmail() {
        System.out.println("\nDigite o novo email do beneficiário: ");
        return sc.nextLine();
    }

    public int inputIdEndereco() {
        System.out.println("\nDigite o novo ID de endereço do beneficiário: ");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public void exibirBeneficiario(Beneficiario beneficiario) {
        System.out.println(beneficiario);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Beneficiario> lista) {
        for (Beneficiario elemento : lista) {
            exibirBeneficiario(elemento);
        }
    }
}

