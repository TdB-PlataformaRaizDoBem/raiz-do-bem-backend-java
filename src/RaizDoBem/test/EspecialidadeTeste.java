package RaizDoBem.test;

import RaizDoBem.controller.EspecialidadeController;
import RaizDoBem.view.EspecialidadeView;

/**
 * Classe de teste com main para validar o fluxo de Especialidade.
 */
public class EspecialidadeTeste {
    public static void main(String[] args) {
        EspecialidadeView view = new EspecialidadeView();
        EspecialidadeController controller = new EspecialidadeController(view);

        //Listando todas as especialidades
        controller.listarTodas();
    }
}
