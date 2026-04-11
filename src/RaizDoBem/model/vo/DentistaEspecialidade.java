package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de DentistaEspecialidade.
 * Camada: VO.
 */
public class DentistaEspecialidade {
    private int idDentista;
    private int idEspecialidade;

    public int getIdDentista() {
        return idDentista;
    }

    public DentistaEspecialidade setIdDentista(int idDentista) {
        this.idDentista = idDentista;
        return this;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public DentistaEspecialidade setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
        return this;
    }

    public DentistaEspecialidade(int idDentista, int idEspecialidade) {
        this.idDentista = idDentista;
        this.idEspecialidade = idEspecialidade;
    }

    @Override
    public String toString() {
        return "Dentista ID:" + idDentista +
                " - Especialidade ID: " + idEspecialidade;
    }
}
