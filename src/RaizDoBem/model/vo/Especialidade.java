package RaizDoBem.model.vo;

/**
 * Representa as especialidades odontológicas, contendo informações como idEspecialidade e descrição. Esta classe é utilizada para modelar as especialidades associadas aos dentistas.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único da especialidade.
 * @param descricao Descrição da especialidade odontológica.
 */
public class Especialidade {
    private int idEspecialidade;
    private String descricao;

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Especialidade(int idEspecialidade, String descricao) {
        this.idEspecialidade = idEspecialidade;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return idEspecialidade +
                " - " + descricao;
    }
}
