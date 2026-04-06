package RaizDoBem.view;

import RaizDoBem.model.vo.ProgramaSocial;

import java.util.List;

public class ProgramaView {

    public void exibir(ProgramaSocial programa) {
        System.out.println(programa);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<ProgramaSocial> lista) {
        for (ProgramaSocial elemento : lista) {
            exibir(elemento);
        }
    }
}
