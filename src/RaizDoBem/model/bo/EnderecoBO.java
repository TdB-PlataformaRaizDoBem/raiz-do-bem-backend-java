package RaizDoBem.model.bo;

import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;
import RaizDoBem.model.vo.ViaCep;

import java.util.List;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de EnderecoBO.
 * Camada: BO.
 */
public class EnderecoBO {
    private final EnderecoDAO dao = new EnderecoDAO();
    private final ViaCepBO bo = new ViaCepBO();

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     * @param endereco parametro da operacao.
     */
    public void criar(Endereco endereco){
        if(endereco != null)
            dao.adicionar(endereco);
        else{
            throw new RuntimeException("Endereço Inválido");
        }
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param id parametro da operacao.
     * @return resultado da operacao.
     */
    public Endereco buscaPorId(int id){
        return dao.buscarPorId(id);
    }
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @return resultado da operacao.
     */
    public List<Endereco> listarTodos(){
        return dao.listarTodos();
    }
    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param cidade parametro da operacao.
     * @return resultado da operacao.
     */
    public List<Endereco> listarPorCidade(String cidade){
        return dao.listarPorCidade(cidade);
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param id parametro da operacao.
     * @param enderecoAtualizado parametro da operacao.
     */
    public void atualizar(int id, Endereco enderecoAtualizado) {
        Endereco endereco = dao.buscarPorId(id);

        if(endereco == null){
            throw new RuntimeException("Endereço não encontrado!!!");
        }
        dao.atualizar(id, enderecoAtualizado);
    }
    /**
     * Remove um registro existente conforme validacoes aplicadas.
     * @param id parametro da operacao.
     */
    public void excluir(int id) {
        Endereco endereco = dao.buscarPorId(id);

        if(endereco == null){
            throw new RuntimeException("Endereço não encontrado!!!");
        }
        dao.excluir(id);
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cep parametro da operacao.
     * @param numero parametro da operacao.
     * @param tipoEndereco parametro da operacao.
     * @return resultado da operacao.
     */
    public Endereco validarEndereco(String cep, String numero, TipoEndereco tipoEndereco){
        ViaCep enderecoBuscado = bo.buscarInformacoesEndereco(cep);

        if(enderecoBuscado == null || enderecoBuscado.isErro()){
            throw new RuntimeException("Endereço não encontrado!!!");
        }
        return new Endereco(
                enderecoBuscado.getLogradouro(),
                cep,
                numero,
                enderecoBuscado.getBairro(),
                enderecoBuscado.getLocalidade(),
                enderecoBuscado.getUf(),
                tipoEndereco
        );
    }
    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cep parametro da operacao.
     * @return resultado da operacao.
     */
    public boolean validarCep(String cep){
        return cep != null && cep.matches("\\d{8}");
    }

    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param opc parametro da operacao.
     * @return resultado da operacao.
     */
    public boolean validarTipoEndereco(int opc){
        if (opc != 1 && opc != 2) {
            throw new RuntimeException("Tipo de endereço inválido! Escolha 1 para Residencial ou 2 para Profissional.");
        }
        return true;
    }
}
