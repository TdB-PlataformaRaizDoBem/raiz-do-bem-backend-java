package RaizDoBem.Model;

public class Sexo {
    private final int id;
    private final int tipo;

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public Sexo(int id, int tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id + " - " + tipo;
    }
}
