package RaizDoBem.Model;

import java.time.LocalDate;

public class Beneficiario{
    private int id;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private Sexo sexo;
    private ProgramaSocial programaSocial;
    private Endereco endereco;
    private PedidoAjuda pedidoAjuda;
    private Coordenador coordenador;

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

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public ProgramaSocial getProgramaSocial() {
        return programaSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Beneficiario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public Beneficiario setEmail(String email) {
        this.email = email;
        return this;
    }

    public void setProgramaSocial(ProgramaSocial programaSocial) {
        this.programaSocial = programaSocial;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Beneficiario setPedidoAjuda(PedidoAjuda pedidoAjuda) {
        this.pedidoAjuda = pedidoAjuda;
        return this;
    }

    public Beneficiario setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
        return this;
    }

    public Beneficiario(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, Sexo sexo, ProgramaSocial programaSocial, Endereco endereco, PedidoAjuda pedidoAjuda, Coordenador coordenador) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.programaSocial = programaSocial;
        this.endereco = endereco;
        this.pedidoAjuda = pedidoAjuda;
        this.coordenador = coordenador;
    }
}
