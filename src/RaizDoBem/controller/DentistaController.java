package RaizDoBem.controller;

import RaizDoBem.model.bo.DentistaBO;
import RaizDoBem.model.vo.*;
import RaizDoBem.view.DentistaView;

import java.util.List;

/**
 * Controller responsavel por orquestrar o fluxo de DentistaController entre View e BO.
 * Camada: Controller.
 */
public class DentistaController {
    private final DentistaView view;
    private final DentistaBO bo;

    public DentistaController(DentistaView view) {
        this.view = view;
        this.bo = new DentistaBO();
    }

    /**
     * Cria um novo registro aplicando as validacoes necessarias do modulo.
     */
    public void criar() {
        try{
            Sexo sexo;
            String cro;
            String cpf;
            view.mostrar("\nCriando dentista: ");
            do{
                cro = view.inputCro();
            } while(bo.validarCro(cro));

            do{
                cpf = view.inputCpf();
            } while(!Validacao.validarCpf(cpf));

            String nome = view.inputNome();
            int sexoDentista = view.inputSexo();
            if (sexoDentista == 1)
                sexo = Sexo.M;
            else if (sexoDentista == 2)
                sexo = Sexo.F;
            else
                sexo = Sexo.O;

            String telefone  = view.inputTelefone();
            String email = view.inputEmail();

            int categ = view.inputCategoria();
            String categoriaDentista = categ == 1 ? "COORDENADOR" : "CLINICO";

            int idEndereco = view.inputIdEndereco();
            int disponivel = view.inputDisponibilidade();
            boolean disponibilidade = (disponivel == 1);

            Dentista dentista = bo.validarDentista(cro, cpf, nome, sexo, email, telefone, categoriaDentista, idEndereco, disponibilidade);
            bo.criarDentista(dentista);
            view.mostrar("\nDentista criado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     */
    public void listandoTodos() {
        List<Dentista> dentistas = bo.listarTodos();
        if (dentistas.isEmpty())
            view.mostrar("\nNenhum dentista encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os dentistas: ");
            view.listarTodos(dentistas);
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     * @param cidade parametro da operacao.
     */
    public void listarPorCidade(String cidade) {
        List<Dentista> dentistas = bo.listagemPorCidade(cidade);
        if (dentistas.isEmpty())
            view.mostrar("\nNenhum dentista encontrado na cidade!!!");
        else {
            view.mostrar("\nExibindo todos os dentistas da cidade " + cidade + ": ");
            view.listarTodos(dentistas);
        }
    }

    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cpf parametro da operacao.
     */
    public void buscarPorCpf(String cpf) {
        Dentista dentista = bo.buscaPorCpf(cpf);
        if (dentista != null) {
            view.mostrar("\nDentista encontrado: ");
            view.exibirDentista(dentista);
        } else {
            view.mostrar("\nNenhum dentista encontrado!!!");
        }
    }

    /**
     * Lista registros conforme o criterio informado pelo fluxo atual.
     */
    public void listarDisponiveis() {
        List<Dentista> dentista = bo.listarDisponiveis();
        if (dentista.isEmpty()) {
            view.mostrar("\nNenhum dentista disponível encontrado!!!");
        } else {
            view.mostrar("\nExibindo todos os dentistas disponíveis: ");
            view.listarTodos(dentista);
        }
    }

    /**
     * Atualiza dados existentes conforme as regras do modulo.
     * @param cpf parametro da operacao.
     */
    public void atualizar(String cpf){
        try{
            view.mostrar("Atualizando dentista: ");
            if(Validacao.validarCpf(cpf)){
                String telefone = view.inputTelefone();
                String email = view.inputEmail();
                int categ = view.inputCategoria();
                String categoriaDentista = categ == 1 ? "COORDENADOR" : "CLINICO";

                int idEndereco = view.inputIdEndereco();
                int disponivel = view.inputDisponibilidade();
                boolean disponibilidade = (disponivel == 1);

                Dentista dentista = bo.validaAtualizaDentista(email, telefone, categoriaDentista, idEndereco, disponibilidade);

                bo.atualizarDentista(cpf, dentista);
                view.mostrar("\nDentista atualizado com sucesso!!!");
            }
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    /**
     * Orquestra o fluxo entre View e BO para esta operacao.
     * @param cpf parametro da operacao.
     */
    public void apagar(String cpf) {
        try{
            if (!Validacao.validarCpf(cpf)) {
                view.mostrar("\nCpf inválido!!!");
            } else {
                bo.excluirDentista(cpf);
                view.mostrar("\nDentista excluído com sucesso!!!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
