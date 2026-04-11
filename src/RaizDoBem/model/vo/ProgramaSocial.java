package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de ProgramaSocial.
 * Camada: VO.
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
        return idPrograma + " - " + programa;
    }
}
