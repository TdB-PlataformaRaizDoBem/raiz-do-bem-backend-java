package RaizDoBem.model.bo;

import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.Sexo;

import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de DentistaBO.
 * Camada: BO.
 */
public class DentistaBO {
    private final DentistaDAO dao = new DentistaDAO();

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public Dentista buscaPorCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param dentista parametro da operacao.
     */
    public void criarDentista(Dentista dentista){
        if(dentista != null){
            dao.adicionar(dentista);
            System.out.println("Endereço criado e adicionado!");
        }
        else{
            System.out.println("Endereço inválido!!!");
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Dentista> listarTodos(){
        return dao.listarTodos();
    }
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Dentista> listarDisponiveis(){
        return dao.listarDisponiveis();
    }

    /**
     * Aplica regra de negocio e validacoes para esta operacao.
     * @param cidade parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Dentista> listagemPorCidade(String cidade){
        return dao.listarPorCidade(cidade);
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     * @param dentistaAtualizado parametro da operacao.
     */
    public void atualizarDentista(String cpf, Dentista dentistaAtualizado){
        Dentista dentista = dao.buscarPorCpf(cpf);

        if(dentista == null){
            System.out.println("Dentista não encontrado!!!");
            return;
        }
        dao.atualizar(cpf, dentistaAtualizado);
    }

    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param cpf parametro da operacao.
     */
    public void excluirDentista(String cpf){
        Dentista dentista = dao.buscarPorCpf(cpf);

        if(dentista == null){
            System.out.println("Dentista não encontrado!!!");
            return;
        }
        dao.excluir(cpf);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cro parametro da operacao.
     * @param cpf parametro da operacao.
     * @param nome parametro da operacao.
     * @param sexo parametro da operacao.
     * @param email parametro da operacao.
     * @param telefone parametro da operacao.
     * @param categoria parametro da operacao.
     * @param idEndereco parametro da operacao.
     * @param disponivel parametro da operacao.
     * @return resultado da operacao.
     */
    public Dentista validarDentista(String cro, String cpf, String nome, Sexo sexo, String email, String telefone, String categoria, int idEndereco, boolean disponivel) {
        return new Dentista(
                cro,
                cpf,
                nome,
                sexo,
                email,
                telefone,
                categoria,
                idEndereco,
                disponivel
        );
    }

    /**
     * Aplica regra de negocio e validacoes para esta operacao.
     * @param email parametro da operacao.
     * @param telefone parametro da operacao.
     * @param categoria parametro da operacao.
     * @param idEndereco parametro da operacao.
     * @param disponivel parametro da operacao.
     * @return resultado da operacao.
     */
    public Dentista validaAtualizaDentista(String email, String telefone, String categoria, int idEndereco, boolean disponivel) {
        return new Dentista()
                .setEmail(email)
                .setTelefone(telefone)
                .setCategoria(categoria)
                .setIdEndereco(idEndereco)
                .setDisponivel(disponivel);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cro parametro da operacao.
     * @return resultado da operacao.
     */
    public boolean validarCro(String cro){
        return cro!=null && cro.matches("^[a-zA-Z]{2,}\\d{2}$");
    }
}
