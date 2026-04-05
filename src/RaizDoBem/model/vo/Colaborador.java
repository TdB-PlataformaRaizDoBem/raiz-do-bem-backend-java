package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa um coordenador do projeto Raiz do Bem. O coordenador é um tipo específico de colaborador, com responsabilidades adicionais relacionadas à coordenação das atividades do projeto. Contém informações sobre a data de contratação, nível de acesso e senha para acesso ao sistema.
 * @author Paulo
 * @since 2025-09
 * @param dataContratacao Data em que o coordenador foi contratado para o projeto.
 * @param nivelAcesso Nível de acesso do coordenador no sistema, determinando as suas permissões.
 * @param senha Senha utilizada pelo coordenador para acessar o sistema.
 *
 *
 */
public class Colaborador {
    private int id;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private LocalDate dataContratacao;
    private String email;

    public int getId() {
        return id;
    }

    public Colaborador setId(int id) {
        this.id = id;
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

    public Colaborador(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, LocalDate dataContratacao, String email) {
        this.id = id;
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
        return "\n" + id +
                " - " + nomeCompleto + " - Cpf: " +  cpf +
                "\n     Data de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\n     Data de contratação: " + dataContratacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - email: " + email;
    }
}
