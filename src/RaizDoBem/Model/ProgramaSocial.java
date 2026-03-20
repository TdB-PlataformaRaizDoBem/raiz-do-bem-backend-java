package RaizDoBem.Model;

public class ProgramaSocial {
    private final int id;
    private final String programa;

    public int getId() {
        return id;
    }

    public String getPrograma() {
        return programa;
    }

    public ProgramaSocial(int id, String programa) {
        this.id = id;
        this.programa = programa;
    }

    @Override
    public String toString() {
        return programa;
    }
}
