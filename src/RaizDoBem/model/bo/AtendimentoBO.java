package RaizDoBem.model.bo;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;

import java.util.List;

public class AtendimentoBO {
    AtendimentoDAO dao = new AtendimentoDAO();

    public void criar(Atendimento atendimento) {
        if (atendimento != null) {
            dao.adicionar(atendimento);
        } else {
            throw new RuntimeException("Atendimento inválido!!!");
        }
    }

    public Atendimento buscaPorCpf(String cpf) {
        return dao.buscarPorCpf(cpf);
    }

    public Atendimento buscaPorId(int id) {
        return dao.buscarPorId(id);
    }

    public List<Atendimento> listarTodos() {
        return dao.listarTodos();
    }

    public void atualizar(int id, Atendimento novoAtendimento) {
        Atendimento atendimento = dao.buscarPorId(id);

        if(atendimento == null){
            throw new RuntimeException("Atendimento não encontrado!!!");
        }
        dao.atualizar(id, novoAtendimento);
    }

    public Atendimento validarAtendimento(String descricao, int idBeneficiario, int idDentista){

        return new Atendimento(
                descricao,
                idBeneficiario,
                idDentista
        );
    }

    public Atendimento validarAtualizacao(String prontuario, int idColaborador){

        return new Atendimento()
                .setProntuario(prontuario)
                .setIdColaborador(idColaborador);
    }
}
