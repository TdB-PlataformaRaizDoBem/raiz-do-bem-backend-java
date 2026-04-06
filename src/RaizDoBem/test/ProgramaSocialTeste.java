package RaizDoBem.test;

import RaizDoBem.controller.ProgramaController;
import RaizDoBem.view.ProgramaView;

public class ProgramaSocialTeste {
    public static void main(String[] args) {
        ProgramaView view = new ProgramaView();
        ProgramaController controller = new ProgramaController(view);

        controller.listarTodos();
    }
}
