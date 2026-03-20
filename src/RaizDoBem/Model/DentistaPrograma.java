package RaizDoBem.Model;

public class DentistaPrograma {
    private Dentista dentista;
    private ProgramaSocial programa;

    public Dentista getDentista() {
        return dentista;
    }

    public DentistaPrograma setDentista(Dentista dentista) {
        this.dentista = dentista;
        return this;
    }

    public ProgramaSocial getPrograma() {
        return programa;
    }

    public DentistaPrograma setPrograma(ProgramaSocial programa) {
        this.programa = programa;
        return this;
    }

    public DentistaPrograma(Dentista dentista, ProgramaSocial programa) {
        this.dentista = dentista;
        this.programa = programa;
    }
}
