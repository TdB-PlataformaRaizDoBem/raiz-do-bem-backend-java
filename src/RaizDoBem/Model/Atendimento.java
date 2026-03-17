package RaizDoBem.Model;

import java.time.LocalDate;

public class Atendimento {
    private int id;
    private String descricao;
    private LocalDate data;
    private Beneficiario beneficiario;
    private Dentista dentista;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Atendimento(int id, String descricao, LocalDate data, Beneficiario beneficiario, Dentista dentista) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.beneficiario = beneficiario;
        this.dentista = dentista;
    }
}
