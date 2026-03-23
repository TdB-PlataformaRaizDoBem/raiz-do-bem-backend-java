package RaizDoBem.view;

import RaizDoBem.controller.BeneficiarioController;
import RaizDoBem.model.vo.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BeneficiarioInput {
    Scanner sc = new Scanner(System.in);
    BeneficiarioController controller = new BeneficiarioController();
    int idSexo;
    public Beneficiario criar(){
        System.out.println("----- Criando novo beneficiário: -----");

        String cpf;
        do{
            cpf = inputCpf();
            if(!controller.validarCpf(cpf)){
                System.out.println("CPF inválido, digite exatamente 11 dígitos!!!");
            }
        }while(!controller.validarCpf(cpf));

        System.out.println("Nome completo do beneficiário: ");
        String nomeCompleto = sc.nextLine();

        System.out.println("Data de nascimento do beneficiário: ");
        String dataNasc = sc.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNasc, formato);

        System.out.println("Telefone do beneficiário: ");
        String telefone = sc.nextLine();

        System.out.println("Email do beneficiário: ");
        String email = sc.nextLine();

        int opcSexo;
        do{
            opcSexo = inputSexoBeneficiario();
            switch(opcSexo){
                case 1:
                    idSexo = 1;
                    break;
                case 2:
                    idSexo = 2;
                    break;
                case 3:
                    idSexo = 3;
                    break;
                default:
                    idSexo = 0;
                    System.out.println("Opção Inválida!!!");
            }
        } while(!controller.validarSexo(idSexo));

        int idPrograma = 0;
        int segundaOpc;
        do{
            System.out.println("Esse beneficiário(a) fará parte de qual programa da ONG?");
            System.out.println("1. Dentista do Bem");
            System.out.println("2. Apolônias do Bem");
            segundaOpc = sc.nextInt();
            sc.nextLine();

            if (segundaOpc==1)
                idPrograma = 1;

            else if (segundaOpc==2)
                idPrograma = 2;

            else System.out.println("Opção Inválida!!!");

        } while(segundaOpc<1 || segundaOpc>2);

        int idEndereco = 0;
        int terceiraOpc;
//        do{
//            System.out.println("Digite o Id do Endereço do Beneficiário");
//            idEndereco = sc.nextInt();
//            sc.nextLine();
//
//            //buscarId -> se encontrar salvar. senao, id invalido e repete
//              gerar um validar Id Endereco
//        } while();

        int idPedido = 0;
        int quartaOpc;
//        do{
//            System.out.println("Digite o Id do Endereço do Beneficiário");
//            idPedido = sc.nextInt();
//            sc.nextLine();
//
//            //buscarId -> se encontrar salvar. senao, id invalido e repete
//              gerar um validar Id Pedido
//        } while();

        int idCoordenador = 0;
        int quintaOpc;
//        do{
//            System.out.println("Digite o Id do Endereço do Beneficiário");
//            idCoordenador = sc.nextInt();
//            sc.nextLine();
//
//            //buscarId -> se encontrar salvar. senao, id invalido e repete
//              gerar um validar Id Coordenador
//        } while();

        return new Beneficiario(
                cpf,
                nomeCompleto,
                dataNascimento,
                telefone,
                email,
                idSexo,
                idPrograma,
                idEndereco,
                idPedido,
                idCoordenador
        );
    }
    public String inputCpf(){
        System.out.println("Digite o CPF do beneficiário: ");
        return sc.nextLine();
    }
    public int inputSexoBeneficiario(){
        System.out.println("Selecione o sexo do beneficiário: ");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        System.out.println("3. Outros");
        idSexo = sc.nextInt();
        sc.nextLine();

        return idSexo;
    }
}
