package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe VO que representa os dados de dominio de Beneficiario.
 * Camada: VO.
 */

public class Beneficiario{
    private int idBeneficiario;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private int idPedidoAjuda;
    private int idProgramaSocial;
    private int idEndereco;

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public Beneficiario setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Beneficiario setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Beneficiario setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Beneficiario setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Beneficiario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Beneficiario setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getIdPedidoAjuda() {
        return idPedidoAjuda;
    }

    public Beneficiario setIdPedidoAjuda(int idPedidoAjuda) {
        this.idPedidoAjuda = idPedidoAjuda;
        return this;
    }

    public int getIdProgramaSocial() {
        return idProgramaSocial;
    }

    public Beneficiario setIdProgramaSocial(int idProgramaSocial) {
        this.idProgramaSocial = idProgramaSocial;
        return this;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public Beneficiario setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
        return this;
    }

    /**
 * Construtor com ID para listagem e consultas.
 */
    public Beneficiario(int idBeneficiario, String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idPedidoAjuda, int idProgramaSocial, int idEndereco) {
        this.idBeneficiario = idBeneficiario;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.idPedidoAjuda = idPedidoAjuda;
        this.idProgramaSocial = idProgramaSocial;
        this.idEndereco = idEndereco;
    }

    /**
     * Construtor sem ID para insercao.
     */
    public Beneficiario(String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idPedidoAjuda, int idProgramaSocial, int idEndereco) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.idPedidoAjuda = idPedidoAjuda;
        this.idProgramaSocial = idProgramaSocial;
        this.idEndereco = idEndereco;
    }
    public Beneficiario() {
    }

    @Override
    public String toString() {
        return " " + idBeneficiario +
                " - " + nomeCompleto +
                " - Cpf: " + cpf +
                "\n     Data de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Telefone: " + telefone +
                " - email: " + email +
                "\n     Pedido de ajuda: " + idPedidoAjuda +
                ", Programa Social: " + idProgramaSocial;
    }
}
