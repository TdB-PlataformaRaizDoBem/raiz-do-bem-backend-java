package RaizDoBem.model.vo;

/**
 * Representa a resposta da API ViaCep, contendo informações sobre o endereço associado a um CEP. Esta classe é utilizada para modelar os dados retornados pela API, facilitando a integração e o acesso às informações de endereço.
 * @author Paulo
 * @since 2025-09
 * @param cep O código postal (CEP) associado ao endereço.
 * @param logradouro O nome da rua ou logradouro do endereço.
 * @param bairro O nome do bairro do endereço.
 * @param localidade A cidade associada ao endereço.
 * @param uf A sigla do estado (UF) associada ao endereço.
 * @param estado O nome completo do estado associado ao endereço.
 * @param erro Indica se houve um erro na consulta do CEP (true se houve erro, false caso contrário).
 */
public class ViaCep {
        private String cep;
        private String logradouro;
        private String bairro;
        private String localidade; // cidade
        private String uf;
        private String estado;
        private boolean erro;

        public String getCep() { return cep; }
        public String getLogradouro() { return logradouro; }
        public String getBairro() { return bairro; }
        public String getLocalidade() { return localidade; }
        public String getUf() { return uf; }
        public String getEstado() { return estado; }
        public boolean isErro() { return erro; }
}
