package RaizDoBem.model.vo;

/**
 * Relação entre um idDentista e um idPrograma social. Cada idDentista pode estar associado a vários programas sociais, e cada idPrograma social pode ter vários dentistas associados. Esta classe é utilizada para modelar essa relação muitos-para-muitos.
 * @author Paulo
 * @since 2025-09
 * @see DentistaProgramaDAO
 * Exemplo:
 * - Um dentista pode estar associado aos seguintes programas sociais: Programa de Saúde Bucal, Programa de Atendimento a Populações Vulneráveis, Programa de Prevenção ao Câncer Bucal.
 * - O Programa de Saúde Bucal pode ter vários dentistas associados, como o Dr. João, a Dra. Maria e o Dr. Carlos.
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
