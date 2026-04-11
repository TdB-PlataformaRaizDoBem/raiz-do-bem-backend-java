package RaizDoBem.model.bo;

import RaizDoBem.model.dao.EspecialidadeDAO;
import RaizDoBem.model.vo.Especialidade;

import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de EspecialidadeBO.
 * Camada: BO.
 */
public class EspecialidadeBO {
    private final EspecialidadeDAO dao = new EspecialidadeDAO();
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Especialidade> listarTodos(){
        return dao.listarTodos();
    }
}
