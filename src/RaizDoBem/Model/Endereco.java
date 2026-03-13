package RaizDoBem.Model;

//Verificado Sp02
public class Endereco {
    private int idEndereco;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;
    private TipoEndereco tipoEndereco;

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
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

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Endereco(int idEndereco, String logradouro, String cep, String numero, String cidade, String estado) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        //this.tipoEndereco = tipoEndereco;
    }

    public Endereco(String logradouro, String cep, String numero, String cidade, String estado) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idEndereco + " - " + logradouro + ", " + numero + " - Cep: " + cep +
                "\n    " + cidade + " - " + estado;
        //", tipoEndereco=" + tipoEndereco +
        //                '}';

    }
}
