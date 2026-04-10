package RaizDoBem.controller;

import RaizDoBem.model.bo.BeneficiarioBO;
import RaizDoBem.model.vo.Beneficiario;
import RaizDoBem.model.vo.Validacao;
import RaizDoBem.view.BeneficiarioView;

import java.util.List;

/**
 * Classe responsável por controlar as operações relacionadas aos beneficiários,
 * como criação, listagem, busca, atualização e exclusão, utilizando o BeneficiarioBO para acessar os dados.
 *
 * @author Paulo
 * @since 2026-03
 *
 * 1º Metodo - criar: Solicita ao usuário as informações necessárias para criar um novo beneficiário, como ID do pedido e ID do programa social. Em seguida, utiliza o BeneficiarioBO para validar os dados e criar o beneficiário, exibindo uma mensagem de sucesso ou erro conforme o resultado da operação.
 * 2º Metodo - listandoTodos: Recupera a lista de todos os beneficiários utilizando o BeneficiarioBO e exibe os beneficiários para o usuário. Se não houver beneficiários cadastrados, exibe uma mensagem informando que nenhum beneficiário foi encontrado.
 * 3º Metodo - buscarPorCpf: Solicita ao usuário o CPF do beneficiário e utiliza o BeneficiarioBO para buscar o beneficiário correspondente. Se um beneficiário for encontrado, exibe suas informações para o usuário; caso contrário, exibe uma mensagem informando que nenhum beneficiário foi encontrado.
 * 4º Metodo - listarPorPrograma: Solicita ao usuário o ID do programa social e utiliza o BeneficiarioBO para buscar os beneficiários correspondentes a esse programa. Se beneficiários forem encontrados, exibe suas informações para o usuário; caso contrário, exibe uma mensagem informando que nenhum beneficiário foi encontrado.
 * 5º Metodo - listarPorCidade: Solicita ao usuário o nome da cidade e utiliza o BeneficiarioBO para buscar os beneficiários correspondentes a essa cidade. Se beneficiários forem encontrados, exibe suas informações para o usuário; caso contrário, exibe uma mensagem informando que nenhum beneficiário foi encontrado.
 * 6º Metodo - atualizar: Solicita ao usuário o CPF do beneficiário a ser atualizado, bem como as informações necessárias para a atualização, como telefone, email e ID do endereço. Em seguida, utiliza o BeneficiarioBO para validar os dados e atualizar o beneficiário, exibindo uma mensagem de sucesso ou erro conforme o resultado da operação.
 * 7º Metodo - excluir: Solicita ao usuário o CPF do beneficiário a ser excluído. Se o CPF for válido, utiliza o BeneficiarioBO para excluir o beneficiário correspondente e exibe uma mensagem de sucesso. Caso contrário, exibe uma mensagem informando que o CPF é inválido.
 * Esses métodos permitem que o usuário interaja com a funcionalidade de beneficiário, fornecendo as informações necessárias para criar, listar, buscar, atualizar e excluir beneficiários, e visualizando os resultados das operações realizadas.
 *
 */
public class BeneficiarioController {
    private BeneficiarioView view;
    private BeneficiarioBO bo;

    public BeneficiarioController(BeneficiarioView view) {
        this.view = view;
        this.bo = new BeneficiarioBO();
    }

    public BeneficiarioController() {
    }

    public void criar() {
        try{
            view.mostrar("\nCriando beneficiário: ");
            int idPedido = view.inputId();
            int idProgramaSocial = view.inputPrograma();

            bo.adicionar(idPedido, idProgramaSocial);
            view.mostrar("\nBeneficiário criado com sucesso!!!");
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    public void listandoTodos(){
        List<Beneficiario> beneficiarios = bo.listarBeneficiarios();
        if (beneficiarios.isEmpty())
            view.mostrar("\nNenhum beneficiário encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os beneficiários: ");
            view.listarTodos(beneficiarios);
        }
    }

    public void buscarPorCpf(String cpf) {
        Beneficiario beneficiario = bo.buscaPorCpf(cpf);
        if (beneficiario != null) {
            view.mostrar("\nBeneficiário encontrado: ");
            view.exibirBeneficiario(beneficiario);
        } else
            view.mostrar("\nNenhum beneficiário encontrado!!!");
    }

    public void listarPorPrograma(int id) {
        List<Beneficiario> beneficiarios = bo.listagemPorPrograma(id);
        if (beneficiarios.isEmpty())
            view.mostrar("\nNenhum beneficiário encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os beneficiários do programa social: ");
            view.listarTodos(beneficiarios);
        }
    }

    public void listarPorCidade(String cidade) {
        List<Beneficiario> beneficiarios = bo.listagemPorCidade(cidade);
        if (beneficiarios.isEmpty())
            view.mostrar("\nNenhum beneficiário encontrado!!!");
        else {
            view.mostrar("\nExibindo todos os beneficiários da cidade " + cidade + ": ");
            view.listarTodos(beneficiarios);
        }
    }

    public void atualizar(String cpf) {
        try {
            view.mostrar("Atualizando beneficiário: ");
            if (Validacao.validarCpf(cpf)) {
                String telefone = view.inputTelefone();
                String email = view.inputEmail();
                int idEndereco = view.inputIdEndereco();

                Beneficiario beneficiarioAtualizado = bo.validarNovoBeneficiario(telefone, email, idEndereco);

                bo.atualizarBeneficiario(cpf, beneficiarioAtualizado);
                view.mostrar("\nBeneficiário atualizado com sucesso!!!");
            }
        } catch (RuntimeException e) {
            view.mostrar(e.getMessage());
        }
    }

    public void excluir(String cpf) {
        if (!Validacao.validarCpf(cpf)) {
            view.mostrar("\nCpf inválido!!!");
        } else {
            bo.excluirBeneficiario(cpf);
            view.mostrar("\nBeneficiário excluído com sucesso!!!");
        }
    }
}
