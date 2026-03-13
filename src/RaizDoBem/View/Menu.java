//package RaizDoBem.View;
//
//import RaizDoBem.Controller.*;
//
//import java.util.Scanner;
//
//public class Menu {
//    private int opcao;
//    private String escolhido;
//    private Scanner sc;
//
//    GerenciaPedido gerenciaPedido = new GerenciaPedido();
//    GerenciaEndereco gerenciaEndereco = new GerenciaEndereco();
//    GerenciaBeneficiarios gerenciaBeneficiarios = new GerenciaBeneficiarios(gerenciaEndereco);
//    GerenciaDentistas gerenciaDentistas = new GerenciaDentistas();
//    GerenciaAtendimentos gerenciaAtendimentos = new GerenciaAtendimentos(gerenciaBeneficiarios, gerenciaDentistas);
//
//    public Menu(GerenciaPedido gerenciaPedido, GerenciaEndereco gerenciaEndereco, GerenciaBeneficiarios gerenciaBeneficiarios, GerenciaDentistas gerenciaDentistas, GerenciaAtendimentos gerenciaAtendimentos) {
//        this.gerenciaPedido = gerenciaPedido;
//        this.gerenciaEndereco = gerenciaEndereco;
//        this.gerenciaBeneficiarios = gerenciaBeneficiarios;
//        this.gerenciaDentistas = gerenciaDentistas;
//        this.gerenciaAtendimentos = gerenciaAtendimentos;
//    }
//
//    public int getOpcao() {
//        return opcao;
//    }
//
//    public String getEscolhido() {
//        return escolhido;
//    }
//
//    public Scanner getSc() {
//        return sc;
//    }
//
//    public void exibirMenuInicial(){
//        sc = new Scanner(System.in);
//        do{
//            System.out.println("--- Menu Inicial ---");
//            System.out.println("1. Pedidos de ajuda");
//            System.out.println("2. Beneficiários");
//            System.out.println("3. Dentistas");
//            System.out.println("4. Atendimentos");
//            System.out.println("5. Endereços");
//            System.out.println("0. Encerrar programa");
//            System.out.println("Selecione uma opção: ");
//            opcao = sc.nextInt();
//
//            String escolha = "";
//            switch (opcao){
//                case 1:
//                    escolha = "1. Pedidos de ajuda";
//                    System.out.println("Você selecionou: " + escolha);
//                    menuPedidos(sc);
//                    break;
//                case 2:
//                    escolha = "2. Beneficiários";
//                    System.out.println("Você selecionou: " + escolha);
//                    menuBeneficiarios(sc);
//                    break;
//                case 3:
//                    escolha = "3. Dentistas";
//                    System.out.println("Você selecionou: " + escolha);
//                    menuDentistas(sc);
//                    break;
//                case 4:
//                    escolha = "4. Atendimentos";
//                    System.out.println("Você selecionou: " + escolha);
//                    menuAtendimentos(sc);
//                    break;
//                case 5:
//                    escolha = "5. Endereços";
//                    System.out.println("Você selecionou: " + escolha);
//                    menuEnderecos(sc);
//                    break;
//                case 0:
//                    System.out.println("Encerrando programa...");
//                    break;
//                default:
//                    System.out.println("Opção Inválida!!");
//            }
//        } while(opcao!=0);
//
//
//    }
//    public void menuPedidos(Scanner sc){
//        System.out.println("--- Pedidos de ajuda ---");
//        System.out.println("1. Adicionar pedido de ajuda");
//        System.out.println("2. Listar pedidos de ajuda");
//        System.out.println("3. Voltar ao menu principal");
//        System.out.println("0. Encerrar programa");
//        System.out.print("Selecione uma opção: ");
//        int opc = sc.nextInt();
//        sc.nextLine();
//
//        switch (opc){
//            case 1:
//                gerenciaPedido.receberSalvarDados();
//                pausa();
//                break;
//            case 2:
//                gerenciaPedido.listarTodos();
//                pausa();
//                break;
//            case 3:
//                System.out.println("Voltando ao menu principal...");
//                pausa();
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                opcao = 0;
//                break;
//            default:
//                System.out.println("Opção Inválida!");
//        }
//    }
//    public void menuBeneficiarios(Scanner sc){
//        System.out.println("--- Beneficiários ---");
//        System.out.println("1. Adicionar beneficiário");
//        System.out.println("2. Listar beneficiários");
//        System.out.println("3. Voltar ao menu principal");
//        System.out.println("0. Encerrar programa");
//        System.out.print("Selecione uma opção: ");
//        int opc = sc.nextInt();
//        sc.nextLine();
//
//        switch (opc){
//            case 1:
//                gerenciaBeneficiarios.receberSalvarDados();
//                pausa();
//                break;
//            case 2:
//                gerenciaBeneficiarios.listarTodos();
//                pausa();
//                break;
//            case 3:
//                System.out.println("Voltando ao menu principal...");
//                pausa();
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                opcao = 0;
//                break;
//            default:
//                System.out.println("Opção Inválida!");
//        }
//    }
//    public void menuDentistas(Scanner sc){
//        System.out.println("--- Dentistas ---");
//        System.out.println("1. Adicionar dentista");
//        System.out.println("2. Listar dentistas");
//        System.out.println("3. Voltar ao menu principal");
//        System.out.println("0. Encerrar programa");
//        System.out.print("Selecione uma opção: ");
//        int opc = sc.nextInt();
//        sc.nextLine();
//
//        switch (opc){
//            case 1:
//                gerenciaDentistas.receberSalvarDados();
//                pausa();
//                break;
//            case 2:
//                gerenciaDentistas.listarTodos();
//                pausa();
//                break;
//            case 3:
//                System.out.println("Voltando ao menu principal...");
//                pausa();
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                opcao = 0;
//                break;
//            default:
//                System.out.println("Opção Inválida");
//        }
//    }
//    public void menuAtendimentos(Scanner sc){
//        System.out.println("--- Atendimentos ---");
//        System.out.println("1. Adicionar atendimentos");
//        System.out.println("2. Listar atendimentos");
//        System.out.println("3. Voltar ao menu principal");
//        System.out.println("0. Encerrar programa");
//        System.out.print("Selecione uma opção: ");
//        int opc = sc.nextInt();
//        sc.nextLine();
//
//        switch (opc){
//            case 1:
//                gerenciaAtendimentos.receberSalvarDados();
//                pausa();
//                break;
//            case 2:
//                gerenciaAtendimentos.listarTodos();
//                pausa();
//                break;
//            case 3:
//                System.out.println("Voltando ao menu principal...");
//                pausa();
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                opcao = 0;
//                break;
//            default:
//                System.out.println("Opção Inválida");
//        }
//    }
//    public void menuEnderecos(Scanner sc){
//        System.out.println("--- Endereços ---");
//        System.out.println("1. Adicionar endereço");
//        System.out.println("2. Listar endereços");
//        System.out.println("3. Voltar ao menu principal");
//        System.out.println("0. Encerrar programa");
//        System.out.print("Selecione uma opção: ");
//        int opc = sc.nextInt();
//        sc.nextLine();
//
//        switch (opc){
//            case 1:
//                gerenciaEndereco.receberSalvarDados();
//                pausa();
//                break;
//            case 2:
//                gerenciaEndereco.listarTodos();
//                pausa();
//                break;
//            case 3:
//                System.out.println("Voltando ao menu principal...");
//                pausa();
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                opcao = 0;
//                break;
//            default:
//                System.out.println("Opção Inválida");
//        }
//    }
//    public void pausa(){
//        System.out.println("Digite qualquer tecla...");
//        sc.nextLine();
//    }
//}
