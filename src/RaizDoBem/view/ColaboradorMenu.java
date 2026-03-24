package RaizDoBem.view;

import java.util.Scanner;

public class ColaboradorMenu {
    Scanner sc = new Scanner(System.in);
    public void menu() {
        System.out.println("\n      Gerenciar Colaboradores     ");
        System.out.println("        1.  Adicionar colaborador");
        System.out.println("        2.  Listar todos os colaboradores");
        System.out.println("        3.  Listar colaboradores por cidade");
        System.out.println("        4.  Atualizar colaborador");
        System.out.println("        5.  Excluir colaborador");
        System.out.println("        6.  Voltar ao menu principal");
        System.out.println("        0.  Encerrar programa");
        System.out.print("\nSelecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();
        }
}
