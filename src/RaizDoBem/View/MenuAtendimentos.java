package RaizDoBem.View;

import RaizDoBem.DAO.AtendimentoDAO;
import RaizDoBem.Model.Atendimento;

import java.util.Scanner;

public class MenuAtendimentos {
    public void menuAtendimentos(){
        Scanner sc = new Scanner(System.in);
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        System.out.println("\n      Gerenciar Atendimentos     ");
        System.out.println("        1. Adicionar atendimentos");
        System.out.println("        2. Listar todos os atendimentos");
        System.out.println("        3. Listar atendimentos por data");
        System.out.println("        4. Encontrar atendimento ao beneficiário");
        System.out.println("        5. Encontrar atendimentos de um dentista");
        System.out.println("        6. Excluir atendimento");
        System.out.println("        7. Voltar ao menu principal");
        System.out.println("        0. Encerrar programa");
        System.out.print("Selecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                Atendimento at = null;
                atendimentoDAO.adicionar(at);
                break;
            case 2:
                atendimentoDAO.listarTodos();
                break;
            case 3:
//                atendimentoDAO.listar();
                break;
            case 4:
                atendimentoDAO.encontrarAtendimentoBeneficiario();
                break;
            case 5:
                atendimentoDAO.encontrarAtendimentosDentista();
                break;
            case 6:
                int id = 0;
                atendimentoDAO.excluirAtendimento(id);
            case 7:
                System.out.println("Voltando ao menu principal...");
                break;
            case 0:
                System.out.println("Encerrando programa...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida");
        }
    }
}
