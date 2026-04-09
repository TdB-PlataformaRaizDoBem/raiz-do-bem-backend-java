# Diretrizes do Projeto - Raiz do Bem (Java)

## Contexto
- Projeto Java com arquitetura em camadas: View -> Controller -> BO -> DAO -> VO.
- Domínio principal: atendimento odontológico social (beneficiários, dentistas, pedidos, atendimentos).
- Banco Oracle via JDBC.
- Fonte de verdade dos requisitos: Sprint 3 do Challenge FIAP (DDD usando Java).

## Objetivo ao codificar
- Priorizar aderência aos critérios de avaliação da Sprint 3.
- Manter código legível, com regras de negócio na camada BO e persistência na camada DAO.
- Evitar mudanças desnecessárias de estilo e nomenclatura.

## Regras de arquitetura
- VO/entidades: apenas estado e comportamento simples de domínio.
- BO: validações, invariantes e regras de negócio.
- DAO: SQL, mapeamento de ResultSet e operações CRUD.
- Controller: orquestra fluxo entre View e BO.
- View/Testes: entradas e simulação da aplicação via main.

## Requisitos críticos da Sprint 3
- Garantir no minimo 6 classes de modelo com encapsulamento (atributos, construtores, getters/setters).
- Garantir no minimo 4 metodos com logica de negocio relevante e validavel.
- Garantir classe de conexao com banco funcional.
- Garantir camada DAO com CRUD funcional para os modulos que exigem CRUD.
- Garantir classes de teste com main para validar fluxo e regras de negocio.

## Padrao para novas implementacoes
- Validacoes de entrada sempre na BO com mensagens claras de erro.
- DAO com PreparedStatement e tratamento de recursos com try-with-resources.
- Evitar logica de negocio no DAO.
- Evitar acesso direto a banco fora da camada DAO.

## Qualidade minima antes de concluir uma tarefa
- Compilar sem erro.
- Confirmar impacto no fluxo Controller -> BO -> DAO.
- Validar caso feliz e ao menos um caso de erro de regra de negocio.
- Atualizar README ou documentacao quando houver alteracao funcional.

## Documentacao de entrega
- Ajudar a manter consistencia entre codigo e PDF da Sprint 3.
- Quando alterar funcionalidade, registrar evidencias que facilitem prints e explicacoes dos 4 metodos logicos.
- Preservar instrucoes de execucao (ferramentas, versoes e passo a passo).