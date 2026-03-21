package RaizDoBem.Test;

import RaizDoBem.Model.DAO.EnderecoDAO;
import RaizDoBem.Model.Endereco;

public class TestMenuEndereco {
    Endereco end1 = new Endereco("Rua João Távora", "03978020", "231", "Jardim Adutora", "São Paulo", "São Paulo",1);
    Endereco end2 = new Endereco("Avenida Paulista", "01310946", "1200","Jardim Paulista", "São Paulo", "São Paulo", 2);
//         Endereco end3 = new Endereco("Avenida dos Estados", "09290520", "93", "Santo André", "São Paulo");

    EnderecoDAO enderecoDAO = new EnderecoDAO();

//        enderecoDAO.buscarPorId(2);
//        enderecoDAO.listarPorCidade("São Paulo");
//      //  enderecoDAO.adicionar(end2);
    //enderecoDAO.adicionar(end1);
//        enderecoDAO.adicionar(end2);
//        enderecoDAO.adicionar(end3);
//        enderecoDAO.listarTodos();
//        enderecoDAO.excluirEndereco(21);
//        enderecoDAO.listarTodos();
}
