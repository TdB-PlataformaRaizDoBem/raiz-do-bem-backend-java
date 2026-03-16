package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private String croDentista;
    private boolean isDisponivel;

    public String getCroDentista() {
        return croDentista;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.isDisponivel = disponivel;
    }

    public Dentista(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, String croDentista, boolean isDisponivel) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email, endereco);
        this.croDentista = croDentista;
        this.isDisponivel = isDisponivel;
    }
}
