package RaizDoBem.Controller;

import RaizDoBem.Model.Beneficiario;
import RaizDoBem.Model.Endereco;
import RaizDoBem.Model.TipoBeneficiario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciaBeneficiarios implements Gerenciador<Beneficiario>{
    private List<Beneficiario> beneficiarios = new ArrayList<>();
    private GerenciaEndereco ge = new GerenciaEndereco();

    public GerenciaBeneficiarios(GerenciaEndereco ge) {
        this.ge = ge;
    }

    @Override
    public void adicionar(Beneficiario beneficiario) {
        beneficiarios.add(beneficiario);
        System.out.println("Beneficiário criado.");
    }

    @Override
    public List<Beneficiario> listarTodos() {
        System.out.println("----- Listando beneficiários: -----");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for(Beneficiario beneficiario : beneficiarios){
            String dataFormatada = beneficiario.getDataNascimento().format(formato);

            System.out.println("----------------------------------");
            System.out.println("ID Beneficiário: " + beneficiario.getIdBeneficiario());
            System.out.println("CPF do beneficiário: " + beneficiario.getCpfBeneficiario());
            System.out.println("RG do beneficiário: " + beneficiario.getRgBeneficiario());
            System.out.println("Nome do beneficiário: " + beneficiario.getNomeCompleto());
            System.out.println("Data de nascimento: " + dataFormatada);
            System.out.println("Sexo: " + beneficiario.getSexo());
            System.out.println("Tipo de beneficiário: " + beneficiario.getTipoBeneficiario());

            Endereco endereco = beneficiario.getEndereco();
            if(endereco!=null){
                System.out.println("\nEndereço do beneficiário: ");
                System.out.println(endereco.getLogradouro() + ", " + endereco.getNumero());
                System.out.println("CEP: " + endereco.getCep());
                System.out.println(endereco.getCidade() + " - " + endereco.getEstado());
            }

        }
        return beneficiarios;
    }

    @Override
    public void receberSalvarDados() {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Adicionar novo beneficiário: -----");

        int idBeneficiario = (beneficiarios.size() + 1);

        System.out.println("CPF do beneficiário: ");
        String cpf = sc.nextLine();

        System.out.println("RG do beneficiário: ");
        String rg = sc.nextLine();

        System.out.println("Nome completo do beneficiário: ");
        String nomeCompleto = sc.nextLine();

        System.out.println("Data de nascimento do beneficiário: ");
        String dataNasc = sc.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNasc, formato);

        System.out.println("Sexo do beneficiário: ");
        String sexo = sc.nextLine();

        TipoBeneficiario tp;
        int opc;
        do{
            System.out.println("Qual o tipo desse beneficiário?");
            System.out.println("1. Dentista do Bem");
            System.out.println("2. Apolônias do Bem");
            opc = sc.nextInt();
            sc.nextLine();
            if (opc==1){
                tp = new TipoBeneficiario(1, "Dentista do Bem");
            } else if (opc==2){
                tp = new TipoBeneficiario(2, "Apolônias do Bem");
            }
            else{
                System.out.println("Opção Inválida!!!");
                tp=null;
            }
        } while(opc<1 || opc>2);

        System.out.println("Digite o ID do endereço do Beneficiário.");
        int idEndereco = sc.nextInt();
        Endereco enderecoBusca = ge.buscarPeloId(idEndereco);
        if (enderecoBusca==null){
            System.out.println("Endereço não encontrado!!");
        }

        Beneficiario beneficiario = new Beneficiario(
                idBeneficiario,
                cpf,
                rg,
                nomeCompleto,
                dataNascimento,
                sexo,
                tp,
                enderecoBusca
        );
        beneficiarios.add(beneficiario);
    }
    public Beneficiario buscarPeloId(int idBeneficiario) {
        for (Beneficiario beneficiario : beneficiarios) {
            if (beneficiario.getIdBeneficiario() == idBeneficiario) {
                return beneficiario;
            }
        }
        System.out.println("Beneficiário não encontrado");
        return null;
    }
}
