package RaizDoBem.model.vo;

/* Classe que representa um dentista na ONG. Esta classe contém informações sobre o dentista, como seu CRO (Conselho Regional de Odontologia), CPF, nome completo, sexo, email, telefone, categoria de atendimento, disponibilidade e o ID do endereço associado. Ela é utilizada para armazenar e manipular os dados dos dentistas que prestam atendimento aos beneficiários da ONG.
 * @author Paulo
 * @since 2026-03
 * @param id Identificador único do dentista.
 * @param croDentista CRO do dentista, utilizado para identificação profissional.
 * @param cpf CPF do dentista, utilizado para identificação pessoal.
 * @param nomeCompleto Nome completo do dentista.
 * @param sexo Sexo do dentista, utilizado para registro e comunicação adequada.
 * @param email Endereço de e-mail do dentista, utilizado para comunicação e envio de informações relevantes.
 * @param telefone Número de telefone do dentista, utilizado para contato e comunicação.
 * @param categoria Categoria de atendimento do dentista, indicando sua função de Coordenador ou Clínico.
 * @param disponivel Indica se o dentista está disponível para realizar atendimentos, permitindo a gestão eficiente dos recursos humanos da ONG.
 * @param idEndereco Identificador do endereço do dentista, referenciando a localização onde o dentista reside ou onde os atendimentos são realizados, facilitando a organização e logística dos atendimentos odontológicos.
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

    public Dentista(int id, String croDentista, String cpf, String nomeCompleto, Sexo sexo, String email, String telefone, String categoria, int idEndereco, boolean disponivel) {
        this.id = id;
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
        return "\n" + id +
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
