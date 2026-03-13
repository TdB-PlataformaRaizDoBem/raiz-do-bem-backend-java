package RaizDoBem.Model;
//Verificado Sp02
import java.time.LocalDate;

public class PedidoAjuda {
    private int idPedido;
    private String descricaoProblema;
    private LocalDate dataPedido;
    private String urgencia;
    private String statusPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public PedidoAjuda(int idPedido, String descricaoProblema, LocalDate dataPedido, String urgencia, String statusPedido) {
        this.idPedido = idPedido;
        this.descricaoProblema = descricaoProblema;
        this.dataPedido = dataPedido;
        this.urgencia = urgencia;
        this.statusPedido = statusPedido;
    }
}
