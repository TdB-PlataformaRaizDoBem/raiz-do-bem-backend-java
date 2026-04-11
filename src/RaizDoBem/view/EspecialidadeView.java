package RaizDoBem.view;

import RaizDoBem.model.vo.Especialidade;

import java.util.List;

/**
 * Classe de interface em console para o modulo de Especialidade.
 */
public class EspecialidadeView {
    GenericView view = new GenericView(null);

    public void exibirLista(List<Especialidade> especialidades) {
        view.listarTodos(especialidades);
    }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}
