package RaizDoBem.model.bo;

import RaizDoBem.model.dao.BeneficiarioDAO;
import RaizDoBem.model.dao.PedidoAjudaDAO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.model.vo.PedidoAjuda;

import java.util.List;

public class BeneficiarioBO {
    BeneficiarioDAO dao = new BeneficiarioDAO();

    public void adicionar(int idPedido, int idProgramaSocial) {
        PedidoAjudaDAO pedidoDAO = new PedidoAjudaDAO();

        PedidoAjuda pedido = pedidoDAO.buscarPorId(idPedido);

        if(pedido == null){
            throw new RuntimeException("Pedido de ajuda inválido!!!");
        }

        Beneficiario beneficiario = new Beneficiario();

        beneficiario.setCpf(pedido.getCpf());
        beneficiario.setNomeCompleto(pedido.getNomeCompleto());
        beneficiario.setDataNascimento(pedido.getDataNascimento());
        beneficiario.setTelefone(pedido.getTelefone());
        beneficiario.setEmail(pedido.getEmail());
        beneficiario.setIdPedidoAjuda(idPedido);
        beneficiario.setIdEndereco(pedido.getIdEndereco());
        beneficiario.setIdProgramaSocial(idProgramaSocial);

        dao.adicionar(beneficiario);
    }

    public Beneficiario buscaPorCpf(String cpf) {
        return dao.buscarPorCpf(cpf);
    }

    public List<Beneficiario> listarBeneficiarios() {
        return dao.listarTodos();
    }

    public List<Beneficiario> listagemPorCidade(String cidade) {
        return dao.listarPorCidade(cidade);
    }

    public List<Beneficiario> listagemPorPrograma(int idPrograma) {
        return dao.buscarPorPrograma(idPrograma);
    }

    public void atualizarBeneficiario(String cpf, Beneficiario beneficiarioAtualizado) {
        Beneficiario beneficiario = dao.buscarPorCpf(cpf);

        if (beneficiario != null) {
            dao.atualizar(cpf, beneficiarioAtualizado);
        }
        throw new RuntimeException("Beneficiário não encontrado!!!");
    }

    public void excluirBeneficiario(String cpf) {
        Beneficiario beneficiario = dao.buscarPorCpf(cpf);
        if (beneficiario != null) {
            dao.excluir(cpf);
        } else {
            throw new RuntimeException("Beneficiário não encontrado!!!");
        }
    }

    public Boolean validarCpf(String cpf) {
        return (cpf != null && cpf.length() == 11);
    }
}
