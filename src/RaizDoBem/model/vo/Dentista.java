package RaizDoBem.model.vo;

/**
 * Representa um dentista do projeto Raiz do Bem. Esta classe herda de Colaborador, pois um dentista é um tipo específico de colaborador. Contém informações específicas do dentista, como o número do CRO e a disponivel para atendimento.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do dentista, herdado de Colaborador.
 * @param cpf CPF do dentista, utilizado para identificação, herdado de Colaborador.
 * @param nomeCompleto Nome completo do dentista, herdado de Colaborador.
 * @param dataNascimento Data de nascimento do dentista, herdado de Colaborador.
 * @param email Endereço de email do dentista para contato, herdado de Colaborador.
 * @param endereco Referência ao endereço do dentista, utilizando a classe Endereco, herdado de Colaborador.
 * @param sexo Referência ao sexo do dentista, utilizando a classe Sexo, herdado de Colaborador.
 * @param croDentista Número do CRO (Conselho Regional de Odontologia) do dentista, utilizado para identificação profissional.
 * @param disponibilidade Disponibilidade do dentista para atendimento, que pode ser utilizada para agendamento de atendimentos odontológicos.
 */
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
