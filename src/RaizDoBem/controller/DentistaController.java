package RaizDoBem.controller;

import RaizDoBem.model.dao.DentistaDAO;

public class DentistaController {
    private final DentistaDAO dentistaDAO;

    public DentistaController(DentistaDAO dentistaDAO) {
        this.dentistaDAO = dentistaDAO;
    }
}
