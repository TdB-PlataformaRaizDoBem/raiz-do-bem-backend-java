package RaizDoBem.view;

import RaizDoBem.model.vo.Atendimento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class AtendimentoView {
    Scanner sc = new Scanner(System.in);

//        System.out.println("        3. Listar atendimentos por data");
//        System.out.println("        5. Encontrar atendimentos de um dentista");

    public String inputCpf() {
        System.out.println("\nDigite o cpf do colaborador(11 dígitos): ");
        return sc.nextLine();
    }

    public int inputBeneficiario() {
        System.out.println("\nDigite o ID do beneficiário que irá receber o atendimento: ");
        int idBeneficiario = sc.nextInt();
        sc.nextLine();
        return idBeneficiario;
    }

    public int inputDentista() {
        System.out.println("\nDigite o ID do dentista que irá fornecer o atendimento: ");
        int idDentista = sc.nextInt();
        sc.nextLine();
        return idDentista;
    }

    public String inputDescricaoInicial() {
        System.out.println("\nInsira a descrição inicial do atendimento: ");
        return sc.nextLine();
    }

    public LocalDate inputDataFinal(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data final do atendimento (dd/MM/yyyy): ");
        String data = sc.nextLine();

        return LocalDate.parse(data, formato);
    }

    public String inputSolucao() {
        System.out.println("\nInsira a solução final do atendimento: ");
        return sc.nextLine();
    }

    public int inputColaborador() {
        System.out.println("\nDigite o ID do colaborador que está finaizando o atendimento: ");
        int idColaborador = sc.nextInt();
        sc.nextLine();
        return idColaborador;
    }

    public void exibirAtendimento(Atendimento atendimento) {
        System.out.println(atendimento);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<Atendimento> lista) {
        for (Atendimento elemento : lista) {
            exibirAtendimento(elemento);
        }
    }
}
