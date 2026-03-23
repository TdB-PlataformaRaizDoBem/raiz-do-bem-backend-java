package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Cada pessoa que passou pelo processo de solicitação de pedido de ajuda, e agora recebe atendimento da Turma do Bem. Contém informações pessoais, endereço, programa social associado, pedido de ajuda referência e coordenador responsável que o registrou.
 * @author Paulo
 * @since 2025-09
 * @param int Identificador único do beneficiário.
 * @param cpf CPF do beneficiário, utilizado para identificação.
 * @param nomeCompleto Nome completo do beneficiário.
 * @param dataNascimento Data de nascimento do beneficiário.
 * @param telefone Número de telefone do beneficiário para contato.
 * @param email Endereço de email do beneficiário para contato.
 * @param sexo Referência ao sexo do beneficiário, utilizando a classe Sexo.
 * @param programa Referência ao programa social ao qual o beneficiário está associado, utilizando a classe ProgramaSocial.
 * @param endereco Referência ao endereço do beneficiário, utilizando a classe Endereco.
 * @param pedidoAjuda Referência ao pedido de ajuda do beneficiário, utilizando a classe PedidoAjuda.
 * @param coordenador Referência ao coordenador responsável pelo beneficiário, utilizando a classe Coordenador.
 *
 */
public class  Beneficiario{
    private int id;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private Sexo sexo;
    private ProgramaSocial programa;
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
        return programa;
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

    public void setProgramaSocial(ProgramaSocial programa) {
        this.programa = programa;
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

    /**
     * Construtor completo para poder listar um beneficiário com todas as informações necessárias, incluindo referências a outras entidades por meio de seus IDs.
     *
      */
    public Beneficiario(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idSexo, int idPrograma, int idEndereco, int idPedido, int idColaborador) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;

        this.sexo = new Sexo();
        this.sexo.setId(idSexo);

        this.programa = new ProgramaSocial();
        this.programa.setId(idPrograma);

        this.endereco = new Endereco();
        this.endereco.setId(idEndereco);

        this.pedidoAjuda = new PedidoAjuda();
        this.pedidoAjuda.setId(idPedido);

        this.coordenador = new Coordenador();
        this.coordenador.setId(idColaborador);
    }

    /**
     * Construtor para criar um novo beneficiário, onde o ID é gerado automaticamente pelo banco de dados. O coordenador pode fornecer as informações pessoais do beneficiário, bem como as referências aos IDs das entidades relacionadas (sexo, programa social, endereço, pedido de ajuda e coordenador).
     *
     */
    public Beneficiario(String cpf, String nomeCompleto, LocalDate dataNascimento, String telefone, String email, int idSexo, int idPrograma, int idEndereco, int idPedido, int idColaborador) {
        this(0, cpf, nomeCompleto, dataNascimento, telefone, email, idSexo, idPrograma, idEndereco, idPedido, idColaborador);
    }

    /**
    * Construtor vazio para criar um beneficiário sem fornecer informações iniciais. O coordenador pode usar os métodos setters para preencher as informações posteriormente.
     *
     */
     public Beneficiario() {
    }

    @Override
    public String toString() {
        return id + " - " + nomeCompleto +
                " - CPF: " + cpf +
                "| Data de nascimento: " + dataNascimento +
                "\nTelefone: " + telefone + '\'' +
                "Email: " + email + '\'' +
                "Sexo: " + sexo +
                "Programa: " + programa +
                "Endereco" + endereco.getLogradouro() + " - " + endereco.getNumero();
    }
}
