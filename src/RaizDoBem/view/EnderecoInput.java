package RaizDoBem.view;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.model.vo.Endereco;

import java.util.Scanner;

/**
 * Classe de view para coletar entradas de Endereco via console.
 *
 */
public class EnderecoInput {
    private int id;
    Scanner sc = new Scanner(System.in);
    EnderecoController controller = new EnderecoController();

    public Endereco criar(){
        System.out.println("----- Criando novo endereço: -----");

        String cep;
        do{
            System.out.println("Digite o CEP (8 dígitos): ");
            cep = sc.nextLine();
            if(!controller.validarCep(cep)){
                System.out.println("CEP inválido, digite exatamente 8 dígitos!!!");
            }
        } while(!controller.validarCep(cep));

        System.out.println("Digite o logradouro: ");
        String logradouro = sc.nextLine();

        System.out.println("Digite o número da casa: ");
        String numero = sc.nextLine();

        System.out.println("Digite o bairro: ");
        String bairro = sc.nextLine();

        String cidade = inputCidade();

        System.out.println("Digite o estado: ");
        String estado = sc.nextLine();

        int opc;
        int idTipo = 0;
        do {
            System.out.println("Endereço residencial ou Profissional?");
            System.out.println("1. Residencial");
            System.out.println("2. Profissional");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc==1) {
                idTipo = 1;
            }
            else if(opc==2) {
                idTipo = 2;
            }
            else{
                System.out.println("Opção Inválida!!!");
            }
        } while (opc < 1 || opc > 2);

        return new Endereco(
                logradouro,
                cep,
                numero,
                bairro,
                cidade,
                estado,
                idTipo
        );
    }

    public String inputCidade(){
        System.out.println("Digite a cidade: ");
        return sc.nextLine();
    }

    public int inputId(){
        System.out.println("Digite o ID: ");
        id = sc.nextInt();
        sc.nextLine();

        return id;
    }
}

