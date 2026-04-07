package RaizDoBem.view;

import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
/** 
 * Classe de visualização para a funcionalidade de Pedido de Ajuda. Esta classe é responsável por interagir com o usuário, solicitando as informações necessárias para criar, listar e atualizar pedidos de ajuda, e exibindo os resultados das operações realizadas.
 * @author Paulo
 * @since 2026-03
 * 1º Metodo - inputId: Solicita ao usuário o ID do pedido de ajuda
 * 2º Metodo - inputCpf: Solicita ao usuário o CPF do solicitante do pedido de ajuda e retorna a string digitada.
 * 3º Metodo - inputNome: Solicita ao usuário o nome completo do solicitante do pedido de ajuda e retorna a string digitada.
 * 4º Metodo - inputDataNasc: Solicita ao usuário a data de nascimento do solicitante do pedido de ajuda no formato "dd/MM/yyyy", converte a string para um objeto LocalDate e retorna a data.
 * 5º Metodo - inputSexo: Solicita ao usuário o sexo do solicitante do pedido de ajuda, apresentando opções para masculino, feminino e outros, e retorna a opção escolhida como um valor inteiro.
 * 6º Metodo - inputTelefone: Solicita ao usuário o telefone do solicitante do pedido de ajuda e retorna a string digitada.
 * 7º Metodo - inputEmail: Solicita ao usuário o email do solicitante do pedido de ajuda e retorna a string digitada.
 * 8º Metodo - inputDescricao: Solicita ao usuário a descrição completa do pedido de ajuda e retorna a string digitada.
 * 9º Metodo - inputEndereco: Solicita ao usuário o ID do endereço associado ao pedido de ajuda e retorna o valor inteiro digitado.
 * 10º Metodo - inputStatus: Solicita ao usuário o novo status do pedido de ajuda, apresentando opções para aprovado e rejeitado, e retorna a opção escolhida como um valor inteiro.
 * 11º Metodo - inputIdDentista: Solicita ao usuário o ID do dentista responsável pelo pedido de ajuda e retorna o valor inteiro digitado.
 * 12º Metodo - exibirPedido: Recebe um objeto PedidoAjuda e exibe suas informações formatadas para o usuário.
 * 13º Metodo - exibirMensagem: Recebe uma string de mensagem e a exibe para o usuário.
 * 14º Metodo - exibirLista: Recebe uma lista de objetos PedidoAjuda e utiliza o método exibirPedido para exibir cada pedido de ajuda da lista para o usuário.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de pedido de ajuda, fornecendo as informações necessárias para criar e atualizar pedidos de ajuda, e visualizando os resultados das operações realizadas.
 */
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

    public int inputPrograma() {
        System.out.println("\nEsse beneficiário(a) fará parte de qual programa da ONG?");
        System.out.println("1. Dentista do Bem");
        System.out.println("2. Apolônias do Bem");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
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