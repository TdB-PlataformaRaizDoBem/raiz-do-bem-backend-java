package RaizDoBem.controller;

import RaizDoBem.model.bo.AtendimentoBO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.view.AtendimentoView;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de AtendimentoController entre View e BO.
 * Camada: Controller.
 */
public class AtendimentoController {
    private final AtendimentoView view;
    private final AtendimentoBO bo;

    public AtendimentoController(AtendimentoView view) {
        this.view = view;
        this.bo = new AtendimentoBO();
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     */
    public void adicionar(){
        try {
            view.mostrar("\nCriando atendimento: ");
            String prontuario = view.inputProntuario();

            int idBeneficiario = view.inputBeneficiario();
            int idDentista = view.inputDentista();

            Atendimento atendimento = bo.validarAtendimento(prontuario, idBeneficiario, idDentista);
            bo.criar(atendimento);

            view.mostrar("\nAtendimento criado com sucesso!!!");
        } catch (Exception e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     */
    public void listandoTodos() {
        List<Atendimento> atendimentos = bo.listarTodos();
        if (atendimentos.isEmpty())
            view.mostrar("\nNenhum atendimento encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os atendimentos: ");
            view.listarTodos(atendimentos);
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param cpf parametro da operacao.
     */
    public void listarPorCpf(String cpf) {
        Atendimento atendimento = bo.buscaPorCpf(cpf);
        if (atendimento != null) {
            view.mostrar("\nAtendimento encontrado: ");
            view.exibirAtendimento(atendimento);
        }
        else{
            view.mostrar("\nNenhum atendimento encontrado!!!");
            }
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param idAtendimento parametro da operacao.
     */
    public void atualizar(int idAtendimento){
        try{
            String prontuario = view.inputProntuario();
            int idColaborador = view.inputColaborador();

            Atendimento atendimento = bo.validarAtualizacao(prontuario, idColaborador);
            atendimento.setDataFinal(LocalDate.now());

            bo.atualizar(idAtendimento, atendimento);
            view.mostrar("\nAtendimento atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param id parametro da operacao.
     */
    public void excluir(int id) {
        try{
            if(id<=0 || bo.buscaPorId(id) == null)
                view.mostrar("\nID inválido!!!");
            else{
                bo.excluir(id);
                view.mostrar("\nAtendimento " + id + " excluído com sucesso!!!");
            }
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }

    }
}
