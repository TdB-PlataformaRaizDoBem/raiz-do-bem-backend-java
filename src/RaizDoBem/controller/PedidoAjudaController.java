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
        Validacao validacao = new Validacao();
        try{
            String cpf;
            do{
                cpf = view.inputCpf();
            } while(!validacao.validarCpf(cpf));

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
        } catch (RuntimeException e){
            view.mostrar(e.getMessage());
        }
    }

    public void listandoTodos() {
        List<PedidoAjuda> pedidos = bo.listarTodos();
        if (pedidos.isEmpty())
            view.mostrar("\nNenhum pedido encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os pedidos de ajuda: ");
            view.listarTodos(pedidos);
        }
    }

    public void listarPorCpf(String cpf) {
        PedidoAjuda pedido = bo.buscaCpf(cpf);
        if (pedido != null) {
            view.mostrar("\nPedido encontrado: ");
            view.exibirPedido(pedido);
        } else
            view.mostrar("\nNenhum pedido encontrado!!!");
    }

    public void buscarPeloId(int id) {
        PedidoAjuda pedido = bo.buscaId(id);
        if (pedido != null) {
            view.mostrar("\nPedido encontrado: ");
            view.exibirPedido(pedido);
        } else
            view.mostrar("\nNenhum pedido encontrado!!!");
    }

    public void listarPelaData(LocalDate data) {
        List<PedidoAjuda> pedidos = bo.listarPorData(data);
        if (pedidos.isEmpty())
            view.mostrar("\nNenhum pedido encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os pedidos de ajuda encontrados na data inserida: ");
            view.listarTodos(pedidos);
        }
    }

    public void atualizar(int id) {
        try {
            int idStatus = view.inputStatus();
            StatusPedido status = bo.validarStatus(idStatus);
            int idDentista = view.inputIdDentista();

            PedidoAjuda pedido = bo.validarNovoPedido(status, idDentista);

            if(StatusPedido.APROVADO.equals(status)){
                int idPrograma = view.inputPrograma();
                bo.atualizarGerarBeneficiario(id, pedido, idPrograma);
            }
            else{
                bo.atualizar(id, pedido);
            }
            view.mostrar("\nPedido atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    public void deletar(int id) {
        if (id == 0)
            view.mostrar("ID inválido!!!");
        else {
            bo.excluir(id);
            view.mostrar("Pedido de ajuda excluído com sucesso!!!");
        }
    }
}
