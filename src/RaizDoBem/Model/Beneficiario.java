package RaizDoBem.Model;

import java.time.LocalDate;

public class Beneficiario{
    private int id;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private TipoBeneficiario tipoBeneficiario;
    private Endereco endereco;
    private PedidoAjuda pedidoAjuda;

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
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

    public Beneficiario(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, Sexo sexo, TipoBeneficiario tipoBeneficiario, Endereco endereco, PedidoAjuda pedidoAjuda) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoBeneficiario = tipoBeneficiario;
        this.endereco = endereco;
        this.pedidoAjuda = pedidoAjuda;
    }
}
