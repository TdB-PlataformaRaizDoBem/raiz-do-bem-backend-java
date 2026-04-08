package RaizDoBem.model.vo;

/** Representa um dentista, profissional responsável por realizar atendimentos odontológicos e contribuir para a saúde bucal dos beneficiários da ONG. Esta classe é utilizada para armazenar e manipular informações relacionadas aos dentistas, como seu identificador único, CRO, CPF, nome completo, sexo, email, telefone, categoria de atuação, disponibilidade para atendimentos e o identificador do endereço associado.
 * @author Paulo
 * @since 2026-03
 * @param idDentista O identificador único do dentista.
 * @param croDentista O número do CRO (Conselho Regional de Odontologia) do dentista, utilizado para identificar sua habilitação profissional.
 * @param cpf O CPF do dentista, utilizado para identificação pessoal e cadastro na ONG.
 * @param nomeCompleto O nome completo do dentista, utilizado para identificação e comunicação.
 * @param sexo O sexo do dentista, utilizado para fins de registro e comunicação.
 * @param email O email de contato do dentista, utilizado para comunicação e envio de informações relacionadas aos atendimentos e atividades da ONG.
 * @param telefone O telefone de contato do dentista, utilizado para comunicação e agendamento de atendimentos.
 * @param categoria A categoria de atuação do dentista, indicando se ele é um coordenador ou clínico, o que pode influenciar suas responsabilidades e atribuições dentro da ONG.
 * @param disponivel Indica se o dentista está disponível para realizar atendimentos, o que é importante para o agendamento e organização dos atendimentos odontológicos.
 * @param idEndereco O identificador do endereço associado ao dentista, utilizado para armazenar e acessar informações relacionadas ao local de trabalho ou atendimento do dentista, facilitando a organização e logística dos atendimentos odontológicos realizados pela ONG.
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
