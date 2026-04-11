package RaizDoBem.view;

import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
/**
 * Classe de interface em console para o modulo de PedidoAjuda.
 */
public class PedidoAjudaView {
    Scanner sc = new Scanner(System.in);
    GenericView view = new GenericView(sc);

    public int inputId() {
        return view.inputId("\nInsira o ID: ");
    }
    public String inputCpf() {
        return view.inputCpf();
    }

    public String inputNome() {
        return view.inputNome();
    }

     public LocalDate inputData(){
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         view.exibirMensagem("\nInsira a data (dd/MM/yyyy): ");
         String data = sc.nextLine();

        return LocalDate.parse(data, formato);
     }

     public LocalDate inputDataNasc() {
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         view.exibirMensagem("\nInsira a data de nascimento (dd/MM/yyyy): ");
         String data = sc.nextLine();

         return LocalDate.parse(data, formato);
     }
    public int inputSexo() {
        view.exibirMensagem("\nSelecione o sexo do solicitante: ");
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

    public String inputDescricao() {
        return view.inputString("\nDescrição completa do pedido de ajuda: ");
    }

    public int inputEndereco() {
        return view.inputId("\nInsira o ID do endereço do pedido: ");
    }

    public int inputStatus() {
        view.exibirMensagem("\nSelecione o novo status do pedido: ");
        view.exibirMensagem("1. APROVADO");
        view.exibirMensagem("2. REJEITADO");
        int status = sc.nextInt();
        sc.nextLine();

        return status;
    }

    public int inputPrograma() {
        view.exibirMensagem("\nEsse beneficiário(a) fará parte de qual programa da ONG?");
        view.exibirMensagem("1. Dentista do Bem");
        view.exibirMensagem("2. Apolônias do Bem");
        int opc = sc.nextInt();
        sc.nextLine();

        return opc;
    }

    public int inputIdDentista() {
        return view.inputId("\nInsira o ID do dentista responsável: ");
    }

    public void exibirPedido(PedidoAjuda pedido) {
        view.exibir(pedido);
    }

    public void listarTodos(List<PedidoAjuda> pedidos) {
        view.listarTodos(pedidos);
        }

    public void mostrar(String msg) {
        view.exibirMensagem(msg);
    }
}