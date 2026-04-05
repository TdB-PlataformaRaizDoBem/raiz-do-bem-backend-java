package RaizDoBem.view;

import RaizDoBem.model.vo.Beneficiario;

import java.util.List;
import java.util.Scanner;

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

