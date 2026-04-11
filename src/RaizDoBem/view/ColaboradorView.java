package RaizDoBem.view;

import RaizDoBem.model.vo.Colaborador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de interface em console para o modulo de Colaborador.
 */
public class ColaboradorView {
    Scanner sc = new Scanner(System.in);
    GenericView view = new GenericView(sc);

    public String inputCpf() {
        return view.inputCpf();
    }

    public String inputNome() {
        return view.inputNome();
    }

    public LocalDate inputDataNasc(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        view.exibirMensagem("\nData de nascimento do colaborador (dd/MM/yyyy): ");
        String data = sc.nextLine();

        return LocalDate.parse(data, formato);
    }

    public LocalDate inputDataContratacao(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        view.exibirMensagem("\nData de contratação do colaborador (dd/MM/yyyy): ");
        String data = sc.nextLine();

        return LocalDate.parse(data, formato);
    }

    public String inputEmail() {
        return view.inputString("\nEmail do colaborador: ");
    }

    public void exibirColaborador(Colaborador colaborador){
        view.exibir(colaborador);
    }

    public void listarTodos(List<Colaborador> colaboradores){
        view.listarTodos(colaboradores);
    }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}
