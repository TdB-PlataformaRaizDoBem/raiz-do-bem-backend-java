package RaizDoBem.Model;

/**
 * Representa as especialidades odontológicas, contendo informações como id e descrição. Esta classe é utilizada para modelar as especialidades associadas aos dentistas.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único da especialidade.
 * @param descricao Descrição da especialidade odontológica.
 */
public class Especialidade {
    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Especialidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
