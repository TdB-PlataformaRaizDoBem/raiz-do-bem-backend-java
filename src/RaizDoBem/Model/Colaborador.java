package RaizDoBem.Model;

import java.time.LocalDate;

public class Colaborador {
    private int idColaborador;
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String senha;

    public int getIdColaborador() {
        return idColaborador;
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

    public String getSenha() {
        return senha;
    }

    public Colaborador(int idColaborador, String cpf, String nomeCompleto, LocalDate dataNascimento, String email, String senha) {
        this.idColaborador = idColaborador;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }

    public boolean login(){
        System.out.println("Usuário: [" + nomeCompleto + "] está logado!");
        return true;
    }
    public void logout(){
        System.out.println("Logout do usuário...");
    }

}
