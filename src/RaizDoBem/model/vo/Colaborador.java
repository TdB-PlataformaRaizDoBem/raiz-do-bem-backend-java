package RaizDoBem.model.vo;

import java.time.LocalDate;

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
    private LocalDate dataContratacao;
    private String email;
    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public Colaborador setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Colaborador(int id, String cpf, String nomeCompleto, LocalDate dataContratacao, String email, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataContratacao = dataContratacao;
        this.email = email;
        this.senha = senha;
    }

    public Colaborador(String cpf, String nomeCompleto, LocalDate dataContratacao, String email, String senha) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataContratacao = dataContratacao;
        this.email = email;
        this.senha = senha;
    }

    public Colaborador() {
        super();
    }
}
