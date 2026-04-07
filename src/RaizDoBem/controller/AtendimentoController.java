package RaizDoBem.controller;

import RaizDoBem.model.bo.AtendimentoBO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.view.AtendimentoView;

import java.time.LocalDate;
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
            String descricao = view.inputDescricaoInicial();

            int idBeneficiario = view.inputBeneficiario();
            int idDentista = view.inputDentista();

            Atendimento atendimento = bo.validarAtendimento(descricao, idBeneficiario, idDentista);
            bo.criar(atendimento);

            view.exibirMensagem("Atendimento criado com sucesso!!!");
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
    public void atualizar(int idAtendimento){
        try{
            String solucao = view.inputSolucao();
            int idColaborador = view.inputColaborador();

            Atendimento atendimento = bo.validarAtualizacao(solucao, idColaborador);
            atendimento.setDataFinal(LocalDate.now());

            bo.atualizar(idAtendimento, atendimento);
            view.exibirMensagem("Atendimento atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.exibirMensagem(e.getMessage());
        }
    }
}
