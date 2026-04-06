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
 * @param erro Indica se houve um erro na consulta do CEP (true se houve erro, false caso contrário).
 */
public class ViaCep {
        private String cep;
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
        private boolean erro;

        public String getCep() { return cep; }
        public String getLogradouro() { return logradouro; }
        public String getBairro() { return bairro; }
        public String getLocalidade() { return localidade; }
        public String getUf() { return uf; }
        public boolean isErro() { return erro; }

        public ViaCep(String cep, String logradouro, String bairro, String localidade, String uf, boolean erro) {
                this.cep = cep;
                this.logradouro = logradouro;
                this.bairro = bairro;
                this.localidade = localidade;
                this.uf = uf;
                this.erro = erro;
        }

        public ViaCep(String logradouro, String bairro, String localidade, String uf) {
                this.logradouro = logradouro;
                this.bairro = bairro;
                this.localidade = localidade;
                this.uf = uf;
        }

        public ViaCep() {
        }
}
