package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Requisito para poder criar um beneficiário. Contém informações sobre o problema descrito, dados de contato da pessoa alv, data do pedido e status do pedido.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do pedido de ajuda.
 * @param cpf CPF do beneficiário que fez o pedido de ajuda, utilizado para identificação.
 * @param descricaoProblema Descrição detalhada do problema ou necessidade relatada pelo beneficiário.
 * @param nomeCompleto Nome completo do beneficiário que fez o pedido de ajuda.
 * @param telefone Número de telefone do beneficiário para contato.
 * @param email Endereço de email do beneficiário para contato.
 * @param data Data em que o pedido de ajuda foi registrado.
 * @param status Referência ao status atual do pedido de ajuda, utilizando a classe StatusPedido.
 */

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

    public PedidoAjuda setId(int id) {
        this.id = id;
        return this;
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

    public PedidoAjuda(int id, String cpf,  String descricaoProblema, String nomeCompleto, String telefone, String email, LocalDate data, int idStatusPedido) {
        this.id = id;
        this.cpf = cpf;
        this.descricaoProblema = descricaoProblema;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.data = data;
        this.status = new StatusPedido();
        this.status.setId(idStatusPedido);
    }

    public PedidoAjuda() {
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
