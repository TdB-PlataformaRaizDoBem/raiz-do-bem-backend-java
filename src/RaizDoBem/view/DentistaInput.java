package RaizDoBem.view;

import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.Endereco;

import java.util.Scanner;

/**
 * Classe de entrada para criar um novo dentista. Esta classe é responsável por coletar as informações necessárias para criar um dentista, como CPF, nome completo, data de nascimento, email, ID do endereço, sexo, CRO e disponibilidade. Ela utiliza a classe Scanner para ler as entradas do usuário e garantir que as informações sejam coletadas de forma adequada.
 * @author Paulo
 * @since 2026-03
 */
public class DentistaInput {
    Scanner sc = new Scanner(System.in);
    public Dentista criar(){
        System.out.println("----- Criando novo dentista: -----");

        String cpf = inputCpf();

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

        return new Dentista(
//                cpf,
//                nomeCompleto,
//                dataNascimento,
//                email,
//                idEndereco,
//                idSexo,
//                cro,
//                disponibilidade
        );
    }

    public String inputCpf(){
        System.out.println("Digite o CPF do dentista: ");
        return sc.nextLine();
    }
}
