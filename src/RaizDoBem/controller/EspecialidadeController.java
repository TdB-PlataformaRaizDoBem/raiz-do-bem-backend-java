package RaizDoBem.controller;

import RaizDoBem.model.bo.EspecialidadeBO;
import RaizDoBem.model.vo.Especialidade;
import RaizDoBem.view.EspecialidadeView;

import java.util.List;

public class EspecialidadeController {
    private EspecialidadeView view;
    private EspecialidadeBO bo;

    public EspecialidadeController(EspecialidadeView view) {
        this.view = view;
        this.bo = new EspecialidadeBO();
    }

    public EspecialidadeController() {
    }

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
