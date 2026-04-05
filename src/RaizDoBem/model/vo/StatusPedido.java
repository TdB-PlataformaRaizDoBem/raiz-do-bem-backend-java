package RaizDoBem.model.vo;

/**
 * Representa o status de um pedido, utilizado para indicar o estado atual de um pedido realizado por um beneficiário. Esta enumeração é utilizada para armazenar e manipular informações relacionadas ao status dos pedidos, permitindo que a ONG acompanhe o progresso e tome as ações necessárias com base no status do pedido.
 * @author Paulo
 * @since 2026-03
 * PENDENTE - O pedido foi criado, mas ainda não foi processado ou aprovado.
 * APROVADO - O pedido foi revisado e aprovado, indicando que o beneficiário está elegível para receber a assistência ou serviço solicitado.
 * REJEITADO - O pedido foi revisado e rejeitado, indicando que o beneficiário não está elegível para receber a assistência ou serviço solicitado, ou que o pedido não atende aos critérios estabelecidos pela ONG.
 */
public enum StatusPedido {
    PENDENTE,
    APROVADO,
    REJEITADO
}
