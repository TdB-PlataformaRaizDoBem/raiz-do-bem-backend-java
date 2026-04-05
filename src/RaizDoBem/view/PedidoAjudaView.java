package RaizDoBem.view;

import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PedidoAjudaView {
    Scanner sc = new Scanner(System.in);

    public int inputId() {
        System.out.println("\nInsira o ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }
    public String inputCpf() {
        System.out.println("\nDigite o CPF do solicitante: ");
        return sc.nextLine();
    }

    public String inputNome() {
        System.out.println("\nNome completo do solicitante: ");
        return sc.nextLine();
    }

     public LocalDate inputDataNasc(){
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         System.out.println("Data de nascimento do solicitante (dd/MM/yyyy): ");
         String data = sc.nextLine();

        return LocalDate.parse(data, formato);
     }

    public int inputSexo() {
        System.out.println("\nSelecione o sexo do solicitante: ");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        System.out.println("3. Outros");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public String inputTelefone() {
        System.out.println("Telefone do solicitante: ");
        return sc.nextLine();
    }

    public String inputEmail() {
        System.out.println("\nEmail do solicitante: ");
        return sc.nextLine();
    }

    public String inputDescricao() {
        System.out.println("\nDescrição completa do pedido de ajuda: ");
        return sc.nextLine();
    }

    public int inputEndereco() {
        System.out.println("\nInsira o ID do endereço do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public int inputStatus() {
        System.out.println("\nSelecione o novo status do pedido: ");
        System.out.println("1. APROVADO");
        System.out.println("2. REJEITADO");
        int status = sc.nextInt();
        sc.nextLine();

        return status;
    }

    public int inputIdDentista() {
        System.out.println("\nInsira o ID do dentista responsável: ");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public void exibirPedido(PedidoAjuda pedido) {
        System.out.println(pedido);
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirLista(List<PedidoAjuda> lista) {
        for (PedidoAjuda elemento : lista) {
            exibirPedido(elemento);
        }
    }

}