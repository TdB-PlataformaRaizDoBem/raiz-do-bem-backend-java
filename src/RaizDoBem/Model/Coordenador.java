package RaizDoBem.Model;

import java.time.LocalDate;

public class Coordenador extends Colaborador {
    private LocalDate dataContratacao;
    private String nivelAcesso;
    private String senha;
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public Coordenador(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, Sexo sexo, LocalDate dataContratacao, String nivelAcesso, String senha) {
        super(id, cpf, nomeCompleto, dataNascimento, email, endereco, sexo);
        this.dataContratacao = dataContratacao;
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
    }
}
