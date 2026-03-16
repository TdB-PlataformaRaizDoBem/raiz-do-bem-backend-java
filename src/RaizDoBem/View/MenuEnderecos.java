package RaizDoBem.View;

import RaizDoBem.DAO.EnderecoDAO;
import RaizDoBem.Model.Endereco;

import java.util.Scanner;

public class MenuEnderecos {
    public void menuEnderecos(){
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Gerenciar Endereços ---");
        System.out.println("1.  Adicionar endereço");
        System.out.println("2.  Listar todos os endereços");
        System.out.println("3.  Listar endereço pelo ID");
        System.out.println("4.  Listar endereço por cidade");
        System.out.println("5.  Atualizar endereço");
        System.out.println("6.  Excluir endereço");
        System.out.println("7.  Voltar ao menu principal");
        System.out.println("0.  Encerrar programa");
        System.out.print("Selecione uma opção: ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc){
            case 1:
                Endereco endereco = null;
                enderecoDAO.adicionar(endereco);
                break;
            case 2:
                enderecoDAO.listarTodos();
                break;
            case 3:
                //enderecoDAO.listar(parametro_id);
                break;
            case 4:
                //enderecoDAO.listar(parametro_cidade);
                break;
            case 5:
                System.out.println("Atualizar endereço:");
                break;
            case 6:
                System.out.println("Excluir endereço:");
                break;
            case 7:
                System.out.println("Voltando ao menu principal...");
                break;
            case 0:
                System.out.println("Encerrando programa...");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }
}
