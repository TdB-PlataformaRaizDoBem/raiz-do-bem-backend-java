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
 * 1º Metodo - inputId: Solicita ao usuário o ID do pedido de ajuda e retorna o valor inteiro digitado.
 * 2º Metodo - inputCpf: Solicita ao usuário o CPF do solicitante do pedido de ajuda e retorna a string digitada.
 * 3º Metodo - inputNome: Solicita ao usuário o nome completo do solicitante do pedido de ajuda e retorna a string digitada.
 * 4º Metodo - inputDataNasc: Solicita ao usuário a data de nascimento do solicitante do pedido de ajuda no formato "dd/MM/yyyy", converte a string para um objeto LocalDate e retorna a data.
 * 5º Metodo - inputSexo: Solicita ao usuário o sexo do solicitante do pedido de ajuda e retorna a opção escolhida como um valor inteiro.
 * 6º Metodo - inputTelefone: Solicita ao usuário o telefone do solicitante do pedido de ajuda e retorna a string digitada.
 * 7º Metodo - inputEmail: Solicita ao usuário o email do solicitante do pedido de ajuda e retorna a string digitada.
 * 8º Metodo - inputDescricao: Solicita ao usuário a descrição completa do pedido de ajuda e retorna a string digitada.
 * 9º Metodo - inputEndereco: Solicita ao usuário o ID do endereço do pedido de ajuda e retorna o valor inteiro digitado.
 * 10º Metodo - inputStatus: Solicita ao usuário o novo status do pedido de ajuda e retorna a opção escolhida como um valor inteiro.
 * 11º Metodo - inputPrograma: Solicita ao usuário o programa da ONG ao qual o beneficiário do pedido de ajuda fará parte e retorna a opção escolhida como um valor inteiro.
 * 12º Metodo - inputIdDentista: Solicita ao usuário o ID do dentista responsável pelo pedido de ajuda e retorna o valor inteiro digitado.
 * */
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