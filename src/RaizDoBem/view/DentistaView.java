package RaizDoBem.view;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.model.vo.Dentista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DentistaView {
    Scanner sc = new Scanner(System.in);

    String cpf = "";

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
    // controller.listarDisponiveis();
    //
    // case 5:
    // cpf = ""; //falta input cpf
    // dentista = controller.buscaPorCpf(cpf);
    // controller.atualizarDentista(cpf, dentista);
    //
    // case 6:
    // cpf = ""; //falta input cpf
    // dentista = controller.buscaPorCpf(cpf);
    // controller.excluirDentista(cpf);
    // //System.out.println("Dentista foi excluído com sucesso!!!");
    // break;
    // case 7:
    // System.out.println("Voltando ao menu principal...");
    // break;
    // case 0:
    // System.out.println("Encerrando programa...");
    // System.exit(0);
    // default:
    // System.out.println("Opção Inválida");
    //
    public String inputCpf() {
        System.out.println("Digite o CPF do dentista: ");
        return sc.nextLine();
    }

    public int inputSexo() {
        System.out.println("Selecione o sexo do dentista: ");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        System.out.println("3. Outros");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public void exibirEndereco(Dentista dentista) {
        System.out.println(dentista);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Dentista> lista) {
        for (Dentista elemento : lista) {
            exibirEndereco(elemento);
        }
    }
}