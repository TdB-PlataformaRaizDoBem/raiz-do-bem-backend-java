package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe VO que representa os dados de dominio de Colaborador.
 * Camada: VO.
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

    /**
 * Construtor com ID para listagem e consultas.
 */
    public Colaborador(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, LocalDate dataContratacao, String email) {
        this.idColaborador = idColaborador;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
        this.email = email;
    }

    /**
 * Construtor sem ID para insercao.
 */
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
