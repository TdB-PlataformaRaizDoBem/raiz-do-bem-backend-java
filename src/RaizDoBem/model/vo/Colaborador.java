package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** * Cada pessoa que trabalha na Turma do Bem, seja como voluntário ou funcionário, e é responsável por registrar os beneficiários, acompanhar os atendimentos e contribuir para a missão da ONG. Contém informações pessoais, data de contratação e email para contato.
 * @author Paulo
 * @since 2026-03
 * @param id Identificador único do colaborador.
 * @param cpf CPF do colaborador, utilizado para identificação.
 * @param nomeCompleto Nome completo do colaborador.
 * @param dataNascimento Data de nascimento do colaborador, utilizada para calcular a idade e verificar elegibilidade para determinadas funções ou programas dentro da ONG.
 * @param dataContratacao Data de contratação do colaborador, utilizada para registrar o início do vínculo com a ONG e calcular o tempo de serviço.
 * @param email Endereço de e-mail do colaborador, utilizado para comunicação e envio de informações relevantes relacionadas às atividades da ONG.
 */
public class Colaborador {
    private int idColaborador;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private LocalDate dataContratacao;
    private String email;

    public int getIdColaborador() {
        return idColaborador;
    }

    public Colaborador setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Colaborador setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Colaborador setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Colaborador setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public Colaborador setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Colaborador setEmail(String email) {
        this.email = email;
        return this;
    }

    public Colaborador(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, LocalDate dataContratacao, String email) {
        this.idColaborador = idColaborador;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
        this.email = email;
    }

    public Colaborador(String cpf, String nomeCompleto, LocalDate dataNascimento, LocalDate dataContratacao, String email) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
        this.email = email;
    }

    public Colaborador() {
    }

    @Override
    public String toString() {
        return "\n" + idColaborador +
                " - " + nomeCompleto + " - Cpf: " +  cpf +
                "\n     Data de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\n     Data de contratação: " + dataContratacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - email: " + email;
    }
}
