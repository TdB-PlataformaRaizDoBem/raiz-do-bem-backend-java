# Raiz do Bem - Challenge FIAP 2025-2026 (1o ano ADS)

Projeto Java desenvolvido em colaboração com a ONG Turma do Bem para o Challenge FIAP 2025-2026.

## Status Atual do Projeto

**Versão base publicada anteriormente:** `v1.1.0`  
**Marco dessa versão:** CRUD de `Endereco` finalizado e integrado ao Oracle (camadas View -> Controller -> DAO -> Banco).

### O que já está funcionando

- Estrutura em camadas com separação de responsabilidades:
    - `view/` (menus e entrada de dados)
    - `controller/` (regras de aplicação)
    - `model/dao/` (persistência)
    - `model/vo/` (entidades/objetos de domínio)
- Conexão com banco Oracle via JDBC (`ojdbc11`).
- CRUD completo de `Endereco` com testes via menu:
    - Criar
    - Listar todos
    - Buscar por ID
    - Buscar por cidade
    - Atualizar
    - Excluir
- Ajustes de mapeamento para reduzir repetição de código no DAO.
- Validações iniciais de entrada (ex.: CEP com 8 dígitos).

## Progresso Atual (Sprint 3)

No momento, o foco está em:

- Finalizar a `BeneficiarioController`.
- Consolidar o fluxo completo de `Beneficiario` com banco:
    - criação
    - listagens
    - atualização (campos específicos)
    - exclusão
- Iniciar e registrar os testes de integração com Oracle para beneficiários.

## Tecnologias Utilizadas

- Java (JDK 24 no ambiente atual)
- Oracle Database
- JDBC (`ojdbc11.jar`)
- IntelliJ IDEA

## Estrutura do Projeto

```text
src/RaizDoBem/
  controller/
  model/
    dao/
    vo/
  view/
  test/
```
## Como Executar
- Configurar banco Oracle e tabelas necessárias.
- Garantir dependência JDBC Oracle no classpath (ojdbc11.jar).
- Ajustar credenciais de conexão em Conexao.
- Executar classe de teste/menu inicial:
- RaizDoBem.test.TestMenuInicial
- Navegar pelos menus para testar os módulos disponíveis.

## Módulos e Andamento
- Endereço: concluído com CRUD e integração Oracle
- Beneficiário: em construção da controller e validações para testes de banco
- Demais módulos (pedido, atendimento, dentista, colaborador): em evolução

## Boas Práticas Adotadas
- DAO com PreparedStatement e parâmetros seguros.
- Uso de try-with-resources para fechamento automático de conexão/statement/resultset.
- Organização por domínio e camadas.
- Evolução incremental com testes por menu para validar integração real com banco.

Próximos Passos (curto prazo)
- Finalizar BeneficiarioController com validações e fluxos completos.
- Revisar consultas SQL e mapeamentos de BeneficiarioDAO.
- Criar roteiro de testes de integração (casos de sucesso e erro).
- Padronizar comportamento de mensagens e retornos entre controllers.
- Preparar evidências (prints/logs) para documentação da sprint.

## Versões
- v1.1.0 - CRUD de Endereço integrado ao Oracle.
- v1.2.0 - (em preparação) Beneficiário com controller consolidada + início dos testes de banco.