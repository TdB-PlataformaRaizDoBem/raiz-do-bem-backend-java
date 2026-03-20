package RaizDoBem.Model;

public class DentistaEspecialidade {
    private Dentista dentista;
    private Especialidade especialidade;

    public Dentista getDentista() {
        return dentista;
    }

    public DentistaEspecialidade setDentista(Dentista dentista) {
        this.dentista = dentista;
        return this;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public DentistaEspecialidade setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
        return this;
    }

    public DentistaEspecialidade(Dentista dentista, Especialidade especialidade) {
        this.dentista = dentista;
        this.especialidade = especialidade;
    }
}
