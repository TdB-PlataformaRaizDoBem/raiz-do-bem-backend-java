package RaizDoBem.view;

import RaizDoBem.model.vo.Atendimento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de visualização para a funcionalidade de Atendimento. Esta classe é responsável por interagir com o usuário, solicitando as informações necessárias para criar, listar e atualizar atendimentos, e exibindo os resultados das operações realizadas.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - inputCpf: Solicita ao usuário o CPF do colaborador responsável pelo atendimento e retorna a string digitada.
 * 2º Metodo - inputBeneficiario: Solicita ao usuário o ID do beneficiário que irá receber o atendimento e retorna o valor inteiro digitado.
 * 3º Metodo - inputDentista: Solicita ao usuário o ID do dentista que irá fornecer o atendimento e retorna o valor inteiro digitado.
 * 4º Metodo - inputProntuario: Solicita ao usuário a descrição inicial do atendimento e retorna a string digitada.
 * 5º Metodo - inputDataFinal: Solicita ao usuário a data final do atendimento no formato "dd/MM/yyyy", converte a string para um objeto LocalDate e retorna a data.
 * 6º Metodo - inputSolucao: Solicita ao usuário a descrição da solução adotada para resolver o problema odontológico do beneficiário e retorna a string digitada.
 * 7º Metodo - inputColaborador: Solicita ao usuário o ID do colaborador responsável por registrar o atendimento e retorna o valor inteiro digitado.
 * 8º Metodo - exibirAtendimento: Recebe um objeto Atendimento e exibe suas informações formatadas para o usuário.
 * 9º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 10º Metodo - listarTodos: Recebe uma lista de objetos Atendimento e utiliza o método exibirAtendimento para exibir cada atendimento da lista para o usuário.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de atendimento, fornecendo as informações necessárias para criar e atualizar atendimentos, e visualizando os resultados das operações realizadas.
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