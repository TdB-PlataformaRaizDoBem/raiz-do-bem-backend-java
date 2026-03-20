# RaizDoBem - Challenge FIAP 2025-2026

Projeto academico do 1o ano de ADS (FIAP), desenvolvido em colaboracao com a ONG Turma do Bem.

O objetivo do sistema e apoiar a gestao de atendimentos odontologicos sociais (beneficiarios, dentistas, atendimentos, pedidos e enderecos), com evolucao gradual da base em memoria para persistencia em banco Oracle.

## Contexto atual (Sprint 3)

O projeto esta em fase de consolidacao da camada DAO com JDBC, priorizando persistencia de dados e padronizacao da arquitetura.

Hoje, o modulo mais maduro e o de enderecos:

- Conexao com Oracle via `Conexao.conectarAoBanco()`.
- CRUD parcial de `Endereco` com consultas relacionando `Endereco` e `Tipo_Endereco`.
- Navegacao por menu de console com fluxo ativo para modulo de enderecos.

As demais entidades ja possuem classes de dominio e DAOs criados, mas ainda estao em diferentes niveis de implementacao/refatoracao.

## O que melhorou nas ultimas atualizacoes

Com base no estado atual do codigo:

- Estrutura em camadas foi consolidada em `Model`, `DAO`, `Controller` e `View`.
- Persistencia Oracle foi integrada via JDBC com arquivo externo de configuracao (`config.properties`).
- `EnderecoDAO` recebeu operacoes reais de insercao e consultas (`listarTodos`, `listarPorId`, `listarPorCidade`, `excluirEndereco`).
- Fluxo de menu foi reorganizado para apoiar o uso modular por entidade.
- Higiene de repositorio evoluiu com separacao de configuracoes sensiveis e exemplo versionado (`config.properties.example`).
- 
---
## Avaliacao de aderencia aos requisitos (DDD Using Java - Sprint atual)

> Estimativa baseada no estado atual do repositorio (codigo e documentacao existente).  
> Pode variar apos novas refatoracoes/commits.

### 1) Requisitos de Documentacao (PDF) - 20 pts

Status geral estimado: **35% concluido**

1. **Capa [0,25]** - **0%**
  - Falta montar capa final no PDF com: integrantes, equipe e nome da solucao.

2. **Sumario [0,25]** - **0%**
  - Falta gerar sumario (automatico ou manual) com paginacao.

3. **Objetivo e escopo [2,50]** - **80%**
  - Ja existe base boa no `README`.
  - Falta migrar para PDF com redacao final academica.

4. **Descricao das funcionalidades [3,50]** - **60%**
  - Funcionalidades principais estao descritas parcialmente.
  - Falta detalhar claramente os **4 metodos logicos exigidos** com prints de execucao.

5. **Prototipo do sistema [4,50]** - **10%**
  - Menus console existem, mas faltam telas/prototipos (Figma/Canva/PPT) documentados.

6. **MER [3,50]** - **20%**
  - Estrutura de entidades existe no codigo.
  - Falta diagrama MER formal com PK/FK/relacionamentos.

7. **Diagrama de Classes [3,50]** - **35%**
  - Classes existem.
  - Falta diagrama atualizado (heranca, associacao, composicao, metodos principais).

8. **Procedimentos para rodar [2,00]** - **70%**
  - README ja traz boa base de setup/execucao.
  - Falta fechar versoes exatas e fluxo de importacao no PDF final.

---

### 2) Requisitos do Projeto Java (Codigo) - 80 pts

Status geral estimado: **58% concluido**

1. **Camada Modelo [20 pts]** - **85%**
  - Requisito de quantidade e estrutura de classes parece atendido.
  - Falta revisar padrao final de encapsulamento/consistencia geral.

2. **Metodos com logica de negocio (min. 4) [20 pts]** - **45%**
  - Existem metodos e fluxos, mas parte ainda esta mais orientada a CRUD/menu.
  - Falta evidenciar 4 metodos de regra de negocio com clareza e testes/prints.

3. **Classe de conexao com banco [10 pts]** - **90%**
  - `Conexao` implementada e funcional.
  - Observacao do enunciado: pede user/senha no codigo; atualmente usa `config.properties` (tecnicamente melhor pratica, mas pode divergir do criterio literal do avaliador).

4. **Camada DAO + CRUD completo [20 pts]** - **50%**
  - `EnderecoDAO` esta mais avancado.
  - Falta CRUD completo e consistente nas demais entidades.
  - Ainda ha pontos de ajuste (ex.: update incompleto e padronizacao de SQL parametrizado).

5. **Classes de teste [10 pts]** - **20%**
  - `Main` esta sendo usado para testes manuais.
  - Falta estruturar classes de teste por modulo/caso, com retorno dos metodos logicos.

---

## Percentual consolidado (estimativa)

- **Documentacao (PDF): 35%**
- **Codigo Java: 58%**
- **Projeto geral para os requisitos da rubrica: ~52% concluido**

> Regra pratica: voce ja tem uma base forte de arquitetura e persistencia inicial, mas ainda falta fechar os itens formais da entrega academica (PDF completo + CRUD completo + evidencias de regras de negocio).

---

## O que falta para completar (prioridade alta)

