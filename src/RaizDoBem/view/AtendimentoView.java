package RaizDoBem.view;

import RaizDoBem.model.vo.Atendimento;

import java.util.List;
import java.util.Scanner;


public class AtendimentoView {
    Scanner sc = new Scanner(System.in);

    public void menuAtendimentos() {


        System.out.println("\n      Gerenciar Atendimentos     ");
        System.out.println("        1. Adicionar atendimento");
        System.out.println("        2. Listar todos os atendimentos");
        System.out.println("        3. Listar atendimentos por data");
        System.out.println("        4. Encontrar atendimento ao beneficiário");
        System.out.println("        5. Encontrar atendimentos de um dentista");
        System.out.println("        6. Voltar ao menu principal");
        System.out.println("        0. Encerrar programa");
        System.out.print("\nSelecione uma opção: ");
        

  
        // atendimento = input.criar();
        // controller.criarAtendimento(atendimento);

        // case 2:
        // System.out.println("Listagem dos atendimentos: ");
        // controller.listarTodosAtendimentos();
        // break;
        // case 3:
        ////                controller.
        // break;
        // case 4:
        // atendimentoDAO.encontrarAtendimentoBeneficiario();
        // break;
        // case 5:
        // atendimentoDAO.encontrarAtendimentosDentista();
        // break;
    }

    public int inputBeneficiario() {
        System.out.println("Digite o ID do beneficiário que irá receber o atendimento: ");
        int idBeneficiario = sc.nextInt();
        sc.nextLine();
        return idBeneficiario;
    }

    public int inputDentista() {
        System.out.println("Digite o ID do dentista que irá fornecer o atendimento: ");
        int idDentista = sc.nextInt();
        sc.nextLine();
        return idDentista;
    }

    public String inputDescricaoInicial() {
        System.out.println("Insira a descrição inicial do atendimento: ");
        return sc.nextLine();
    }

    public void exibirAtendimento(Atendimento atendimento) {
        System.out.println(atendimento);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Atendimento> lista) {
        for (Atendimento elemento : lista) {
            exibirAtendimento(elemento);
        }
    }
}
