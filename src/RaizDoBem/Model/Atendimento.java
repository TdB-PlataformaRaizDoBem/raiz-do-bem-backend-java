package RaizDoBem.Model;

import java.sql.Date;
import java.time.LocalDate;

public class Atendimento {
    private int idAtendimento;
    private String descricao;
    private LocalDate dataAtendimento;
    private Beneficiario beneficiario;
    private Dentista dentista;

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
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

    public Atendimento(int idAtendimento, String descricao, LocalDate dataAtendimento, Beneficiario beneficiario, Dentista dentista) {
        this.idAtendimento = idAtendimento;
        this.descricao = descricao;
        this.dataAtendimento = dataAtendimento;
        this.beneficiario = beneficiario;
        this.dentista = dentista;
    }
}
