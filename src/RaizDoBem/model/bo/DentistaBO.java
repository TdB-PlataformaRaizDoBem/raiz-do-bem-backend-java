package RaizDoBem.model.bo;

import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;

import java.util.List;

public class DentistaBO {
    DentistaDAO dao = new DentistaDAO();
    Dentista dentista = new Dentista();

    public Dentista buscaPorCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }
    public void criarDentista(Dentista dentista){
        if(dentista != null){
            dao.adicionar(dentista);
            System.out.println("Endereço criado e adicionado!");
        }
        else{
            System.out.println("Endereço inválido!!!");
        }
    }

    public List<Dentista> listarTodos(){
        return dao.listarTodos();
    }
    public List<Dentista> listarDisponiveis(){
        return dao.listarDisponiveis();
    }

    public List<Dentista> listagemPorCidade(String cidade){
        return dao.listarPorCidade(cidade);
    }

    public void atualizarDentista(String cpf, Dentista dentistaAtualizado){
        dentista = dao.buscarPorCpf(cpf);

        if(dentista == null){
            System.out.println("Dentista não encontrado!!!");
            return;
        }
        dao.atualizar(cpf, dentistaAtualizado);
    }

    public void excluirDentista(String cpf){
        dentista = dao.buscarPorCpf(cpf);

        if(dentista == null){
            System.out.println("Dentista não encontrado!!!");
            return;
        }
        dao.excluir(cpf);
    }
}
