package RaizDoBem.model.bo;

import RaizDoBem.model.dao.ColaboradorDAO;
import RaizDoBem.model.vo.Colaborador;


import java.time.LocalDate;
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

    public Colaborador buscarPeloCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }

    public void atualizar(String cpf, Colaborador novoColaborador) {
        Colaborador colaborador = dao.buscarPorCpf(cpf);

        if(colaborador == null){
            throw new RuntimeException("Colaborador não encontrado!!!");
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

    public Colaborador validarColaborador(String cpf, String nome, LocalDate dataNascimento, LocalDate dataContratacao, String email) {

        return new Colaborador(
                cpf,
                nome,
                dataNascimento,
                dataContratacao,
                email
        );
    }

    public Colaborador validarNovoColaborador(String email){
        if (email.isEmpty()) {
            throw new RuntimeException("Email inválido!!!");
        }

        return new Colaborador().setEmail(email);
    }
}
