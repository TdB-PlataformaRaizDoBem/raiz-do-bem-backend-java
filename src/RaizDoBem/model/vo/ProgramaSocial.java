package RaizDoBem.model.vo;

/**
 * Representa um programa social oferecido pela ONG. Cada programa social tem um identificador único e um nome que descreve o programa. Esta classe é utilizada para armazenar e manipular informações sobre os programas sociais disponíveis para os beneficiários da ONG.
 * @author Paulo
 * @since 2026-03
 * @param idPrograma O identificador único do programa social.
 * @param programa O nome do programa social, que descreve o tipo de assistência ou serviço oferecido pela ONG aos beneficiários.
 */
public class ProgramaSocial {
    private int idPrograma;
    private String programa;

    public int getIdPrograma() {
        return idPrograma;
    }

    public String getPrograma() {
        return programa;
    }

    public ProgramaSocial setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
        return this;
    }

    public ProgramaSocial setPrograma(String programa) {
        this.programa = programa;
        return this;
    }

    public ProgramaSocial(int idPrograma, String programa) {
        this.idPrograma = idPrograma;
        this.programa = programa;
    }

    public ProgramaSocial() {
    }

    @Override
    public String toString() {
        return idPrograma +
                " - " + programa;
    }
}
