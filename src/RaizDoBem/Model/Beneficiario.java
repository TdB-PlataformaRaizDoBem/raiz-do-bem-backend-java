package RaizDoBem.Model;

import java.time.LocalDate;

public class Beneficiario{
    private int idBeneficiario;
    private String cpfBeneficiario;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private TipoBeneficiario tipoBeneficiario;
    private Endereco endereco;

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public String getCpfBeneficiario() {
        return cpfBeneficiario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public TipoBeneficiario getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setTipoBeneficiario(TipoBeneficiario tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }



    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Beneficiario(int idBeneficiario, String cpfBeneficiario, String nomeCompleto, LocalDate dataNascimento, Sexo sexo, TipoBeneficiario tipoBeneficiario, Endereco endereco) {
        this.idBeneficiario = idBeneficiario;
        this.cpfBeneficiario = cpfBeneficiario;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoBeneficiario = tipoBeneficiario;
        this.endereco = endereco;
    }
}
