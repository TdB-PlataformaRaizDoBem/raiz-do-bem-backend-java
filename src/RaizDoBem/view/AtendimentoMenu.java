package RaizDoBem.view;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;

import java.util.Scanner;

/**
 * Interface para o menu de gerenciamento de atendimentos. Esta classe é responsável por exibir as opções relacionadas aos atendimentos e interagir com o usuário para realizar as operações correspondentes, como adicionar, listar, encontrar e excluir atendimentos.
 * @author Paulo
 * @since 2026-03
 */
public class AtendimentoMenu {
    public void menuAtendimentos(){
        Scanner sc = new Scanner(System.in);
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        System.out.println("\n      Gerenciar Atendimentos     ");
        System.out.println("        1. Adicionar atendimentos");
        System.out.println("        2. Listar todos os atendimentos");
        System.out.println("        3. Listar atendimentos por data");
        System.out.println("        4. Encontrar atendimento ao beneficiário");
        System.out.println("        5. Encontrar atendimentos de um dentista");
        System.out.println("        6. Voltar ao menu principal");
        System.out.println("        0. Encerrar programa");
        System.out.print("\nSelecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                Atendimento at = null;
                atendimentoDAO.adicionar(at);
                break;
            case 2:
                System.out.println("Listagem dos atendimentos: ");
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
