package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private final String croDentista;
    private boolean disponivel;

    public String getCroDentista() {
        return croDentista;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Dentista(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, Sexo sexo, String croDentista, boolean disponivel) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email, endereco, sexo);
        this.croDentista = croDentista;
        this.disponivel = disponivel;
    }
}
