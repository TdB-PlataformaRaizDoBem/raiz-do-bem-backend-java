package RaizDoBem.Model;

public class TipoEndereco {
    private int id;
    private String localizacao;

    public int getId() {
        return id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public TipoEndereco setId(int id) {
        this.id = id;
        return this;
    }

    public TipoEndereco setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public TipoEndereco() {
    }

    public TipoEndereco(int id, String localizacao) {
        this.id = id;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return localizacao;
    }
}
