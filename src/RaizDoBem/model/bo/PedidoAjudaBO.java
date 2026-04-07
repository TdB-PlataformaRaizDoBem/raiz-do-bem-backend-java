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

    public void atualizar(int id, PedidoAjuda novoPedido){
        PedidoAjuda pedidoAjuda = dao.buscarPorId(id);

        if(pedidoAjuda == null){
            throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.atualizarPedido(id, novoPedido);
    }

    public void atualizarGerarBeneficiario(int id, PedidoAjuda novoPedido, int idPrograma){
        PedidoAjuda pedidoAjuda = dao.buscarPorId(id);

        if(pedidoAjuda == null){
            throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.atualizarPedido(id, novoPedido);

        BeneficiarioBO bo = new BeneficiarioBO();
        bo.adicionar(pedidoAjuda.getIdPedido(), idPrograma);
    }

    public void excluir(int id){
        PedidoAjuda pedidoAjuda = dao.buscarPorId(id);

        if(pedidoAjuda == null){
           throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.excluirPedido(id);
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

    public StatusPedido validarStatus(int status) {
        return switch (status) {
            case 1 -> StatusPedido.APROVADO;
            case 2 -> StatusPedido.REJEITADO;
            default -> throw new RuntimeException("Status inválido!!!");
        };
    }

    public PedidoAjuda validarNovoPedido(StatusPedido status, int idDentista) {
        if (status == null) {
            throw new RuntimeException("Status inválido!!!");
        }

        if (idDentista <= 0) {
            throw new RuntimeException("ID do dentista obrigatório para atualização do pedido!!!");
        }

        return new PedidoAjuda()
                .setStatus(status)
                .setIdDentista(idDentista);
    }

    public Boolean validarCpf(String cpf) {
        return (cpf != null && cpf.length() == 11);
    }
}
