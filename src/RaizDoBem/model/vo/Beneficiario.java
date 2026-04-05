package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Cada pessoa que passou pelo processo de solicitação de pedido de ajuda, e agora recebe atendimento da Turma do Bem. Contém informações pessoais, endereço, programa social associado, pedido de ajuda referência e colaborador responsável que o registrou.
 * @author Paulo
 * @since 2025-09
 * @param int Identificador único do beneficiário.
 * @param cpf CPF do beneficiário, utilizado para identificação.
 * @param nomeCompleto Nome completo do beneficiário.
 * @param dataNascimento Data de nascimento do beneficiário.
 * @param telefone Número de telefone do beneficiário para contato.
 * @param email Endereço de email do beneficiário para contato.
 * @param sexo Referência ao sexo do beneficiário, utilizando a classe Sexo.
 * @param programa Referência ao programa social ao qual o beneficiário está associado, utilizando a classe ProgramaSocial.
 * @param endereco Referência ao endereço do beneficiário, utilizando a classe Endereco.
 * @param pedidoAjuda Referência ao pedido de ajuda do beneficiário, utilizando a classe PedidoAjuda.
 * @param coordenador Referência ao colaborador responsável pelo beneficiário, utilizando a classe Colaborador.
 *
 */
public class Beneficiario{
    private int id;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private int idPedidoAjuda;
    private int idProgramaSocial;
    private int idEndereco;

    public int getId() {
        return id;
    }

    public Beneficiario setId(int id) {
        this.id = id;
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

    public Beneficiario(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idPedidoAjuda, int idProgramaSocial, int idEndereco) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.idPedidoAjuda = idPedidoAjuda;
        this.idProgramaSocial = idProgramaSocial;
        this.idEndereco = idEndereco;
    }

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
        return " " + id +
                " - " + nomeCompleto +
                " - Cpf: " + cpf +
                "\n     Data de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Telefone: " + telefone +
                " - email: " + email +
                "\n     Pedido de ajuda: " + idPedidoAjuda +
                ", Programa Social: " + idProgramaSocial;
    }
}
