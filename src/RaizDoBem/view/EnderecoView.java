package RaizDoBem.view;

import RaizDoBem.model.vo.Endereco;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de interface em console para o modulo de Endereco.
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

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}