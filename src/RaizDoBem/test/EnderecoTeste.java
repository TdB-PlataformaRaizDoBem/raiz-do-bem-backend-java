package RaizDoBem.test;

import RaizDoBem.controller.EnderecoController;
import RaizDoBem.model.dao.EnderecoDAO;
import RaizDoBem.model.vo.Endereco;
import RaizDoBem.model.vo.TipoEndereco;
import RaizDoBem.view.EnderecoView;
import com.google.gson.Gson;

public class EnderecoTeste {
    public static void main(String[] args) {
        Endereco end1 = new Endereco("Rua João Távora", "03978020", "220", "Jardim Adutora", "São Paulo", "São Paulo", TipoEndereco.RESIDENCIAL);
        Endereco end2 = new Endereco("Avenida Paulista", "01310946", "1200","Jardim Paulista", "São Paulo", "São Paulo", TipoEndereco.PROFISSIONAL);
        Endereco end3 = new Endereco("Avenida dos Estados", "09290520", "93"," Jd Santo André", "Santo André", "São Paulo", TipoEndereco.RESIDENCIAL);
        Endereco end4 = new Endereco("Avenida Brasil", "20940-070", "1222"," Jd Santo André", "São Cristóvão", "Rio de Janeiro", TipoEndereco.PROFISSIONAL);
        EnderecoView view = new EnderecoView();
        EnderecoController controller = new EnderecoController(view);

        String cep = "03978020";
        //System.out.println(controller.buscarInformacoesEndereco(cep));
        Gson gson = new Gson();
        String endereco = gson.toJson(end2);

//        //1º Metodo - Criação
//        controller.adicionar();
//
//        //2º Metodo - Listando todos
//        controller.listandoTodos();
//
//        //3º Metodo - Listando apenas pelo Id
//        int id = view.entradaId();
//        controller.listarPorId(id);
//
//        //4º Metodo - Listando por cidade
//        String cidade = view.entradaCidade();
//        controller.listandoPorCidade(cidade);
//
//        //5º Metodo - Atualizando
//        id = view.entradaId();
//        controller.atualizar(id);
//
//        //6º Metodo - Excluindo
//        id = view.entradaId();
//        controller.deletar(id);

        EnderecoDAO dao = new EnderecoDAO();
        dao.adicionar(end4);

    }
}
