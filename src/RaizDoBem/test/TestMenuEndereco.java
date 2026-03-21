package RaizDoBem.test;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.view.EnderecoInput;

public class TestMenuEndereco {
    public static void main(String[] args) {
        Endereco end1 = new Endereco("Rua João Távora", "03978020", "220", "Jardim Adutora", "São Paulo", "São Paulo",1);
        Endereco end2 = new Endereco("Avenida Paulista", "01310946", "1200","Jardim Paulista", "São Paulo", "São Paulo", 2);
        Endereco end3 = new Endereco("Avenida dos Estados", "09290520", "93"," Jd Santo André", "Santo André", "São Paulo", 1);
        EnderecoController controller = new EnderecoController();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        EnderecoInput input = new EnderecoInput();

        String cep = "03978020";
        //System.out.println(controller.buscarInformacoesEndereco(cep));
    }
}
