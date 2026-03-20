package RaizDoBem.View;

//import RaizDoBem.Controller.*;

import java.util.Scanner;

public class Menu {
    private int opcao;
    private String escolhido;
    private Scanner sc;
    MenuAtendimentos menuAtendimentos = new MenuAtendimentos();
    MenuBeneficiarios menuBeneficiarios = new MenuBeneficiarios();
    MenuEnderecos menuEndereco = new MenuEnderecos();
    MenuDentistas menuDentistas = new MenuDentistas();
    MenuPedidos menuPedidos = new MenuPedidos();

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
                    break;
                case 2:
                    escolha = "2. Beneficiários";
                    System.out.println("Você selecionou: " + escolha);
                    menuBeneficiarios.menuBeneficiarios();
                    break;
                case 3:
                    escolha = "3. Dentistas";
                    System.out.println("Você selecionou: " + escolha);
                    menuDentistas.menu();
                    break;
                case 4:
                    escolha = "4. Atendimentos";
                    System.out.println("Você selecionou: " + escolha);
                    menuAtendimentos.menuAtendimentos();
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
