package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Representa um atendimento odontológico realizado por um dentista a um beneficiário. Cada atendimento possui uma descrição detalhada, data de realização, e referências ao beneficiário e dentista envolvidos. Essa classe é fundamental para registrar e acompanhar os atendimentos realizados, permitindo que o coordenador tenha acesso a informações relevantes para a gestão dos serviços odontológicos oferecidos.
 * @author Paulo
 * @param id Identificador único do atendimento realizado.
 * @param descricaoAtendimento Descrição detalhada do atendimento, para auxiliar o trabalho do coordenador.
 * @param data Data em que o atendimento foi realizado.
 * @param beneficiario Referência ao beneficiário que recebeu o atendimento.
 * @param dentista Referência ao dentista que realizou o atendimento.
 * @since 2025-09
 */
public class Atendimento {
    private int id;
    private String descricaoAtendimento;
    private LocalDate data;
    private Beneficiario beneficiario;
    private Dentista dentista;

    public int getId() {
        return id;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    /**
     * Construtor para listar atendimentos, retornados do banco de dados. O coordenador pode fornecer a descrição do atendimento, a data, e as referências ao beneficiário e dentista envolvidos.
     *
     */
    public Atendimento(int id, String descricaoAtendimento, LocalDate data, int idBeneficiario, int idDentista) {
        this.id = id;
        this.descricaoAtendimento = descricaoAtendimento;
        this.data = data;

        this.beneficiario = new Beneficiario();
        this.beneficiario.setId(idBeneficiario);

        this.dentista = new Dentista();
        this.beneficiario.setId(idDentista);
    }
}
