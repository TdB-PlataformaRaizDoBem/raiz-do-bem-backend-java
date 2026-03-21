package RaizDoBem.controller;

import RaizDoBem.model.dao.CoordenadorDAO;

public class CoordenadorController {
    private final CoordenadorDAO coordenadorDAO;

    public CoordenadorController(CoordenadorDAO coordenadorDAO) {
        this.coordenadorDAO = coordenadorDAO;
    }
}
