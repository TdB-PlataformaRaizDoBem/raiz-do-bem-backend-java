package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private String croDentista;
    private String especialidade;
    private boolean isDisponivel;

    public String getCroDentista() {
        return croDentista;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDisponivel(boolean disponivel) {
        this.isDisponivel = disponivel;
    }

    public Dentista(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, String croDentista, String especialidade, boolean isDisponivel) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email, endereco);
        this.croDentista = croDentista;
        this.especialidade = especialidade;
        this.isDisponivel = isDisponivel;
    }
}
