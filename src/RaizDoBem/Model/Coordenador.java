package RaizDoBem.Model;

import java.time.LocalDate;

public class Coordenador extends Colaborador {
    private int idCoordenador;
    private LocalDate dataContratacao;
    private String nivelAcesso;

    public int getIdCoordenador() {
        return idCoordenador;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public Coordenador(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, String senha, int idCoordenador, LocalDate dataContratacao, String nivelAcesso) {
        super(idColaborador, cpf, nomeCompleto, dataNascimento, email, senha);
        this.idCoordenador = idCoordenador;
        this.dataContratacao = dataContratacao;
        this.nivelAcesso = nivelAcesso;
    }

}
