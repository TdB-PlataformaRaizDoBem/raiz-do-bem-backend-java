package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa um beneficiário, que é uma pessoa que recebe ajuda ou benefícios de um programa social. Esta classe contém informações pessoais do beneficiário, como CPF, nome completo, data de nascimento, telefone e email, além de referências a pedidos de ajuda, programas sociais e endereços associados ao beneficiário. Ela é utilizada para armazenar e manipular os dados dos beneficiários envolvidos nas atividades da ONG.
 * @author Paulo
 * @since 2026-03
 * @param idBeneficiario Identificador único do beneficiário, utilizado para diferenciar cada beneficiário na base de dados e facilitar a gestão dos registros.
 * @param cpf CPF do beneficiário, utilizado para identificação e registro dos beneficiários na base de dados, permitindo a associação de informações pessoais e a verificação de elegibilidade para programas sociais ou atendimentos.
 * @param nomeCompleto Nome completo do beneficiário, utilizado para identificação e registro dos beneficiários na base de dados, facilitando a comunicação e o atendimento personalizado aos beneficiários.
 * @param dataNascimento Data de nascimento do beneficiário, utilizada para calcular a idade e verificar elegibilidade para determinados programas sociais ou atendimentos, além de permitir o registro cronológico dos beneficiários na base de dados.
 * @param telefone Número de telefone do beneficiário, utilizado para contato e comunicação com os beneficiários, facilitando a organização e logística dos atendimentos odontológicos, além de permitir o envio de informações relevantes relacionadas aos programas sociais ou atendimentos.
 * @param email Endereço de e-mail do beneficiário, utilizado para comunicação e envio de informações relevantes relacionadas aos programas sociais ou atendimentos, facilitando a comunicação eficiente com os beneficiários e permitindo o envio de atualizações, convites para eventos ou outras informações importantes relacionadas às atividades da ONG.
 * @param idPedidoAjuda Identificador do pedido de ajuda associado ao beneficiário, referenciando o pedido de ajuda que motivou a inclusãoo do beneficiário na base de dados, permitindo a associação entre o beneficiário e o pedido de ajuda correspondente, facilitando a gestão eficiente dos registros e a análise de histórico de pedidos para cada beneficiário.
 * @param idProgramaSocial Identificador do programa social associado ao beneficiário, referenciando o programa social ao qual o beneficiário está vinculado, permitindo a associação entre o beneficiário e o programa social correspondente, facilitando a gestão eficiente dos registros e a análise de participação dos beneficiários em diferentes programas sociais oferecidos pela ONG.
 * @param idEndereco Identificador do endereço associado ao beneficiário, referenciando a localização onde o beneficiário reside ou onde os atendimentos são realizados, facilitando a organização e logística dos atendimentos odontológicos, além de permitir a associação entre o beneficiário e o endereço correspondente, facilitando a gestão eficiente dos registros e a análise de localização dos beneficiários para fins de planejamento e organização das atividades da ONG.
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
