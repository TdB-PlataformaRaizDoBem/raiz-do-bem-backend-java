package RaizDoBem.Model;

public class TipoEndereco {
    private int idTipoEndereco;
    private String localizacao;

    public int getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public TipoEndereco setIdTipoEndereco(int idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
        return this;
    }

    public TipoEndereco setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public TipoEndereco() {
    }

    public TipoEndereco(int idTipoEndereco, String localizacao) {
        this.idTipoEndereco = idTipoEndereco;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return localizacao;
    }
}
