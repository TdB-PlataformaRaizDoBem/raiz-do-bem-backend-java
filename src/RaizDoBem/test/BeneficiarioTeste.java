package RaizDoBem.test;

import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.view.BeneficiarioView;


public class BeneficiarioTeste {
    public static void main(String[] args) {
        BeneficiarioView view = new BeneficiarioView();
        BeneficiarioController controller = new BeneficiarioController(view);


        controller.listandoTodos();
    }
}