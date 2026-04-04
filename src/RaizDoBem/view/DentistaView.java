package RaizDoBem.view;

import RaizDoBem.controller.DentistaController;
import RaizDoBem.model.dao.DentistaDAO;
import RaizDoBem.model.vo.Dentista;
import RaizDoBem.model.vo.Endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de menu para gerenciar os dentistas que prestarão serviço a ONG. Esta classe é responsável por exibir as opções de gerenciamento de dentistas, como criar, listar, atualizar e excluir dentistas. Ela interage com o DentistaController para realizar as operações necessárias e fornecer uma interface amigável para o usuário.
 * @author Paulo
 * @since 2026-03
 *
 * @see DentistaController
 * @see DentistaDAO
 * @see Dentista
 */
public class DentistaView {
    Scanner sc = new Scanner(System.in);
    public void menu() {
        Dentista dentista = new Dentista();

        String cpf = "";


//            case 1:
//                controller.criarDentista(dentista);
//                break;
//            case 2:
//                dentistas = controller.listarTodos();
//                System.out.println("Listagem dos dentistas: ");
//                for (Dentista d : dentistas) {
//                    System.out.println(d);
//                }
//                break;
//            case 3:
//                String cidade = ""; //falta input cidade
//                controller.listagemPorCidade(cidade);
//                break;
//            case 4:
//                controller.listarDisponiveis();
//                break;
//            case 5:
//                cpf = ""; //falta input cpf
//                dentista = controller.buscaPorCpf(cpf);
//                controller.atualizarDentista(cpf, dentista);
//                break;
//            case 6:
//                cpf = ""; //falta input cpf
//                dentista = controller.buscaPorCpf(cpf);
//                controller.excluirDentista(cpf);
//                //System.out.println("Dentista foi excluído com sucesso!!!");
//                break;
//            case 7:
//                System.out.println("Voltando ao menu principal...");
//                break;
//            case 0:
//                System.out.println("Encerrando programa...");
//                System.exit(0);
//            default:
//                System.out.println("Opção Inválida");
//
    }
    public String inputCpf(){
        System.out.println("Digite o CPF do dentista: ");
        return sc.nextLine();
    }

    public void exibirEndereco(Dentista dentista){
        System.out.println(dentista);
    }
    public void exibirMensagem(String msg){
        System.out.println(msg);
    }

    public void exibirLista(List<Dentista> lista){
        for (Dentista elemento : lista){
            exibirEndereco(elemento);
        }
    }
}