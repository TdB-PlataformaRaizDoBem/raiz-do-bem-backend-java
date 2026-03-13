# RaizDoBem

Projeto acadêmico desenvolvido para o **Challenge FIAP 2025-2026** do **1º ano de Análise e Desenvolvimento de Sistemas**, em colaboração com a **ONG Turma do Bem**.

O sistema foi criado para apoiar a organização de informações relacionadas a atendimentos odontológicos sociais, com foco no cadastro e gerenciamento de entidades como beneficiários, dentistas, pedidos de ajuda, atendimentos e endereços.

## Contexto do Challenge

O `RaizDoBem` nasce como uma solução acadêmica voltada para uma necessidade social real: estruturar, de forma simples e evolutiva, o controle de dados de uma operação ligada ao atendimento odontológico solidário.

No contexto do Challenge, a proposta do projeto é unir:

- modelagem de domínio;
- lógica de negócio em Java;
- organização por camadas;
- evolução incremental por sprint;
- integração com banco de dados Oracle.

Nesta fase do projeto, o principal objetivo técnico é preparar e consolidar a **Sprint 3**, cujo foco está na **persistência em banco de dados Oracle**.

## Objetivo do sistema

O sistema busca centralizar o registro e a consulta de dados importantes para o fluxo de atendimento, permitindo evoluir de uma aplicação inicialmente voltada à execução em memória para uma base mais estruturada, persistente e preparada para crescer.

Entre os objetivos do projeto, estão:

- organizar pedidos de ajuda;
- cadastrar beneficiários;
- cadastrar dentistas;
- registrar atendimentos;
- armazenar endereços;
- iniciar a persistência relacional com Oracle Database.

## Foco atual: Sprint 3

A Sprint 3 marca a transição do projeto para uma arquitetura mais próxima de um sistema real, com ênfase em persistência de dados.

### Prioridades da Sprint 3

- configurar conexão com banco Oracle via JDBC;
- estruturar os DAOs do sistema;
- persistir dados em banco em vez de manter apenas armazenamento temporário em memória;
- consolidar a camada de modelos;
- preparar a aplicação para expansão nas próximas entregas.

### Situação atual da Sprint 3

Com base no código do repositório, o projeto já possui:

- classe de conexão com banco em `src/RaizDoBem/Model/Conexao.java`;
- arquivo de configuração de exemplo em `config.properties.example`;
- implementação concreta de inserção de endereço em banco por meio de `src/RaizDoBem/DAO/EnderecoDAO.java`;
- estrutura de pacotes `Model`, `DAO`, `Controller` e `View` organizada para evolução.

Ao mesmo tempo, o repositório mostra que a persistência ainda está **parcialmente implementada**:

- o fluxo principal ativo hoje está concentrado no teste de gravação de endereço;
- vários DAOs ainda estão como estrutura inicial, sem implementação completa;
- parte dos controllers e da view em console permanece comentada, indicando refatoração em andamento.

## Arquitetura do projeto

O projeto está organizado em pacotes que separam responsabilidades principais.

### `Model`
Contém as entidades de domínio e a classe de conexão com o banco.

Exemplos encontrados no repositório:

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
Camada destinada ao acesso a dados e persistência.

Arquivos identificados:

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

> Neste momento, a implementação funcional de persistência encontrada com clareza está em `EnderecoDAO`, responsável por inserir registros de endereço no banco Oracle.

### `Controller`
Camada voltada ao gerenciamento das regras e do fluxo da aplicação.

Arquivos identificados:

- `GerenciaAtendimentos`
- `GerenciaBeneficiarios`
- `GerenciaDentistas`
- `Gerenciador`
- `GerenciaEndereco`
- `GerenciaPedido`

> Parte dessa camada ainda reflete a abordagem anterior baseada em listas em memória e menus de console, servindo como base para refatoração.

### `View`
Responsável pela interface em console.

Arquivo encontrado:

- `Menu`

> O arquivo `src/RaizDoBem/View/Menu.java` está atualmente comentado no repositório, o que indica que o fluxo completo de navegação textual ainda está em revisão ou adaptação para a nova fase com persistência.

## Estrutura de pastas

