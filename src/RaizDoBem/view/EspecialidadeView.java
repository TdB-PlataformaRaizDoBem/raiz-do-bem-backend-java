package RaizDoBem.view;

import RaizDoBem.model.vo.Especialidade;

import java.util.List;

public class EspecialidadeView {

    public void exibir(Especialidade especialidade) {
        System.out.println(especialidade);
    }

    public void exibirLista(List<Especialidade> lista) {
        for (Especialidade elemento : lista) {
            exibir(elemento);
        }
    }
    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

}
