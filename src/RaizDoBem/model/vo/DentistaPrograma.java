package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de DentistaPrograma.
 * Camada: VO.
 */
public class DentistaPrograma {
    private int idDentista;
    private int idPrograma;

    public int getIdDentista() {
        return idDentista;
    }

    public DentistaPrograma setIdDentista(int idDentista) {
        this.idDentista = idDentista;
        return this;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public DentistaPrograma setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
        return this;
    }

    /**
 * Construtor vazio.
 */
    public DentistaPrograma(int idDentista, int idPrograma) {
        this.idDentista = idDentista;
        this.idPrograma = idPrograma;
    }

    @Override
    public String toString() {
        return "Dentista: "+ idDentista +
                " atende - Programa Social:" + idPrograma +
                '}';
    }
}
