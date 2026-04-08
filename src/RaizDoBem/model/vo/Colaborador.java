package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa um colaborador da ONG Raiz do Bem, contendo informações como CPF, nome completo, data de nascimento, data de contratação e email. Esta classe é utilizada para armazenar e manipular os dados dos colaboradores envolvidos nas atividades da ONG, permitindo a criação, leitura, atualização e exclusão de registros relacionados aos colaboradores.
 * @author Paulo
 * @since 2026-03
 * @param idColaborador O identificador único do colaborador, utilizado para diferenciar cada colaborador na base de dados e facilitar a gestão dos registros.
 * @param cpf O CPF do colaborador, utilizado para identificação e registro do colaborador na base de dados, garantindo a unicidade do registro e facilitando a consulta e manipulação dos dados relacionados ao colaborador.
 * @param nomeCompleto O nome completo do colaborador, utilizado para identificação e registro do colaborador na base de dados, permitindo a associação do nome ao CPF e facilitando a consulta e manipulação dos dados relacionados ao colaborador.
 * @param dataNascimento A data de nascimento do colaborador, utilizada para calcular a idade do colaborador e verificar a elegibilidade para determinados programas sociais ou atendimentos, além de ser uma informação relevante para o registro e gestão dos colaboradores na base de dados da ONG.
 * @param dataContratacao A data de contratação do colaborador, utilizada para registrar o início do vínculo do colaborador com a ONG, permitindo a gestão eficiente dos recursos humanos e a organização dos atendimentos realizados pelos colaboradores.
 * @param email O endereço de e-mail do colaborador, utilizado para comunicação e envio de
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
