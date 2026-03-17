package RaizDoBem.Model;

public class Endereco {
    private int id;
    private String logradouro;
    private String cep;
    private String numero;
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

    public Endereco(int id, String logradouro, String cep, String numero, String cidade, String estado, int idTipoEndereco, String tipoEndereco) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = new TipoEndereco();
        this.tipoEndereco.setId(idTipoEndereco);
        this.tipoEndereco.setLocalizacao(tipoEndereco);
    }

    public Endereco(String logradouro, String cep, String numero, String cidade, String estado, int idTipoEndereco) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = new TipoEndereco();
        this.tipoEndereco.setId(idTipoEndereco);
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + logradouro + ", " + numero + " - Cep: " + cep +
                "\n    " + cidade + " - " + estado + "\n    Endereço: " + tipoEndereco.getLocalizacao();

    }
}
