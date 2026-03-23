package RaizDoBem.view;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.controller.ViaCepController;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.ViaCep;

import java.util.Scanner;

/**
 * Classe de view para coletar entradas de Endereco via console.
 * Esta classe é responsável por interagir com o usuário para obter as informações necessárias para criar um novo endereço, como CEP, número da casa e tipo de endereço (residencial ou profissional). Ela utiliza a classe Scanner para ler as entradas do usuário e a classe ViaCepController para validar o CEP e obter informações adicionais sobre o endereço.
 */
public class EnderecoInput {
    private int id;
    Scanner sc = new Scanner(System.in);
    EnderecoController controller = new EnderecoController();
    ViaCepController viaCepController = new ViaCepController();

    public Endereco criar(){
        System.out.println("----- Criando novo endereço: -----");

        String cep;
        String logradouro = "";
        String bairro = "";
        String cidade = "";
        String estado = "";
        do{
            System.out.println("Digite o CEP (8 dígitos): ");
            cep = sc.nextLine();
            if(!controller.validarCep(cep)){
                System.out.println("CEP inválido, digite exatamente 8 dígitos!!!");
            }
        } while(!controller.validarCep(cep));

        ViaCep viaCep = null;
        try{
            viaCep = viaCepController.buscarInformacoesEndereco(cep);
        }
        catch(Exception e){
            System.out.println("Falha ao verificar CEP! Erro:" + e.getMessage());
        }

        if(!viaCep.isErro()){
            logradouro = viaCep.getLogradouro();
            bairro = viaCep.getBairro();
            cidade = viaCep.getLocalidade();
            estado = viaCep.getUf();
        }

        System.out.println("Digite o número da casa: ");
        String numero = sc.nextLine();


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

