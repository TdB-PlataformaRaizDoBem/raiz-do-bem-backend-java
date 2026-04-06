package RaizDoBem.model.vo;

/**
 * Representa a relação entre um dentista e uma especialidade. Cada dentista pode ter várias especialidades, e cada especialidade pode ser associada a vários dentistas. Esta classe é utilizada para modelar essa relação muitos-para-muitos.
 * @author Paulo
 * @since 2025-09
 * @param dentista Referência ao dentista, utilizando a classe Dentista.
 * @param especialidade Referência à especialidade, utilizando a classe Especialidade.
 *
 * Exemplo:
 * - Um dentista pode ter as seguintes especialidades: Ortodontia, Endodontia, Periodontia.
 * - A especialidade de Ortodontia pode ser associada a vários dentistas,
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
