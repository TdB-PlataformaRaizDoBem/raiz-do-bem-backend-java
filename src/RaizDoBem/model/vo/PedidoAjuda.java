package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Requisito para poder criar um beneficiário. Contém informações sobre o problema descrito, dados de contato da pessoa alv, data do pedido e status do pedido.
    * @author Paulo
    * @since 2026-03
    * @param id Identificador único do pedido de ajuda.
    * @param cpf CPF do solicitante, utilizado para identificação.
    * @param nomeCompleto Nome completo do solicitante.
    * @param dataNascimento Data de nascimento do solicitante, utilizada para calcular a idade e
    * verificar elegibilidade para determinados programas sociais ou atendimentos.
    * @param sexo Sexo do solicitante, utilizado para registro e comunicação adequada.
    * @param telefone Número de telefone do solicitante, utilizado para contato e comunicação.
    * @param email Endereço de e-mail do solicitante, utilizado para comunicação e envio de informações relevantes relacionadas ao pedido de ajuda.
    * @param descricaoProblema Descrição detalhada do problema enfrentado pelo solicitante, incluindo informações sobre a situação odontológica, dificuldades financeiras ou outras necessidades que motivaram a solicitação de ajuda.
    * @param dataPedido Data em que o pedido de ajuda foi realizado, permitindo o registro cronológico dos pedidos e facilitando a análise de histórico de pedidos para cada solicitante.
    * @param status Status atual do pedido de ajuda, indicando se o pedido está pendente, em andamento ou concluído, permitindo a gestão eficiente dos pedidos e a priorização de atendimentos.
    * @param idEndereco Identificador do endereço associado ao pedido de ajuda, referenciando a localização onde o solicitante reside ou onde os atendimentos são realizados, facilitando a organização e logística dos atendimentos odontológicos.
    * @param idDentista Identificador do dentista associado ao pedido de ajuda, referenciando o profissional responsável por fornecer os cuidados odontológicos ao solicitante durante o processo de atendimento, permitindo a gestão eficiente dos recursos humanos da ONG e a atribuição adequada dos atendimentos.
    * 
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
                "\n    Descrição: " + descricaoProblema +
                "\n    Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Sexo: " + sexo +
                "\n    Telefone: " + telefone +
                " - email: " + email +
                "\n    Data do Pedido: " + dataPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - status: " + status;
    }
}
