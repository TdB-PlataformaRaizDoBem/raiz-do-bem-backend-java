package RaizDoBem.Model;

public class StatusPedido {
    private int id;
    private String situacao;

    public int getId() {
        return id;
    }

    public String getSituacao() {
        return situacao;
    }

    public StatusPedido setId(int id) {
        this.id = id;
        return this;
    }

    public StatusPedido setSituacao(String situacao) {
        this.situacao = situacao;
        return this;
    }

    public StatusPedido(int id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public StatusPedido() {
    }

    @Override
    public String toString() {
        return "\n" + id + " - Status: " + situacao;

    }
}
