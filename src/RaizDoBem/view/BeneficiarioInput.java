package RaizDoBem.view;

import RaizDoBem.model.vo.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;

public class BeneficiarioInput {
    Scanner sc = new Scanner(System.in);
    public Beneficiario criar(){
        System.out.println("----- Criando novo beneficiário: -----");

        String cpf = inputCpf();

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

        int idSexo = 0;
        int primeiraOpc;
        do{
            System.out.println("Selecione o sexo do beneficiário: ");
            System.out.println("1. Masculino");
            System.out.println("2. Feminino");
            System.out.println("3. Outros");
            primeiraOpc = sc.nextInt();
            sc.nextLine();

            if (primeiraOpc==1)
                idSexo = 1;

            else if (primeiraOpc==2)
                idSexo = 2;

            else if (primeiraOpc==3)
                idSexo = 3;

            else System.out.println("Opção Inválida!!!");

        } while(primeiraOpc<1 || primeiraOpc>3);

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
}
