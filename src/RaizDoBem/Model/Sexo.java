package RaizDoBem.Model;

public class Sexo {
    private final int idSexo;
    private final int tipo;

    public int getIdSexo() {
        return idSexo;
    }

    public int getTipo() {
        return tipo;
    }

    public Sexo(int idSexo, int tipo) {
        this.idSexo = idSexo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return idSexo + " - " + tipo;
    }
}
