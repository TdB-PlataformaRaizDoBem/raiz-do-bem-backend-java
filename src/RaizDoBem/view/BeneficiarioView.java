package RaizDoBem.view;

import RaizDoBem.model.vo.Beneficiario;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de interface em console para o modulo de Beneficiario.
 */
public class BeneficiarioView {
    Scanner sc = new Scanner(System.in);
    GenericView view = new GenericView(sc);

    public String inputCpf() {
        return view.inputCpf();
    }

    public int inputPrograma() {
        view.exibirMensagem("\nSelecione o programa da ONG: 1. Dentista do Bem | 2. Apolônias do Bem");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }
    public int inputId() {
        return view.inputId("\nDigite o id do pedido origem para o beneficiário: ");
    }

    public String inputCidade() {
        return view.inputCidade();
    }

    public String inputTelefone() {
        return view.inputString("\nDigite o novo telefone do beneficiário: ");
    }

    public String inputEmail() {
        return view.inputString("\nDigite o novo email do beneficiário: ");
    }

    public int inputIdEndereco() {
        return view.inputId("\nDigite o novo ID de endereço do beneficiário: ");
    }

    public void exibirBeneficiario(Beneficiario beneficiario){
        view.exibir(beneficiario);
    }

    public void listarTodos(List<Beneficiario> beneficiarios) {
        view.listarTodos(beneficiarios);
    }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}

