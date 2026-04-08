package RaizDoBem.controller;

import RaizDoBem.model.bo.ColaboradorBO;
import RaizDoBem.model.vo.Colaborador;
import RaizDoBem.view.ColaboradorView;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe responsável por controlar as operações relacionadas aos colaboradores,
 * como criação, listagem, busca, atualização e exclusão, utilizando o ColaboradorBO para acessar os dados.
 * @author Paulo
 * @since 2026-03
 * @see ColaboradorBO
 * @see ColaboradorView
 * 1º Metodo - criar: Solicita ao usuário as informações necessárias para criar um novo colaborador, como CPF, nome, data de nascimento, data de contratação e email. Em seguida, utiliza o ColaboradorBO para validar os dados e criar o colaborador, exibindo uma mensagem de sucesso ou erro conforme o resultado da operação.
 * 2º Metodo - listandoTodos: Recupera a lista de todos os colaboradores utilizando o ColaboradorBO e exibe os colaboradores para o usuário. Se não houver colaboradores cadastrados, exibe uma mensagem informando que nenhum colaborador foi encontrado.
 * 3º Metodo - buscarPorCpf: Solicita ao usuário o CPF do colaborador e utiliza o ColaboradorBO para buscar o colaborador correspondente. Se um colaborador for encontrado, exibe suas informações para o usuário; caso contrário, exibe uma mensagem informando que nenhum colaborador foi encontrado.
 * 4º Metodo - atualizar: Solicita ao usuário o CPF do colaborador a ser atualizado, bem como as informações necessárias para a atualização, como email. Em seguida, utiliza o ColaboradorBO para validar os dados e atualizar o colaborador, exibindo uma mensagem de sucesso ou erro conforme o resultado da operação.
 * 5º Metodo - excluir: Solicita ao usuário o CPF do colaborador a ser excluído. Se o CPF for válido, utiliza o ColaboradorBO para excluir o colaborador e exibe uma mensagem de sucesso. Caso contrário, exibe uma mensagem informando que o CPF é inválido.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de colaborador, fornecendo as informações necessárias para criar, listar, buscar, atualizar e excluir colaboradores, e visualizando os resultados das operações realizadas.
 */
public class ColaboradorController {
    private ColaboradorView view;
    private ColaboradorBO bo;

    public ColaboradorController(ColaboradorView view) {
        this.view = view;
        this.bo = new ColaboradorBO();
    }

    public ColaboradorController() {
    }

    public void criar() {
        try{
            String cpf = view.inputCpf();
            String nome = view.inputNome();
            LocalDate dataNascimento = view.inputDataNasc();
            LocalDate dataContratacao = view.inputDataContratacao();
            String email = view.inputEmail();

            Colaborador colaborador = bo.validarColaborador(cpf, nome, dataNascimento, dataContratacao, email);

            bo.criar(colaborador);
            view.mostrar("\nColaborador criado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    public void listandoTodos() {
        List<Colaborador> colaboradores = bo.listarTodos();
        if (colaboradores.isEmpty())
            view.mostrar("\nNenhum colaborador encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os colaboradores: ");
            view.listarTodos(colaboradores);
        }
    }

    public void buscarPorCpf(String cpf) {
        Colaborador colaborador = bo.buscarPeloCpf(cpf);
        if (colaborador != null) {
            view.mostrar("Colaborador encontrado: ");
            view.exibirColaborador(colaborador);
        } else {
            view.mostrar("Nenhum colaborador encontrado!!!");
        }
    }

    public void atualizar(String cpf) {
        try{
            Colaborador novoColaborador;
            String email = view.inputEmail();
            novoColaborador = bo.validarNovoColaborador(email);

            bo.atualizar(cpf, novoColaborador);
            view.mostrar("\nColaborador foi atualizado com sucesso!");
        } catch (Exception e) {
            view.mostrar(e.getMessage());
        }
    }

    public void excluir(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            view.mostrar("\nCpf inválido!!!");
        } else {
            bo.excluir(cpf);
            view.mostrar("\nColaborador excluído com sucesso!!!");
        }
    }
}
