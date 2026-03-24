package RaizDoBem.model.vo;

/**
 * Classe para armazenar endereços, e contém informações como logradouro, cep, número,
 * bairro, cidade, estado e tipo de endereço. Esta classe é utilizada para modelar os
 * endereços associados a colaboradores e beneficiários.
 *
 * @param id Identificador único do endereço.
 * @param logradouro Nome da rua ou avenida do endereço.
 * @param cep Código postal do endereço.
 * @param numero Número do endereço.
 * @param bairro Bairro onde o endereço está localizado.
 * @param cidade Cidade onde o endereço está localizado.
 * @param estado Estado onde o endereço está localizado.
 * @param tipoEndereco Tipo do endereço, representado por um objeto da classe TipoEndereco.
 *
 * Exemplo de tipos de endereço:
 * - Residencial: Endereço onde o beneficiário reside.
 * - Profissional: Endereço onde o colaborador atua.
 *
 * @author Paulo
 * @since 2025-09
 */
public class Endereco {
    private int id;
    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private TipoEndereco tipoEndereco;

    public int getId() {
        return id;
    }

    public Endereco setId(int id) {
        this.id = id;
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

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public Endereco setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
        return this;
    }

    public Endereco(int id, String logradouro, String cep, String numero, String bairro, String cidade, String estado, TipoEndereco tipoEndereco) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = tipoEndereco;
    }

    public Endereco(String logradouro, String cep, String numero, String bairro, String cidade, String estado, TipoEndereco tipoEndereco) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = tipoEndereco;
    }

    public Endereco() {
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + logradouro + ", " + numero + " - Cep: " + cep +
                "\n    " + cidade + " - " + estado + "\n    Endereço: " + tipoEndereco;

    }
}
