package RaizDoBem.Model;

public class ProgramaSocial {
    private int id;
    private String programa;

    public int getId() {
        return id;
    }

    public String getPrograma() {
        return programa;
    }

    public ProgramaSocial setId(int id) {
        this.id = id;
        return this;
    }

    public ProgramaSocial setPrograma(String programa) {
        this.programa = programa;
        return this;
    }

    public ProgramaSocial(int id, String programa) {
        this.id = id;
        this.programa = programa;
    }

    public ProgramaSocial() {
    }

    @Override
    public String toString() {
        return programa;
    }
}
