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

    public Beneficiario setId(int id) {
        this.id = id;
        return this;
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

    public Beneficiario(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idSexo, int idPrograma, int idEndereco, int idPedido, int idColaborador) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;

        this.sexo = new Sexo();
        this.sexo.setId(idSexo);

        this.programaSocial = new ProgramaSocial();
        this.programaSocial.setId(idPrograma);

        this.endereco = new Endereco();
        this.endereco.setId(idEndereco);

        this.pedidoAjuda = new PedidoAjuda();
        this.pedidoAjuda.setId(idPedido);

        this.coordenador = new Coordenador();
        this.coordenador.setId(idColaborador);
    }

    public Beneficiario(String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idSexo, int idPrograma, int idEndereco, int idPedido, int idColaborador) {
        this(0, cpf, nomeCompleto, dataNascimento, telefone, email, idSexo, idPrograma, idEndereco, idPedido, idColaborador);
    }

    public Beneficiario() {
    }
}
