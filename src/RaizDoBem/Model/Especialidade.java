package RaizDoBem.Model;

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
}
