package RaizDoBem.view;

import RaizDoBem.model.vo.ProgramaSocial;

import java.util.List;

public class ProgramaView {
    GenericView view = new GenericView(null);

    public void exibirPrograma(ProgramaSocial programa) {
        view.exibir(programa);
    }

    public void listarProgramas(List<ProgramaSocial> programas) {
        view.listarTodos(programas);
    }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}
