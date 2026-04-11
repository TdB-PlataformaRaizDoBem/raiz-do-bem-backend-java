package RaizDoBem.view;

import RaizDoBem.model.vo.Atendimento;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de interface em console para o modulo de Atendimento.
 */
public class AtendimentoView {
    Scanner sc = new Scanner(System.in);
    GenericView view = new GenericView(sc);

    public int inputId() {
        return view.inputId("\nDigite o id do atendimento: ");
    }

    public String inputCpf() {
        return view.inputCpf();
    }

    public int inputBeneficiario() {
        return view.inputId("\nDigite o ID do beneficiário que irá receber o atendimento: ");
    }

    public int inputDentista() {
        return view.inputId("\nDigite o ID do dentista que irá fornecer o atendimento: ");
    }

    public String inputProntuario() {
        return view.inputString("\nInsira o prontuário do atendimento: ");
    }

    public int inputColaborador() {
        return view.inputId("\nDigite o ID do colaborador que está finalizando o atendimento: ");
    }
    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }

    public void exibirAtendimento(Atendimento atendimento){
        view.exibir(atendimento);
    }

    public void listarTodos(List<Atendimento> atendimentos) {
        view.listarTodos(atendimentos);
    }
}