package RaizDoBem.Model;

import java.time.LocalDate;

/**
 * Cada colaborador da ONG. Colaborador é a classe pai, que dá origem a Dentista e Coordenador. Contém informações pessoais, endereço e sexo do colaborador.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do colaborador.
 * @param cpf CPF do colaborador, utilizado para identificação.
 * @param nomeCompleto Nome completo do colaborador.
 * @param dataNascimento Data de nascimento do colaborador.
 * @param email Endereço de email do colaborador para contato.
 * @param endereco Referência ao endereço do colaborador, utilizando a classe Endereco.
 * @param sexo Referência ao sexo do colaborador, utilizando a classe Sexo.
 */
public class Colaborador {
    protected int id;
    protected String cpf;
    protected String nomeCompleto;
    protected LocalDate dataNascimento;
    protected String email;
    protected Endereco endereco;
    protected Sexo sexo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Sexo getSexo() {
        return sexo;
    }

    protected Colaborador(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, int idEndereco, int idSexo) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = new Endereco();
        this.endereco.setId(idEndereco);
        this.sexo = new Sexo();
        this.sexo.setId(idSexo);
    }

    public Colaborador() {
    }

    public boolean login(){
        System.out.println("Usuário: [" + nomeCompleto + "] está logado!");
        return true;
    }
    public void logout(){
        System.out.println("Logout do usuário...");
    }

}
