package RaizDoBem.controller;

import RaizDoBem.model.bo.PedidoAjudaBO;
import RaizDoBem.model.vo.*;
import RaizDoBem.view.PedidoAjudaView;

import java.time.LocalDate;
import java.util.List;

public class PedidoAjudaController {
    private PedidoAjudaView view;
    private PedidoAjudaBO bo;

    public PedidoAjudaController(PedidoAjudaView view) {
        this.view = view;
        this.bo = new PedidoAjudaBO();
    }

    public PedidoAjudaController() {
    }

    public void adicionar() {
        String cpf;
        do{
            cpf = view.inputCpf();
        } while(!bo.validarCpf(cpf));

        String nome = view.inputNome();
        LocalDate dataNascimento = view.inputDataNasc();
        Sexo sexoSolicitante;
        int sexo = view.inputSexo();
        if (sexo == 1) {
            sexoSolicitante = Sexo.M;
        } else if (sexo == 2) {
            sexoSolicitante = Sexo.F;
        } else {
            sexoSolicitante = Sexo.O;
        }

        String telefone = view.inputTelefone();
        String email = view.inputEmail();
        String descricao = view.inputDescricao();
        int idEndereco = view.inputEndereco();

        PedidoAjuda pedido = bo.validarPedido(cpf, nome, dataNascimento, sexoSolicitante, telefone, email, descricao, idEndereco);

        bo.criar(pedido);
    }

    public void listandoTodos() {
        List<PedidoAjuda> pedidos = bo.listarTodos();
        if (pedidos.isEmpty())
            view.exibirMensagem("Nenhum pedido encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os pedidos de ajuda: ");
            view.exibirLista(pedidos);
        }
    }

    public void listarPorCpf(String cpf) {
        PedidoAjuda pedido = bo.buscaCpf(cpf);
        if (pedido != null) {
            view.exibirMensagem("Pedido encontrado: ");
            view.exibirPedido(pedido);
        } else {
            view.exibirMensagem("Nenhum pedido encontrado!!!");
        }
    }

    public void buscarPeloId(int id) {
        PedidoAjuda pedido = bo.buscaId(id);
        if (pedido != null) {
            view.exibirMensagem("Pedido encontrado: ");
            view.exibirPedido(pedido);
        } else {
            view.exibirMensagem("Nenhum pedido encontrado!!!");
        }
    }

    public void listarPelaData(LocalDate data) {
        List<PedidoAjuda> pedidos = bo.listarPorData(data);
        if (pedidos.isEmpty()) {
            view.exibirMensagem("Nenhum pedido encontrado!!!");
        } else {
            view.exibirMensagem("Exibindo todos os pedidos de ajuda encontrados na data inserida: ");
            view.exibirLista(pedidos);
        }
    }

    public void atualizar(String cpf) {
        try {
            int idStatus = view.inputStatus();
            StatusPedido status = bo.validarStatus(idStatus);
            int idDentista = view.inputIdDentista();


            PedidoAjuda pedido = bo.validarNovoPedido(status, idDentista);
            bo.atualizar(cpf, pedido);
            view.exibirMensagem("Pedido atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void deletar(String cpf) {
        if (cpf == null) {
            view.exibirMensagem("Cpf inválido!!!");
        } else {
            bo.excluir(cpf);
            view.exibirMensagem("Pedido de ajuda excluído com sucesso!!!");
        }
    }
}
