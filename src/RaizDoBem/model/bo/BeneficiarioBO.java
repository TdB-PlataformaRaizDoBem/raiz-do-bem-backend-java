package RaizDoBem.model.bo;

import RaizDoBem.model.dao.BeneficiarioDAO;
import RaizDoBem.model.dao.PedidoAjudaDAO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.model.vo.PedidoAjuda;
import RaizDoBem.model.vo.StatusPedido;

import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de BeneficiarioBO.
 * Camada: BO.
 */
public class BeneficiarioBO {
    private final BeneficiarioDAO dao = new BeneficiarioDAO();

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param idPedido parametro da operacao.
     * @param idProgramaSocial parametro da operacao.
     */
    public void adicionar(int idPedido, int idProgramaSocial) {
        PedidoAjudaDAO pedidoDAO = new PedidoAjudaDAO();
        PedidoAjuda pedido = pedidoDAO.buscarPorId(idPedido);

        if (pedido == null)
            throw new RuntimeException("Pedido de ajuda inválido!!!");

        if(validarAprovacaoPedido(pedido)){
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
        else
            throw new RuntimeException("Impossível criar beneficiário, pedido de ajuda não aprovado!!!");
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Beneficiario buscaPorCpf(String cpf) {
        return dao.buscarPorCpf(cpf);
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Beneficiario> listarBeneficiarios() {
        return dao.listarTodos();
    }

    /**
     * Aplica regra de negocio e validacoes para esta operacao.
     * @param cidade parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Beneficiario> listagemPorCidade(String cidade) {
        return dao.listarPorCidade(cidade);
    }

    /**
     * Aplica regra de negocio e validacoes para esta operacao.
     * @param idPrograma parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Beneficiario> listagemPorPrograma(int idPrograma) {
        return dao.buscarPorPrograma(idPrograma);
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     * @param beneficiarioAtualizado parametro da operacao.
     */
    public void atualizarBeneficiario(String cpf, Beneficiario beneficiarioAtualizado) {
        Beneficiario beneficiario = dao.buscarPorCpf(cpf);

        if (beneficiario == null)
            throw new RuntimeException("Beneficiário não encontrado!!!");
        else
            dao.atualizar(cpf, beneficiarioAtualizado);
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluirBeneficiario(String cpf) {
        Beneficiario beneficiario = dao.buscarPorCpf(cpf);
        if (beneficiario != null)
            dao.excluir(cpf);
        else
            throw new RuntimeException("Beneficiário não encontrado!!!");
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param telefone parametro da operacao.
     * @param email parametro da operacao.
     * @param idEndereco parametro da operacao.
     * @return resultado da operacao.
     */
    public Beneficiario validarNovoBeneficiario(String telefone, String email, int idEndereco) {
        if (telefone.isEmpty()) {
            throw new RuntimeException("Telefone inválido!!!");
        }
        if (email.isEmpty()) {
            throw new RuntimeException("Email inválido!!!");
        }
        if (idEndereco <= 0) {
            throw new RuntimeException("ID de endereço inválido!!!");
        }

        return new Beneficiario()
                .setTelefone(telefone)
                .setEmail(email)
                .setIdEndereco(idEndereco);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param pedido parametro da operacao.
     * @return resultado da operacao.
     */
    public boolean validarAprovacaoPedido(PedidoAjuda pedido){
        return StatusPedido.APROVADO.equals(pedido.getStatus());
    }
}
