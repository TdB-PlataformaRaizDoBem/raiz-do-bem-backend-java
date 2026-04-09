package RaizDoBem.model.bo;

import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;
import RaizDoBem.model.vo.ViaCep;

import java.util.List;

public class EnderecoBO {
    EnderecoDAO dao = new EnderecoDAO();
    ViaCepBO bo = new ViaCepBO();

    public void criar(Endereco endereco){
        if(endereco != null)
            dao.adicionar(endereco);
        else{
            throw new RuntimeException("Endereço Inválido");
        }
    }

    public Endereco buscaPorId(int id){
        return dao.buscarPorId(id);
    }
    public List<Endereco> listarTodos(){
        return dao.listarTodos();
    }
    public List<Endereco> listarPorCidade(String cidade){
        return dao.listarPorCidade(cidade);
    }

    public void atualizar(int id, Endereco enderecoAtualizado) {
        Endereco endereco = dao.buscarPorId(id);

        if(endereco == null){
            throw new RuntimeException("Endereço não encontrado!!!");
        }
        dao.atualizar(id, enderecoAtualizado);
    }
    public void excluir(int id) {
        Endereco endereco = dao.buscarPorId(id);

        if(endereco == null){
            throw new RuntimeException("Endereço não encontrado!!!");
        }
        dao.excluir(id);
    }

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
    public boolean validarCep(String cep){
        return cep != null && cep.matches("\\d{8}");
    }

    public boolean validarTipoEndereco(int opc){
        if (opc != 1 && opc != 2) {
            throw new RuntimeException("Tipo de endereço inválido! Escolha 1 para Residencial ou 2 para Profissional.");
        }
        return true;
    }
}
