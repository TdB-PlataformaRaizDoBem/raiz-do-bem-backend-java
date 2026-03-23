package RaizDoBem.controller;

import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;

import java.util.List;

/**
 * Classe de controle para os dentistas que prestarão serviço a ONG. Esta classe é responsável por gerenciar as operações relacionadas aos dentistas, como criar, buscar e listar dentistas. Ela atua como uma camada intermediária entre a interface do usuário e a camada de acesso a dados (DAO), garantindo que as regras de negócio sejam aplicadas corretamente.
 * @author Paulo
 * @since 2026-03
 */
public class DentistaController {
    private final DentistaDAO dentistaDAO;
    Dentista dentistaEncontrado = new Dentista();

    public DentistaController() {
        this.dentistaDAO = new DentistaDAO();
    }

    public Dentista buscaPorCpf(String cpf){
        return dentistaDAO.buscarPorCpf(cpf);
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

    public List<Dentista> listarDisponiveis(){
        return dentistaDAO.listarDisponiveis();
    }

    public List<Dentista> listagemPorCidade(String cidade){
        return dentistaDAO.listarPorCidade(cidade);
    }

    public void atualizarDentista(String cpf, Dentista dentistaAtualizado){
        dentistaEncontrado = dentistaDAO.buscarPorCpf(cpf);

        if(dentistaEncontrado == null){
            System.out.println("Dentista não encontrado!!!");
            return;
        }
        dentistaDAO.atualizar(cpf, dentistaAtualizado);
    }

    public void excluirDentista(String cpf){
        dentistaEncontrado = dentistaDAO.buscarPorCpf(cpf);

        if(dentistaEncontrado == null){
            System.out.println("Dentista não encontrado!!!");
            return;
        }
        dentistaDAO.excluir(cpf);
    }
}
