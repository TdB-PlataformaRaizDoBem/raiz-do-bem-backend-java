package RaizDoBem.view;

import RaizDoBem.model.vo.Dentista;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de visualização para o Dentista. Esta classe é responsável por interagir com o usuário, solicitando as informações necessárias para criar, listar e buscar dentistas. Ela utiliza a classe Scanner para ler as entradas do usuário e exibe mensagens e listas de dentistas de forma clara e organizada.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - inputCpf: Solicita ao usuário o CPF do dentista e retorna a string digitada.
 * 2º Metodo - inputCro: Solicita ao usuário o CRO do dentista e retorna a string digitada.
 * 3º Metodo - inputNome: Solicita ao usuário o nome completo do dentista e retorna a string digitada.
 * 4º Metodo - inputSexo: Solicita ao usuário o sexo do dentista e retorna a opção escolhida como um valor inteiro.
 * 5º Metodo - inputTelefone: Solicita ao usuário o telefone do dentista e retorna a string digitada.
 * 6º Metodo - inputEmail: Solicita ao usuário o email do dentista e retorna a string digitada.
 * 7º Metodo - inputCategoria: Solicita ao usuário a categoria do dentista (coordenador ou clínico) e retorna a opção escolhida como um valor inteiro.
 * 8º Metodo - inputIdEndereco: Solicita ao usuário o ID do endereço do dentista e retorna o valor inteiro digitado.
 * 9º Metodo - inputCidade: Solicita ao usuário a cidade do dentista e retorna a string digitada.
 * 10º Metodo - inputDisponibilidade: Solicita ao usuário se o dentista está disponível para atendimentos e retorna a opção escolhida como um valor inteiro.
 * 11º Metodo - exibirDentista: Recebe um objeto Dentista e exibe suas informações formatadas para o usuário.
 * 12º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 13º Metodo - listarTodos: Recebe uma lista de objetos Dentista e utiliza o método exibirDentista para exibir cada dentista da lista para o usuário.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de dentista, fornecendo as informações necessárias para criar e buscar dentistas, e visualizando os resultados das operações realizadas.
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
}