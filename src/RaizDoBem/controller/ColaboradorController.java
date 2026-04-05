package RaizDoBem.controller;

import RaizDoBem.model.bo.ColaboradorBO;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.PedidoAjuda;
import RaizDoBem.view.ColaboradorView;

import java.time.LocalDate;
import java.util.List;

public class ColaboradorController {
    private ColaboradorView view;
    private ColaboradorBO bo;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        this.bo = new ColaboradorBO();
    }

    public ColaboradorController() {
    }

    public void criar() {
        try{
            String cpf = view.inputCpf();
            String nome = view.inputNome();
            LocalDate dataNascimento = view.inputDataNasc();
            LocalDate dataContratacao = view.inputDataContratacao();
            String email = view.inputEmail();

            Colaborador colaborador = bo.validarColaborador(cpf, nome, dataNascimento, dataContratacao, email);

            bo.criar(colaborador);
            view.exibirMensagem("Colaborador criado com sucesso!!!");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void listandoTodos() {
        List<Colaborador> colaboradores = bo.listarTodos();
        if (colaboradores.isEmpty())
            view.exibirMensagem("Nenhum colaborador encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os colaboradores: ");
            view.exibirLista(colaboradores);
        }
    }


    public void buscarPorCpf(String cpf) {
        Colaborador colaborador = bo.buscarPeloCpf(cpf);
        if (colaborador != null) {
            view.exibirMensagem("Colaborador encontrado: ");
            view.exibir(colaborador);
        } else {
            view.exibirMensagem("Nenhum colaborador encontrado!!!");
        }
    }

    public void atualizar(String cpf) {
        try{
            Colaborador novoColaborador;

            String email = view.inputEmail();

            novoColaborador = bo.validarNovoColaborador(email);

            bo.atualizar(cpf, novoColaborador);
            view.exibirMensagem("Colaborador foi atualizado com sucesso!");
        } catch (Exception e) {
            view.exibirMensagem(e.getMessage());
        }

    }

    public void excluir(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            view.exibirMensagem("Cpf inválido!!!");
        } else {
            bo.excluir(cpf);
            view.exibirMensagem("Colaborador excluído com sucesso!!!");
        }
    }

}
