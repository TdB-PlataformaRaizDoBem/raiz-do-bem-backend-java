package RaizDoBem.Model;

import java.time.LocalDate;

public class Dentista extends Colaborador{
    private String croDentista;
    private String disponibilidade;

    public String getCroDentista() {
        return croDentista;
    }

    public void setCroDentista(String croDentista) {
        this.croDentista = croDentista;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public Dentista setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
        return this;
    }

    public Dentista(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, String croDentista, String disponibilidade) {
        super(id, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo);
        this.croDentista = croDentista;
        this.disponibilidade = disponibilidade;
    }

    public Dentista(String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, String croDentista, String disponibilidade) {
        this(0, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo, croDentista, disponibilidade);
    }

    public Dentista() {
        super();
    }
}
