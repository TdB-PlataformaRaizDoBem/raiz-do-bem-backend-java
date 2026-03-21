package RaizDoBem.model.vo;

/**
 * Classe para armazenar endereços, e contém informações como logradouro, cep, número,
 * bairro, cidade, estado e tipo de endereço. Esta classe é utilizada para modelar os
 * endereços associados a colaboradores e beneficiários.
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

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public Endereco(int id, String logradouro, String cep, String numero, String bairro, String cidade, String estado, int idTipoEndereco, String tipoEndereco) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = new TipoEndereco();
        this.tipoEndereco.setId(idTipoEndereco);
        this.tipoEndereco.setLocalizacao(tipoEndereco);
    }
    public Endereco(String logradouro, String cep, String numero, String bairro, String cidade, String estado, int idTipoEndereco) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = new TipoEndereco();
        this.tipoEndereco.setId(idTipoEndereco);
    }

    public Endereco() {
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + logradouro + ", " + numero + " - Cep: " + cep +
                "\n    " + cidade + " - " + estado + "\n    Endereço: " + tipoEndereco.getLocalizacao();

    }
}
