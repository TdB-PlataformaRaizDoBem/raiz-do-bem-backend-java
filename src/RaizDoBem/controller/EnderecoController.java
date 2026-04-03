    package RaizDoBem.controller;

    import RaizDoBem.model.bo.EnderecoBO;
    import RaizDoBem.model.vo.Endereco;
    import RaizDoBem.model.vo.TipoEndereco;
    import RaizDoBem.view.EnderecoView;

    import java.util.ArrayList;
    import java.util.List;

    /**
     * Classe responsável por controlar as operações relacionadas aos endereços,
     * como atualização, utilizando o EnderecoDAO para acessar os dados.
     *
     * @author Paulo
     * @since 2026-03
     *
     *
     */
    public class EnderecoController {
        private EnderecoView view;
        private EnderecoBO bo;
        private Endereco endereco;

        List<Endereco> enderecos = new ArrayList<>();

        public EnderecoController(EnderecoView view) {
            this.view = view;
            this.bo = new EnderecoBO();
        }

        public EnderecoController() {
        }

        public void adicionar(){
            try {
                String cep = view.entradaCep();
                String numero = view.entradaNumero();
                TipoEndereco tipoEndereco;
                int tipo = view.entradaTipoEndereco();

                if(tipo == 1){
                    tipoEndereco = TipoEndereco.RESIDENCIAL;
                }
                else{
                    tipoEndereco = TipoEndereco.PROFISSIONAL;
                }

                endereco = bo.validarEndereco(cep, numero, tipoEndereco);
                bo.criar(endereco);
                view.exibirMensagem("Endereço criado com sucesso!!!");
                view.exibirEndereco(endereco);
            } catch (Exception e) {
                view.exibirMensagem(e.getMessage());
            }
        }

        public void listandoTodos(){
            List<Endereco> enderecos = bo.listarTodos();
            view.exibirLista(enderecos);
        }
        public void listarPorId(int id){
            id = view.entradaId();
            if(id >= 0){
                endereco = bo.buscaPorId(id);
                if(endereco != null){
                    view.exibirEndereco(endereco);
                }
            }
        }
        public void listandoPorCidade(String cidade){
            cidade = view.entradaCidade();
            List<Endereco> enderecos = bo.listarPorCidade(cidade);
            view.exibirLista(enderecos);
        }

        public void atualizar(int id){
            id = view.entradaId();
            bo.atualizar(id, endereco);
            view.exibirMensagem("Endereço " + id + " atualizado com sucesso!!!");
        }

        public void deletar(int id){
            id = view.entradaId();
            bo.excluir(id);
            view.exibirMensagem("Endereço " + id + " excluído com sucesso!!!");
        }
    }
