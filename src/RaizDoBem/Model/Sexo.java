package RaizDoBem.Model;

public class Sexo {
    private int id;
    private int tipo;

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public Sexo setId(int id) {
        this.id = id;
        return this;
    }

    public Sexo setTipo(int tipo) {
        this.tipo = tipo;
        return this;
    }

    public Sexo(int id, int tipo) {
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
