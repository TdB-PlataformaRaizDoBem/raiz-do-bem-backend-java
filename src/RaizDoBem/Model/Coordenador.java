package RaizDoBem.Model;

import java.time.LocalDate;

public class Coordenador extends Colaborador {
    private LocalDate dataContratacao;
    private String nivelAcesso;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public Coordenador(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, Sexo sexo, LocalDate dataContratacao, String nivelAcesso) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email, endereco, sexo);
        this.dataContratacao = dataContratacao;
        this.nivelAcesso = nivelAcesso;
    }
}
