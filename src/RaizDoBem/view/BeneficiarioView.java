package RaizDoBem.view;

import RaizDoBem.model.vo.Beneficiario;

import java.util.List;
import java.util.Scanner;


public class BeneficiarioView {
    Scanner sc = new Scanner(System.in);

//        System.out.println("\n      Gerenciar Beneficiários     ");
//        System.out.println("        1.  Adicionar beneficiário");
//        System.out.println("        2.  Listar todos os beneficiários");
//        System.out.println("        3.  Listar beneficiário único");
//        System.out.println("        4.  Listar beneficiários por programa");
//        System.out.println("        5.  Listar beneficiários por cidade");
//        System.out.println("        6.  Atualizar beneficiário");
//        System.out.println("        7.  Excluir beneficiário");

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

    /// /                String cidade = beneficiarioInput();
    /// /                controller.listagemPorCidade(cidade);
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
    public String inputCpf() {
        System.out.println("Digite o CPF do beneficiário: ");
        return sc.nextLine();
    }

    public int inputSexoBeneficiario() {
        System.out.println("Selecione o sexo do beneficiário: ");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        System.out.println("3. Outros");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public int inputPrograma() {
        System.out.println("Esse beneficiário(a) fará parte de qual programa da ONG?");
        System.out.println("1. Dentista do Bem");
        System.out.println("2. Apolônias do Bem");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public void exibirPedido(Beneficiario beneficiario) {
        System.out.println(beneficiario);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Beneficiario> lista) {
        for (Beneficiario elemento : lista) {
            exibirPedido(elemento);
        }
    }
}

