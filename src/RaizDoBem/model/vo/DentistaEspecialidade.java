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
    private Dentista dentista;
    private Especialidade especialidade;

    public Dentista getDentista() {
        return dentista;
    }

    public DentistaEspecialidade setDentista(Dentista dentista) {
        this.dentista = dentista;
        return this;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public DentistaEspecialidade setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
        return this;
    }

    public DentistaEspecialidade(Dentista dentista, Especialidade especialidade) {
        this.dentista = dentista;
        this.especialidade = especialidade;
    }
}
