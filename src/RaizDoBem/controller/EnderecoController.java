package RaizDoBem.controller;

import RaizDoBem.model.bo.EnderecoBO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;
import RaizDoBem.view.EnderecoView;

import java.util.List;

/**
 * Classe responsável por controlar as operações relacionadas aos endereços,
 * como atualização, utilizando o EnderecoDAO para acessar os dados.
 *
 * @author Paulo
 * @since 2026-03
 *
 *
 */
public class EnderecoController {
    private EnderecoView view;
    private EnderecoBO bo;

    public EnderecoController(EnderecoView view) {
        this.view = view;
        this.bo = new EnderecoBO();
    }

    public EnderecoController() {
    }

    public void adicionar() {
        boolean retorno;
        String cep;
        TipoEndereco tipoEndereco;
        boolean validacao;
        int tipo;
        try {
            do {
                cep = view.entradaCep();
                System.out.println("Você digitou o cep: " + cep);
                retorno = bo.validarCep(cep);
            } while (!retorno);

            String numero = view.entradaNumero();
            System.out.println("Você digitou o número: " + numero);
            do{
                tipo = view.entradaTipoEndereco();
                System.out.println("Você selecionou o tipo: " + tipo);
                validacao = bo.validarTipoEndereco(tipo);
            } while(!validacao);

            if (tipo == 1) {
                tipoEndereco = TipoEndereco.RESIDENCIAL;
            } else {
                tipoEndereco = TipoEndereco.PROFISSIONAL;
            }

            Endereco endereco = bo.validarEndereco(cep, numero, tipoEndereco);
            bo.criar(endereco);
            view.exibirMensagem("Endereço criado com sucesso!!!");
            view.exibirEndereco(endereco);
        } catch (Exception e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void listandoTodos() {
        List<Endereco> enderecos = bo.listarTodos();
        if (enderecos.isEmpty())
            view.exibirMensagem("Nenhum endereço encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os endereços: ");
            view.exibirLista(enderecos);
        }
    }

    public void listarPorId(int id) {
        if (id >= 0) {
            Endereco endereco = bo.buscaPorId(id);
            if (endereco != null) {
                view.exibirMensagem("Endereço encontrado: ");
                view.exibirEndereco(endereco);
            }
            else{
                view.exibirMensagem("Nenhum endereço encontrado!!!");
            }
        }
    }

    public void listandoPorCidade(String cidade) {
        List<Endereco> enderecos = bo.listarPorCidade(cidade);
        if (enderecos.isEmpty())
            view.exibirMensagem("Nenhum endereço encontrado!!!");
        else {
            view.exibirMensagem("Exibindo os endereços por cidade: ");
            view.exibirLista(enderecos);
        }
    }

    public void atualizar(int id) {
        try {
            Endereco endereco;
            boolean retorno;
            String cep;
            TipoEndereco tipoEndereco;
            boolean validacao;
            int tipo;
            do {
                cep = view.entradaCep();
                System.out.println("Você digitou o cep: " + cep);
                retorno = bo.validarCep(cep);
            } while (!retorno);
            String numero = view.entradaNumero();
            System.out.println("Você digitou o número: " + numero);
            do{
                tipo = view.entradaTipoEndereco();
                System.out.println("Você selecionou o tipo: " + tipo);
                validacao = bo.validarTipoEndereco(tipo);
            } while(!validacao);

            if (tipo == 1) {
                tipoEndereco = TipoEndereco.RESIDENCIAL;
            } else {
                tipoEndereco = TipoEndereco.PROFISSIONAL;
            }

            endereco = bo.validarEndereco(cep, numero, tipoEndereco);

            bo.atualizar(id, endereco);
            view.exibirMensagem("Endereço " + id + " atualizado com sucesso!!!");

        } catch (Exception e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void deletar(int id) {
        if(id<=0){
            view.exibirMensagem("ID inválido!!!");
        }
        else{
            bo.excluir(id);
            view.exibirMensagem("Endereço " + id + " excluído com sucesso!!!");
        }
    }
}
