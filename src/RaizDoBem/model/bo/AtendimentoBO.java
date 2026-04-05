package RaizDoBem.model.bo;

import RaizDoBem.model.dao.AtendimentoDAO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.model.vo.PedidoAjuda;
import RaizDoBem.model.vo.Sexo;

import java.time.LocalDate;
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

    public List<Atendimento> listarTodos() {
        return dao.listarTodos();
    }

    public void atualizar(String cpf, Atendimento novoAtendimento) {
        Atendimento atendimento = dao.buscarPorCpf(cpf);

        if(atendimento == null){
            throw new RuntimeException("Atendimento não encontrado!!!");
        }
        dao.atualizar(cpf, novoAtendimento);
    }

    public Atendimento validarAtendimento(String descricao, int idBeneficiario, int idDentista){

        return new Atendimento(
                descricao,
                idBeneficiario,
                idDentista
        );
    }
}
