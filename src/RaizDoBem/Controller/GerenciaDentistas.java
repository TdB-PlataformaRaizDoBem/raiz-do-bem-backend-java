package RaizDoBem.Controller;

import RaizDoBem.Model.Dentista;
import RaizDoBem.Model.Endereco;
import RaizDoBem.Model.TipoEndereco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciaDentistas implements Gerenciador<Dentista>{
    private List<Dentista> dentistas = new ArrayList<>();
    private GerenciaEndereco ge = new GerenciaEndereco();

    public GerenciaDentistas(GerenciaEndereco ge) {
        this.ge = ge;
    }

    public GerenciaDentistas() {
    }

    public void alterarStatus(int idDentista) {
        System.out.println("--- Alterar disponibilidade de dentista: ---");
    }

    @Override
    public void adicionar(Dentista dentista) {
        dentistas.add(dentista);
        System.out.println("Novo dentista foi adicionado.");
    }

    @Override
    public List<Dentista> listarTodos() {
        System.out.println("----- Listando dentistas: -----");
        String status;
        for (Dentista dentista: dentistas) {
            System.out.println("-----------------------------------------");
            System.out.println("CRO-Dentista: " + dentista.getCroDentista());
            System.out.println("Especialidade: " + dentista.getEspecialidade());
            if (dentista.isDisponivel()){
                status = "Disponível";
            }
            else{
                status = "Não disponível";
            }
            System.out.println("Disponibilidade do dentista: " + status);
            System.out.println("Nível do dentista: " + dentista.getNivelDentista());

            System.out.println("\nEndereço residencial do Dentista: ");
            System.out.println(dentista.getEndereco().getLogradouro() + ", " + dentista.getEndereco().getNumero());
            System.out.println("CEP: " + dentista.getEndereco().getCep());
            System.out.println(dentista.getEndereco().getCidade() + " - " + dentista.getEndereco().getEstado());

            System.out.println("\nEndereço profissional do Dentista: ");
            System.out.println(dentista.getEndProfissional().getLogradouro() + ", " + dentista.getEndProfissional().getNumero());
            System.out.println("CEP: " + dentista.getEndProfissional().getCep());
            System.out.println(dentista.getEndProfissional().getCidade() + " - " + dentista.getEndProfissional().getEstado());
        }
        return dentistas;
    }

//    @Override
//    public void receberSalvarDados() {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("--- Adicionar novo dentista: ---");
//
//            System.out.println("ID do colaborador: ");
//            int idColaborador = sc.nextInt();
//            sc.nextLine();
//
//            System.out.println("CPF do dentista: ");
//            String cpf = sc.nextLine();
//
//            System.out.println("RG do dentista: ");
//            String rg = sc.nextLine();
//
//            System.out.println("Nome completo do dentista: ");
//            String nomeCompleto = sc.nextLine();
//
//            System.out.println("Data de nascimento do dentista: ");
//            String dataNasc = sc.nextLine();
//            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate dataNascimento = LocalDate.parse(dataNasc, formato);
//
//            System.out.println("E-mail do dentista: ");
//            String email = sc.nextLine();
//
//            System.out.println("Senha do dentista: ");
//            String senha = sc.nextLine();
//
//            int idDentista = (dentistas.size() + 1 );
//
//            System.out.println("Digite o CRO do dentista: ");
//            String croDentista = sc.nextLine();
//
//            System.out.println("Especialidade do dentista: ");
//            String especialidade = sc.nextLine();
//
//            System.out.println("Dentista disponível para atendimento:");
//            String disponibilidade = sc.nextLine();
//
//            boolean disponivel = false;
//            if (disponibilidade.equals("sim")  || disponibilidade.equals("Sim")){
//                disponivel = true;
//            } else{
//                disponivel = false;
//            }
//
//            System.out.println("Nível do dentista: ");
//            String nivelDentista = sc.nextLine();
//
//            Endereco enderecoResidencial;
//
//            System.out.println("Endereço residencial do dentista: ");
//
//            System.out.println("Digite o endereço: ");
//            String logradouro = sc.nextLine();
//
//            System.out.println("Digite o logradouro: ");
//            String logradouro = sc.nextLine();
//
//            System.out.println("CEP: ");
//            String cep = sc.nextLine();
//
//            System.out.println("Número: ");
//            String numero = sc.nextLine();
//
//            System.out.println("Cidade: ");
//            String cidade = sc.nextLine();
//
//            System.out.println("Estado: ");
//            String estado = sc.nextLine();
//
//            TipoEndereco tipoEndereco = new TipoEndereco(1, "Residencial");
//            enderecoResidencial = new Endereco(
//                    idEndereco,
//                    logradouro,
//                    cep,
//                    numero,
//                    cidade,
//                    estado
//                 //   , tipoEndereco
//            );
//            ge.adicionar(enderecoResidencial);
//
//            System.out.println("Endereço profissional do dentista: ");
//
//            System.out.println("Digite o logradouro: ");
//            logradouro = sc.nextLine();
//
//            System.out.println("CEP: ");
//            cep = sc.nextLine();
//
//            System.out.println("Número: ");
//            numero = sc.nextLine();
//
//            System.out.println("Cidade: ");
//            cidade = sc.nextLine();
//
//            System.out.println("Estado: ");
//            estado = sc.nextLine();
//
//            tipoEndereco = new TipoEndereco(2,"Profissional");
//            Endereco enderecoProfissional = new Endereco(
//                    logradouro,
//                    cep,
//                    numero,
//                    cidade,
//                    estado
//                    //,tipoEndereco
//            );
//            ge.adicionar(enderecoProfissional);
//
//            Dentista dentista = new Dentista(
//                    idColaborador,
//                    cpf,
//                    nomeCompleto,
//                    dataNascimento,
//                    email,
//                    senha,
//                    idDentista,
//                    croDentista,
//                    especialidade,
//                    disponivel,
//                    nivelDentista,
//                    enderecoResidencial,
//                    enderecoProfissional
//            );
//            adicionar(dentista);
//    }
    public Dentista buscarPeloId(int idDentista) {
        for (Dentista dentista : dentistas) {
            if (dentista.getIdDentista() == idDentista) {
                return dentista;
            }
        }
        System.out.println("Dentista não encontrado");
        return null;
    }
}
