package RaizDoBem.view;

import RaizDoBem.model.vo.Colaborador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de visualização para a entidade Colaborador. Esta classe é responsável por interagir com o usuário, solicitando informações e exibindo resultados relacionados aos colaboradores. Ela utiliza a classe Scanner para ler as entradas do usuário e exibe mensagens e listas de colaboradores conforme necessário.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - inputCpf: Solicita ao usuário o CPF do colaborador e retorna a string digitada.
 * 2º Metodo - inputNome: Solicita ao usuário o nome completo do colaborador e retorna a string digitada.
 * 3º Metodo - inputDataNasc: Solicita ao usuário a data de nascimento do colaborador no formato "dd/MM/yyyy", converte a string para um objeto LocalDate e retorna a data.
 * 4º Metodo - inputDataContratacao: Solicita ao usuário a data de contratação do colaborador no formato "dd/MM/yyyy", converte a string para um objeto LocalDate e retorna a data.
 * 5º Metodo - inputEmail: Solicita ao usuário o email do colaborador e retorna a string digitada.
 * 6º Metodo - exibir: Recebe um objeto Colaborador e exibe suas informações formatadas para o usuário.
 * 7º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 8º Metodo - listarTodos: Recebe uma lista de objetos Colaborador e utiliza o método exibir para exibir cada colaborador da lista para o usuário.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de colaborador, fornecendo as informações necessárias para criar e buscar colaboradores, e visualizando os resultados das operações realizadas.
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
}
