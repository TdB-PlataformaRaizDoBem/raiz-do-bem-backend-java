package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe de valor (VO) que representa um atendimento realizado por um dentista a um beneficiário. Esta classe contém informações como o ID do atendimento, prontuário, datas de início e término do atendimento, IDs do beneficiário, dentista e colaborador responsável. Ela inclui métodos getters e setters para acessar e modificar os atributos, além de construtores para criar objetos Atendimento e um método toString para exibir as informações do atendimento de forma formatada.
 * @author Paulo
 * @since 2026-03
 * @param idAtendimento O ID do atendimento, um valor inteiro que identifica unicamente cada atendimento.
 * @param prontuario Uma string que contém o prontuário do atendimento, descrevendo os detalhes do caso odontológico do beneficiário.
 * @param dataInicial A data de início do atendimento, representada por um objeto LocalDate.
 * @param dataFinal A data de término do atendimento, representada por um objeto LocalDate. Pode ser nula se o atendimento ainda estiver em andamento.
 * @param idBeneficiario O ID do beneficiário que recebeu o atendimento, um valor inteiro que identifica unicamente cada beneficiário.
 * @param idDentista O ID do dentista que realizou o atendimento, um valor inteiro que identifica unicamente cada dentista.
 * @param idColaborador O ID do colaborador responsável por registrar o atendimento, um valor inteiro que identifica unicamente cada colaborador. Pode ser zero se o colaborador ainda não tiver sido designado para o atendimento.
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
        return idAtendimento +
                " -  Prontuário: " + prontuario +
                "\n     Data inicial: " + dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Data Final: " + dataFinalString +
                "\n\n     Id do beneficiário atendido: " + idBeneficiario +
                "\n     Id do dentista que atende: " + idDentista +
                "\n     Id colaborador responsável: " + colaborador;
    }
}
