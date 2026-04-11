package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de Validacao.
 * Camada: VO.
 */
public class Validacao {
    /**
     * Executa validacoes de dados e regras de negocio do modulo.
     * @param cpf parametro da operacao.
     * @return resultado da operacao.
     */
    public static boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
