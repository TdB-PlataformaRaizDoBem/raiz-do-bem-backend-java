package RaizDoBem.controller;

import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.ViaCep;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    Endereco enderecoMapeado = new Endereco();

    public EnderecoController() {
        this.enderecoDAO = new EnderecoDAO();
    }

    public void criarEndereco(Endereco endereco){
        if(endereco != null){
            enderecoDAO.adicionar(endereco);
            System.out.println("Endereço criado e adicionado!");
        }
        else{
            System.out.println("Endereço inválido!!!");
        }
    }

    public Endereco buscaPorId(int id){
        return enderecoDAO.buscarPorId(id);
    }
    public List<Endereco> listarEnderecos(){
        return enderecoDAO.listarTodos();
    }
    public List<Endereco> listagemPorCidade(String cidade){
        return enderecoDAO.listarPorCidade(cidade);
    }

    public void atualizarEndereco(int id, Endereco enderecoAtualizado) {
        enderecoMapeado = enderecoDAO.buscarPorId(id);

        if(enderecoMapeado == null){
            System.out.println("Endereço não encontrado!!!");
            return;
        }
        enderecoDAO.atualizar(id, enderecoAtualizado);
    }
    public void excluirEndereco(int id) {
        enderecoMapeado = enderecoDAO.buscarPorId(id);

        if(enderecoMapeado == null){
            System.out.println("Endereço não encontrado!!!");
            return;
        }
        enderecoDAO.excluir(id);
    }

    public boolean validarCep(String cep){
        return ((cep!=null) && (cep.length()==8));
    }
}
