package RaizDoBem.View;

import RaizDoBem.Model.DAO.EnderecoDAO;
import RaizDoBem.Model.Endereco;

import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de gerenciamento de endereços e interagir com o usuário para realizar as operações relacionadas aos endereços.
 * @author Paulo
 * @since 2026-03
 *
 *
 *
 */
public class MenuEnderecos {
    public void menuEnderecos(){
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = new Endereco();
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("\n      Gerenciar Endereços     ");
        System.out.println("        1.  Adicionar endereço");
        System.out.println("        2.  Listar todos os endereços");
        System.out.println("        3.  Listar endereço pelo ID");
        System.out.println("        4.  Listar endereço por cidade");
        System.out.println("        5.  Atualizar endereço");
        System.out.println("        6.  Excluir endereço");
        System.out.println("        7.  Voltar ao menu principal");
        System.out.println("        0.  Encerrar programa");
        System.out.println("Selecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                Endereco e1 = endereco.criarEndereco();
                enderecoDAO.adicionar(e1);
                break;
            case 2:
                System.out.println("Listagem dos endereços: ");
                enderecoDAO.listarTodos();
                break;
            case 3:
                id = endereco.entradaId();
                enderecoDAO.buscarPorId(id);
                break;
            case 4:
                String cidade = endereco.entradaCidade();
                enderecoDAO.listarPorCidade(cidade);
                break;
            case 5:
                id = endereco.entradaId();
                Endereco enderecoMapeado = enderecoDAO.buscarPorId(id);
                if(enderecoMapeado == null){
                    System.out.println("Endereço não encontrado!!!");
                    break;
                }
                Endereco novoEndereco = endereco.criarEndereco();
                enderecoDAO.atualizarEndereco(id, novoEndereco);
                break;
            case 6:
                id = endereco.entradaId();
                enderecoDAO.excluirEndereco(id);
                break;
            case 7:
                System.out.println("Voltando ao menu principal...");
                break;
            case 0:
                System.out.println("Encerrando programa...");
                System.exit(0);
            default:
                System.out.println("Opção Inválida");
        }
    }
}
