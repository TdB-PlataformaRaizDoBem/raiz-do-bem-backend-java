package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Representa um atendimento odontológico realizado por um dentista a um beneficiário. Cada atendimento possui uma descrição detalhada, data de realização, e referências ao beneficiário e dentista envolvidos. Essa classe é fundamental para registrar e acompanhar os atendimentos realizados, permitindo que o coordenador tenha acesso a informações relevantes para a gestão dos serviços odontológicos oferecidos.
 * @author Paulo
 * @since 2025-09
 */
public class Atendimento {
    private int id;
    private String descricaoInicial;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String solucaoProblema;
    private int idBeneficiario;
    private int idDentista;
    private int idColaborador;

    public int getId() {
        return id;
    }

    public Atendimento setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescricaoInicial() {
        return descricaoInicial;
    }

    public Atendimento setDescricaoInicial(String descricaoInicial) {
        this.descricaoInicial = descricaoInicial;
        return this;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public Atendimento setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
        return this;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Atendimento setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
        return this;
    }

    public String getSolucaoProblema() {
        return solucaoProblema;
    }

    public Atendimento setSolucaoProblema(String solucaoProblema) {
        this.solucaoProblema = solucaoProblema;
        return this;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public Atendimento setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        return this;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public Atendimento setIdDentista(int idDentista) {
        this.idDentista = idDentista;
        return this;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public Atendimento setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
        return this;
    }

    public Atendimento(int id, String descricaoInicial, LocalDate dataInicial, LocalDate dataFinal, String solucaoProblema, int idBeneficiario, int idDentista) {
        this.id = id;
        this.descricaoInicial = descricaoInicial;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.solucaoProblema = solucaoProblema;
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
    }

    public Atendimento(String descricaoInicial, LocalDate dataInicial, LocalDate dataFinal, String solucaoProblema, int idBeneficiario, int idDentista) {
        this.descricaoInicial = descricaoInicial;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.solucaoProblema = solucaoProblema;
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
    }

    public Atendimento() {
    }
}
