//package RaizDoBem.View;
//
//import RaizDoBem.DAO.EnderecoDAO;
//
//import java.util.Scanner;
//
//public class MenuEnderecos {
//        public void menuEnderecos(Scanner sc){
//        EnderecoDAO enderecoDAO = new EnderecoDAO();
//
//        System.out.println("--- Endereços ---");
//        System.out.println("1.  Adicionar endereço");
//        System.out.println("2.  Listar todos os endereços");
//        System.out.println("3.  Listar único endereço");
//        System.out.println("4.  Atualizar endereço");
//        System.out.println("5.  Excluir endereço");
//        System.out.println("6.  Voltar ao menu principal");
//        System.out.println("0.  Encerrar programa");
//        System.out.print("Selecione uma opção: ");
//        int opc = sc.nextInt();
//        sc.nextLine();
//
//        switch (opc){
//            case 1:
//                enderecoDAO.adicionar(endereco);
//                pausa();
//                break;
//            case 2:
//                enderecoDAO.listarTodos();
//                pausa();
//                break;
//            case 3:
//                enderecoDAO.listar(parametro);
//                pausa();
//                break;
//            case 4:
//                System.out.println("Voltando ao menu principal...");
//                pausa();
//                break;
//            case 5:
//                System.out.println("Atualizar endereço:");
//                break;
//            case 6:
//                System.out.println("Excluir endereço:");
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                opcao = 0;
//                break;
//            default:
//                System.out.println("Opção Inválida");
//        }
//    }
//}
