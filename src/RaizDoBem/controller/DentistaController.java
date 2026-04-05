package RaizDoBem.controller;

import RaizDoBem.model.bo.DentistaBO;
import RaizDoBem.model.vo.*;
import RaizDoBem.view.DentistaView;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe de controle para os dentistas que prestarão serviço a ONG. Esta classe
 * é responsável por gerenciar as operações relacionadas aos dentistas, como
 * criar, buscar e listar dentistas. Ela atua como uma camada intermediária
 * entre a interface do usuário e a camada de acesso a dados (DAO), garantindo
 * que as regras de negócio sejam aplicadas corretamente.
 * 
 * @author Paulo
 * @since 2026-03
 */
public class DentistaController {
    private DentistaView view;
    private DentistaBO bo;

    public DentistaController(DentistaView view) {
        this.view = view;
        this.bo = new DentistaBO();
    }

    public DentistaController() {
    }

    public void criar() {
        Sexo sexo;
        String categoriaDentista;
        boolean disponibilidade;

        String cro = view.inputCro();
        String cpf = view.inputCpf();
        String nome = view.inputNome();
        int sexoDentista = view.inputSexo();
        if (sexoDentista == 1) {
            sexo = Sexo.M;
        } else if (sexoDentista == 2) {
            sexo = Sexo.F;
        } else {
            sexo = Sexo.O;
        }
        String telefone  = view.inputTelefone();
        String email = view.inputEmail();

        int categ = view.inputCategoria();
        if(categ == 1 )
            categoriaDentista = "COORDENADOR";
        else if(categ ==2 )
            categoriaDentista = "CLINICO";

        int disponivel = view.inputDisponibilidade();
        if(disponivel == 1 )
            disponibilidade = true;
        else if(disponivel == 2 )
            disponibilidade = false;

//        bo.criarDentista(dentista);
        view.exibirMensagem("Dentista criado com sucesso!!!");
    }


    public void listandoTodos() {
        List<Dentista> dentistas = bo.listarTodos();
        if (dentistas.isEmpty())
            view.exibirMensagem("Nenhum dentista encontrado!!!");
        else {
            view.exibirMensagem("Exibindo todos os dentistas: ");
            view.exibirLista(dentistas);
        }
    }

    public void listarPorCidade(String cidade) {
        List<Dentista> dentistas = bo.listagemPorCidade(cidade);
        if (dentistas.isEmpty())
            view.exibirMensagem("Nenhum dentista encontrado na cidade!!!");
        else {
            view.exibirMensagem("Exibindo todos os dentistas da cidade " + cidade + ": ");
            view.exibirLista(dentistas);
        }
    }

    public void buscarPorCpf(String cpf) {
        Dentista dentista = bo.buscaPorCpf(cpf);
        if (dentista != null) {
            view.exibirMensagem("Dentista encontrado: ");
            view.exibirDentista(dentista);
        } else {
            view.exibirMensagem("Nenhum dentista encontrado!!!");
        }
    }

    public void listarDisponiveis(boolean disponivel) {
        List<Dentista> dentista = bo.listarDisponiveis(disponivel);
        if (dentista.isEmpty()) {
            view.exibirMensagem("Nenhum dentista disponível encontrado!!!");
        } else {
            view.exibirMensagem("Exibindo todos os dentistas dispníveis: ");
            view.exibirLista(dentista);
        }
    }

    public void atualizar(String cpf){
        try{



//            bo.atualizarDentista(cpf, );
            view.exibirMensagem("Dentista atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void apagar(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            view.exibirMensagem("Cpf inválido!!!");
        } else {
            bo.excluirDentista(cpf);
            view.exibirMensagem("Dentista excluído com sucesso!!!");
        }
    }
}
