package RaizDoBem.controller;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Endereco;

import java.util.List;

public class AtendimentoController {
    private final AtendimentoDAO atendimentoDAO;

    public AtendimentoController() {
        this.atendimentoDAO = new AtendimentoDAO();
    }
    public void criarAtendimento(Atendimento atendimento){
        if(atendimento != null){
            atendimentoDAO.adicionar(atendimento);
            System.out.println("Atendimento criado e adicionado!");
        }
        else{
            System.out.println("Atendimento inválido!!!");
        }
    }
    public Atendimento buscaPorCpf(String cpf){
        return atendimentoDAO.buscarPorCpf(cpf);
    }
    public List<Atendimento> listarTodosAtendimentos(){
        return atendimentoDAO.listarTodos();
    }
 }
