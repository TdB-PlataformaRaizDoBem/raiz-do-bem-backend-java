package RaizDoBem.View;

//import RaizDoBem.Controller.*;

import java.util.Scanner;

public class Menu {
    private int opcao;
    private String escolhido;
    private Scanner sc;
    MenuEnderecos menuEndereco = new MenuEnderecos();
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

    public int getOpcao() {
        return opcao;
    }

    public String getEscolhido() {
        return escolhido;
    }

    public Scanner getSc() {
        return sc;
    }

    public void exibirMenuInicial(){
        sc = new Scanner(System.in);
        do{
        //     seja bem-vindo coordenador, simular login
            System.out.println("\n      Menu Inicial      ");
            System.out.println("        1. Pedidos de ajuda");
            System.out.println("        2. Beneficiários");
            System.out.println("        3. Dentistas");
            System.out.println("        4. Atendimentos");
            System.out.println("        5. Endereços");
            System.out.println("        0. Encerrar programa");
            System.out.print("Selecione uma opção: ");
            opcao = sc.nextInt();

            String escolha = "";
            switch (opcao){
                case 1:
                    escolha = "1. Pedidos de ajuda";
                    System.out.println("Você selecionou: " + escolha);
                    //menuPedidos(sc);
                    break;
                case 2:
                    escolha = "2. Beneficiários";
                    System.out.println("Você selecionou: " + escolha);
                   // menuBeneficiarios(sc);
                    break;
                case 3:
                    escolha = "3. Dentistas";
                    System.out.println("Você selecionou: " + escolha);
                    //menuDentistas(sc);
                    break;
                case 4:
                    escolha = "4. Atendimentos";
                    System.out.println("Você selecionou: " + escolha);
                    //menuAtendimentos(sc);
                    break;
                case 5:
                    escolha = "5. Endereços";
                    System.out.println("Você selecionou: " + escolha);
                    menuEndereco.menuEnderecos();
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!!");
            }
        } while(opcao!=0);
    }


    public void pausa(){
        System.out.println("Digite qualquer tecla...");
        sc.nextLine();
    }
}
