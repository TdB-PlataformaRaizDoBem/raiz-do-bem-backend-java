package RaizDoBem.view;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de menu para gerenciar os dentistas que prestarão serviço a ONG. Esta classe é responsável por exibir as opções de gerenciamento de dentistas, como criar, listar, atualizar e excluir dentistas. Ela interage com o DentistaController para realizar as operações necessárias e fornecer uma interface amigável para o usuário.
 * @author Paulo
 * @since 2026-03
 *
 * @see DentistaController
 * @see DentistaDAO
 * @see Dentista
 */
public class DentistaMenu {
    public void menu() {
        DentistaDAO dentistaDAO = new DentistaDAO();
        Dentista dentista = new Dentista();
        DentistaController controller = new DentistaController();
        Scanner sc = new Scanner(System.in);
        List<Dentista> dentistas = new ArrayList<>();

        String cpf = "";
        System.out.println("\n      Gerenciar Dentistas     ");
        System.out.println("        1.  Adicionar dentista");
        System.out.println("        2.  Listar todos os dentistas");
        System.out.println("        3.  Listar dentistas por cidade");
        System.out.println("        4.  Listar dentistas disponíveis");
        System.out.println("        5.  Atualizar dentista");
        System.out.println("        6.  Excluir dentista");
        System.out.println("        7.  Voltar ao menu principal");
        System.out.println("        0.  Encerrar programa");
        System.out.println("\nSelecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                controller.criarDentista(dentista);
                break;
            case 2:
                dentistas = controller.listarTodos();
                System.out.println("Listagem dos dentistas: ");
                for (Dentista d : dentistas) {
                    System.out.println(d);
                }
                break;
            case 3:
                String cidade = ""; //falta input cidade
                controller.listagemPorCidade(cidade);
                break;
            case 4:
                controller.listarDisponiveis();
                break;
            case 5:
                cpf = ""; //falta input cpf
                dentista = controller.buscaPorCpf(cpf);
                controller.atualizarDentista(cpf, dentista);
                break;
            case 6:
                cpf = ""; //falta input cpf
                dentista = controller.buscaPorCpf(cpf);
                controller.excluirDentista(cpf);
                //System.out.println("Dentista foi excluído com sucesso!!!");
                break;
            case 7:
                System.out.println("Voltando ao menu principal...");
                break;
            case 0:
                System.out.println("Encerrando programa...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida");
        }
    }
}