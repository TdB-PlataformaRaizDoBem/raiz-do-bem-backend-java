package RaizDoBem.controller;

import RaizDoBem.model.bo.ColaboradorBO;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.view.ColaboradorView;

import java.util.List;

public class ColaboradorController {
    private ColaboradorView view;
    private ColaboradorBO bo;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        this.bo = new ColaboradorBO();
    }

    public ColaboradorController() {
    }



    public void listandoTodos() {
        List<Colaborador> colaboradores = bo.listarTodos();
        if (colaboradores.isEmpty())
            view.exibirMensagem("Nenhum colaborador encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os colaboradores: ");
            view.exibirLista(colaboradores);
        }
    }
}
