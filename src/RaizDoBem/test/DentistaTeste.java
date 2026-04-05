package RaizDoBem.test;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.view.DentistaView;

public class DentistaTeste {
    public static void main(String[] args) {
        DentistaView view = new DentistaView();
        DentistaController controller = new DentistaController(view);

//        controller.criar();

        controller.listandoTodos();


    }
}