```text
RaizDoBem/
├─ config.properties
├─ config.properties.example
├─ src/
│  └─ RaizDoBem/
│     ├─ Main.java
│     ├─ Controller/
│     ├─ DAO/
│     ├─ Model/
│     └─ View/
```

## Entidades principais do domínio

A partir das classes do projeto, o domínio do sistema é composto principalmente por:

### `Endereco`
Representa o endereço associado a beneficiários e dentistas.

Campos identificados na classe:

- `idEndereco`
- `logradouro`
- `cep`
- `numero`
- `cidade`
- `estado`
- `tipoEndereco`

### `Beneficiario`
Representa a pessoa atendida pelo projeto social.

Campos identificados:

- `idBeneficiario`
- `cpfBeneficiario`
- `nomeCompleto`
- `dataNascimento`
- `sexo`
- `tipoBeneficiario`
- `endereco`

### `Dentista`
Representa o profissional associado aos atendimentos.

Campos identificados:

- `idDentista`
- `croDentista`
- `especialidade`
- `isDisponivel`
- `nivelDentista`
- `endResidencial`
- `endProfissional`

### `Atendimento`
Representa o vínculo entre beneficiário, dentista e ocorrência de atendimento.

Campos identificados:

- `idAtendimento`
- `descricao`
- `dataAtendimento`
- `beneficiario`
- `dentista`

### `PedidoAjuda`
Representa a solicitação inicial registrada para acompanhamento.

## Fluxo atual da aplicação

O ponto de entrada do projeto está em `src/RaizDoBem/Main.java`.

Hoje, o `main` mostra dois contextos no código:

1. um fluxo anterior, comentado, com criação manual de objetos e uso da interface de menu;
2. um fluxo ativo, mais enxuto, focado em testar persistência de endereço no banco Oracle.

Na prática, o trecho atualmente executado faz:

- instanciação de um objeto `Endereco`;
- criação de `EnderecoDAO`;
- chamada do método `adicionar(end1)` para inserir o endereço no banco.

Isso mostra que o projeto já está direcionado para a camada de persistência, mesmo que a integração completa de todas as entidades ainda esteja em evolução.

## Persistência com Oracle

A principal frente técnica do projeto neste momento é a integração com **Oracle Database** usando **JDBC**.

### Conexão com o banco

A conexão é feita pela classe `src/RaizDoBem/Model/Conexao.java`, que lê credenciais a partir de um arquivo `config.properties` na raiz do projeto.

O arquivo de exemplo disponível no repositório é:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.username=usuario
db.password=senha
```

### Observação importante

No código atual da classe `Conexao`, as propriedades lidas são:

- `db.url`
- `db.user`
- `db.password`

Já no arquivo `config.properties.example`, a chave apresentada para usuário é `db.username`.

Ou seja: antes de rodar o projeto, é importante alinhar esse nome no arquivo real de configuração para evitar erro de leitura da credencial.

## Persistência implementada até agora

A implementação concreta identificada no repositório é a classe `EnderecoDAO`, com o método:

- `adicionar(Endereco endereco)`

Esse método executa um `INSERT` na tabela `Endereco` com os campos:

- `logradouro`
- `cep`
- `numero`
- `cidade`
- `estado`

### Query atualmente usada

```sql
INSERT INTO Endereco (logradouro, cep, numero, cidade, estado)
VALUES (?, ?, ?, ?, ?)
```

## Requisitos para execução com Oracle

Para executar a persistência corretamente, o ambiente precisa ter:

- Java configurado;
- Oracle Database disponível;
- driver JDBC do Oracle no classpath do projeto;
- arquivo `config.properties` preenchido com as credenciais válidas;
- tabela `Endereco` criada previamente no banco.

## Exemplo de configuração

Crie um arquivo `config.properties` na raiz do projeto com base no exemplo do repositório.

Sugestão prática, alinhada ao código atual de `Conexao.java`:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=SEU_USUARIO
db.password=SUA_SENHA
```

## Exemplo mínimo de tabela Oracle

Como o repositório ainda não traz script SQL versionado, uma estrutura inicial coerente com o `EnderecoDAO` seria:

