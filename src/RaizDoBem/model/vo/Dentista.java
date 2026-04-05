package RaizDoBem.model.vo;


public class Dentista{
    private int id;
    private String croDentista;
    private String cpf;
    private String nomeCompleto;
    private Sexo sexo;
    private String email;
    private String telefone;
    private String categoria;
    private boolean disponivel;
    private int idEndereco;

    public int getId() {
        return id;
    }

    public Dentista setId(int id) {
        this.id = id;
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

    public boolean isDisponivel() {
        return disponivel;
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

    public Dentista(int id, String croDentista, String cpf, String nomeCompleto, Sexo sexo, String email, String telefone, String categoria, boolean disponivel, int idEndereco) {
        this.id = id;
        this.croDentista = croDentista;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.idEndereco = idEndereco;
    }

    public Dentista(String croDentista, String cpf, String nomeCompleto, Sexo sexo, String email, String telefone, String categoria, boolean disponivel, int idEndereco) {
        this.croDentista = croDentista;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.idEndereco = idEndereco;
    }

    public Dentista() {
    }
}
