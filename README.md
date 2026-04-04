# Raiz do Bem - Challenge FIAP 2025-2026

Projeto Java (MVC puro, sem framework) desenvolvido para o Challenge FIAP em parceria com a Turma do Bem.

## Status do Projeto

- Atualizado em: 04/04/2026
- Banco de dados: Oracle via JDBC
- Módulo de endereço: implementado em fluxo MVC completo (View -> Controller -> BO -> DAO)
- Demais módulos: em diferentes estágios de implementação

## Arquitetura

Estrutura em camadas:

- `view/`: entrada e saída no console
- `controller/`: orquestra fluxo da tela e chama regras de negócio
- `model/bo/`: validações e regras de negócio
- `model/dao/`: acesso a dados no Oracle
- `model/vo/`: entidades e enums

## Fluxo do Módulo Endereço

### 1) Entrada de dados (View)

`EnderecoView` coleta:

- CEP (8 dígitos)
- Número do endereço
- Tipo do endereço (1 = residencial, 2 = profissional)
- Cidade e ID para operações de consulta/edição/exclusão

### 2) Orquestração (Controller)

`EnderecoController` executa o fluxo:

- `adicionar()`: recebe entradas da view, valida CEP e tipo, monta entidade e persiste
- `listandoTodos()`: lista todos os endereços
- `listarPorId(id)`: busca por ID
- `listandoPorCidade(cidade)`: filtra por cidade
- `atualizar(id)`: refaz validações e atualiza registro
- `deletar(id)`: remove por ID

### 3) Regras de negócio (BO)

`EnderecoBO` aplica validações e integração externa:

- `validarCep(cep)`: valida apenas tamanho (8)
- `validarTipoEndereco(opc)`: aceita apenas 1 ou 2
- `validarEndereco(cep, numero, tipo)`: consulta ViaCEP e monta o objeto `Endereco`
- `criar`, `atualizar`, `excluir`, `listar`: encaminham para DAO após validações

### 4) Persistência (DAO)

`EnderecoDAO` executa CRUD no Oracle com `PreparedStatement`:

- `adicionar`
- `listarTodos`
- `buscarPorId`
- `listarPorCidade`
- `atualizar`
- `excluir`

### 5) Integração ViaCEP

`ViaCepController` consulta:

- URL: `https://viacep.com.br/ws/{cep}/json/`
- Parse JSON com Gson para `ViaCep`
- Se a API retornar erro, o BO lança exceção de endereço não encontrado

## Cenário Atual do Fluxo de Endereço

O fluxo MVC do módulo está implementado e funcional por chamada direta do controller em teste manual.

Observações importantes do estado atual:

- `EnderecoTeste` está preparado para validar o CRUD manualmente
- `MenuInicial` ainda não encaminha efetivamente para o menu de endereços
- `EnderecoView` contém entradas e exibição, mas não possui um `menu()` próprio

## Como Executar

### 1) Configuração de banco

1. Copie `config.properties.example` para `config.properties`
2. Preencha:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=usuario
db.password=senha
```

### 2) Executar teste do módulo Endereço

Classe principal recomendada no estado atual:

- `RaizDoBem.test.EnderecoTeste`

No arquivo de teste, descomente os blocos dos métodos que deseja validar (criar, listar, buscar, atualizar, excluir).

## Estrutura Relevante do Endereço

```text
src/RaizDoBem/
  controller/
    EnderecoController.java
    ViaCepController.java
  model/
    bo/
      EnderecoBO.java
    dao/
      EnderecoDAO.java
    vo/
      Endereco.java
      TipoEndereco.java
      ViaCep.java
  view/
    EnderecoView.java
  test/
    EnderecoTeste.java
```

## Boas Práticas já Aplicadas

- Separação por camadas MVC + BO/DAO
- DAO com `PreparedStatement`
- `try-with-resources` para conexões e statements
- Mapeamento de `ResultSet` em método específico (`mapeamento`)
- Tratamento de exceções com mensagem de domínio
