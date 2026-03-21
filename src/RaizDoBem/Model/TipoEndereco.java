package RaizDoBem.Model;

/**
 * Representa o tipo de endereço, contendo informações como id e localização. Esta classe é utilizada para modelar os tipos de endereço associados aos colaboradores e dentistas.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do tipo de endereço.
 * @param localizacao Localização do tipo de endereço, representada por uma string (por exemplo, "Residencial", "Comercial", etc.).
 *
 * Exemplo de tipos de endereço:
 * - Residencial: Endereço onde o beneficiário reside.
 * - Comercial: Endereço onde o colaborador ou dentista trabalha.
 */
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
