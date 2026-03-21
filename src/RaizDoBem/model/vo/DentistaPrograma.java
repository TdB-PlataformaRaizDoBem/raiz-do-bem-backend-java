package RaizDoBem.model.vo;

/**
 * Relação entre um dentista e um programa social. Cada dentista pode estar associado a vários programas sociais, e cada programa social pode ter vários dentistas associados. Esta classe é utilizada para modelar essa relação muitos-para-muitos.
 * @author Paulo
 * @since 2025-09
 * @param dentista Referência ao dentista, utilizando a classe Dentista.
 * @param programa Referência ao programa social, utilizando a classe ProgramaSocial.
 *
 * - O dentista João pode estar associado ao programa "Dentista do Bem", oferecendo atendimento odontológico para crianças em situação de vulnerabilidade social.
 * - O dentista Maria pode estar associada ao programa "Apolônias do Bem", auxiliando mulheres que sofreram algum tipo de violência, em situação de vulnerabilidade social.
 * - O programa "Dentista do Bem" pode ter vários dentistas associados, como João, Ana e Carlos, que oferecem atendimento odontológico para crianças em situação de vulnerabilidade social.
 */
public class DentistaPrograma {
    private Dentista dentista;
    private ProgramaSocial programa;

    public Dentista getDentista() {
        return dentista;
    }

    public DentistaPrograma setDentista(Dentista dentista) {
        this.dentista = dentista;
        return this;
    }

    public ProgramaSocial getPrograma() {
        return programa;
    }

    public DentistaPrograma setPrograma(ProgramaSocial programa) {
        this.programa = programa;
        return this;
    }

    public DentistaPrograma(Dentista dentista, ProgramaSocial programa) {
        this.dentista = dentista;
        this.programa = programa;
    }
}
