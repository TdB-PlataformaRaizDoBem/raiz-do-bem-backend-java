package RaizDoBem.Model;

import java.time.LocalDate;

public class Colaborador {
    private int id;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private Endereco endereco;
    private Sexo sexo;

    public int getId() {
        return id;
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

    public Colaborador(int id, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, Endereco endereco, Sexo sexo) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.sexo = sexo;
    }

    public boolean login(){
        System.out.println("Usuário: [" + nomeCompleto + "] está logado!");
        return true;
    }
    public void logout(){
        System.out.println("Logout do usuário...");
    }

}
