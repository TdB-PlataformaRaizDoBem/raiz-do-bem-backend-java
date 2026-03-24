package RaizDoBem.model.vo;

/**
 * Cada pessoa que passou pelo processo de solicitação de pedido de ajuda, e agora recebe atendimento da Turma do Bem. Contém informações pessoais, endereço, programa social associado, pedido de ajuda referência e colaborador responsável que o registrou.
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
 * @param coordenador Referência ao colaborador responsável pelo beneficiário, utilizando a classe Colaborador.
 *
 */
public class Beneficiario{
    private int id;
    private String cpf;
    private String nomeCompleto;
    private int idPedidoAjuda;

    public int getId() {
        return id;
    }

    public Beneficiario setId(int id) {
        this.id = id;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Beneficiario setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Beneficiario setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public int getIdPedidoAjuda() {
        return idPedidoAjuda;
    }

    public Beneficiario setIdPedidoAjuda(int idPedidoAjuda) {
        this.idPedidoAjuda = idPedidoAjuda;
        return this;
    }

    public Beneficiario(int id, String cpf, String nomeCompleto, int idPedidoAjuda) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.idPedidoAjuda = idPedidoAjuda;
    }

    public Beneficiario(String cpf, String nomeCompleto, int idPedidoAjuda) {
        this.nomeCompleto = nomeCompleto;
        this.idPedidoAjuda = idPedidoAjuda;
    }

     public Beneficiario() {
    }

}
