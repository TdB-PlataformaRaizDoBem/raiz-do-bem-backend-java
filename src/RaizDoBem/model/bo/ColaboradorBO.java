package RaizDoBem.model.bo;

import RaizDoBem.model.dao.ColaboradorDAO;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.model.vo.Endereco;


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

    public Colaborador BuscarPeloCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }

    public void atualizar(Colaborador novoColaborador, String cpf) {
        Colaborador colaborador = dao.buscarPorCpf(cpf);

        if(colaborador == null){
            throw new RuntimeException("Colaorador não encontrado!!!");
        }
        dao.atualizar(novoColaborador, cpf);
    }
    public void excluir(String cpf) {
        Colaborador colaborador = dao.buscarPorCpf(cpf);

        if(colaborador == null){
            return;
        }
        dao.excluir(cpf);
    }
}
