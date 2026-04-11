package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de Dentista.
 * Camada: VO.
 */
public class Dentista{
    private int idDentista;
    private String croDentista;
    private String cpf;
    private String nomeCompleto;
    private Sexo sexo;
    private String email;
    private String telefone;
    private String categoria;
    private boolean disponivel;
    private int idEndereco;

    public int getIdDentista() {
        return idDentista;
    }

    public Dentista setIdDentista(int idDentista) {
        this.idDentista = idDentista;
        return this;
    }

    public String getCroDentista() {
        return croDentista;
    }

    public Dentista setCroDentista(String croDentista) {
        this.croDentista = croDentista;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Dentista setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Dentista setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Dentista setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Dentista setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Dentista setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public Dentista setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public String isDisponivel() {
        return disponivel ? "S" : "N";
    }
    public Dentista setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        return this;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public Dentista setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
        return this;
    }

    /**
 * Construtor com ID para listagem e consultas.
 */
    public Dentista(int idDentista, String croDentista, String cpf, String nomeCompleto, Sexo sexo, String email, String telefone, String categoria, int idEndereco, boolean disponivel) {
        this.idDentista = idDentista;
        this.croDentista = croDentista;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
        this.idEndereco = idEndereco;
        this.disponivel = disponivel;
    }

    public Dentista(String croDentista, String cpf, String nomeCompleto, Sexo sexo, String email, String telefone, String categoria, int idEndereco, boolean disponivel) {
        this.croDentista = croDentista;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
        this.idEndereco = idEndereco;
        this.disponivel = disponivel;
    }

    public Dentista() {
    }

    @Override
    public String toString() {
        return "\n" + idDentista +
                "  - CRO: " + croDentista +
                " - Cpf: " + cpf +
                "\n     Nome Completo: " + nomeCompleto  +
                " -  sexo: " + sexo +
                "\n     Email: " + email +
                " - telefone: " + telefone +
                "\n     Categoria: " + categoria +
                " - disponível: " + disponivel +
                "\n     idEndereco: " + idEndereco;
    }
}
