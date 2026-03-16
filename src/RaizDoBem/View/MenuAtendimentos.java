package RaizDoBem.View;

import RaizDoBem.DAO.AtendimentoDAO;
import RaizDoBem.Model.Atendimento;

import java.util.Scanner;

public class MenuAtendimentos {
    public void menuAtendimentos(Scanner sc){
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        System.out.println("--- Atendimentos ---");
        System.out.println("1. Adicionar atendimentos");
        System.out.println("2.  Listar todos os atendimentos");
        System.out.println("3.  Listar atendimentos por data");
        System.out.println("4.  Atualizar atendimento");
        System.out.println("5.  Excluir atendimento");
        System.out.println("6.  Voltar ao menu principal");
        System.out.println("0. Encerrar programa");
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
                System.out.println("Voltando ao menu principal...");
                break;
            case 4:
            case 5:
            case 6:
            case 0:
                System.out.println("Encerrando programa...");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }
}
