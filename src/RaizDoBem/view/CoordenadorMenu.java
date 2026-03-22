package RaizDoBem.view;

import java.util.Scanner;

public class CoordenadorMenu {
    Scanner sc = new Scanner(System.in);
    public void menu() {
        System.out.println("\n      Gerenciar Coordenadores     ");
        System.out.println("        1.  Adicionar coordenador");
        System.out.println("        2.  Listar todos os coordenadores");
        System.out.println("        3.  Listar coordenadores por cidade");
        System.out.println("        4.  Atualizar coordenador");
        System.out.println("        5.  Excluir coordenador");
        System.out.println("        6.  Voltar ao menu principal");
        System.out.println("        0.  Encerrar programa");
        System.out.print("\nSelecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();
        }
}
