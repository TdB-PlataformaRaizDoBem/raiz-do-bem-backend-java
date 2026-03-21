package RaizDoBem.controller;

import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;

import java.util.List;

/**
 * Classe responsável por controlar as operações relacionadas aos endereços, como atualização, utilizando o EnderecoDAO para acessar os dados.
 * @author Paulo
 * @since 2026-03
 *
 * @see EnderecoDAO
 * @see Endereco
 *
 */
public class EnderecoController {
    private final EnderecoDAO enderecoDAO;

    public EnderecoController() {
        this.enderecoDAO = new EnderecoDAO();
    }

    public List<Endereco> listarEnderecos(){
        return enderecoDAO.listarTodos();
    }

    public void excluirEndereco(int id) {
        Endereco enderecoMapeado = enderecoDAO.buscarPorId(id);

        if(enderecoMapeado == null){
            System.out.println("Endereço não encontrado!!!");
            return;
        }
        enderecoDAO.excluir(id);
    }

    public void atualizarEndereco(int id, Endereco novoEndereco) {
        Endereco enderecoMapeado = enderecoDAO.buscarPorId(id);

        if(enderecoMapeado == null){
            System.out.println("Endereço não encontrado!!!");
            return;
        }
        enderecoDAO.atualizar(id, novoEndereco);
    }
}
