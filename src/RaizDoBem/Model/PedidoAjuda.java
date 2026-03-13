package RaizDoBem.Model;
//Verificado Sp02
import java.time.LocalDate;

public class PedidoAjuda {
    private int idPedido;
    private String descricaoProblema;
    private LocalDate dataPedido;
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


    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public PedidoAjuda(int idPedido, String descricaoProblema, LocalDate dataPedido, String statusPedido) {
        this.idPedido = idPedido;
        this.descricaoProblema = descricaoProblema;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }
}
