package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Representa um atendimento odontológico realizado por um dentista a um beneficiário. Cada atendimento possui uma descrição detalhada, data de realização, e referências ao beneficiário e dentista envolvidos. Essa classe é fundamental para registrar e acompanhar os atendimentos realizados, permitindo que o coordenador tenha acesso a informações relevantes para a gestão dos serviços odontológicos oferecidos.
 * @author Paulo
 * @param id Identificador único do atendimento realizado.
 * @param descricao Descrição detalhada do atendimento, para auxiliar o trabalho do coordenador.
 * @param data Data em que o atendimento foi realizado.
 * @param beneficiario Referência ao beneficiário que recebeu o atendimento.
 * @param dentista Referência ao dentista que realizou o atendimento.
 * @since 2025-09
 */
public class Atendimento {
    private int id;
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private int idBeneficiario;
    private int dentista;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public Atendimento setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        return this;
    }

    public int getDentista() {
        return dentista;
    }

    public Atendimento setDentista(int dentista) {
        this.dentista = dentista;
        return this;
    }

    public Atendimento(int id, String descricao, LocalDate dataInicial, LocalDate dataFinal, int idBeneficiario, int dentista) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.idBeneficiario = idBeneficiario;
        this.dentista = dentista;
    }

    public Atendimento(String descricao, LocalDate dataInicial, LocalDate dataFinal, int idBeneficiario, int dentista) {
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.idBeneficiario = idBeneficiario;
        this.dentista = dentista;
    }

    public Atendimento() {
    }
}
