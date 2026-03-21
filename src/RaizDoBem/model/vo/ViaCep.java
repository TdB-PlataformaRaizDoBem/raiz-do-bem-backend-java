package RaizDoBem.model.vo;

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
