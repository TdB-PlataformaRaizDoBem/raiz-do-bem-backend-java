package RaizDoBem.Model;

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
