package RaizDoBem;

import RaizDoBem.DAO.EnderecoDAO;
import RaizDoBem.Model.*;
import RaizDoBem.View.Menu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
//import RaizDoBem.View.Menu;


public class Main {
    public static void main(String[] args) {
        //Criação de coordenador e login demonstrativo apenas:
//        Coordenador c1 = new Coordenador(1,"123.374", "643.934", "Hugo Costa", LocalDate.of(1994,9, 18), "hugo@email.com", "****",
//                1, LocalDate.of(2020, 9, 12), "Administrador");
//        c1.login();
//
//        //Criando os dois tipos de beneficiário do sistema.
//        TipoBeneficiario tipoBeneficiario1 = new TipoBeneficiario(1, "Dentista do Bem");
//        TipoBeneficiario tipoBeneficiario2 = new TipoBeneficiario(2, "Apolônias do Bem");
//
//        //Criando os dois tipos de endereço do sistema.
//        TipoEndereco tipoEndereco1 = new TipoEndereco(1, "Residencial");
//        TipoEndereco tipoEndereco2 = new TipoEndereco(2, "Profisssional");
//
//        //Testando classes que gerenciam pedidos de ajuda.
//        GerenciaPedido gerenciarPedido = new GerenciaPedido();
//        PedidoAjuda pa1 = new PedidoAjuda(1, "Paciente com 16 anos, precisando de tratamento com dente quebrado e cáries.", LocalDate.now(), "Grave", "Primeiro pedido, esperando avaliação.");
//        gerenciarPedido.adicionar(pa1);
//
//        //Criando alguns endereços para poder verificar na listagem
//        Endereco e1 = new Endereco("Rua da Bela", "03921-000", "123", "São Paulo", "São Paulo",tipoEndereco1);
//        Endereco e2 = new Endereco("Rua Horange Fito", "03341-233", "2222", "Rio de Janeiro", "Rio de Janeiro",tipoEndereco2);
//        Endereco e3 = new Endereco("Rua dos Números", "28313-233", "156", "Belo Horizonte", "Minas Gerais",tipoEndereco1);
//        GerenciaEndereco gerenciarEndereco = new GerenciaEndereco();
//        gerenciarEndereco.adicionar(e1);
//        gerenciarEndereco.adicionar(e2);
//        gerenciarEndereco.adicionar(e3);
//
//        //Criando alguns beneficiários e deixando salvos.
//        GerenciaBeneficiarios gerenciarBeneficiarios = new GerenciaBeneficiarios(gerenciarEndereco);
//        Beneficiario b1 = new Beneficiario(1,"123.122.444",
//                "Paulo Cavalcante", LocalDate.of(2010, 7,18), "Masculino", tipoBeneficiario1, e1);
//        Beneficiario b2 = new Beneficiario(2,"235.122.244",
//                "Maria Kandida", LocalDate.of(2001, 5,10), "Feminino", tipoBeneficiario2, e1);
//        gerenciarBeneficiarios.adicionar(b1);
//        gerenciarBeneficiarios.adicionar(b2);
//
//        //Criando dentistas
//        Dentista d1 = new Dentista(2, "123.321", "Claudionor Costa",
//                LocalDate.of(2000, 7,22),"Claudionor@email.com", "****", 1, "48385-34", "Ortodontia", true, "Coordenador", e3, e2);
//        Dentista d2 = new Dentista(3, "344.787", "Juliana Sousa",
//                LocalDate.of(2000, 7,22),"juliana@email.com", "****", 2, "48385-34", "Implante", true, "Dentista Simples",e1, e2);
//        GerenciaDentistas gerenciarDentistas = new GerenciaDentistas(gerenciarEndereco);
//        gerenciarDentistas.adicionar(d1);
//        gerenciarDentistas.adicionar(d2);
//
//        //Adicionando um atendimento inicial.
//        GerenciaAtendimentos gerenciarAtendimentos = new GerenciaAtendimentos(gerenciarBeneficiarios, gerenciarDentistas);
//        Atendimento a1 = new Atendimento(1, "Atendimento a moça com dentes quebrados, 24 anos de idade e sem condições financeiras.", LocalDate.now(),b2, d2);
//        gerenciarAtendimentos.adicionar(a1);
//
//        Menu menu = new Menu(
//                gerenciarPedido,
//                gerenciarEndereco,
//                gerenciarBeneficiarios,
//                gerenciarDentistas,
//                gerenciarAtendimentos
//        );
//        menu.exibirMenuInicial();
       // Connection conexao = Conexao.conectarAoBanco();
        TipoEndereco tipoEndereco1 = new TipoEndereco(1, "Residencial");
        TipoEndereco tipoEndereco2 = new TipoEndereco(2, "Profissional");
        Endereco end1 = new Endereco("Rua João Távora", "03978020", "231", "São Paulo", "São Paulo",1);
         Endereco end2 = new Endereco("Avenida Paulista", "01310946", "1200", "São Paulo", "São Paulo", 2);
//         Endereco end3 = new Endereco("Avenida dos Estados", "09290520", "93", "Santo André", "São Paulo");

        EnderecoDAO enderecoDAO = new EnderecoDAO();

//        enderecoDAO.listarPorId(2);
//        enderecoDAO.listarPorCidade("São Paulo");
//      //  enderecoDAO.adicionar(end2);
        //enderecoDAO.adicionar(end1);
//        enderecoDAO.adicionar(end2);
//        enderecoDAO.adicionar(end3);
        enderecoDAO.listarTodos();
        enderecoDAO.excluirEndereco(21);
        enderecoDAO.listarTodos();

//        Dentista dentista = new Dentista();
//        dentista.setId(10L);
//        dentista.setNomeCompleto("Paulo Cavalcante");
//        dentista.setCro("SP-123456");


//        Menu menu = new Menu();
//        menu.exibirMenuInicial();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//
//        String endereco = gson.toJson(end1);
//        System.out.println(endereco);
  //      enderecoDAO.adicionar(end1);
    }
}
