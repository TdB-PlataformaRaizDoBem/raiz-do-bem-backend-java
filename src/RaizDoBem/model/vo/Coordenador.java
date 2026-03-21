package RaizDoBem.model.vo;

import java.time.LocalDate;

/**
 * Representa um coordenador do projeto Raiz do Bem. O coordenador é um tipo específico de colaborador, com responsabilidades adicionais relacionadas à coordenação das atividades do projeto. Contém informações sobre a data de contratação, nível de acesso e senha para acesso ao sistema.
 * @author Paulo
 * @since 2025-09
 * @param dataContratacao Data em que o coordenador foi contratado para o projeto.
 * @param nivelAcesso Nível de acesso do coordenador no sistema, determinando as suas permissões.
 * @param senha Senha utilizada pelo coordenador para acessar o sistema.
 *
 *
 */
public class Coordenador extends Colaborador {
    private LocalDate dataContratacao;
    private String nivelAcesso;
    private String senha;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
        * Construtor para poder listar um coordenador com todas as informações, incluindo o ID. O coordenador pode fornecer a data de contratação, nível de acesso e senha para acesso ao sistema.
     */
    public Coordenador(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, LocalDate dataContratacao, String nivelAcesso, String senha) {
        super(id, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo);
        this.dataContratacao = dataContratacao;
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
    }

    /**
     * Construtor para criar um coordenador sem fornecer o ID, utilizado para inserção no banco de dados. O coordenador pode fornecer a data de contratação, nível de acesso e senha para acesso ao sistema.
     */
    public Coordenador(String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo, LocalDate dataContratacao, String nivelAcesso, String senha) {
        this(0, cpf, nomeCompleto, dataNascimento, email, idEndereco, idSexo, dataContratacao, nivelAcesso, senha);
    }

    public Coordenador() {
        super();
    }
}
