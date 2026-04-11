package RaizDoBem.model.bo;

import RaizDoBem.model.dao.ProgramaSocialDAO;
import RaizDoBem.model.vo.ProgramaSocial;

import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de ProgramaBO.
 * Camada: BO.
 */
public class ProgramaBO {
    private final ProgramaSocialDAO dao = new ProgramaSocialDAO();

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<ProgramaSocial> listarTodos(){
        return dao.listarTodos();
    }
}
