package RaizDoBem.controller;

import RaizDoBem.model.bo.ProgramaBO;
import RaizDoBem.model.vo.ProgramaSocial;
import RaizDoBem.view.ProgramaView;

import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de ProgramaController entre View e BO.
 * Camada: Controller.
 */
public class ProgramaController {
    private final ProgramaView view;
    private final ProgramaBO bo;

    public ProgramaController(ProgramaView view) {
        this.view = view;
        this.bo = new ProgramaBO();
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     */
    public void listarTodos(){
        List<ProgramaSocial> programas = bo.listarTodos();
        if (programas.isEmpty())
            view.mostrar("Nenhum programa social encontrado!!!");
        else {
            view.mostrar("Exibindo todos os programas sociais disponíveis na ONG: ");
            view.listarProgramas(programas);
        }
    }
}
