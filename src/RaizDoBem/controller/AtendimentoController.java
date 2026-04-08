package RaizDoBem.controller;

import RaizDoBem.model.bo.AtendimentoBO;
import RaizDoBem.model.vo.Atendimento;
import RaizDoBem.view.AtendimentoView;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe responsável por controlar as operações relacionadas aos atendimentos,
 * como criação, listagem e atualização, utilizando o AtendimentoBO para acessar os dados.
 *
 * @author Paulo
 * @since 2026-03
 *
 * @see AtendimentoBO
 * @see AtendimentoView
 * 
 * 1º Metodo - adicionar: Solicita ao usuário as informações necessárias para criar um novo atendimento, como prontuário, ID do beneficiário e ID do dentista. Em seguida, utiliza o AtendimentoBO para validar os dados e criar o atendimento, exibindo uma mensagem de sucesso ou erro conforme o resultado da operação.
 * 2º Metodo - listandoTodos: Recupera a lista de todos os atendimentos utilizando o AtendimentoBO e exibe os atendimentos para o usuário. Se não houver atendimentos cadastrados, exibe uma mensagem informando que nenhum atendimento foi encontrado.
 * 3º Metodo - listarPorCpf: Solicita ao usuário o CPF do beneficiário e utiliza o AtendimentoBO para buscar o atendimento correspondente. Se um atendimento for encontrado, exibe suas informações para o usuário; caso contrário, exibe uma mensagem informando que nenhum atendimento foi encontrado.
 * 4º Metodo - atualizar: Solicita ao usuário o ID do atendimento a ser atualizado, bem como as informações necessárias para a atualização, como prontuário e ID do colaborador. Em seguida, utiliza o AtendimentoBO para validar os dados e atualizar o atendimento, exibindo uma mensagem de sucesso ou erro conforme o resultado da operação.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de atendimento, fornecendo as informações necessárias para criar, listar, buscar e atualizar atendimentos, e visualizando os resultados das operações realizadas.
 */
public class AtendimentoController {
    private AtendimentoView view;
    private AtendimentoBO bo;

    public AtendimentoController(AtendimentoView view) {
        this.view = view;
        this.bo = new AtendimentoBO();
    }

    public void adicionar(){
        try {
            String prontuario = view.inputProntuario();

            int idBeneficiario = view.inputBeneficiario();
            int idDentista = view.inputDentista();

            Atendimento atendimento = bo.validarAtendimento(prontuario, idBeneficiario, idDentista);
            bo.criar(atendimento);

            view.mostrar("\nAtendimento criado com sucesso!!!");
        } catch (Exception e) {
            view.mostrar(e.getMessage());
        }
    }

    public void listandoTodos() {
        List<Atendimento> atendimentos = bo.listarTodos();
        if (atendimentos.isEmpty())
            view.mostrar("\nNenhum atendimento encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os atendimentos: ");
            view.listarTodos(atendimentos);
        }
    }

    public void listarPorCpf(String cpf) {
        Atendimento atendimento = bo.buscaPorCpf(cpf);
        if (atendimento != null) {
            view.mostrar("\nAtendimento encontrado: ");
            view.exibirAtendimento(atendimento);
        }
        else{
            view.mostrar("\nNenhum atendimento encontrado!!!");
            }
    }
    public void atualizar(int idAtendimento){
        try{
            String prontuario = view.inputProntuario();
            int idColaborador = view.inputColaborador();

            Atendimento atendimento = bo.validarAtualizacao(prontuario, idColaborador);
            atendimento.setDataFinal(LocalDate.now());

            bo.atualizar(idAtendimento, atendimento);
            view.mostrar("\nAtendimento atualizado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }
}
