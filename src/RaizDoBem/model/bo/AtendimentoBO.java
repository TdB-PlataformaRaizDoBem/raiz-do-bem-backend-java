package RaizDoBem.model.bo;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;

import java.util.List;

public class AtendimentoBO {
    AtendimentoDAO dao = new AtendimentoDAO();
    Atendimento atendimento = new Atendimento();

    public void criar(Atendimento atendimento){
        if(atendimento != null){
            dao.adicionar(atendimento);
        }
        else{
            throw new RuntimeException("Atendimento inválido!!!");
        }
    }
    public Atendimento buscaPorId(String cpf){
        return dao.buscarPorId(cpf);
    }
    public List<Atendimento> listarTodos(){
        return dao.listarTodos();
    }
}
