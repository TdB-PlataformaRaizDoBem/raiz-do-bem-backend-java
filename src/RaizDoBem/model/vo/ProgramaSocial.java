package RaizDoBem.model.vo;

/**
 * Representa um programa social oferecido pela ONG. Cada programa social tem um identificador único e um nome que descreve o programa. Esta classe é utilizada para armazenar e manipular informações sobre os programas sociais disponíveis para os beneficiários da ONG.
 * @author Paulo
 * @since 2026-03
 * @param id Identificador único do programa social.
 * @param programa Nome do programa social, utilizado para descrever o tipo de assistência ou serviço oferecido aos beneficiários.
 */
public class ProgramaSocial {
    private int id;
    private String programa;

    public int getId() {
        return id;
    }

    public String getPrograma() {
        return programa;
    }

    public ProgramaSocial setId(int id) {
        this.id = id;
        return this;
    }

    public ProgramaSocial setPrograma(String programa) {
        this.programa = programa;
        return this;
    }

    public ProgramaSocial(int id, String programa) {
        this.id = id;
        this.programa = programa;
    }

    public ProgramaSocial() {
    }

    @Override
    public String toString() {
        return programa;
    }
}
