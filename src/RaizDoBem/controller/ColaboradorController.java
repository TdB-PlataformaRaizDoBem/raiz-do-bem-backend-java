package RaizDoBem.controller;

import RaizDoBem.model.bo.ColaboradorBO;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Validacao;
import RaizDoBem.view.ColaboradorView;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de ColaboradorController entre View e BO.
 * Camada: Controller.
 */
public class ColaboradorController {
    private final ColaboradorView view;
    private final ColaboradorBO bo;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        this.bo = new ColaboradorBO();
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     */
    public void criar() {
        try{
            view.mostrar("\nCriando colaborador: ");
            String cpf;
            do{
                cpf = view.inputCpf();
            } while(!Validacao.validarCpf(cpf));

            String nome = view.inputNome();
            LocalDate dataNascimento = view.inputDataNasc();
            LocalDate dataContratacao = view.inputDataContratacao();
            String email = view.inputEmail();

            Colaborador colaborador = bo.validarColaborador(cpf, nome, dataNascimento, dataContratacao, email);

            bo.criar(colaborador);
            view.mostrar("\nColaborador criado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     */
    public void listandoTodos() {
        List<Colaborador> colaboradores = bo.listarTodos();
        if (colaboradores.isEmpty())
            view.mostrar("\nNenhum colaborador encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os colaboradores: ");
            view.listarTodos(colaboradores);
        }
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     */
    public void buscarPorCpf(String cpf) {
        Colaborador colaborador = bo.buscarPeloCpf(cpf);
        if (colaborador != null) {
            view.mostrar("\nColaborador encontrado: ");
            view.exibirColaborador(colaborador);
        } else {
            view.mostrar("\nNenhum colaborador encontrado!!!");
        }
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     */
    public void atualizar(String cpf) {
        try{
            view.mostrar("\nAtualizando colaborador: ");
            Colaborador novoColaborador;
            String email = view.inputEmail();
            novoColaborador = bo.validarNovoColaborador(email);

            bo.atualizar(cpf, novoColaborador);
            view.mostrar("\nColaborador foi atualizado com sucesso!");
        } catch (Exception e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluir(String cpf) {
        try{
            if (!Validacao.validarCpf(cpf)) {
                view.mostrar("\nCpf inválido!!!");
            } else {
                bo.excluir(cpf);
                view.mostrar("\nColaborador excluído com sucesso!!!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
