package RaizDoBem.test;

import RaizDoBem.controller.EspecialidadeController;
import RaizDoBem.view.EspecialidadeView;

public class EspecialidadeTeste {
    public static void main(String[] args) {
        EspecialidadeView view = new EspecialidadeView();
        EspecialidadeController controller = new EspecialidadeController(view);

        controller.listarTodas();
    }
}
