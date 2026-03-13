package RaizDoBem.Model;

public class TipoEndereco {
    private final int idTipoEndereco;
    private final String tipoEndereco;

    public int getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public TipoEndereco(int idTipoEndereco, String tipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public String toString() {
        return tipoEndereco;
    }
}
