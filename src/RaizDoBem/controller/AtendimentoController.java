package RaizDoBem.controller;

import RaizDoBem.model.dao.AtendimentoDAO;

public class AtendimentoController {
    private final AtendimentoDAO atendimentoDAO;

    public AtendimentoController(AtendimentoDAO atendimentoDAO) {
        this.atendimentoDAO = atendimentoDAO;
    }
}
