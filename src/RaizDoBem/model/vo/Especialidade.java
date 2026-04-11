package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de Especialidade.
 * Camada: VO.
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
        return idEspecialidade + " - " + descricao;
    }
}
