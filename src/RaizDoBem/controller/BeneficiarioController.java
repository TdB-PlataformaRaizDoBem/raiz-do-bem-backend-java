package RaizDoBem.controller;

import RaizDoBem.model.dao.BeneficiarioDAO;

public class BeneficiarioController {
    private final BeneficiarioDAO beneficiarioDAO;

    public BeneficiarioController(BeneficiarioDAO beneficiarioDAO) {
        this.beneficiarioDAO = beneficiarioDAO;
    }
}
