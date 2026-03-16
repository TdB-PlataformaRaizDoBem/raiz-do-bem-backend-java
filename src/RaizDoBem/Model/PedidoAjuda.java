package RaizDoBem.Model;
//Verificado Sp02
import java.time.LocalDate;

public class PedidoAjuda {
    private int idPedido;
    private String descricaoProblema;
    private String nomeCompleto;
    private String telefone;
    private String email;
    private LocalDate dataPedido;
    private Coordenador coordenador;
    private StatusPedido status;

    public int getIdPedido() {
        return idPedido;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public PedidoAjuda setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
        return this;
    }

    public PedidoAjuda setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public PedidoAjuda setEmail(String email) {
        this.email = email;
        return this;
    }

    public PedidoAjuda setStatus(StatusPedido status) {
        this.status = status;
        return this;
    }

    public PedidoAjuda(int idPedido, String descricaoProblema, String nomeCompleto, String telefone, String email, LocalDate dataPedido, Coordenador coordenador, StatusPedido status) {
        this.idPedido = idPedido;
        this.descricaoProblema = descricaoProblema;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.dataPedido = dataPedido;
        this.coordenador = coordenador;
        this.status = status;
    }
}
