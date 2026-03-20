package RaizDoBem.Model;

import java.time.LocalDate;

public class Coordenador extends Colaborador {
    private LocalDate dataContratacao;
    private String nivelAcesso;
    private String senha;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Coordenador(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, LocalDate dataContratacao, String nivelAcesso, String senha) {
        super(id, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo);
        this.dataContratacao = dataContratacao;
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
    }

    public Coordenador(String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, LocalDate dataContratacao, String nivelAcesso, String senha) {
        this(0, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo, dataContratacao, nivelAcesso, senha);
    }

    public Coordenador() {
        super();
    }
}
