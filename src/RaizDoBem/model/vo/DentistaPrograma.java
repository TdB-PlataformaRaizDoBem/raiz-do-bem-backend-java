package RaizDoBem.model.vo;

/**
 * Relação entre um idDentista e um idPrograma social. Cada idDentista pode estar associado a vários programas sociais, e cada idPrograma social pode ter vários dentistas associados. Esta classe é utilizada para modelar essa relação muitos-para-muitos.
 * @author Paulo
 * @since 2025-09
 * @param dentista Referência ao idDentista, utilizando a classe Dentista.
 * @param programa Referência ao idPrograma social, utilizando a classe ProgramaSocial.
 *
 * - O idDentista João pode estar associado ao idPrograma "Dentista do Bem", oferecendo atendimento odontológico para crianças em situação de vulnerabilidade social.
 * - O idDentista Maria pode estar associada ao idPrograma "Apolônias do Bem", auxiliando mulheres que sofreram algum tipo de violência, em situação de vulnerabilidade social.
 * - O idPrograma "Dentista do Bem" pode ter vários dentistas associados, como João, Ana e Carlos, que oferecem atendimento odontológico para crianças em situação de vulnerabilidade social.
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
