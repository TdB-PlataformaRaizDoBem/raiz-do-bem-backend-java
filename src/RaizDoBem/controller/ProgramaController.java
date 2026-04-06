package RaizDoBem.controller;

import RaizDoBem.model.bo.ProgramaBO;
import RaizDoBem.model.vo.Especialidade;
import RaizDoBem.model.vo.ProgramaSocial;
import RaizDoBem.view.ProgramaView;

import java.util.List;

public class ProgramaController {
    private ProgramaView view;
    private ProgramaBO bo;

    public ProgramaController(ProgramaView view) {
        this.view = view;
        this.bo = new ProgramaBO();
    }

    public ProgramaController() {
    }

    public void listarTodos(){
        List<ProgramaSocial> programas = bo.listarTodos();
        if (programas.isEmpty())
            view.exibirMensagem("Nenhum programa social encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os programas sociais disponíveis na ONG: ");
            view.exibirLista(programas);
        }
    }
}
