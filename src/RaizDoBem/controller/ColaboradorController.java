package RaizDoBem.controller;

import RaizDoBem.model.bo.ColaboradorBO;
import RaizDoBem.view.ColaboradorView;

public class ColaboradorController {
    private ColaboradorView view;
    private ColaboradorBO bo;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        this.bo = new ColaboradorBO();
    }

    public ColaboradorController() {
    }
}
