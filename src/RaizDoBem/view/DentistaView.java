package RaizDoBem.view;

import RaizDoBem.model.vo.Dentista;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de interface em console para o modulo de Dentista.
 */
public class DentistaView {
    Scanner sc = new Scanner(System.in);
    GenericView view = new GenericView(sc);

    public String inputCpf() {
        return view.inputCpf();
    }

    public String inputCro() {
        return view.inputString("\nCRO do dentista: ");
    }

    public String inputNome() {
        return view.inputNome();
    }
    public int inputSexo() {
        view.exibirMensagem("\nSelecione o sexo do dentista: ");
        view.exibirMensagem("1. Masculino");
        view.exibirMensagem("2. Feminino");
        view.exibirMensagem("3. Outros");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public String inputTelefone() {
        return view.inputString("\nTelefone do solicitante: ");
    }

    public String inputEmail() {
        return view.inputString("\nEmail do solicitante: ");
    }

    public int inputCategoria() {
        view.exibirMensagem("\nSelecione a categoria do dentista: ");
        view.exibirMensagem("1. Coordenador");
        view.exibirMensagem("2. Clínico");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public int inputIdEndereco() {
        return view.inputId("\nDigite o ID de endereço do dentista: ");
    }

    public String inputCidade() {
        return view.inputCidade();
    }

    public int inputDisponibilidade() {
        view.exibirMensagem("\nDentista disponível para atendimentos: ");
        view.exibirMensagem("1. Sim");
        view.exibirMensagem("2. Não");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public void exibirDentista(Dentista dentista) {
        view.exibir(dentista);
    }

    public void listarTodos(List<Dentista> dentistas) {
        view.listarTodos(dentistas);
    }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}