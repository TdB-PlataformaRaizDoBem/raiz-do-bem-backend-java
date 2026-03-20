# RaizDoBem

Projeto academico do Challenge FIAP (1o ano ADS), desenvolvido com foco em organizacao de atendimentos odontologicos sociais e evolucao para persistencia em Oracle Database.

## Estado atual (mar/2026)

O projeto esta em fase de transicao entre a base antiga em memoria e a camada DAO com banco.

O que esta funcional hoje:

- Conexao com Oracle via `Conexao.conectarAoBanco()`.
- CRUD parcial de enderecos em `EnderecoDAO`:
  - `adicionar(Endereco)`
  - `listarTodos()`
  - `listarPorId(int)`
  - `listarPorCidade(String)`
  - `excluirEndereco(int)`
- Menus em console com estrutura inicial ativa (`Menu` e `MenuEnderecos`).
- DAOs adicionais com metodo de insercao e/ou estrutura de listagem em progresso (`AtendimentoDAO`, `BeneficiarioDAO`, `CoordenadorDAO`, `DentistaDAO`, `PedidoAjudaDAO`).

Pontos em evolucao:

- Parte dos controllers antigos permanece comentada (codigo legado da fase em memoria).
- Alguns metodos DAO ainda estao incompletos ou com mapeamentos em ajuste.
- `Main.java` esta sendo usado como fluxo de teste de banco (listagem/exclusao/listagem de enderecos), nao como entrada final de produto.

## Atualizacoes recentes por commit

Resumo dos commits mais recentes mapeados no repositorio:

- `7191fe0` - refac 1.0.9: correcao de atributos das classes/entidades e ajustes em DAOs.
- `25ce179` - feat 1.0.8: pequenas adicoes em DAOs, renomeacoes e correcoes de classes.
- `6fe4980` - feat 1.0.7: implementacao de metodos DAO e evolucao do `EnderecoDAO`.
- `2037503` - security: remocao de arquivos sensiveis e de IDE do versionamento.
- `776c27d` - fix: resolucao de conflito no `.gitignore`.
- `71d08d6` - refac 1.0.6: mudanca inicial dos menus para novas funcionalidades.
- `8565320` - feat 1.0.5: teste de adicao de tipo de endereco junto da `EnderecoDAO`.

Leitura da evolucao:

1. O projeto consolidou a arquitetura em camadas (`Model`, `DAO`, `Controller`, `View`).
2. A persistencia de `Endereco` virou o caso mais avancado da sprint.
3. As demais entidades estao passando por ajuste de modelo e DAO para convergir ao banco.
4. A higiene de repositorio foi fortalecida com remocao de arquivos sensiveis do rastreio.

## Estrutura de pastas

```text
RaizDoBem/
|- config.properties
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

## Arquitetura atual

### Model

Entidades principais e tipos de apoio do dominio:

- `Atendimento`
- `Beneficiario`
- `Colaborador`
- `Coordenador`
- `Dentista`
- `DentistaEspecialidade`
- `DentistaTipoBeneficiario`
- `Endereco`
- `Especialidade`
- `PedidoAjuda`
- `Sexo`
- `StatusPedido`
- `TipoBeneficiario`
- `TipoEndereco`
- `Conexao`

### DAO

Arquivos presentes hoje:

- `AtendimentoDAO`
- `BeneficiarioDAO`
- `CoordenadorDAO`
- `DentistaDAO`
- `DentistaEspecialidadeDAO`
- `DentistaTipoBeneficiarioDAO`
- `EnderecoDAO`
- `EspecialidadeDAO`
- `PedidoAjudaDAO`

### Controller

Arquivos presentes:

- `Gerenciador`
- `GerenciaAtendimentos`
- `GerenciaBeneficiarios`
- `GerenciaDentistas`
- `GerenciaEndereco`
- `GerenciaPedido`

### View

Arquivos presentes:

- `Menu`
- `MenuAtendimentos`
- `MenuBeneficiarios`
- `MenuDentistas`
- `MenuEnderecos`
- `MenuPedidos`

## Persistencia com Oracle

A conexao JDBC esta centralizada em `src/RaizDoBem/Model/Conexao.java`.

A leitura de propriedades usa:

- `db.url`
- `db.user`
- `db.password`

O arquivo `config.properties.example` ja esta alinhado com essas chaves.

### Exemplo de configuracao

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=usuario
db.password=senha
```

## Como configurar

1. Configure um banco Oracle acessivel pela URL JDBC.
2. Crie `config.properties` na raiz do projeto (baseado no exemplo).
3. Garanta o driver JDBC Oracle no classpath da IDE/projeto.
4. Crie as tabelas usadas pelos DAOs (principalmente `Endereco` e `Tipo_Endereco`, que ja sao usadas em consultas com join).

## Como executar

1. Ajuste `config.properties`.
2. Garanta o Oracle em execucao e tabelas criadas.
3. Execute `src/RaizDoBem/Main.java`.

No estado atual, o `main` faz chamadas de teste para `EnderecoDAO` (listagem e exclusao por ID).

## Proximos passos recomendados

- Finalizar os metodos de leitura/atualizacao dos DAOs restantes.
- Parametrizar consultas que hoje usam concatenacao em alguns pontos.
- Evoluir o fluxo dos menus para operacoes completas por entidade.
- Adicionar scripts SQL versionados (DDL e dados iniciais).
- Cobrir os fluxos principais com testes.

## Status

Projeto ativo, em refatoracao e consolidacao da camada de persistencia Oracle, com `EnderecoDAO` como modulo mais maduro no momento.