1. **Fechar CRUD completo de 1 entidade alem de Endereco** (sugestao: `Beneficiario`).
2. **Concluir `update` real no DAO** e padronizar queries com `PreparedStatement`.
3. **Definir e implementar 4 metodos de negocio claros** (com entrada, regra e saida validavel).
4. **Criar classes de teste dedicadas** (uma por contexto principal), sem depender so do menu.
5. **Produzir PDF final** com capa, sumario, objetivo/escopo, funcionalidades com prints, prototipo, MER, diagrama de classes e procedimento de execucao.
6. **Revisar compilacao ponta a ponta** antes do ZIP final para evitar penalidade grave.

## Arquitetura do projeto

```text
RaizDoBem/
|- config.properties.example
|- README.md
|- src/
   |- RaizDoBem/
      |- Main.java
      |- Controller/
      |- DAO/
      |- Model/
      |- View/
```

### Model (`src/RaizDoBem/Model`)

Camada de entidades de dominio e tipos auxiliares, como:

- `Beneficiario`, `Dentista`, `Atendimento`, `PedidoAjuda`
- `Endereco`, `TipoEndereco`
- `ProgramaSocial`, `Especialidade`, `StatusPedido`, `Sexo`
- `Conexao` (infra de acesso ao banco)

### DAO (`src/RaizDoBem/DAO`)

Camada de acesso a dados com JDBC.

Implementacoes presentes:

- `EnderecoDAO` (mais completo no momento)
- `AtendimentoDAO`, `BeneficiarioDAO`, `CoordenadorDAO`, `DentistaDAO`
- `DentistaEspecialidadeDAO`, `DentistaProgramaDAO`, `EspecialidadeDAO`, `PedidoAjudaDAO`

### Controller (`src/RaizDoBem/Controller`)

Camada de orquestracao de regras de negocio e integracao entre view e dados.

Observacao: parte do codigo de controllers ainda esta em transicao da versao em memoria para a versao persistida.

### View (`src/RaizDoBem/View`)

Menus de console para interacao com o sistema:

- `Menu` (menu principal)
- `MenuEnderecos` (fluxo com uso ativo)
- Menus das demais entidades prontos para evolucao incremental

## Persistencia Oracle (foco principal)

A conexao esta centralizada em `src/RaizDoBem/Model/Conexao.java`, lendo credenciais de `config.properties` na raiz.

Chaves utilizadas:

- `db.url`
- `db.user`
- `db.password`

Arquivo de exemplo:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=usuario
db.password=senha
```

## Como configurar o ambiente

1. Criar o arquivo `config.properties` na raiz com base em `config.properties.example`.
2. Garantir o Oracle Database acessivel pela URL JDBC configurada.
3. Garantir o driver JDBC Oracle no classpath/projeto.
4. Criar as tabelas do schema usadas pelos DAOs (prioridade: `Endereco` e `Tipo_Endereco`).

## Como executar

No estado atual, a entrada principal esta em `src/RaizDoBem/Main.java` e o menu inicial em `src/RaizDoBem/View/Menu.java`.

Fluxo pratico:

1. Configurar banco e `config.properties`.
2. Executar `Main` pela IDE.
3. Navegar pelo menu e validar operacoes do modulo de enderecos.

## O que falta (prioridades tecnicas)

Para a Sprint 3 e proximas iteracoes, os principais pontos sao:

1. Completar CRUDs das entidades alem de `Endereco`.
2. Padronizar todas as consultas para `PreparedStatement` com parametros (evitar concatenacao de SQL).
3. Implementar atualizacao real no `EnderecoDAO.atualizarEndereco` (hoje esta incompleto).
4. Melhorar tratamento de erro e mensagens para diagnostico em ambiente de teste.
5. Criar scripts SQL versionados (DDL + carga inicial).
6. Adicionar testes (principalmente para DAOs e fluxos criticos de menu).

## Boas praticas recomendadas para evolucao

- **Versionamento incremental**: commits pequenos e descritivos por funcionalidade.
- **Refatoracao segura**: alterar pouco por vez e testar logo apos cada mudanca.
- **Padrao de persistencia**: sempre preferir SQL parametrizado com `PreparedStatement`.
- **Separacao de responsabilidades**: manter regras de negocio no controller/servico, evitando logica na view.
- **Padronizacao de nomenclatura**: alinhar nomes Java e nomes SQL para reduzir bugs de mapeamento.
- **Confiabilidade**: registrar erros com contexto (operacao, entidade, ID) para facilitar troubleshooting.

## Roadmap sugerido (curto prazo)

- Fechar modulo `Endereco` com update validado ponta a ponta.
- Escolher a proxima entidade prioritaria (ex.: `Beneficiario`) e replicar o padrao DAO completo.
- Integrar menus dessa entidade com operacoes de banco.
- Introduzir uma camada de servico para reduzir acoplamento menu-DAO.
- Preparar base para testes automatizados e pipeline inicial de qualidade.

## Status do projeto

Projeto ativo, em processo de refatoracao e estruturacao para crescimento continuo.

O foco atual esta correto para Sprint 3: fortalecer persistencia Oracle, estabilizar fluxos principais e evoluir com versionamento disciplinado no GitHub.
