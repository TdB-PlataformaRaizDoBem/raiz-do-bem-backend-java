package RaizDoBem.Model;

import java.util.Scanner;

/**
 * Classe para armazenar endereços, e contém informações como logradouro, cep, número, bairro, cidade, estado e tipo de endereço. Esta classe é utilizada para modelar os endereços associados a colaboradores e beneficiários.
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do endereço.
 * @param logradouro Logradouro do endereço.
 * @param cep CEP do endereço.
 * @param numero Número do endereço.
 * @param bairro Bairro do endereço.
 * @param cidade Cidade do endereço.
 * @param estado Estado do endereço.
 * @param tipoEndereco Tipo de endereço, utilizando a classe TipoEndereco para representar se é residencial ou profissional.
 *
 *Exemplo de tipos de endereço:
 *  - Residencial: Endereço onde o beneficiário reside.
 *  - Profissional: Endereço onde o colaborador atua.
 */
public class Endereco {
    private int id;
    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private TipoEndereco tipoEndereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public Endereco(int id, String logradouro, String cep, String numero, String bairro, String cidade, String estado, int idTipoEndereco, String tipoEndereco) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = new TipoEndereco();
        this.tipoEndereco.setId(idTipoEndereco);
        this.tipoEndereco.setLocalizacao(tipoEndereco);
    }
    public Endereco(String logradouro, String cep, String numero, String bairro, String cidade, String estado, int idTipoEndereco) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoEndereco = new TipoEndereco();
        this.tipoEndereco.setId(idTipoEndereco);
    }

    public Endereco() {
    }

    public Endereco criarEndereco(){
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Criando novo endereço: -----");

        System.out.println("Logradouro: ");
        String logradouro = sc.nextLine();

        System.out.println("CEP: ");
        String cep = sc.nextLine();

        System.out.println("Número: ");
        String numero = sc.nextLine();

        System.out.println("Bairro: ");
        String bairro = sc.nextLine();

        System.out.println("Cidade: ");
        String cidade = sc.nextLine();

        System.out.println("Estado: ");
        String estado = sc.nextLine();

        int opc;
        int idTipoEndereco = 0;
        do {
            System.out.println("Endereço residencial ou Profissional?");
            System.out.println("1. Residencial");
            System.out.println("2. Profissional");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc==1) {
                idTipoEndereco = 1;
            }
            else if(opc==2) {
                idTipoEndereco = 2;
            }
            else{
                System.out.println("Opção Inválida!!!");
            }
        } while (opc < 1 || opc > 2);

        Endereco endereco = new Endereco(
                logradouro,
                cep,
                numero,
                bairro,
                cidade,
                estado,
                idTipoEndereco
        );
        return endereco;
    }
    public String entradaCidade(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Digite a cidade, que deseja utilizar na busca: ");
        cidade = sc.nextLine();

        return cidade;
    }
    public int entradaId(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Digite o ID que será utilizado como parâmetro: ");
        id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + logradouro + ", " + numero + " - Cep: " + cep +
                "\n    " + cidade + " - " + estado + "\n    Endereço: " + tipoEndereco.getLocalizacao();

    }
}
