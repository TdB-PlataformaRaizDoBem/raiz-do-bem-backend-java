package RaizDoBem.view;

import RaizDoBem.model.dao.BeneficiarioDAO;
import RaizDoBem.model.vo.Beneficiario;

import java.util.Scanner;

/**
 * Menu de gerenciamento de beneficiários, permitindo ao usuário realizar operações como adicionar, listar, atualizar e excluir beneficiários do programa social. Esta classe interage com a classe BeneficiarioDAO para realizar as operações de acesso a dados.
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioMenu {
    public void menuBeneficiarios(){
        Scanner sc = new Scanner(System.in);
        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();
        Beneficiario beneficiario = new Beneficiario();
        int id = 0;
        System.out.println("\n      Gerenciar Beneficiários     ");
        System.out.println("        1.  Adicionar beneficiário");
        System.out.println("        2.  Listar todos os beneficiários");
        System.out.println("        3.  Listar beneficiário único");
        System.out.println("        4.  Listar beneficiários por programa");
        System.out.println("        5.  Listar beneficiários por cidade");
        System.out.println("        6.  Atualizar beneficiário");
        System.out.println("        7.  Excluir beneficiário");
        System.out.println("        8.  Voltar ao menu principal");
        System.out.println("        0.  Encerrar programa");
        System.out.print("Selecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                beneficiarioDAO.adicionar(beneficiario);
                break;
            case 2:
                beneficiarioDAO.listarTodos();
                break;
            case 3:
                String cpf = "";
                if(beneficiarioDAO.listarBeneficiarioUnico(cpf) == null){
                    System.out.println("Beneficiário não encontrado!!!");
                    break;
                }
                System.out.println("Beneficiário encontrado: " + beneficiarioDAO.listarBeneficiarioUnico(cpf));
                break;
            case 4:
                beneficiarioDAO.listarPorPrograma();
                break;
            case 5:
                beneficiarioDAO.listarPorCidade();
                break;
            case 6:
                beneficiarioDAO.atualizarBeneficiario(id);
                break;
            case 7:
                beneficiarioDAO.excluirBeneficiario(id);
                break;
            case 8:
                System.out.println("Voltando ao menu principal...");
                break;
            case 0:
                System.out.println("Encerrando programa...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
        }
    }
}
