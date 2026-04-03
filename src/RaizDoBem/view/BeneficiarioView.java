package RaizDoBem.view;

import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.model.vo.Beneficiario;

import java.util.Scanner;

/**
 * Menu de gerenciamento de beneficiários, permitindo ao usuário realizar operações como adicionar, listar, atualizar e excluir beneficiários do programa social. Esta classe interage com a classe BeneficiarioDAO para realizar as operações de acesso a dados.
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioView {
    Scanner sc = new Scanner(System.in);
    public void menu(){
        Beneficiario beneficiario = new Beneficiario();
        BeneficiarioController controller = new BeneficiarioController();
        String cpf;

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
        System.out.print("\nSelecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

//        switch (opc){
//            case 1:
//                controller.adicionar(beneficiario);
//                break;
//            case 2:
//                System.out.println("Listagem dos beneficiários: ");
//                controller.listarBeneficiarios();
//                break;
//            case 3:
//                cpf = input.inputCpf();
//                beneficiario = controller.buscaPorCpf(cpf);
//                if(controller.buscaPorCpf(cpf) == null){
//                    System.out.println("Beneficiário não encontrado!!!");
//                    break;
//                }
//                System.out.println("Beneficiário encontrado: ");
//                System.out.println(beneficiario);
//                break;
//            case 4:
//                int id = 0;
//                controller.listagemPorPrograma(id);
//                break;
//            case 5:
//                BeneficiarioInput beneficiarioInput = new BeneficiarioInput();
////                String cidade = beneficiarioInput();
////                controller.listagemPorCidade(cidade);
//                break;
//            case 6:
//                cpf = input.inputCpf();
//                //falta definir o beneficiario
//                beneficiario = controller.buscaPorCpf(cpf);
//                controller.atualizarBeneficiario(cpf, beneficiario);
//                break;
//            case 7:
//                cpf = input.inputCpf();
//                controller.excluirBeneficiario(cpf);
//                break;
//            case 8:
//                System.out.println("Voltando ao menu principal...");
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                System.exit(0);
//            default:
//                System.out.println("Opção Inválida!");
//        }
    }
    public String inputCpf(){
        System.out.println("Digite o CPF do beneficiário: ");
        return sc.nextLine();
    }
    public int inputSexoBeneficiario(){
        System.out.println("Selecione o sexo do beneficiário: ");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        System.out.println("3. Outros");
        int idSexo = sc.nextInt();
        sc.nextLine();

        return idSexo;
    }
}
