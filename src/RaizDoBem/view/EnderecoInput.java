package RaizDoBem.view;

import RaizDoBem.model.vo.Endereco;

import java.util.Scanner;

/**
 * Classe de view para coletar entradas de Endereco via console.
 */
public class EnderecoInput {
    private int id;
    private String cidade;

    public Endereco criarEndereco(){
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Criando novo endereço: -----");

        System.out.println("Logradouro: ");
        String logradouro = sc.nextLine();

        System.out.println("CEP: ");
        String cep = sc.nextLine();

        System.out.println("Número: ");
        String numero = sc.nextLine();

        System.out.println("Bairro: ");
        String bairro = sc.nextLine();

        System.out.println("Cidade: ");
        String cidade = sc.nextLine();

        System.out.println("Estado: ");
        String estado = sc.nextLine();

        int opc;
        int idTipoEndereco = 0;
        do {
            System.out.println("Endereço residencial ou Profissional?");
            System.out.println("1. Residencial");
            System.out.println("2. Profissional");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc==1) {
                idTipoEndereco = 1;
            }
            else if(opc==2) {
                idTipoEndereco = 2;
            }
            else{
                System.out.println("Opção Inválida!!!");
            }
        } while (opc < 1 || opc > 2);

        Endereco endereco = new Endereco(
                logradouro,
                cep,
                numero,
                bairro,
                cidade,
                estado,
                idTipoEndereco
        );
        return endereco;
    }

    public String inputCidade(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Digite a cidade, que deseja utilizar na busca: ");
        cidade = sc.nextLine();

        return cidade;
    }

    public int inputId(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Digite o ID que será utilizado como parâmetro: ");
        id = sc.nextInt();
        sc.nextLine();

        return id;
    }
}

