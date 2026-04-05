package RaizDoBem.view;

import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PedidoAjudaView {
    Scanner sc = new Scanner(System.in);

    public int inputId() {
        System.out.println("Insira o ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }
    public String inputCpf() {
        System.out.println("Digite o CPF do beneficiário: ");
        return sc.nextLine();
    }

    public String inputNome() {
        System.out.println("Nome completo do solicitante: ");
        return sc.nextLine();
    }

     public LocalDate inputDataNasc(){
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         System.out.println("Data de nascimento do solicitante (dd/MM/yyyy): ");
         String data = sc.nextLine();

        return LocalDate.parse(data, formato);
     }

    public int inputSexo() {
        System.out.println("Selecione o sexo do solicitante: ");
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
        System.out.println("Email do solicitante: ");
        return sc.nextLine();
    }

    public String inputDescricao() {
        System.out.println("Descrição completa do pedido de ajuda: ");
        return sc.nextLine();
    }

    public int inputEndereco() {
        System.out.println("Insira o ID do endereço: ");
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