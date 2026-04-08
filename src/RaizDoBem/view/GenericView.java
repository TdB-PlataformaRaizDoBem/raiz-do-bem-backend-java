package RaizDoBem.view;

import java.util.List;
import java.util.Scanner;

public class GenericView {
    private final Scanner sc;

    public GenericView(Scanner sc) {
        this.sc = sc;
    }

    public String inputString(String msg){
        exibirMensagem(msg);
        return sc.nextLine();
    }

    public int inputId(String msg){
        exibirMensagem(msg);
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public String inputCpf(){
        return inputString("\nDigite o CPF:");
    }

    public String inputNome(){
        return inputString("\nDigite o nome:");
    }

    public String inputCidade(){
        return inputString("\nDigite a cidade:");
    }
    public void exibirMensagem(String msg){
        System.out.println(msg);
    }
    public <T> void exibir(Object objeto){
        exibirMensagem(objeto.toString());
    }
    public <T> void listarTodos(List<T> lista){
        for(T objeto : lista){
            exibir(objeto);
        }
    }
}
