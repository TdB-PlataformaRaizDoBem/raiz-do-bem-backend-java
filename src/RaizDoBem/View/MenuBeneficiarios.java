package RaizDoBem.View;

import RaizDoBem.DAO.BeneficiarioDAO;

import java.util.Scanner;

public class MenuBeneficiarios {
        public void menuBeneficiarios(Scanner sc){
        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();
        System.out.println("--- Beneficiários ---");
        System.out.println("1. Adicionar beneficiário");
        System.out.println("2. Listar todos os beneficiários");
        System.out.println("3. Mostrar beneficiário pelo 'parâmetro'");
        System.out.println("4. Atualizar beneficiário");
        System.out.println("5. Excluir beneficiário");
        System.out.println("6. Voltar ao menu principal");
        System.out.println("0. Encerrar programa");
        System.out.print("Selecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                //beneficiarioDAO.adicionar();
                break;
            case 2:
                //beneficiarioDAO.listarTodos();
                break;
            case 3:
                System.out.println("Voltando ao menu principal...");
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                System.out.println("Encerrando programa...");
                break;
            default:
                System.out.println("Opção Inválida!");
        }
    }
}
