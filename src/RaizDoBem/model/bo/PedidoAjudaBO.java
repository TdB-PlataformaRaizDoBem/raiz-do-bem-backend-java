package RaizDoBem.model.bo;

import RaizDoBem.model.dao.PedidoAjudaDAO;
import RaizDoBem.model.vo.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de PedidoAjudaBO.
 * Camada: BO.
 */
public class PedidoAjudaBO {
    private final PedidoAjudaDAO dao = new PedidoAjudaDAO();

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public PedidoAjuda buscaCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }
    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param id parametro da operacao.
     * @return resultado da operacao.
     */
    public PedidoAjuda buscaId(int id){
        return dao.buscarPorId(id);
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param pedido parametro da operacao.
     */
    public void criar(PedidoAjuda pedido){
        if(pedido != null)
            dao.adicionar(pedido);
        else{
            throw new RuntimeException("Pedido inválido!!!");
        }
    }
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<PedidoAjuda> listarTodos(){
        return dao.listarTodos();
    }
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param data parametro da operacao.
     * @return resultado da operacao.
     */
    public List<PedidoAjuda> listarPorData(LocalDate data){
        return dao.listarPedidosData(data);
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param id parametro da operacao.
     * @param novoPedido parametro da operacao.
     */
    public void atualizar(int id, PedidoAjuda novoPedido){
        PedidoAjuda pedidoAjuda = dao.buscarPorId(id);

        if(pedidoAjuda == null)
            throw new RuntimeException("Pedido não encontrado!!!");
        else{
            dao.atualizarPedido(id, novoPedido);
        }  
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param id parametro da operacao.
     * @param novoPedido parametro da operacao.
     * @param idPrograma parametro da operacao.
     */
    public void validarGerarBeneficiario(int id, PedidoAjuda novoPedido, int idPrograma){
        PedidoAjuda pedidoAjuda = dao.buscarPorId(id);

        if(pedidoAjuda == null){
            throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.atualizarPedido(id, novoPedido);

        BeneficiarioBO bo = new BeneficiarioBO();
        bo.adicionar(pedidoAjuda.getIdPedido(), idPrograma);
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param id parametro da operacao.
     */
    public void excluir(int id){
        PedidoAjuda pedidoAjuda = dao.buscarPorId(id);

        if(pedidoAjuda == null){
           throw new RuntimeException("Pedido não encontrado!!!");
        }
        dao.excluirPedido(id);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cpf parametro da operacao.
     * @param nome parametro da operacao.
     * @param dataNascimento parametro da operacao.
     * @param sexo parametro da operacao.
     * @param telefone parametro da operacao.
     * @param email parametro da operacao.
     * @param descricao parametro da operacao.
     * @param idEndereco parametro da operacao.
     * @return resultado da operacao.
     */
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

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param status parametro da operacao.
     * @return resultado da operacao.
     */
    public StatusPedido validarStatus(int status) {
        return switch (status) {
            case 1 -> StatusPedido.APROVADO;
            case 2 -> StatusPedido.REJEITADO;
            default -> throw new RuntimeException("Status inválido!!!");
        };
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param status parametro da operacao.
     * @param idDentista parametro da operacao.
     * @return resultado da operacao.
     */
    public PedidoAjuda validarNovoPedido(StatusPedido status, int idDentista) {
        if (status == null)
            throw new RuntimeException("Status inválido!!!");

        if (idDentista <= 0)
            throw new RuntimeException("ID do dentista obrigatório para atualização do pedido!!!");

        return new PedidoAjuda()
                .setStatus(status)
                .setIdDentista(idDentista);
    }
    /**
     * Aplica regra de negocio e validacoes para esta operacao.
     * @param dataNasc parametro da operacao.
     * @return resultado da operacao.
     */
    public static boolean invalidarHomens(LocalDate dataNasc){
        Period idade = Period.between(dataNasc, LocalDate.now());
        return idade.getYears() >= 18;
    }
}
