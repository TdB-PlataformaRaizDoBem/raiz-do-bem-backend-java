package RaizDoBem.Controller;

import java.util.List;

public interface Gerenciador<Tipo>{

    void adicionar(Tipo tipo);
    List<Tipo> listarTodos();
    void receberSalvarDados();
}
