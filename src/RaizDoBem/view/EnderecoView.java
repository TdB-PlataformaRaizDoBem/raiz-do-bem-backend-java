package RaizDoBem.view;

import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de menu para gerenciar os endereços relacionados à ONG. Esta classe é
 * responsável por exibir as opções de gerenciamento de endereços, como criar,
 * listar, atualizar e excluir endereços. Ela interage com o EnderecoController
 * para realizar as operações necessárias e fornecer uma interface amigável para
 * o usuário.
 * 
 * @author Paulo
 * @since 2026-03
 *
 * @see EnderecoDAO
 * @see Endereco
 */
public class EnderecoView {
    Scanner sc = new Scanner(System.in);

    public String entradaCep() {
        System.out.println("\nDigite o cep (8 dígitos): ");
        return sc.nextLine();
    }

    public String entradaNumero() {
        System.out.println("\nDigite a número do endereço: ");
        return sc.nextLine();
    }

    public String entradaCidade() {
        System.out.println("vDigite a cidade: ");
        return sc.nextLine();
    }

    public int entradaId() {
        System.out.println("\nDigite o ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public int entradaTipoEndereco() {
        int opc;
        do {
            System.out.println("Endereço residencial ou Profissional?");
            System.out.println("1. Residencial");
            System.out.println("2. Profissional");

            opc = sc.nextInt();
            sc.nextLine();
            if (opc!= 1 && opc!=2) {
                System.out.println("Opção Inválida!!!");
            }
        } while (opc < 1 || opc > 2);

        return opc;
    }

    public void exibirEndereco(Endereco endereco) {
        System.out.println(endereco);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Endereco> lista) {
        for (Endereco elemento : lista) {
            exibirEndereco(elemento);
        }
    }
}