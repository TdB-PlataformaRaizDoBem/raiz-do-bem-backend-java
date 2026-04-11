package RaizDoBem.controller;

import RaizDoBem.model.bo.EnderecoBO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;
import RaizDoBem.view.EnderecoView;

import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de EnderecoController entre View e BO.
 * Camada: Controller.
 */
public class EnderecoController {
    private final EnderecoView view;
    private final EnderecoBO bo;

    public EnderecoController(EnderecoView view) {
        this.view = view;
        this.bo = new EnderecoBO();
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     */
    public void adicionar() {
        String cep;
        TipoEndereco tipoEndereco;
        int tipo;
        try {
            view.mostrar("\nCriando endereço: ");
            do {
                cep = view.entradaCep();
                view.mostrar("\nVocê digitou o cep: " + cep);
            } while (!bo.validarCep(cep));

            String numero = view.entradaNumero();
            view.mostrar("\nVocê digitou o número: " + numero);
            do{
                tipo = view.entradaTipoEndereco();
                view.mostrar("\nVocê selecionou o tipo: " + tipo);
            } while(!bo.validarTipoEndereco(tipo));

            if (tipo == 1)
                tipoEndereco = TipoEndereco.RESIDENCIAL;
            else
                tipoEndereco = TipoEndereco.PROFISSIONAL;

            Endereco endereco = bo.validarEndereco(cep, numero, tipoEndereco);
            bo.criar(endereco);
            view.mostrar("\nEndereço criado com sucesso!!!");
            view.exibirEndereco(endereco);
        } catch (Exception e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     */
    public void listandoTodos() {
        List<Endereco> enderecos = bo.listarTodos();
        if (enderecos.isEmpty())
            view.mostrar("\nNenhum endereço encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os endereços: ");
            view.exibirLista(enderecos);
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param id parametro da operacao.
     */
    public void listarPorId(int id) {
        if (id >= 0) {
            Endereco endereco = bo.buscaPorId(id);
            if (endereco != null) {
                view.mostrar("\nEndereço encontrado: ");
                view.exibirEndereco(endereco);
            }
            else{
                view.mostrar("\nNenhum endereço encontrado!!!");
            }
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     * @param cidade parametro da operacao.
     */
    public void listandoPorCidade(String cidade) {
        List<Endereco> enderecos = bo.listarPorCidade(cidade);
        if (enderecos.isEmpty())
            view.mostrar("\nNenhum endereço encontrado!!!");
        else {
            view.mostrar("\nExibindo os endereços por cidade: ");
            view.exibirLista(enderecos);
        }
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param id parametro da operacao.
     */
    public void atualizar(int id) {
        try {
            Endereco endereco;
            String cep;
            TipoEndereco tipoEndereco;
            int tipo;
            view.mostrar("\nAtualizando endereço: ");
            do {
                cep = view.entradaCep();
                view.mostrar("Você digitou o cep: " + cep);
            } while (!bo.validarCep(cep));

            String numero = view.entradaNumero();
            view.mostrar("Você digitou o número: " + numero);
            do{
                tipo = view.entradaTipoEndereco();
                view.mostrar("Você selecionou o tipo: " + tipo);
            } while(!bo.validarTipoEndereco(tipo));

            if (tipo == 1)
                tipoEndereco = TipoEndereco.RESIDENCIAL;
            else
                tipoEndereco = TipoEndereco.PROFISSIONAL;

            endereco = bo.validarEndereco(cep, numero, tipoEndereco);

            bo.atualizar(id, endereco);
            view.mostrar("\nEndereço " + id + " atualizado com sucesso!!!");
        } catch (Exception e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     * @param id parametro da operacao.
     */
    public void deletar(int id) {
        try{
            if(id<=0)
                view.mostrar("\nID inválido!!!");
            else{
                bo.excluir(id);
                view.mostrar("\nEndereço " + id + " excluído com sucesso!!!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
