package RaizDoBem.controller;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.Endereco;

import java.util.List;

/**
 * Classe de controle para os atendimentos realizados pela ONG. Esta classe é responsável por gerenciar as operações relacionadas aos atendimentos, como criar, buscar e listar atendimentos. Ela atua como uma camada intermediária entre a interface do usuário e a camada de acesso a dados (DAO), garantindo que as regras de negócio sejam aplicadas corretamente.
 * @author Paulo
 * @since 2026-03
 */
public class AtendimentoController {
    private AtendimentoView view;
    private AtendimentoBO bo;

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
