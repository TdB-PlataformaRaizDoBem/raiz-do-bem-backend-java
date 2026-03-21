package RaizDoBem.Model;

/**
 * Usada para armazenar o sexo de um colaborador ou beneficiário, contendo informações como id e tipo. Esta classe é utilizada para modelar o sexo associado às pessoas envolvidas no sistema.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do sexo.
 * @param tipo Tipo do sexo, representado por uma string (por exemplo, "Masculino", "Feminino", "Outros").
 *
 * Exemplo de tipos de sexo:
 * - 1: Masculino
 * - 2: Feminino
 * - 3: Outros
 */
public class Sexo {
    private int id;
    private String tipo;

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Sexo setId(int id) {
        this.id = id;
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sexo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Sexo() {
    }

    @Override
    public String toString() {
        return id + " - " + tipo;
    }
}
