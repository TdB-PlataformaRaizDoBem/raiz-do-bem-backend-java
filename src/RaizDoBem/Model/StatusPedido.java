package RaizDoBem.Model;

public class StatusPedido {
    private int idStatus;
    private String situacao;

    public int getIdStatus() {
        return idStatus;
    }

    public String getSituacao() {
        return situacao;
    }

    public StatusPedido(int idStatus, String situacao) {
        this.idStatus = idStatus;
        this.situacao = situacao;
    }
}
