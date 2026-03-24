package RaizDoBem.view;

import RaizDoBem.model.vo.Atendimento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe de entrada para criar um novo atendimento. Esta classe é responsável por coletar as informações necessárias para criar um atendimento, como descrição, data, ID do beneficiário e ID do dentista. Ela utiliza a classe Scanner para ler as entradas do usuário e formata a data utilizando DateTimeFormatter.
 * @author Paulo
 * @since 2026-03
 */
public class AtendimentoInput {
    Scanner sc = new Scanner(System.in);
    public Atendimento criar(){
        System.out.println("--- Adicionar novo atendimento: ---");

        System.out.println("Descrição do Atendimento: ");
        String descricao = sc.nextLine();

        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data do atendimento: ");
        String dataDigitada = sc.nextLine();
        LocalDate data = LocalDate.parse(dataDigitada,formatacao);

//        LocalDate dataHoje = LocalDate.now();
//        LocalDate data = LocalDate.parse(dataHoje,formatacao);

        System.out.println("Digite o ID do beneficiário que recebe o atendimento: ");
        int idBeneficiario = sc.nextInt();
        sc.nextLine();

        //validar dentista
//        if (idBeneficiario==0){
//            System.out.println("Beneficiário não encontrado!!");
//        }

        System.out.println("Digite o ID do dentista que irá fornecer o atendimento: ");
        int idDentista = sc.nextInt();
        sc.nextLine();

        //validar beneficiario
//        if (idDentista==0){
//            System.out.println("Dentista não encontrado!!");
//        }

        return new Atendimento(
                descricao,
                dataInicial,
                dataFinal,
                idBeneficiario,
                idDentista
        );
    }
}
