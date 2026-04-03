package RaizDoBem.view;

import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de menu para gerenciar os endereços relacionados à ONG. Esta classe é responsável por exibir as opções de gerenciamento de endereços, como criar, listar, atualizar e excluir endereços. Ela interage com o EnderecoController para realizar as operações necessárias e fornecer uma interface amigável para o usuário.
 * @author Paulo
 * @since 2026-03
 *
 * @see EnderecoDAO
 * @see Endereco
 */
public class EnderecoView {
    Scanner sc = new Scanner(System.in);

    public String entradaCep() {
        System.out.println("Digite o cep (8 dígitos): ");
        return sc.nextLine();
    }
    public String entradaNumero(){
        System.out.println("Digite a numeração do endereço: ");
        return sc.nextLine();
    }
    public String entradaCidade() {
        System.out.println("Digite a cidade: ");
        return sc.nextLine();
    }

    public int entradaId() {
        System.out.println("Digite o ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public int entradaTipoEndereco(){
        int opc;
        int idTipo = 0;
        do {
            System.out.println("Endereço residencial ou Profissional?");
            System.out.println("1. Residencial");
            System.out.println("2. Profissional");

            opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1) {
                idTipo = 1;
            } else if (opc == 2) {
                idTipo = 2;
            } else {
                System.out.println("Opção Inválida!!!");
            }
        } while (opc < 1 || opc > 2);

        return opc;
    }

//        System.out.println("\n      Gerenciar Endereços     ");
//        System.out.println("        1.  Adicionar endereço");
//        System.out.println("        2.  Listar todos os endereços");
//        System.out.println("        3.  Listar endereço pelo ID");
//        System.out.println("        4.  Listar endereço por cidade");
//        System.out.println("        5.  Atualizar endereço");
//        System.out.println("        6.  Excluir endereço");


    public void exibirEndereco(Endereco endereco){
        System.out.println(endereco);
    }
    public void exibirMensagem(String msg){
        System.out.println(msg);
    }

    public void exibirLista(List<Endereco> lista){
        for (Endereco elemento : lista){
            exibirEndereco(elemento);
        }
    }
}

