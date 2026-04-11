package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe VO que representa os dados de dominio de Atendimento.
 * Camada: VO.
 */
public class Atendimento {
    private int idAtendimento;
    private String prontuario;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private int idBeneficiario;
    private int idDentista;
    private int idColaborador;

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public Atendimento setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
        return this;
    }

    public String getProntuario() {
        return prontuario;
    }

    public Atendimento setProntuario(String prontuario) {
        this.prontuario = prontuario;
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

    public Atendimento(int idAtendimento, String prontuario, LocalDate dataInicial, LocalDate dataFinal, int idBeneficiario, int idDentista, int idColaborador) {
        this.idAtendimento = idAtendimento;
        this.prontuario = prontuario;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
        this.idColaborador = idColaborador;
    }

    public Atendimento(String prontuario, int idBeneficiario, int idDentista) {
        this.prontuario = prontuario;
        this.dataInicial = LocalDate.now();
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
    }

    public Atendimento() {
    }

    @Override
    public String toString() {
        String dataFinalString;
        if(dataFinal == null)
            dataFinalString = "Em aberto";
        else
            dataFinalString = dataFinal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        String colaborador;
        if(idColaborador == 0)
            colaborador = "Colaborador relator pendente";
        else
            colaborador = String.valueOf(idColaborador);
        return "\n" + idAtendimento +
                " -  Prontuário: " + prontuario +
                "\n     Data inicial: " + dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Data Final: " + dataFinalString +
                "\n\n     Id do beneficiário atendido: " + idBeneficiario +
                "\n     Id do dentista que atende: " + idDentista +
                "\n     Id colaborador responsável: " + colaborador;
    }
}
