package RaizDoBem.test;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;
import RaizDoBem.view.EnderecoView;
import com.google.gson.Gson;

import java.util.List;

public class EnderecoTeste {
    public static void main(String[] args) {
        EnderecoView view = new EnderecoView();
        EnderecoController controller = new EnderecoController(view);


//      //1º Metodo - Criação
//      controller.adicionar();
//
//      //2º Metodo - Listando todos
        controller.listandoTodos();
//
//      //3º Metodo - Listando apenas pelo Id
//      int id = view.entradaId();
//      controller.listarPorId(id);
//
//      //4º Metodo - Listando por cidade
//      String cidade = view.entradaCidade();
//      controller.listandoPorCidade(cidade);
//
//      //5º Metodo - Atualizando
        int id = view.entradaId();
        controller.atualizar(id);
//
//      //6º Metodo - Excluindo
//      int id = view.entradaId();
//      controller.deletar(id);

        controller.listandoTodos();
    }
}
