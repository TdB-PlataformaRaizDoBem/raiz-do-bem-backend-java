package RaizDoBem.controller;

import RaizDoBem.model.bo.AtendimentoBO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.view.AtendimentoView;

import java.util.List;


/**
 * Classe de controle para os atendimentos realizados pela ONG. Esta classe é responsável por gerenciar as operações relacionadas aos atendimentos, como criar, buscar e listar atendimentos. Ela atua como uma camada intermediária entre a interface do usuário e a camada de acesso a dados (DAO), garantindo que as regras de negócio sejam aplicadas corretamente.
 * @author Paulo
 * @since 2026-03
 */
public class AtendimentoController {
    private AtendimentoView view;
    private AtendimentoBO bo;

    public AtendimentoController(AtendimentoView view) {
        this.view = view;
        this.bo = new AtendimentoBO();
    }

    public void adicionar(){
        try {
            //String cep = view.entradaCep();

            Atendimento atendimento = new Atendimento();
            bo.criar(atendimento);

            view.exibirMensagem("Atendimento criado com sucesso!!!");
            view.exibirAtendimento(atendimento);
        } catch (Exception e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void listandoTodos() {
        List<Atendimento> atendimentos = bo.listarTodos();
        if (atendimentos.isEmpty())
            view.exibirMensagem("Nenhum atendimento encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os atendimentos: ");
            view.exibirLista(atendimentos);
        }
    }

    public void listarPorCpf(String cpf) {
        Atendimento atendimento = bo.buscaPorCpf(cpf);
        if (atendimento != null) {
            view.exibirMensagem("Atendimento encontrado: ");
            view.exibirAtendimento(atendimento);
        }
        else{
            view.exibirMensagem("Nenhum atendimento encontrado!!!");
            }
    }

}
