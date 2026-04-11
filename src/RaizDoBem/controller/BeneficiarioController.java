package RaizDoBem.controller;

import RaizDoBem.model.bo.BeneficiarioBO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.model.vo.Validacao;
import RaizDoBem.view.BeneficiarioView;

import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de BeneficiarioController entre View e BO.
 * Camada: Controller.
 */
public class BeneficiarioController {
    private final BeneficiarioView view;
    private final BeneficiarioBO bo;

    public BeneficiarioController(BeneficiarioView view) {
        this.view = view;
        this.bo = new BeneficiarioBO();
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     */
    public void criar() {
        try{
            view.mostrar("\nCriando beneficiário: ");
            int idPedido = view.inputId();
            int idProgramaSocial = view.inputPrograma();

            bo.adicionar(idPedido, idProgramaSocial);
            view.mostrar("\nBeneficiário criado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     */
    public void listandoTodos(){
        List<Beneficiario> beneficiarios = bo.listarBeneficiarios();
        if (beneficiarios.isEmpty())
            view.mostrar("\nNenhum beneficiário encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os beneficiários: ");
            view.listarTodos(beneficiarios);
        }
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     */
    public void buscarPorCpf(String cpf) {
        Beneficiario beneficiario = bo.buscaPorCpf(cpf);
        if (beneficiario != null) {
            view.mostrar("\nBeneficiário encontrado: ");
            view.exibirBeneficiario(beneficiario);
        } else
            view.mostrar("\nNenhum beneficiário encontrado!!!");
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param id parametro da operacao.
     */
    public void listarPorPrograma(int id) {
        List<Beneficiario> beneficiarios = bo.listagemPorPrograma(id);
        if (beneficiarios.isEmpty())
            view.mostrar("\nNenhum beneficiário encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os beneficiários do programa social: ");
            view.listarTodos(beneficiarios);
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param cidade parametro da operacao.
     */
    public void listarPorCidade(String cidade) {
        List<Beneficiario> beneficiarios = bo.listagemPorCidade(cidade);
        if (beneficiarios.isEmpty())
            view.mostrar("\nNenhum beneficiário encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os beneficiários da cidade " + cidade + ": ");
            view.listarTodos(beneficiarios);
        }
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     */
    public void atualizar(String cpf) {
        try {
            view.mostrar("Atualizando beneficiário: ");
            if (Validacao.validarCpf(cpf)) {
                String telefone = view.inputTelefone();
                String email = view.inputEmail();
                int idEndereco = view.inputIdEndereco();

                Beneficiario beneficiarioAtualizado = bo.validarNovoBeneficiario(telefone, email, idEndereco);

                bo.atualizarBeneficiario(cpf, beneficiarioAtualizado);
                view.mostrar("\nBeneficiário atualizado com sucesso!!!");
            }
        } catch (RuntimeException e) {
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
                bo.excluirBeneficiario(cpf);
                view.mostrar("\nBeneficiário excluído com sucesso!!!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
