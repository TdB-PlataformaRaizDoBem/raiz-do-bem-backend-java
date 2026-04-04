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
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String telefone;
    private String email;
    private String descricaoProblema;
    private LocalDate dataPedido;
    private StatusPedido status;
    private int idEndereco;
    private int idDentista;

    public int getId() {
        return id;
    }

    public PedidoAjuda setId(int id) {
        this.id = id;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PedidoAjuda setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public PedidoAjuda setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public PedidoAjuda setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public PedidoAjuda setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public PedidoAjuda setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public PedidoAjuda setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PedidoAjuda setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public PedidoAjuda setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
        return this;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public PedidoAjuda setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
        return this;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public PedidoAjuda setStatus(StatusPedido status) {
        this.status = status;
        return this;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public PedidoAjuda setIdDentista(int idDentista) {
        this.idDentista = idDentista;
        return this;
    }

    public PedidoAjuda(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, Sexo sexo, String telefone, String email, String descricaoProblema, LocalDate dataPedido, StatusPedido status, int idEndereco, int idDentista) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.descricaoProblema = descricaoProblema;
        this.dataPedido = dataPedido;
        this.status = status;
        this.idEndereco = idEndereco;
    }

    public PedidoAjuda(String cpf, String nomeCompleto, LocalDate dataNascimento, Sexo sexo, String telefone, String email, String descricaoProblema, int idEndereco) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.descricaoProblema = descricaoProblema;
        this.dataPedido = LocalDate.now();
        this.status = StatusPedido.AGUARDANDO;
        this.idEndereco = idEndereco;
    }

    public PedidoAjuda() {
    }

    @Override
    public String toString() {
        return "PedidoAjuda{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", data=" + dataPedido.toString() +
                ", status=" + status +
                '}';
    }
}
