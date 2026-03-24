package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Representa um dentista do projeto Raiz do Bem. Esta classe herda de Colaborador, pois um dentista é um tipo específico de colaborador. Contém informações específicas do dentista, como o número do CRO e a disponibilidade para atendimento.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do dentista, herdado de Colaborador.
 * @param cpf CPF do dentista, utilizado para identificação, herdado de Colaborador.
 * @param nomeCompleto Nome completo do dentista, herdado de Colaborador.
 * @param dataNascimento Data de nascimento do dentista, herdado de Colaborador.
 * @param email Endereço de email do dentista para contato, herdado de Colaborador.
 * @param endereco Referência ao endereço do dentista, utilizando a classe Endereco, herdado de Colaborador.
 * @param sexo Referência ao sexo do dentista, utilizando a classe Sexo, herdado de Colaborador.
 * @param croDentista Número do CRO (Conselho Regional de Odontologia) do dentista, utilizado para identificação profissional.
 * @param disponibilidade Disponibilidade do dentista para atendimento, que pode ser utilizada para agendamento de atendimentos odontológicos.
 */
public class Dentista{
    private int id;
    private String cpf;
    private String croDentista;
    private String nomeCompleto;
    private boolean disponibilidade;
    private boolean isCoordenador;

    public int getId() {
        return id;
    }

    public Dentista setId(int id) {
        this.id = id;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Dentista setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getCroDentista() {
        return croDentista;
    }

    public Dentista setCroDentista(String croDentista) {
        this.croDentista = croDentista;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Dentista setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public Dentista setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
        return this;
    }

    public boolean isCoordenador() {
        return isCoordenador;
    }

    public Dentista setCoordenador(boolean coordenador) {
        isCoordenador = coordenador;
        return this;
    }

    public Dentista(int id, String cpf, String croDentista, String nomeCompleto, boolean disponibilidade, boolean isCoordenador) {
        this.id = id;
        this.cpf = cpf;
        this.croDentista = croDentista;
        this.nomeCompleto = nomeCompleto;
        this.disponibilidade = disponibilidade;
        this.isCoordenador = isCoordenador;
    }

    public Dentista(String cpf, String croDentista, String nomeCompleto, boolean disponibilidade, boolean isCoordenador) {
        this.cpf = cpf;
        this.croDentista = croDentista;
        this.nomeCompleto = nomeCompleto;
        this.disponibilidade = disponibilidade;
        this.isCoordenador = isCoordenador;
    }

    public Dentista() {
        super();
    }


}
