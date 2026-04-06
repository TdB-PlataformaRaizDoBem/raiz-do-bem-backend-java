package RaizDoBem.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** * Classe de valor para os atendimentos realizados pela ONG. Esta classe representa um atendimento específico, contendo informações como descrição inicial, data de início, data de término, solução do problema, e os IDs do beneficiário, dentista e colaborador envolvidos no atendimento. Ela é utilizada para transferir dados entre as camadas da aplicação, facilitando a manipulação e exibição das informações relacionadas aos atendimentos.
 * @author Paulo
 * @since 2026-03
 * @param id Identificador único do atendimento.
 * @param descricaoInicial Descrição detalhada do atendimento, incluindo informações sobre o problema odontológico enfrentado pelo beneficiário e as ações realizadas pelo dentista durante o atendimento.
 * @param dataInicial Data em que o atendimento foi realizado, permitindo o registro cronológico dos atendimentos e facilitando a análise de histórico de atendimentos para cada beneficiário.
 * @param dataFinal Data em que o atendimento foi concluído, indicando o término do processo de atendimento e permitindo a avaliação do tempo gasto para resolver o problema odontológico do beneficiário.
 * @param solucaoProblema Descrição da solução adotada para resolver o problema odontológico do beneficiário, incluindo detalhes sobre os procedimentos realizados, medicamentos prescritos, e orientações fornecidas ao beneficiário para cuidados posteriores.
 * @param idBeneficiario Identificador do beneficiário que recebe o atendimento, referenciando a pessoa que está sendo assistida pela ONG.
 * @param idDentista Identificador do dentista que realiza o atendimento, referenciando o profissional responsável por fornecer os cuidados odontológicos ao beneficiário durante o atendimento.
 * @param idColaborador Identificador do colaborador responsável por registrar o atendimento, referenciando a pessoa que documenta as informações do atendimento e garante que os dados sejam corretamente armazenados para futuras consultas e análises.
 */
public class Atendimento {
    private int idAtendimento;
    private String descricaoInicial;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String solucaoProblema;
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

    public Atendimento(int idAtendimento, String descricaoInicial, LocalDate dataInicial, LocalDate dataFinal, String solucaoProblema, int idBeneficiario, int idDentista, int idColaborador) {
        this.idAtendimento = idAtendimento;
        this.descricaoInicial = descricaoInicial;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.solucaoProblema = solucaoProblema;
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
        this.idColaborador = idColaborador;
    }

    public Atendimento(String descricaoInicial, int idBeneficiario, int idDentista) {
        this.descricaoInicial = descricaoInicial;
        this.dataInicial = LocalDate.now();
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
    }

    public Atendimento() {
    }

    @Override
    public String toString() {
        return idAtendimento +
                " - Descrição: " + descricaoInicial +
                "\n     Data inicial: " + dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " - Data Final: " + dataFinal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\n     Solução do problema: " + solucaoProblema +
                "\n\n     Id do beneficiário que atendido: " + idBeneficiario +
                "\n     Id do dentista que atende: " + idDentista +
                "\n     Id colaborador responsável: " + idColaborador;
    }
}
