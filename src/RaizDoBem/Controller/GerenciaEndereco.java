//package RaizDoBem.Controller;
//
//import RaizDoBem.Model.Endereco;
//import RaizDoBem.Model.TipoEndereco;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class GerenciaEndereco implements Gerenciador<Endereco> {
//    private List<Endereco> enderecos = new ArrayList<>();
//    private int proximoId = 1;
//
//    public int getProximoId() {
//        return proximoId;
//    }
//
//    @Override
//    public void adicionar(Endereco endereco) {
//        endereco.setIdEndereco(proximoId++);
//        enderecos.add(endereco);
//        System.out.println("Endereço criado!");
//    }
//
//    @Override
//    public List<Endereco> listarTodos() {
//        System.out.println("----- Listando endereços cadastrados: -----");
//
//        for (Endereco endereco : enderecos) {
//            System.out.println("ID Endereço: " + endereco.getIdEndereco());
//            System.out.println("Logradouro: " + endereco.getLogradouro());
//            System.out.println("CEP: " + endereco.getCep());
//            System.out.println("Número: " + endereco.getNumero());
//            System.out.println("Cidade: " + endereco.getCidade());
//            System.out.println("Estado: " + endereco.getEstado());
//            System.out.println("Tipo de endereço: " + endereco.getTipoEndereco());
//            System.out.println("-----------------------------------------");
//        }
//        return enderecos;
//    }
//
////    @Override
////    public void receberSalvarDados() {
////        Scanner sc = new Scanner(System.in);
////
////        System.out.println("----- Adicionar novo endereço: -----");
////
////        System.out.println("Logradouro: ");
////        String logradouro = sc.nextLine();
////
////        System.out.println("CEP: ");
////        String cep = sc.nextLine();
////
////        System.out.println("Número: ");
////        String numero = sc.nextLine();
////
////        System.out.println("Cidade: ");
////        String cidade = sc.nextLine();
////
////        System.out.println("Estado: ");
////        String estado = sc.nextLine();
////
////        int opc;
////        TipoEndereco tipoEndereco;
////        do {
////            System.out.println("Endereço residencial ou Profissional?");
////            System.out.println("1. Residencial");
////            System.out.println("2. Profissional");
////            opc = sc.nextInt();
////            sc.nextLine();
////            if (opc == 1) {
////                tipoEndereco = new TipoEndereco(1, "Residencial");
////            } else if (opc == 2) {
////                tipoEndereco = new TipoEndereco(2, "Profissional");
////            } else {
////                System.out.println("Opção Inválida!!!");
////                tipoEndereco = null;
////            }
////        } while (opc < 1 || opc > 2);
////
////
////        Endereco endereco = new Endereco(
////                idEndereco,
////                logradouro,
////                cep,
////                numero,
////                cidade,
////                estado
////        );
////        adicionar(endereco);
////    }
//
//    public Endereco buscarPeloId(int idEndereco) {
//        for (Endereco endereco : enderecos) {
//            if (endereco.getIdEndereco() == idEndereco) {
//                return endereco;
//            }
//        }
//        System.out.println("Endereço não encontrado");
//    return null;
//    }
//}
