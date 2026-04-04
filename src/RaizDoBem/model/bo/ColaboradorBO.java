package RaizDoBem.model.bo;

import RaizDoBem.model.dao.ColaboradorDAO;
import RaizDoBem.model.vo.Colaborador;


import java.util.List;

public class ColaboradorBO {
    ColaboradorDAO dao = new ColaboradorDAO();

    public void criar(Colaborador colaborador){
        if(colaborador != null){
            dao.adicionar(colaborador);
        }
        else{
            throw new RuntimeException("Colaborador Inválido");
        }
    }

    public List<Colaborador> listarTodos(){
        return dao.listarTodos();
    }
}
