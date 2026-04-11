package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de Endereco.
 * Camada: VO.
 */
public class Endereco {
    private int idEndereco;
    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private TipoEndereco tipo;

    public int getIdEndereco() {
        return idEndereco;
    }

    public Endereco setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Endereco setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public Endereco setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
        return this;
    }

    public Endereco(int idEndereco, String logradouro, String cep, String numero, String bairro, String cidade, String estado, TipoEndereco tipo) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Endereco(String logradouro, String cep, String numero, String bairro, String cidade, String estado, TipoEndereco tipo) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\n" + idEndereco + " - " + logradouro + ", " + numero + " - Cep: " + cep +
                "\n    " + cidade + " - " + estado + "\n    Tipo de endereço: " + tipo;
    }
}
