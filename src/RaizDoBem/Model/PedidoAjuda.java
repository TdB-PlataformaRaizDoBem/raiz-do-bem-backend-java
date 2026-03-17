package RaizDoBem.Model;
//Verificado Sp02
import java.time.LocalDate;

public class PedidoAjuda {
    private int id;
    private String descricaoProblema;
    private String nomeCompleto;
    private String telefone;
    private String email;
    private LocalDate data;
    private Coordenador coordenador;
    private StatusPedido status;

    public int getId() {
        return id;
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

    public LocalDate getData() {
        return data;
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

    public PedidoAjuda(int id, String descricaoProblema, String nomeCompleto, String telefone, String email, LocalDate data, Coordenador coordenador, StatusPedido status) {
        this.id = id;
        this.descricaoProblema = descricaoProblema;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.data = data;
        this.coordenador = coordenador;
        this.status = status;
    }
}
