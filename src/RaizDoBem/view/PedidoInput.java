package RaizDoBem.view;

import RaizDoBem.controller.PedidoAjudaController;
import RaizDoBem.model.vo.PedidoAjuda;

import java.time.LocalDate;
import java.util.Scanner;

public class PedidoInput {
    Scanner sc = new Scanner(System.in);
    PedidoAjudaController controller = new PedidoAjudaController();
    public PedidoAjuda criar(){


        return new PedidoAjuda(
                cpf,
                descricaoProblema
                nomeCompleto,
                telefone,
                email,
                data,
                idStatus
        );
    }
}
