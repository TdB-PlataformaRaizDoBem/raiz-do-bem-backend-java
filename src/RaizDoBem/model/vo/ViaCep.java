package RaizDoBem.model.vo;

/**
 * Classe VO que representa os dados de dominio de ViaCep.
 * Camada: VO.
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

        /**
 * Construtor com ID para listagem e consultas.
 */
        public ViaCep(String cep, String logradouro, String bairro, String localidade, String uf, boolean erro) {

                this.cep = cep;
                this.logradouro = logradouro;
                this.bairro = bairro;
                this.localidade = localidade;
                this.uf = uf;
                this.erro = erro;
        }

        /**
 * Construtor com ID para listagem e consultas.
 */
        public ViaCep(String logradouro, String bairro, String localidade, String uf) {

                this.logradouro = logradouro;
                this.bairro = bairro;
                this.localidade = localidade;
                this.uf = uf;
        }

        /**
         * Inicializa a classe com as dependencias necessarias para o fluxo do modulo.
         */
        public ViaCep() {
        }
}
