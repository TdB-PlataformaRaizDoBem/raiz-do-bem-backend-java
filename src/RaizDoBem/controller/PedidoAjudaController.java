package RaizDoBem.controller;

import RaizDoBem.model.dao.PedidoAjudaDAO;

public class PedidoAjudaController {
    private final PedidoAjudaDAO pedidoAjudaDAO;

    public PedidoAjudaController(PedidoAjudaDAO pedidoAjudaDAO) {
        this.pedidoAjudaDAO = pedidoAjudaDAO;
    }
}
