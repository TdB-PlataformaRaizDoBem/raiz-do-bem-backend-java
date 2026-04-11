package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe VO que representa os dados de dominio de PedidoAjuda.
 * Camada: VO.
 */
public class PedidoAjuda {
    private int idPedido;
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

    public int getIdPedido() {
        return idPedido;
    }

    public PedidoAjuda setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public PedidoAjuda(int idPedido, String cpf, String nomeCompleto, LocalDate dataNascimento, Sexo sexo, String telefone, String email, String descricaoProblema, LocalDate dataPedido, StatusPedido status, int idEndereco, int idDentista) {
        this.idPedido = idPedido;
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
        this.idDentista = idDentista;
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
        this.status = StatusPedido.PENDENTE;
        this.idEndereco = idEndereco;
        this.idDentista = getIdDentista();
    }

    public PedidoAjuda() {
    }

    @Override
    public String toString() {
        return "\n" + idPedido +
                " - Solicitante: " + nomeCompleto +
                " - Cpf: " + cpf +
                "\n     Descrição: " + descricaoProblema +
                "\n     Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Sexo: " + sexo +
                "\n     Telefone: " + telefone +
                " - email: " + email +
                "\n     Data do Pedido: " + dataPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - status: " + status;
    }
}
