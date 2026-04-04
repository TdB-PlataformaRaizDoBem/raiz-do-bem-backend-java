package RaizDoBem.view;

import RaizDoBem.model.vo.Colaborador;

import java.util.List;
import java.util.Scanner;

public class ColaboradorView {
    Scanner sc = new Scanner(System.in);

    public void exibir(Colaborador colaborador){
        System.out.println(colaborador);
    }
    public void exibirMensagem(String msg){
        System.out.println(msg);
    }

    public void exibirLista(List<Colaborador> lista){
        for (Colaborador elemento : lista){
            exibir(elemento);
        }
    }
}
