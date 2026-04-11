package RaizDoBem.controller;

import RaizDoBem.model.bo.EspecialidadeBO;
import RaizDoBem.model.vo.Especialidade;
import RaizDoBem.view.EspecialidadeView;

import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de EspecialidadeController entre View e BO.
 * Camada: Controller.
 */
public class EspecialidadeController {
    private final EspecialidadeView view;
    private final EspecialidadeBO bo;

    public EspecialidadeController(EspecialidadeView view) {
        this.view = view;
        this.bo = new EspecialidadeBO();
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     */
    public void listarTodas() {
        List<Especialidade> especialidades = bo.listarTodos();
        if (especialidades.isEmpty())
            view.mostrar("\nNenhuma especialidade encontrada!!!");
        else {
            view.mostrar("\nExibindo todas as especialidades: ");
            view.exibirLista(especialidades);
        }
    }
}
