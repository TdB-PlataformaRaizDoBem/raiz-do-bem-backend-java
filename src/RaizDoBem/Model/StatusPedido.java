package RaizDoBem.Model;

public class StatusPedido {
    private final int id;
    private final String situacao;

    public int getId() {
        return id;
    }

    public String getSituacao() {
        return situacao;
    }

    public StatusPedido(int id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }
}
