package RaizDoBem.controller;

import RaizDoBem.model.bo.DentistaBO;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.view.DentistaView;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe de controle para os dentistas que prestarão serviço a ONG. Esta classe
 * é responsável por gerenciar as operações relacionadas aos dentistas, como
 * criar, buscar e listar dentistas. Ela atua como uma camada intermediária
 * entre a interface do usuário e a camada de acesso a dados (DAO), garantindo
 * que as regras de negócio sejam aplicadas corretamente.
 * 
 * @author Paulo
 * @since 2026-03
 */
public class DentistaController {
    private DentistaView view;
    private DentistaBO bo;

    public DentistaController(DentistaView view) {
        this.view = view;
        this.bo = new DentistaBO();
    }

    public void criar() {
//        String cpf = view.inputCpf();
//        String nome = view.inputNome();
//        LocalDate dataNascimento = view.inputDataNasc();
//        LocalDate dataContratacao = view.inputDataContratacao();
//        String email = view.inputEmail();
//
//
//        bo.criarDentista(dentista);
        view.exibirMensagem("Dentista criado com sucesso!!!");
    }


    public void listandoTodos() {
        List<Dentista> dentistas = bo.listarTodos();
        if (dentistas.isEmpty())
            view.exibirMensagem("Nenhum dentista encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os dentistas: ");
            view.exibirLista(dentistas);
        }
    }

}
