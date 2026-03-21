package RaizDoBem.model.vo;

/**
 * Status de um pedido de ajuda, contendo informações como id e situação. Classe utilizada para modelar os diferentes status que um pedido pode ter, como "Pendente", "Aprovado", "Reprovado".
 * @author Paulo
 * @since 2025-09
 * @param id Identificador único do status do pedido.
 * @param situacao Descrição da situação do pedido, representada por uma string.
 *
 * Exemplo de status de pedido:
 * - Em Andamento: O pedido está sendo processado ou em execução.
 * - Aprovado: O pedido foi aprovado e está aguardando conclusão.
 * - Recusado: O pedido foi recusado e não será processado.
 */
public class StatusPedido {
    private int id;
    private String situacao;

    public int getId() {
        return id;
    }

    public String getSituacao() {
        return situacao;
    }

    public StatusPedido setId(int id) {
        this.id = id;
        return this;
    }

    public StatusPedido setSituacao(String situacao) {
        this.situacao = situacao;
        return this;
    }

    public StatusPedido(int id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public StatusPedido() {
    }

    @Override
    public String toString() {
        return "\n" + id + " - Status: " + situacao;

    }
}
