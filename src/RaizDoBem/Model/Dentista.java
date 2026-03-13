package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private String croDentista;
    private String especialidade;
    private boolean isDisponivel;
    private Endereco endResidencial;
    private Endereco endProfissional;

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

    public Endereco getEndResidencial() {
        return endResidencial;
    }

    public void setEndResidencial(Endereco endResidencial) {
        this.endResidencial = endResidencial;
    }

    public Endereco getEndProfissional() {
        return endProfissional;
    }

    public void setEndProfissional(Endereco endProfissional) {
        this.endProfissional = endProfissional;
    }

    public Dentista(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, String croDentista, String especialidade, boolean isDisponivel, Endereco endResidencial, Endereco endProfissional) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email);
        this.croDentista = croDentista;
        this.especialidade = especialidade;
        this.isDisponivel = isDisponivel;
        this.endResidencial = endResidencial;
        this.endProfissional = endProfissional;
    }
}
