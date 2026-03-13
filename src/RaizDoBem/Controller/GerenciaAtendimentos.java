//package RaizDoBem.Controller;
//
//import RaizDoBem.Model.Atendimento;
//import RaizDoBem.Model.Beneficiario;
//import RaizDoBem.Model.Dentista;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class GerenciaAtendimentos implements Gerenciador<Atendimento>{
//    private List<Atendimento> atendimentos = new ArrayList<>();
//    private GerenciaBeneficiarios gerenciaBeneficiarios;
//    private GerenciaDentistas gerenciaDentistas;
//
//    public GerenciaAtendimentos(GerenciaBeneficiarios gerenciaBeneficiarios, GerenciaDentistas gerenciaDentistas) {
//        this.gerenciaBeneficiarios = gerenciaBeneficiarios;
//        this.gerenciaDentistas = gerenciaDentistas;
//    }
//
//    @Override
//    public void adicionar(Atendimento atendimento) {
//        atendimentos.add(atendimento);
//        System.out.println("Novo atendimento adicionado.");
//    }
//
//    @Override
//    public List<Atendimento> listarTodos() {
//        System.out.println("----- Listando atendimentos: -----");
//
//        for (Atendimento atendimento: atendimentos) {
//            System.out.println("-----------------------------------------");
//            System.out.println("Atendimento [" + atendimento.getIdAtendimento() + "]");
//            System.out.println("Descrição do atendimento: " + atendimento.getDescricao());
//            System.out.println("Data do atendimento: " + atendimento.getDataAtendimento());
//
//            Beneficiario b1 = atendimento.getBeneficiario();
//            Dentista d1 = atendimento.getDentista();
//            String nomeBeneficiario = "";
//            String nomeDentista = "";
//            if(b1!=null){
//                nomeBeneficiario = atendimento.getBeneficiario().getNomeCompleto();
//                System.out.println("Beneficiário que recebeu o atendimento: " + nomeBeneficiario + " - ID: [" + b1.getIdBeneficiario() + "]");
//            } else{
//                System.out.println("Beneficiário não encontrado!");
//                }
//            if(d1!=null){
//                nomeDentista = atendimento.getDentista().getNomeCompleto();
//                System.out.println("Dentista responsável pelo atendimento: " + nomeDentista + " - ID: [" + d1.getIdDentista() + "]");
//            }else{
//                System.out.println("Dentista não encontrado!");
//            }
//        }
//        return atendimentos;
//    }
//
//    @Override
//    public void receberSalvarDados() {
//        Scanner sc = new Scanner(System.in);
//        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        System.out.println("--- Adicionar novo atendimento: ---");
//
//        int idAtendimento = (atendimentos.size() + 1);
//
//        System.out.println("Descrição do Atendimento: ");
//        String descricao = sc.nextLine();
//
//        System.out.println("Data do atendimento: ");
//        String dataDigitada = sc.nextLine();
//        LocalDate dataAtendimento = LocalDate.parse(dataDigitada,formatacao);
//
//        System.out.println("Digite o ID do beneficiário envolvido no atendimento: ");
//        int idBeneficiario = sc.nextInt();
//        sc.nextLine();
//        Beneficiario beneficiario = gerenciaBeneficiarios.buscarPeloId(idBeneficiario);
//
//        if (idBeneficiario==0){
//            System.out.println("Beneficiário não encontrado!!");
//        }
//        System.out.println("Digite o ID do dentista envolvido no atendimento: ");
//        int idDentista = sc.nextInt();
//        sc.nextLine();
//        Dentista dentista = gerenciaDentistas.buscarPeloId(idDentista);
//
//        if (idDentista==0){
//            System.out.println("Dentista não encontrado!!");
//        }
//
//        Atendimento novoAtendimento = new Atendimento(
//                idAtendimento,
//                descricao,
//                dataAtendimento,
//                beneficiario,
//                dentista
//        );
//
//        this.adicionar(novoAtendimento);
//    }
//}
