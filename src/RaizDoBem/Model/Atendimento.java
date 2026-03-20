package RaizDoBem.Model;

import java.time.LocalDate;

public class Atendimento {
    private int id;
    private String descricaoAtendimento;
    private LocalDate data;
    private Beneficiario beneficiario;
    private Dentista dentista;

    public int getId() {
        return id;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
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

    public Atendimento(int id, String descricaoAtendimento, LocalDate data, Beneficiario beneficiario, Dentista dentista) {
        this.id = id;
        this.descricaoAtendimento = descricaoAtendimento;
        this.data = data;
        this.beneficiario = beneficiario;
        this.dentista = dentista;
    }
}
