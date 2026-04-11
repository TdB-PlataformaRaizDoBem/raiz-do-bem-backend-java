package RaizDoBem.test;

import RaizDoBem.controller.ProgramaController;
import RaizDoBem.view.ProgramaView;

/**
 * Classe de teste com main para validar o fluxo de ProgramaSocial.
 */
public class ProgramaSocialTeste {
    public static void main(String[] args) {
        ProgramaView view = new ProgramaView();
        ProgramaController controller = new ProgramaController(view);

        //Listando todos os programas sociais
        controller.listarTodos();
    }
}
