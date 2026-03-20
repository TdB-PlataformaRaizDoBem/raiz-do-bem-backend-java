package RaizDoBem.Model;
//Verificado Sp02
import java.time.LocalDate;

public class PedidoAjuda {
    private int id;
    private String cpf;
    private String descricaoProblema;
    private String nomeCompleto;
    private String telefone;
    private String email;
    private LocalDate data;
    private StatusPedido status;

    public int getId() {
        return id;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public String getCpf() {
        return cpf;
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

    public PedidoAjuda(int id, String cpf,  String descricaoProblema, String nomeCompleto, String telefone, String email, LocalDate data, StatusPedido status) {
        this.id = id;
        this.cpf = cpf;
        this.descricaoProblema = descricaoProblema;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.data = data;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", CPF: " + cpf + "\nDescrição: " + descricaoProblema + "\nNomeCompleto" + nomeCompleto +
                "\nTelefone:" + telefone +
                ", Email" + email +
                "\nData do pedido de ajuda: " + data +
                ", status: " + status;
    }
}
