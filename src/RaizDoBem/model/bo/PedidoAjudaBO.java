package RaizDoBem.model.bo;

import RaizDoBem.model.dao.PedidoAjudaDAO;
import RaizDoBem.model.vo.*;

import java.time.LocalDate;
import java.util.List;

public class PedidoAjudaBO {
    PedidoAjudaDAO dao = new PedidoAjudaDAO();

    public PedidoAjuda buscaCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }
    public PedidoAjuda buscaId(int id){
        return dao.buscarPorId(id);
    }

    public void criar(PedidoAjuda pedido){
        if(pedido != null){
            dao.adicionar(pedido);
        }
        else{
            throw new RuntimeException("Pedido inválido!!!");
        }
    }
    public List<PedidoAjuda> listarTodos(){
        return dao.listarTodos();
    }
    public List<PedidoAjuda> listarPorData(LocalDate data){
        return dao.listarPedidosData(data);
    }

    public void atualizar(String cpf, PedidoAjuda novoPedido){
        PedidoAjuda pedidoAjuda = dao.buscarPorCpf(cpf);

        if(pedidoAjuda == null){
            throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.atualizarPedido(cpf, novoPedido);
    }

    public void excluir(String cpf){
        PedidoAjuda pedidoAjuda = dao.buscarPorCpf(cpf);

        if(pedidoAjuda == null){
           throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.excluirPedido(cpf);
    }

    public PedidoAjuda validarPedido(String cpf, String nome, LocalDate dataNascimento, Sexo sexo, String telefone, String email, String descricao, int idEndereco){
        return new PedidoAjuda(
                cpf,
                nome,
                dataNascimento,
                sexo,
                telefone,
                email,
                descricao,
                idEndereco
        );
    }

    public Boolean validarCpf(String cpf) {
        return (cpf != null && cpf.length() == 11);
    }
}
