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
public class Dentista extends Colaborador{
    private String croDentista;
    private boolean disponibilidade;

    public String getCroDentista() {
        return croDentista;
    }

    public void setCroDentista(String croDentista) {
        this.croDentista = croDentista;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /**
        * Construtor completo para a classe Dentista, que herda de Colaborador. Este construtor é utilizado para criar um objeto Dentista com todas as suas propriedades, incluindo as herdadas de Colaborador e as específicas de Dentista.
     */
    public Dentista(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, String croDentista, boolean disponibilidade) {
        super(id, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo);
        this.croDentista = croDentista;
        this.disponibilidade = disponibilidade;
    }

    /**
     * Construtor para criar um dentista sem fornecer o ID, utilizado para inserção no banco de dados. Este construtor é utilizado quando o ID é gerado automaticamente pelo banco de dados, e o dentista pode fornecer as informações necessárias para criação do registro.
     */
    public Dentista(String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, String croDentista, boolean disponibilidade) {
        this(0, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo, croDentista, disponibilidade);
    }

    public Dentista() {
        super();
    }
}
