package RaizDoBem.view;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;

import java.util.Scanner;

public class DentistaMenu {
    public void menu() {
        DentistaDAO dentistaDAO = new DentistaDAO();
        Dentista dentista = new Dentista();
        DentistaController controller = new DentistaController();
        Scanner sc = new Scanner(System.in);
        int id = 0;

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
                System.out.println("Listagem dos dentistas: ");
                controller.listarTodos();
                break;
            case 3:
                String cidade = "";
                dentistaDAO.listarPorCidade(cidade);
                break;
            case 4:
                dentistaDAO.listarDisponiveis();
                break;
            case 5:
                dentistaDAO.atualizarDentista(id);
                break;
            case 6:
                dentistaDAO.excluirDentista(id);
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