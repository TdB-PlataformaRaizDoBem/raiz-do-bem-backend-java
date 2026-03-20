package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private final String croDentista;
    private boolean disponibilidade;

    public String getCroDentista() {
        return croDentista;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Dentista(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, Sexo sexo, String croDentista, boolean disponibilidade) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email, endereco, sexo);
        this.croDentista = croDentista;
        this.disponibilidade = disponibilidade;
    }
}
