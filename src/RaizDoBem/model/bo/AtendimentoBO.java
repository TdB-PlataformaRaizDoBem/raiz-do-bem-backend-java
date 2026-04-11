package RaizDoBem.model.bo;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;

import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de AtendimentoBO.
 * Camada: BO.
 */
public class AtendimentoBO {
    private final AtendimentoDAO dao = new AtendimentoDAO();

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param atendimento parametro da operacao.
     */
    public void criar(Atendimento atendimento) {
        if (atendimento != null)
            dao.adicionar(atendimento);
        else
            throw new RuntimeException("Atendimento inválido!!!");
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Atendimento buscaPorCpf(String cpf) {
        return dao.buscarPorCpf(cpf);
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param id parametro da operacao.
     * @return resultado da operacao.
     */
    public Atendimento buscaPorId(int id) {
        return dao.buscarPorId(id);
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Atendimento> listarTodos() {
        return dao.listarTodos();
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param id parametro da operacao.
     * @param novoAtendimento parametro da operacao.
     */
    public void atualizar(int id, Atendimento novoAtendimento) {
        Atendimento atendimento = dao.buscarPorId(id);

        if(atendimento == null){
            throw new RuntimeException("Atendimento não encontrado!!!");
        }
        dao.atualizar(id, novoAtendimento);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param descricao parametro da operacao.
     * @param idBeneficiario parametro da operacao.
     * @param idDentista parametro da operacao.
     * @return resultado da operacao.
     */
    public Atendimento validarAtendimento(String descricao, int idBeneficiario, int idDentista){
        return new Atendimento(
                descricao,
                idBeneficiario,
                idDentista
        );
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param prontuario parametro da operacao.
     * @param idColaborador parametro da operacao.
     * @return resultado da operacao.
     */
    public Atendimento validarAtualizacao(String prontuario, int idColaborador){
        return new Atendimento()
                .setProntuario(prontuario)
                .setIdColaborador(idColaborador);
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param id parametro da operacao.
     */
    public void excluir(int id) {
        Atendimento atendimento = dao.buscarPorId(id);
        if (atendimento == null)
            throw new RuntimeException("Atendimento não encontrado!!!");

        dao.excluir(id);
    }
}
