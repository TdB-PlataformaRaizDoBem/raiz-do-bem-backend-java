package RaizDoBem.Model;

/**
 * Representa um programa social do projeto Raiz do Bem, contendo informações como id e nome do programa. Esta classe é utilizada para modelar os programas sociais associados aos colaboradores e dentistas.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do programa social.
 * @param programa Nome do programa social.
 *
 * Exemplos de programas sociais da ONG:
 * - Dentista do Bem: Programa que oferece atendimento odontológico para crianças em situação de vulnerabilidade social.
 * - Apolônias do Bem: Programa que auxilia mulheres que sofreram algum tipo de violência, em situação de vulnerabilidade social.
 *
 *
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
