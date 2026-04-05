package RaizDoBem.controller;

import RaizDoBem.model.bo.BeneficiarioBO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.view.BeneficiarioView;

import java.time.LocalDate;
import java.util.List;

/** * Classe de controle para os beneficiários da ONG. Esta classe é responsável por gerenciar as operações relacionadas aos beneficiários, como adicionar, buscar, listar, atualizar e excluir beneficiários. Ela atua como uma camada intermediária entre a interface do usuário e a camada de acesso a dados (DAO), garantindo que as regras de negócio sejam aplicadas corretamente.
 * @author Paulo
 * @since 2026-03
 */
public class BeneficiarioController {
    private BeneficiarioView view;
    private BeneficiarioBO bo;

    public BeneficiarioController(BeneficiarioView view) {
        this.view = view;
        this.bo = new BeneficiarioBO();
    }

    public BeneficiarioController() {
    }

    public void criar() {

//        bo.adicionar(beneficiario);
        view.exibirMensagem("Beneficiário criado com sucesso!!!");

    }

    public void listandoTodos(){
        List<Beneficiario> beneficiarios = bo.listarBeneficiarios();
        if (beneficiarios.isEmpty())
            view.exibirMensagem("Nenhum beneficiário encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os beneficiários: ");
            view.exibirLista(beneficiarios);
        }
    }

    public void buscarPorCpf(String cpf) {
        Beneficiario beneficiario = bo.buscaPorCpf(cpf);
        if (beneficiario != null) {
            view.exibirMensagem("Beneficiário encontrado: ");
            view.exibirBeneficiario(beneficiario);
        } else {
            view.exibirMensagem("Nenhum beneficiário encontrado!!!");
        }
    }

    public void listarPorPrograma(int id) {
        List<Beneficiario> beneficiarios = bo.listagemPorPrograma(id);
        if (beneficiarios.isEmpty())
            view.exibirMensagem("Nenhum beneficiário encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os beneficiários do programa social: ");
            view.exibirLista(beneficiarios);
        }
    }

    public void listarPorCidade(String cidade) {
        List<Beneficiario> beneficiarios = bo.listagemPorCidade(cidade);
        if (beneficiarios.isEmpty())
            view.exibirMensagem("Nenhum beneficiário encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os beneficiários da cidade " + cidade + ": ");
            view.exibirLista(beneficiarios);
        }
    }

    public void excluir(String cpf) {
        if (cpf == null) {
            view.exibirMensagem("Cpf inválido!!!");
        } else {
            bo.excluirBeneficiario(cpf);
            view.exibirMensagem("Beneficiário excluído com sucesso!!!");
        }
    }
}
