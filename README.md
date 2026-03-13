# RaizDoBem

Projeto acadêmico desenvolvido para o **Challenge FIAP 2025-2026** do **1º ano de Análise e Desenvolvimento de Sistemas (ADS)**, em colaboração com a **ONG Turma do Bem**.

O `RaizDoBem` está sendo retomado e preparado para a **Sprint 3**, com foco principal em **persistência de dados com Oracle Database**. Nesta fase, o projeto consolida a base Java orientada a objetos, organiza a arquitetura em camadas e começa a migrar do fluxo em memória para operações apoiadas por banco de dados.

## Sumário

- [Visão geral](#visão-geral)
- [Contexto do Challenge](#contexto-do-challenge)
- [Objetivo da Sprint 3](#objetivo-da-sprint-3)
- [Estado atual do projeto](#estado-atual-do-projeto)
- [Últimas atualizações mapeadas no repositório](#últimas-atualizações-mapeadas-no-repositório)
- [Arquitetura atual](#arquitetura-atual)
- [Entidades do domínio](#entidades-do-domínio)
- [Persistência com Oracle](#persistência-com-oracle)
- [Estrutura de pastas](#estrutura-de-pastas)
- [Como configurar](#como-configurar)
- [Como executar](#como-executar)
- [O que já está implementado](#o-que-já-está-implementado)
- [Pontos de atenção](#pontos-de-atenção)
- [Próximos passos da Sprint 3](#próximos-passos-da-sprint-3)
- [Valor acadêmico e social](#valor-acadêmico-e-social)

## Visão geral

O projeto foi pensado para apoiar a organização de informações relacionadas a atendimentos odontológicos sociais. A solução modela beneficiários, dentistas, atendimentos, pedidos de ajuda, endereços e perfis de colaboração, preparando a aplicação para evoluir de um protótipo em console para uma base com persistência relacional.

Hoje, o código mostra com clareza uma **fase de transição**:

- parte da estrutura original em memória ainda existe em `Controller` e `View`;
- a camada `DAO` já foi iniciada para suportar persistência;
- a integração mais concreta neste momento está em `EnderecoDAO`;
- o `Main` atual está focado em testar acesso ao banco e listagem de endereços.

## Contexto do Challenge

O `RaizDoBem` faz parte do **Challenge FIAP 2025-2026**, no contexto do **1º ano de ADS**, e está alinhado a uma proposta de aplicação prática de:

- orientação a objetos em Java;
- modelagem de domínio;
- separação por camadas;
- evolução incremental por sprint;
- persistência com banco de dados Oracle;
- conexão entre tecnologia e impacto social.

A colaboração com a **Turma do Bem** fortalece o propósito do projeto ao aproximar a solução de um cenário real de atendimento e organização de dados voltados a ações sociais na área odontológica.

## Objetivo da Sprint 3

A Sprint 3 concentra os esforços na **persistência em banco de dados Oracle**, consolidando a fundação técnica para as próximas entregas.

### Prioridades atuais

- configurar conexão JDBC com Oracle;
- validar leitura de credenciais por arquivo externo;
- estruturar os DAOs do sistema;
- substituir gradualmente listas em memória por acesso real ao banco;
- estabilizar o fluxo principal para operações persistidas.

## Estado atual do projeto

Com base na análise do repositório, o estado atual pode ser resumido assim:

### O que está ativo no código hoje

- a conexão com banco está centralizada em `src/RaizDoBem/Model/Conexao.java`;
- a classe `src/RaizDoBem/DAO/EnderecoDAO.java` já executa operações de **insert** e **listagem**;
- o `main` atual em `src/RaizDoBem/Main.java` instancia `EnderecoDAO` e chama `listarTodos()`;
- a organização em pacotes `Model`, `DAO`, `Controller` e `View` já está estabelecida.

### O que está em transição ou incompleto

- vários controllers antigos estão totalmente comentados;
- o menu principal em console está comentado em `src/RaizDoBem/View/Menu.java`;
- a maior parte dos demais DAOs ainda está apenas como estrutura vazia;
- existem sinais de refatoração de relacionamento entre classes e adaptação do domínio para a nova fase de persistência.

## Últimas atualizações mapeadas no repositório

Os commits recentes ajudam a entender a fase atual do projeto:

- `6fb719b` — **refac 1.0.4: corrigindo alguns pontos de relacionamentos entre classes**
- `90e764f` — **feat 1.0.3: listagem e insert pronto em Endereco - falta incluir tipo_endereco**
- `35f7886` — **feat 1.0.2: criando casca de menu endereo, que servir como base para a sequncia**
- `7243cc3` — **feat: v1 do cdigo ps sprint2, iniciando conexo com banco para sp3**
- `4e2ce73` — **Primeiro commit do projeto, verso da Sprint 2 praticamente, apenas com cdigos dentro das pastas**

### Leitura técnica dessas mudanças

Esses commits mostram uma evolução coerente com a Sprint 3:

1. a base da Sprint 2 foi preservada como estrutura inicial;
2. a conexão com banco começou a ser integrada;
3. a camada de menu passou a servir como esqueleto para futura retomada;
4. a entidade `Endereco` virou o primeiro caso real de persistência;
5. os relacionamentos entre classes começaram a ser ajustados para sustentar o modelo atual.

## Arquitetura atual

O projeto adota uma divisão por pacotes com responsabilidades bem separadas.

### `Model`

Concentra as entidades do domínio e a infraestrutura de conexão com o banco.

Classes identificadas:

- `Atendimento`
- `Beneficiario`
- `Colaborador`
- `Conexao`
- `Coordenador`
- `Dentista`
- `DentistaEspecialidade`
- `DentistaTipoBeneficiario`
- `Endereco`
- `Especialidade`
- `PedidoAjuda`
- `Sexo`
- `TipoBeneficiario`
- `TipoEndereco`

### `DAO`

Camada responsável pela persistência e acesso aos dados.

Arquivos existentes:

- `AtendimentoDAO`
- `BeneficiarioDAO`
- `ColaboradorDAO`
- `CoordenadorDAO`
- `DentistaDAO`
- `DentistaEspecialidadeDAO`
- `DentistaTipoBeneficiario`
- `EnderecoDAO`
- `EspecialidadeDAO`
- `PedidoAjudaDAO`

> No estado atual, a implementação funcional confirmada está concentrada em `EnderecoDAO`. Os demais arquivos dessa camada existem principalmente como preparação estrutural para a expansão da persistência.

### `Controller`

Representa a camada de gerenciamento e regras de fluxo.

Arquivos encontrados:

- `GerenciaAtendimentos`
- `GerenciaBeneficiarios`
- `GerenciaDentistas`
- `GerenciaEndereco`
- `GerenciaPedido`
- `Gerenciador`

Observações:

- `Gerenciador` segue ativo como interface genérica;
- `GerenciaPedido` está implementado com lista em memória;
- `GerenciaAtendimentos`, `GerenciaBeneficiarios`, `GerenciaDentistas` e `GerenciaEndereco` aparecem comentados, preservando a lógica anterior como base de refatoração.

### `View`

Camada de interface em console.

Arquivos existentes:

- `Menu`
- `MenuAtendimentos`
- `MenuBeneficiarios`
- `MenuDentistas`
- `MenuEnderecos`
- `MenuPedidos`

Observações:

- `Menu.java` está comentado;
- alguns menus específicos existem apenas como casca ou classe vazia;
- a navegação em console ainda não representa o fluxo principal da aplicação nesta fase.

## Entidades do domínio

A modelagem atual cobre os principais atores e registros do contexto de atendimento odontológico social.

### `Endereco`

Representa dados de localização e hoje é a entidade com integração mais direta com o banco.

Campos presentes no modelo:

- `idEndereco`
- `logradouro`
- `cep`
- `numero`
- `cidade`
- `estado`
- `tipoEndereco`

### `Beneficiario`

Representa a pessoa beneficiada pelo atendimento.

Campos observados no código atual:

- `idBeneficiario`
- `cpfBeneficiario`
- `nomeCompleto`
- `dataNascimento`
- `tipoBeneficiario`
- `endereco`

> Importante: versões antigas comentadas do código sugerem que o modelo já teve outros atributos, como sexo, mas a classe ativa atual não contém esse campo.

### `Dentista`

Representa o profissional vinculado aos atendimentos.

Campos observados:

- `croDentista`
- `especialidade`
- `isDisponivel`

Como `Dentista` herda de `Colaborador`, ele também reutiliza dados como:

- `idColaborador`
- `cpf`
- `nomeCompleto`
- `dataNascimento`
- `email`
- `endereco`

### `Atendimento`

Relaciona o atendimento em si com beneficiário e dentista.

Campos observados:

- `idAtendimento`
- `descricao`
- `dataAtendimento`
- `beneficiario`
- `dentista`

### `PedidoAjuda`

Representa uma solicitação inicial ou demanda registrada.

Campos presentes na classe atual:

- `idPedido`
- `descricaoProblema`
- `dataPedido`
- `statusPedido`

### Outras classes auxiliares

Também fazem parte do modelo:

- `TipoBeneficiario`
- `TipoEndereco`
- `Sexo`
- `Especialidade`
- `Coordenador`
- `DentistaEspecialidade`
- `DentistaTipoBeneficiario`

## Persistência com Oracle

Este é o principal foco técnico da fase atual do projeto.

### Conexão JDBC

A conexão está centralizada em `src/RaizDoBem/Model/Conexao.java`.

A classe:

- lê as propriedades a partir de `config.properties` na raiz do projeto;
- recupera `db.url`, `db.user` e `db.password`;
- abre a conexão usando `DriverManager.getConnection(...)`;
- imprime uma mensagem de sucesso ao conectar.

---
Arquivo de exemplo versionado:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.username=usuario
db.password=senha
```

### Ponto de atenção importante

Existe uma inconsistência entre o arquivo de exemplo e o código:

- `Conexao.java` lê `db.user`;
- `config.properties.example` usa `db.username`.

Para o projeto funcionar como está hoje, a chave precisa estar alinhada com **`db.user`**.

### Persistência implementada em `EnderecoDAO`

A classe `src/RaizDoBem/DAO/EnderecoDAO.java` já possui:

- `adicionar(Endereco endereco)`
- `listarTodos()`

A operação de inserção usa a query:

```sql
INSERT INTO Endereco (logradouro, cep, numero, cidade, estado)
VALUES (?, ?, ?, ?, ?)
```

Já a listagem faz uma consulta simples em toda a tabela e monta objetos `Endereco` a partir do `ResultSet`.

### O que isso significa para a Sprint 3

Na prática, `Endereco` é hoje o **primeiro caso concreto de persistência Oracle no projeto**. Isso torna essa entidade a melhor referência para:

- padronizar convenções da camada DAO;
- definir nomes de tabela e colunas;
- preparar CRUD completo;
- replicar a estratégia para beneficiários, dentistas, pedidos e atendimentos.

## Estrutura de pastas

```text
RaizDoBem/
├─ config.properties
├─ config.properties.example
├─ README.md
├─ src/
│  └─ RaizDoBem/
│     ├─ Main.java
│     ├─ Controller/
│     ├─ DAO/
│     ├─ Model/
│     └─ View/
```

## Como configurar

### 1. Preparar o Oracle Database

Garanta que o ambiente Oracle esteja acessível pela URL JDBC definida no projeto.

### 2. Criar o arquivo de configuração

Use `config.properties.example` como base, mas ajuste o nome da propriedade do usuário para ficar compatível com o código atual.

Exemplo compatível com `Conexao.java`:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@localhost:1521/FREEPDB1
db.user=SEU_USUARIO
db.password=SUA_SENHA
```

### 3. Adicionar o driver JDBC do Oracle

O projeto depende do driver JDBC do Oracle disponível no classpath da IDE ou do módulo Java configurado localmente.

### 4. Criar a tabela inicial usada pela camada DAO

Como ainda não há script SQL oficial versionado no repositório, uma base mínima coerente com o código atual é:

```sql
CREATE TABLE Endereco (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    logradouro VARCHAR2(255) NOT NULL,
    cep VARCHAR2(20) NOT NULL,
    numero VARCHAR2(20) NOT NULL,
    cidade VARCHAR2(100) NOT NULL,
    estado VARCHAR2(100) NOT NULL
);
```

> Esse script serve como ponto de partida para viabilizar a execução do código atual. Caso a modelagem oficial da equipe já tenha outro padrão, ela deve prevalecer.

## Como executar

Com base no estado atual do projeto, o caminho de execução é simples:

1. configurar o Oracle;
2. criar a tabela `Endereco`;
3. criar ou ajustar `config.properties`;
4. garantir o driver JDBC no projeto;
5. executar `src/RaizDoBem/Main.java`.

No estado atual, o `main` faz o seguinte:

- instancia `EnderecoDAO`;
- chama `listarTodos()`;
- usa a conexão Oracle para buscar os endereços existentes.

## O que já está implementado

### Já existe e está visível no código

- modelagem de entidades principais do domínio;
- separação em camadas `Model`, `DAO`, `Controller` e `View`;
- conexão com Oracle via JDBC;
- persistência inicial de `Endereco` com inserção;
- listagem de endereços no banco;
- interface `Gerenciador` para padronizar operações de controller;
- controlador de pedidos ainda funcionando em memória.

### Estrutura pronta para expansão

- DAOs para outras entidades já criados como base;
- menus específicos separados por contexto;
- relacionamento entre classes sendo refinado;
- projeto preparado para evoluir de protótipo para aplicação persistente.

## Pontos de atenção

Durante a análise do repositório, apareceram alguns pontos importantes que merecem ficar documentados:

1. **Persistência parcial**  
   A integração com Oracle já começou, mas ainda está consolidada principalmente em `EnderecoDAO`.

2. **Fluxo principal ainda provisório**  
   O `Main.java` atual está voltado a teste de listagem no banco, não à navegação completa por menus.

3. **Controllers e views em refatoração**  
   Boa parte do fluxo anterior está comentada ou incompleta, o que indica migração em andamento da versão em memória.

4. **Inconsistência de configuração**  
   O exemplo usa `db.username`, mas o código lê `db.user`.

5. **Ausência de script SQL oficial versionado**  
   Ainda não há no repositório um pacote formal de criação das tabelas.

6. **Domínio ainda em ajuste**  
   Alguns arquivos comentados mostram assinaturas antigas de construtores e atributos que já não batem com as classes ativas atuais.

7. **Existem sinais de inconsistência entre classes legadas**  
   Parte do código preservado da versão anterior ainda não representa exatamente o modelo atual, então ele deve ser tratado como referência histórica e não como fluxo ativo.

## Próximos passos da Sprint 3

Para fortalecer a entrega com foco em persistência Oracle, os próximos passos mais importantes são:

- padronizar `config.properties.example` com `Conexao.java`;
- versionar scripts SQL oficiais do projeto;
- completar o CRUD de `Endereco`;
- implementar os DAOs de `Beneficiario`, `Dentista`, `PedidoAjuda` e `Atendimento`;
- migrar controllers para consumo real dos DAOs;
- retomar o menu de console usando dados persistidos;
- revisar relacionamentos entre entidades e banco;
- tratar exceções SQL com mais clareza;
- consolidar uma rotina de testes para conexão e operações básicas.

## Valor acadêmico e social

O `RaizDoBem` tem valor em duas frentes complementares.

### Acadêmica

O projeto exercita competências centrais do curso:

- Java orientado a objetos;
- modelagem de domínio;
- organização por camadas;
- integração com banco relacional;
- evolução incremental por sprint.

### Social

Ao ser desenvolvido em colaboração com a **ONG Turma do Bem**, o projeto reforça a aplicação da tecnologia em um contexto de impacto real, conectado à organização de atendimentos e informações relevantes para ações sociais na área odontológica.

---

## Status atual

**Projeto em retomada, com base da Sprint 2 preservada e preparação ativa para a Sprint 3, priorizando persistência com Oracle Database.**

A estrutura já existe, a conexão com banco já foi iniciada, e `Endereco` hoje representa o primeiro módulo concreto dessa virada para uma aplicação mais próxima de um sistema real.
