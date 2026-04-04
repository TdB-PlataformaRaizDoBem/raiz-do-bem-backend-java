package RaizDoBem.controller;

import RaizDoBem.model.bo.BeneficiarioBO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.view.BeneficiarioView;

import java.util.List;

/** * Classe de controle para os beneficiários da ONG. Esta classe é responsável por gerenciar as operações relacionadas aos beneficiários, como adicionar, buscar, listar, atualizar e excluir beneficiários. Ela atua como uma camada intermediária entre a interface do usuário e a camada de acesso a dados (DAO), garantindo que as regras de negócio sejam aplicadas corretamente.
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioController {
    private BeneficiarioView view;
    private BeneficiarioBO bo;

    Beneficiario beneficiarioEncontrado = new Beneficiario();

    public BeneficiarioController(BeneficiarioView view) {
        this.view = view;
        this.bo = new BeneficiarioBO();
    }

    public BeneficiarioController() {
    }

    public void listandoTodos(){
        List<Beneficiario> beneficiarios = bo.listarBeneficiarios();
        view.exibirLista(beneficiarios);
    }
}
