package RaizDoBem.model.bo;

import RaizDoBem.model.dao.ProgramaSocialDAO;
import RaizDoBem.model.vo.ProgramaSocial;

import java.util.List;

public class ProgramaBO {
    private final ProgramaSocialDAO dao = new ProgramaSocialDAO();

    public List<ProgramaSocial> listarTodos(){
        return dao.listarTodos();
    }
}
