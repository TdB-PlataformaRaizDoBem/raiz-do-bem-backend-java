package RaizDoBem.model.bo;

import RaizDoBem.model.dao.EspecialidadeDAO;
import RaizDoBem.model.vo.Especialidade;

import java.util.List;

public class EspecialidadeBO {
    EspecialidadeDAO dao = new EspecialidadeDAO();
    public List<Especialidade> listarTodos(){
        return dao.listarTodos();
    }
}
