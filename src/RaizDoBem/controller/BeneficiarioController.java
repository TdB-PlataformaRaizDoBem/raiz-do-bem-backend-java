package RaizDoBem.controller;

import RaizDoBem.model.bo.BeneficiarioBO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.view.BeneficiarioView;

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
        try{
            int idPedido = view.inputId();
            int idProgramaSocial = view.inputPrograma();

            bo.adicionar(idPedido, idProgramaSocial);
            view.exibirMensagem("Beneficiário criado com sucesso!!!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
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

    public void atualizar(String cpf) {
        try {
            String telefone = view.inputTelefone();
            String email = view.inputEmail();
            int idEndereco = view.inputIdEndereco();

            Beneficiario beneficiarioAtualizado = bo.validarNovoBeneficiario(telefone, email, idEndereco);

            bo.atualizarBeneficiario(cpf, beneficiarioAtualizado);
            view.exibirMensagem("Beneficiário atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void excluir(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            view.exibirMensagem("Cpf inválido!!!");
        } else {
            bo.excluirBeneficiario(cpf);
            view.exibirMensagem("Beneficiário excluído com sucesso!!!");
        }
    }
}
