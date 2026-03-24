package RaizDoBem.controller;

import RaizDoBem.model.dao.ColaboradorDAO;

public class ColaboradorController {
    private final ColaboradorDAO colaboradorDAO;

    public ColaboradorController(ColaboradorDAO colaboradorDAO) {
        this.colaboradorDAO = colaboradorDAO;
    }
}
