package RaizDoBem.model.vo;

/**
 *
 */
public class Validacao {
    public boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
