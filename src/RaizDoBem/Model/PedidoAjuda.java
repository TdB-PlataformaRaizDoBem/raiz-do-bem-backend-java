package RaizDoBem.Model;
//Verificado Sp02
import java.time.LocalDate;

public class PedidoAjuda {
    private int idPedido;
    private String descricao;
    private LocalDate dataPedido;
    private String urgencia;
    private String statusPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public String getDescricao() {
        return descricao;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public PedidoAjuda(int idPedido, String descricao, LocalDate dataPedido, String urgencia, String statusPedido) {
        this.idPedido = idPedido;
        this.descricao = descricao;
        this.dataPedido = dataPedido;
        this.urgencia = urgencia;
        this.statusPedido = statusPedido;
    }
}
