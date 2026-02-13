package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private int idDentista;
    private String croDentista;
    private String especialidade;
    private boolean disponivel;
    private String nivelDentista;
    private Endereco endResidencial;
    private Endereco endProfissional;

    public int getIdDentista() {
        return idDentista;
    }

    public String getCroDentista() {
        return croDentista;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getNivelDentista() {
        return nivelDentista;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setNivelDentista(String nivelDentista) {
        this.nivelDentista = nivelDentista;
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

    public Dentista(int idColaborador, String cpf, String rg, String nomeCompleto, LocalDate dataNascimento, String email, String senha, int idDentista, String croDentista, String especialidade, boolean disponivel, String nivelDentista, Endereco endResidencial, Endereco endProfissional) {
        super(idColaborador, cpf, rg, nomeCompleto, dataNascimento, email, senha);
        this.idDentista = idDentista;
        this.croDentista = croDentista;
        this.especialidade = especialidade;
        this.disponivel = disponivel;
        this.nivelDentista = nivelDentista;
        this.endResidencial = endResidencial;
        this.endProfissional = endProfissional;
    }
}
