package RaizDoBem.model.bo;

import RaizDoBem.model.dao.ColaboradorDAO;
import RaizDoBem.model.vo.Colaborador;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de ColaboradorBO.
 * Camada: BO.
 */
public class ColaboradorBO {
    private final ColaboradorDAO dao = new ColaboradorDAO();

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param colaborador parametro da operacao.
     */
    public void criar(Colaborador colaborador){
        if(colaborador != null){
            dao.adicionar(colaborador);
        }
        else{
            throw new RuntimeException("Colaborador Inválido");
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Colaborador> listarTodos(){
        return dao.listarTodos();
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Colaborador buscarPeloCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     * @param novoColaborador parametro da operacao.
     */
    public void atualizar(String cpf, Colaborador novoColaborador) {
        Colaborador colaborador = dao.buscarPorCpf(cpf);

        if(colaborador == null){
            throw new RuntimeException("Colaborador não encontrado!!!");
        }
        dao.atualizar(novoColaborador, cpf);
    }
    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluir(String cpf) {
        Colaborador colaborador = dao.buscarPorCpf(cpf);

        if(colaborador == null){
           throw new RuntimeException("Colaborador não encontrado!!!");
        }
        dao.excluir(cpf);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cpf parametro da operacao.
     * @param nome parametro da operacao.
     * @param dataNascimento parametro da operacao.
     * @param dataContratacao parametro da operacao.
     * @param email parametro da operacao.
     * @return resultado da operacao.
     */
    public Colaborador validarColaborador(String cpf, String nome, LocalDate dataNascimento, LocalDate dataContratacao, String email) {

        return new Colaborador(
                cpf,
                nome,
                dataNascimento,
                dataContratacao,
                email
        );
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param email parametro da operacao.
     * @return resultado da operacao.
     */
    public Colaborador validarNovoColaborador(String email){
        if (email.isEmpty()) {
            throw new RuntimeException("Email inválido!!!");
        }

        return new Colaborador().setEmail(email);
    }
}