```sql
CREATE TABLE Endereco (
    id_endereco NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    logradouro VARCHAR2(255) NOT NULL,
    cep VARCHAR2(20) NOT NULL,
    numero VARCHAR2(20) NOT NULL,
    cidade VARCHAR2(100) NOT NULL,
    estado VARCHAR2(100) NOT NULL
);
```

> Esse script é uma base sugerida para viabilizar a execução do código atual. Se a modelagem oficial do grupo já estiver definida de outra forma, ela deve prevalecer.

## Como executar

### 1. Configure o banco Oracle

- crie o schema ou usuário que será utilizado;
- crie a tabela `Endereco`;
- garanta que o banco esteja acessível pela URL JDBC.

### 2. Configure o arquivo de propriedades

Crie o arquivo `config.properties` na raiz do projeto usando o modelo de exemplo e ajustando as credenciais reais.

### 3. Adicione o driver JDBC do Oracle ao projeto

Na IDE, inclua o driver Oracle no classpath do módulo Java.

### 4. Execute a aplicação

Rode a classe `src/RaizDoBem/Main.java`.

No estado atual do projeto, a execução tenta gravar um endereço de teste no banco configurado.

## Funcionalidades identificadas no repositório

### Já modeladas no domínio

- pedidos de ajuda;
- beneficiários;
- dentistas;
- atendimentos;
- endereços;
- papéis de colaboração e coordenação;
- tipos e especialidades auxiliares.

### Já estruturadas em código

- modelos Java para as entidades principais;
- camada DAO criada;
- conexão com banco Oracle via JDBC;
- teste de inserção de endereço em banco;
- controllers para operações de cadastro e listagem em memória.

### Ainda em evolução

- persistência completa das demais entidades;
- refatoração dos controllers para usar DAO em vez de listas locais;
- retomada ou reestruturação do menu de console;
- padronização completa entre modelo, banco e fluxo de execução;
- criação de scripts SQL oficiais do projeto.

## Pontos de atenção encontrados na análise

Durante a análise do repositório, alguns pontos importantes apareceram:

1. **Persistência parcial**  
   O projeto já iniciou a integração com Oracle, mas ela ainda não cobre todas as entidades.

2. **Inconsistência de configuração**  
   O arquivo `config.properties.example` usa `db.username`, enquanto o código de `Conexao.java` lê `db.user`.

3. **Fluxo principal temporário**  
   O `Main.java` está, neste momento, focado em testar a inserção de endereço, e não em executar todo o sistema por menu.

4. **Controllers e view comentados**  
   Parte importante do fluxo anterior está comentada, sugerindo uma transição entre a versão em memória e a versão com banco.

5. **Ausência de documentação SQL no repositório**  
   Não foi encontrado script oficial de criação das tabelas na análise do workspace.

## Próximos passos recomendados para a Sprint 3

Para consolidar a entrega da sprint, os próximos passos mais importantes são:

- padronizar o arquivo `config.properties` com a classe `Conexao`;
- criar scripts SQL oficiais do projeto;
- implementar os DAOs das demais entidades;
- ligar os controllers à camada DAO;
- restaurar ou refatorar a navegação da aplicação;
- adicionar consultas e listagens vindo do banco;
- tratar erros de conexão e SQL de forma mais robusta;
- revisar nomes de tabelas, colunas e chaves do modelo relacional.

## Valor do projeto

Além da entrega acadêmica, o `RaizDoBem` representa uma construção importante de base técnica:

- aplica conceitos de orientação a objetos;
- exercita separação por camadas;
- aproxima o sistema de um cenário real com banco relacional;
- conecta tecnologia a um contexto social relevante em parceria com a Turma do Bem.

## Status atual

**Projeto em retomada e preparação para a Sprint 3**, com foco principal em **persistência com Oracle Database**.

A estrutura do sistema já está desenhada, e o estágio atual mostra a transição da lógica local para uma base persistente, que deve servir como fundação para as próximas evoluções do Challenge.

## Autores e contexto acadêmico

Projeto desenvolvido para o **Challenge FIAP 2025-2026**, no **1º ano de ADS**, em colaboração com a **ONG Turma do Bem**, com objetivo de aplicar conhecimentos de desenvolvimento Java, modelagem de domínio e persistência de dados em um problema com impacto social.

