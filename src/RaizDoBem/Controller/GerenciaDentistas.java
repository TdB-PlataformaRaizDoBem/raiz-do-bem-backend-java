//package RaizDoBem.Controller;
//
//import RaizDoBem.Model.Dentista;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class GerenciaDentistas implements Gerenciador<Dentista>{
//    private List<Dentista> dentistas = new ArrayList<>();
//
//    public GerenciaDentistas() {
//    }
//
//    public void alterarStatus(int idDentista) {
//        System.out.println("--- Alterar disponibilidade de dentista: ---");
//    }
//
//    @Override
//    public void adicionar(Dentista dentista) {
//        dentistas.add(dentista);
//        System.out.println("Novo dentista foi adicionado.");
//    }
//
//    @Override
//    public List<Dentista> listarTodos() {
//        System.out.println("----- Listando dentistas: -----");
//        String status;
//        for (Dentista dentista: dentistas) {
//            System.out.println("-----------------------------------------");
//            System.out.println("CRO-Dentista: " + dentista.getCroDentista());
//            System.out.println("Especialidade: " + dentista.getEspecialidade());
//            if (dentista.isDisponivel()){
//                status = "Disponível";
//            }
//            else{
//                status = "Não disponível";
//            }
//            System.out.println("Disponibilidade do dentista: " + status);
//            System.out.println("Nível do dentista: " + dentista.getNivelDentista());
//
//            System.out.println("\nEndereço residencial do Dentista: ");
//            System.out.println(dentista.getEndereco().getLogradouro() + ", " + dentista.getEndereco().getNumero());
//            System.out.println("CEP: " + dentista.getEndereco().getCep());
//            System.out.println(dentista.getEndereco().getCidade() + " - " + dentista.getEndereco().getEstado());
//
//            System.out.println("\nEndereço profissional do Dentista: ");
//            System.out.println(dentista.getEndProfissional().getLogradouro() + ", " + dentista.getEndProfissional().getNumero());
//            System.out.println("CEP: " + dentista.getEndProfissional().getCep());
//            System.out.println(dentista.getEndProfissional().getCidade() + " - " + dentista.getEndProfissional().getEstado());
//        }
//        return dentistas;
//    }
//
//    @Override
//    public void receberSalvarDados() {
//        throw new UnsupportedOperationException("Fluxo legado desativado. Use a camada DAO/Service.");
//    }
//
//    public Dentista buscarPeloId(int idDentista) {
//        for (Dentista dentista : dentistas) {
//            if (dentista.getIdDentista() == idDentista) {
//                return dentista;
//            }
//        }
//        System.out.println("Dentista não encontrado");
//        return null;
//    }
//}
