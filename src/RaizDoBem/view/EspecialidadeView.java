package RaizDoBem.view;

import RaizDoBem.model.vo.Especialidade;

import java.util.List;

public class EspecialidadeView {
    GenericView view = new GenericView(null);

    public void exibirEspec(Especialidade especialidade) {
        view.exibir(especialidade);
    }

    public void exibirLista(List<Especialidade> especialidades) {
        view.listarTodos(especialidades);
    }
}
