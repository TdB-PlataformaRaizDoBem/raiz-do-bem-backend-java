package RaizDoBem.view;

import RaizDoBem.model.vo.ProgramaSocial;

import java.util.List;

/**
 * Classe de interface em console para o modulo de Programa.
 */
public class ProgramaView {
    GenericView view = new GenericView(null);

    public void listarProgramas(List<ProgramaSocial> programas) {
        view.listarTodos(programas);
    }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}
