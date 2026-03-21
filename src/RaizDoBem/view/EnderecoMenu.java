package RaizDoBem.view;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de gerenciamento de endereços e interagir com o usuário para realizar as operações relacionadas aos endereços.
 * @author Paulo
 * @since 2026-03
 *
 * @see EnderecoController
 * @see EnderecoDAO
 * @see EnderecoInput
 *
 */
public class EnderecoMenu {
    public void menuEnderecos(){
        EnderecoController controller = new EnderecoController();
        EnderecoInput enderecoInput = new EnderecoInput();
        Scanner sc = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
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
                Endereco endereco = enderecoInput.criar();
                controller.criarEndereco(endereco);
                break;
            case 2:
                enderecos = controller.listarEnderecos();
                System.out.println("Listagem dos endereços: ");
                for (int i = 0; i < enderecos.size(); i++) {
                    System.out.println(enderecos.get(i));
                }
                break;
            case 3:
                id = enderecoInput.inputId();
                endereco = controller.buscaPorId(id);
                System.out.println(endereco);
                break;
            case 4:
                String cidade = enderecoInput.inputCidade();
                enderecos = controller.listagemPorCidade(cidade);
                for (int i = 0; i < enderecos.size(); i++) {
                    System.out.println(enderecos.get(i));
                }
                break;
            case 5:
                id = enderecoInput.inputId();
                Endereco novoEndereco = enderecoInput.criar();
                controller.atualizarEndereco(id, novoEndereco);
                System.out.println("Endereço "+ id + " atualizado com sucesso!!!");
                break;
            case 6:
                id = enderecoInput.inputId();
                controller.excluirEndereco(id);
                System.out.println("Endereço "+ id + " excluído com sucesso!!!");
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
