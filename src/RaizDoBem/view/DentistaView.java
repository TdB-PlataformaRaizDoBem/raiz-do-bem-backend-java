package RaizDoBem.view;

import RaizDoBem.model.vo.Dentista;

import java.util.List;
import java.util.Scanner;


public class DentistaView {
    Scanner sc = new Scanner(System.in);

    // case 2:
    // dentistas = controller.listarTodos();
    // System.out.println("Listagem dos dentistas: ");
    // for (Dentista d : dentistas) {
    // System.out.println(d);
    // }
    //
    // case 3:
    // String cidade = ""; //falta input cidade
    // controller.listagemPorCidade(cidade);
    // b
    // case 4:

    public String inputCpf() {
        System.out.println("\nDigite o CPF do dentista: ");
        return sc.nextLine();
    }

    public String inputCro() {
        System.out.println("\nDigite o CRO do dentista: ");
        return sc.nextLine();
    }

    public String inputNome() {
        System.out.println("Nome completo do dentista: ");
        return sc.nextLine();
    }
    public int inputSexo() {
        System.out.println("\nSelecione o sexo do dentista: ");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        System.out.println("3. Outros");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public String inputTelefone() {
        System.out.println("Telefone do solicitante: ");
        return sc.nextLine();
    }

    public String inputEmail() {
        System.out.println("Email do solicitante: ");
        return sc.nextLine();
    }

    public int inputCategoria() {
        System.out.println("\nSelecione a categoria do dentista: ");
        System.out.println("1. Coordenador");
        System.out.println("2. Clínico");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public int inputDisponibilidade() {
        System.out.println("\nDentista disponível para atendimentos: ");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public void exibirDentista(Dentista dentista) {
        System.out.println(dentista);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Dentista> lista) {
        for (Dentista elemento : lista) {
            exibirDentista(elemento);
        }
    }
}