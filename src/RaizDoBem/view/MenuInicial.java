package RaizDoBem.view;

import java.util.Scanner;

/**
 * Classe do menu inicial do sistema que serve para direcionar o usuário para as diferentes funcionalidades, como gerenciamento de pedidos de ajuda, beneficiários, dentistas, atendimentos e endereços. O menu é exibido em um loop até que o usuário escolha encerrar o programa.
 * @author Paulo
 * @since 2025-09
 *
 */
public class MenuInicial {
    private int opcao;
    private Scanner sc;
    AtendimentoView atendimentoView = new AtendimentoView();
    BeneficiarioView beneficiarioView = new BeneficiarioView();
    EnderecoView menuEndereco = new EnderecoView();
    DentistaMenu dentistaMenu = new DentistaMenu();
    PedidoAjudaView pedidoAjudaView = new PedidoAjudaView();

    public int getOpcao() {
        return opcao;
    }

    public Scanner getSc() {
        return sc;
    }

    /**
     * Exibe o menu inicial do sistema, permitindo ao usuário selecionar diferentes opções para gerenciar pedidos de ajuda, beneficiários, dentistas, atendimentos e endereços. O menu é exibido em um loop até que o usuário escolha encerrar o programa.
     * O metodo utiliza a classe Scanner para ler a entrada do usuário e direciona para os menus correspondentes com base na opção selecionada.
     *
     * Exemplo de uso:
     * - O usuário inicia o programa e é apresentado com o menu inicial.
     * - O usuário seleciona uma opção (por exemplo, "2. Beneficiários") e o sistema direciona para o menu de beneficiários.
     * - O usuário pode navegar entre os diferentes menus (pedidos de ajuda, dentistas, atendimentos, endereços) e realizar as operações correspondentes.
     * - O usuário pode escolher encerrar o programa selecionando a opção "0. Encerrar programa".
     */
    public void exibirMenuInicial(){
        sc = new Scanner(System.in);
        do{
        //     seja bem-vindo coordenador, simular login
            System.out.println("\n      Menu Inicial Raiz do Bem      ");
            System.out.println("\n        1. Pedidos de ajuda");
            System.out.println("        2. Beneficiários");
            System.out.println("        3. Dentistas");
            System.out.println("        4. Coordenadores");
            System.out.println("        4. Atendimentos");
            System.out.println("        5. Endereços");
            System.out.println("        0. Encerrar programa");
            System.out.print("\nSelecione uma opção: ");
            opcao = sc.nextInt();

            String escolha = "";
            switch (opcao){
                case 1:
                    escolha = "1. Pedidos de ajuda";
                    System.out.println("Você selecionou: " + escolha);
                    pedidoAjudaView.menu();
                    break;
                case 2:
                    escolha = "2. Beneficiários";
                    System.out.println("Você selecionou: " + escolha);
                    beneficiarioView.menu();
                    break;
                case 3:
                    escolha = "3. Dentistas";
                    System.out.println("Você selecionou: " + escolha);
                    dentistaMenu.menu();
                    break;
                case 4:
                    escolha = "4. Coordenadores";
                    System.out.println("Você selecionou: " + escolha);

                    break;
                case 5:
                    escolha = "5. Atendimentos";
                    atendimentoView.menuAtendimentos();
                    break;
                case 6:
                    escolha = "6. Endereços";
                    System.out.println("Você selecionou: " + escolha);
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!!");
            }
        } while(opcao!=0);
    }

   
}
