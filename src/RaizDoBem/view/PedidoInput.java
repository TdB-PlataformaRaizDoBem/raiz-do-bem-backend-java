package RaizDoBem.view;

import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PedidoInput {
    Scanner sc = new Scanner(System.in);
    PedidoAjudaController controller = new PedidoAjudaController();
    public PedidoAjuda criar(){
        System.out.println("----- Adicionar novo pedido de ajuda: -----");

        String cpf;
//        do{
//            cpf = inputCpf();
//            if(!controller.validarCpf(cpf)){
//                System.out.println("CPF inválido, digite exatamente 11 dígitos!!!");
//            }
//        }while(!controller.validarCpf(cpf));

        System.out.println("Descrição completa do pedido de ajuda: ");
        String descricaoProblema = sc.nextLine();

        System.out.println("Nome completo do solicitante: ");
        String nomeCompleto = sc.nextLine();

        System.out.println("Telefone do solicitante: ");
        String telefone = sc.nextLine();

        System.out.println("Email do solicitante: ");
        String email = sc.nextLine();

        LocalDate data = LocalDate.now();
        //Corrigir formatacao para pegar a data atual

        int idStatus = 1; //status inicial do pedido de ajuda

        return new PedidoAjuda(
                cpf,
                descricaoProblema,
                nomeCompleto,
                telefone,
                email,
                data,
                idStatus
        );
    }
}
