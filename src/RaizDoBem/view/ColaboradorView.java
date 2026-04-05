package RaizDoBem.view;

import RaizDoBem.model.vo.Colaborador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ColaboradorView {
    Scanner sc = new Scanner(System.in);

    public String inputCpf() {
        System.out.println("\nDigite o cpf do colaborador(11 dígitos): ");
        return sc.nextLine();
    }

    public String inputNome() {
        System.out.println("\nNome completo do colaborador: ");
        return sc.nextLine();
    }

    public LocalDate inputDataNasc(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nData de nascimento do colaborador (dd/MM/yyyy): ");
        String data = sc.nextLine();

        return LocalDate.parse(data, formato);
    }

    public LocalDate inputDataContratacao(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nData de contratação do colaborador (dd/MM/yyyy): ");
        String data = sc.nextLine();

        return LocalDate.parse(data, formato);
    }

    public String inputEmail() {
        System.out.println("\nEmail do colaborador: ");
        return sc.nextLine();
    }


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
