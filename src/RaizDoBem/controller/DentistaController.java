package RaizDoBem.controller;

import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;

import java.util.List;

public class DentistaController {
    private final DentistaDAO dentistaDAO;

    public DentistaController() {
        this.dentistaDAO = new DentistaDAO();
    }

    public void criarDentista(Dentista dentista){
        if(dentista != null){
            dentistaDAO.adicionar(dentista);
            System.out.println("Endereço criado e adicionado!");
        }
        else{
            System.out.println("Endereço inválido!!!");
        }
    }

    public List<Dentista> listarTodos(){
        return dentistaDAO.listarTodos();
    }

    public Dentista buscaPorCpf(String cpf){
        return dentistaDAO.buscarPorCpf(cpf);
    }
}
