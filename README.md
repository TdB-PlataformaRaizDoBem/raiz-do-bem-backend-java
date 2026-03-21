# RaizDoBem - Challenge FIAP 2025-2026

Projeto academico de ADS (FIAP) para apoio a atendimentos odontologicos sociais (beneficiarios, dentistas, atendimentos, pedidos e enderecos).

> Ultima atualizacao desta documentacao: 2026-03-21
> Estado descrito com base no codigo atual em `src/RaizDoBem`.

## Atualizacoes recentes

- Camada DAO reorganizada para `src/RaizDoBem/Model/DAO`.
- Menu de atendimentos sem opcao de exclusao (a operacao saiu do fluxo atual).
- Visualizacao do historico total de atendimentos via listagem geral (`listarTodos`).
- Especialidades tratadas como dados fixos de apoio (apenas listagem; sem CRUD completo no momento).
- Registro de evidencias em andamento com capturas de tela dos fluxos DAO.

## Visao geral do estado atual

O projeto esta em migracao de uma base antiga (fluxo em memoria) para JDBC com Oracle. A separacao em camadas (`Model`, `DAO`, `View`) esta definida, mas alguns modulos ainda possuem metodos vazios, placeholders de entrada e pontos de ajuste SQL.

Hoje, o modulo de `Endereco` e o mais consistente no fluxo de DAO + menu.

## Pontos de entrada

- Entrada geral: `src/RaizDoBem/Main.java` (classe base do projeto, sem fluxo completo de menu no `main`).
- Entrada recomendada para uso manual: `src/RaizDoBem/Test/TestMenuInicial.java`.
- Classe auxiliar de testes de endereco: `src/RaizDoBem/Test/TestMenuEndereco.java`.

## Status por modulo

| Modulo | DAO | Menu | Estado atual |
|---|---|---|---|
| Enderecos | `adicionar`, `listarTodos`, `buscarPorId`, `listarPorCidade`, `atualizarEndereco`, `excluirEndereco` implementados | `MenuEnderecos` chama operacoes principais | Parcial avancado |
| Beneficiarios | `adicionar`, `listarTodos`, `excluirBeneficiario` implementados; filtros/listagem unica/update vazios | `MenuBeneficiarios` ainda usa objeto `null` e `id = 0` em alguns fluxos | Parcial inicial |
| Dentistas | `adicionar`, `listarTodos`, `listarPorCidade`, `listarDisponiveis`, `excluirDentista`; `atualizarDentista` vazio | `MenuDentistas` ainda usa dados placeholder (`cidade = ""`, `id = 0`) | Parcial inicial |
| Atendimentos | `adicionar`, `listarTodos`; buscas especificas vazias | `MenuAtendimentos` focado em cadastro, historico total e consultas; sem exclusao no menu atual | Parcial inicial |
| Especialidades | `listarTodos` implementado | Sem CRUD de especialidade no menu (somente consulta) | Somente leitura |
| Pedidos de ajuda | `adicionar`, `listarTodos`, `excluirPedido`; filtros/update vazios | `MenuPedidos` comentado e fora do fluxo | Parcial inicial |

## Persistencia Oracle (JDBC)

A conexao fica em `src/RaizDoBem/Model/Conexao.java` e usa `config.properties` na raiz do repositorio.

Chaves esperadas:

- `db.driver`
- `db.url`
- `db.user`
- `db.password`

Exemplo em `config.properties.example`:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=usuario
db.password=senha
```

## Como configurar

1. Copie `config.properties.example` para `config.properties`.
2. Ajuste URL, usuario e senha do Oracle.
3. Adicione o driver JDBC Oracle ao classpath do projeto na IDE.
4. Garanta as tabelas usadas pelos DAOs (`Endereco`, `Tipo_Endereco`, `Beneficiario`, `Dentista`, `Atendimento`, `Especialidade`, `Pedido_Ajuda`).

## Como executar (IntelliJ)

No estado atual, nao ha `pom.xml` nem `build.gradle`; a execucao esta orientada a IDE.

1. Abra a pasta do projeto no IntelliJ.
2. Configure o SDK Java.
3. Configure o Oracle JDBC no classpath.
4. Execute `src/RaizDoBem/Test/TestMenuInicial.java`.

## Estrutura

```text
raiz-do-bem-backend-java/
|- config.properties.example
|- README.md
|- src/
   |- RaizDoBem/
      |- Main.java
      |- Controller/
      |- Model/
      |  |- DAO/
      |- Test/
      |- View/
```

## Limitacoes tecnicas conhecidas

- Metodos DAO ainda em aberto em varios modulos (ex.: filtros, listagens especificas e updates).
- Ainda ha consultas com concatenacao de SQL em vez de parametros (risco de SQL injection e erros de aspas).
- Fluxos de menu com placeholders (`null`, `0`, string vazia) podem causar falhas de execucao.
- `Menu` principal exibe "Pedidos de ajuda", mas a opcao `1` apenas confirma escolha e nao abre submenu.
- Existem inconsistencias pontuais de pacote/import entre classes DAO durante a reorganizacao para `Model/DAO`.

## Evidencias

- Capturas de tela dos testes manuais de DAO estao sendo coletadas nesta etapa.
- Recomendacao: armazenar em uma pasta versionada (ex.: `docs/evidencias/dao/`) para rastreabilidade da sprint.

## Proximos passos recomendados

1. Padronizar consultas para `PreparedStatement` com parametros em todos os DAOs.
2. Remover `System.out.println` da camada DAO e retornar objetos/listas para impressao na camada de view.
3. Remover placeholders dos menus e coletar entrada real do usuario antes de chamar DAOs.
4. Completar CRUD e filtros de `Beneficiario`, `Atendimento` e `PedidoAjuda`.
5. Reativar/implementar `MenuPedidos` e integrar no fluxo da opcao `1` do menu principal.
6. Criar scripts SQL versionados (DDL + carga inicial) e testes de regressao por modulo.

## Observacao academica

Este repositorio segue em evolucao incremental para atender a sprint atual, com foco em consolidar persistencia JDBC e estabilizar os fluxos de menu.
