# Raiz do Bem - Challenge FIAP Spring 3

Projeto Java (MVC puro, sem framework) desenvolvido para o Challenge FIAP em parceria com a Turma do Bem.

## Status do Projeto

- **Atualizado em**: 06/04/2026
- **Sprint**: 3 (COMPLETA)
- **Banco de dados**: Oracle via JDBC
- **Status**: ✅ Todos os 6 CRUDs implementados e validados
- **Ponto de entrada**: `Main` mantida para execução do sistema/menu

## Arquitetura

Estrutura em camadas Domain Driven Design:

```
src/RaizDoBem/
├── view/              (Entrada/saída console)
├── controller/        (Orquestração de fluxos)
├── model/
│   ├── bo/           (Regras de negócio e validações)
│   ├── dao/          (Acesso a dados Oracle)
│   └── vo/           (Entidades e enums)
└── test/             (Classes de teste com main)
```

## Módulos Implementados Sprint 3

### 1) Endereço
**Status**: ✅ CRUD Completo (C-R-U-D)

- **DAO**: CRUD completo + `listarPorCidade()`
- **BO**: Validações + Integração ViaCep API
- **Controller/View**: Fluxo MVC completo
- **Métodos de Negócio**:
  - `validarCep()` - Valida tamanho (8 dígitos)
  - `validarEndereco()` - Consulta ViaCep e monta entidade

### 2) Dentista
**Status**: ✅ CRUD Completo (C-R-U-D)

- **DAO**: CRUD completo + `listarPorCidade()` + `listarDisponiveis()`
- **BO**: Validações de sexo, categoria, disponibilidade
- **Controller/View**: Fluxo MVC completo
- **Métodos de Negócio**:
  - `validarDentista()` - Validação completa com enum Sexo
  - `validaAtualizaDentista()` - Validação para atualização

### 3) Colaborador
**Status**: ✅ CRUD Completo (C-R-U-D)

- **DAO**: CRUD completo
- **BO**: Validações de email
- **Controller/View**: Fluxo MVC completo
- **Métodos de Negócio**:
  - `validarColaborador()` - Validação de dados iniciais
  - `validarNovoColaborador()` - Validação para atualização

### 4) Pedido de Ajuda
**Status**: ✅ CRUD Completo (C-R-U-D)

- **DAO**: CRUD completo + `listarPedidosData()` + update/delete por `id_pedido`
- **BO**: Validações de CPF/status e fluxo de aprovação com criação de beneficiário
- **Controller/View**: Fluxo MVC completo
- **Métodos de Negócio**:
  - `validarPedido()` - Validação com enum Sexo e StatusPedido
  - `validarStatus()` - Conversão int → enum
  - `validarCpf()` - Validação de CPF (11 dígitos)
  - `atualizarGerarBeneficiario()` - Atualiza pedido e cria beneficiário apenas quando status = `APROVADO`

### 5) Beneficiário
**Status**: ✅ CRUD Completo (C-R-U-D)

- **DAO**: CRUD completo + `buscarPorPrograma()` + `listarPorCidade()`
- **BO**: Validações + Integração com PedidoAjuda
- **Controller/View**: Fluxo MVC completo
- **Métodos de Negócio**:
  - `adicionar()` - **Lógica Crítica**: Cria Beneficiário apenas a partir de PedidoAjuda com status `APROVADO`
  - `validarNovoBeneficiario()` - Validação de campos

### 6) Atendimento
**Status**: ✅ CRUD Completo (C-R-U) - **SEM DELETE (por opção)**

- **DAO**: Create, Read (CPF, ID, listarTodos), Update
- **BO**: Validações de atendimento
- **Controller/View**: Fluxo MVC completo
- **Métodos de Negócio**:
  - `validarAtendimento()` - Validação de dados iniciais
  - `validarAtualizacao()` - Validação para finalização
  - `toString()` robusto para atendimento em aberto (exibição sem `NullPointerException`)

### 7) Módulos de Apoio (Catálogos Fixos)
**Status**: ✅ Implementados para listagem e validação

- **Especialidade**: catálogo fixo com listagem (`EspecialidadeDAO`)
- **Programa Social**: catálogo fixo com listagem (`ProgramaSocialDAO`)
- **Estratégia**: sem operações de criação/edição/exclusão via sistema para preservar consistência de dados de referência
- **Uso no domínio**: apoio aos vínculos de dentistas e beneficiários

## Fluxo MVC de Exemplo: Endereço

### 1) Entrada (View)
- **Classe**: `EnderecoView`
- **Coleta**: CEP (8 dígitos), Número, Tipo (1=Residencial, 2=Profissional)

### 2) Orquestração (Controller)
- **Classe**: `EnderecoController`
- **Métodos**: `adicionar()`, `listandoTodos()`, `listarPorId()`, `atualizar()`, `deletar()`

### 3) Regras de Negócio (BO)
- **Classe**: `EnderecoBO`
- **Validações**:
  - `validarCep()` - Tamanho = 8
  - `validarTipoEndereco()` - Apenas 1 ou 2
  - `validarEndereco()` - Consulta API ViaCep, monta Endereco

### 4) Persistência (DAO)
- **Classe**: `EnderecoDAO`
- **Operações**: CRUD + `listarPorCidade()`

### 5) Integração Externa
- **Classe**: `ViaCepBO`
- **API**: `https://viacep.com.br/ws/{cep}/json/`
- **Parse**: Gson para objeto `ViaCep`

## Como Executar

### 1) Configuração de Banco

```bash
# Copiar arquivo de exemplo
cp config.properties.example config.properties

# Editar com suas credenciais
vim config.properties
```

**Conteúdo esperado**:
```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=usuario
db.password=senha
```

### 2) Executar Testes por Módulo

Cada módulo possui uma classe de teste:

```bash
java RaizDoBem.test.EnderecoTeste
java RaizDoBem.test.DentistaTeste
java RaizDoBem.test.ColaboradorTeste
java RaizDoBem.test.BeneficiarioTeste
java RaizDoBem.test.PedidoTeste
java RaizDoBem.test.AtendimentoTeste
java RaizDoBem.test.EspecialidadeTeste
java RaizDoBem.test.ProgramaSocialTeste
```

**Nota**: Nos testes, descomente os métodos que deseja validar (criar, listar, buscar, atualizar, excluir).

### 3) Execução principal do sistema

Use a classe `Main` como ponto de entrada do menu principal:

```bash
java RaizDoBem.Main
```

### 4) Estrutura de Diretórios

```text
src/RaizDoBem/
├── controller/
│   ├── EnderecoController.java
│   ├── DentistaController.java
│   ├── ColaboradorController.java
│   ├── BeneficiarioController.java
│   ├── PedidoAjudaController.java
│   ├── AtendimentoController.java
│   ├── EspecialidadeController.java
│   └── ProgramaController.java
├── model/
│   ├── bo/
│   │   ├── EnderecoBO.java
│   │   ├── DentistaBO.java
│   │   ├── ColaboradorBO.java
│   │   ├── BeneficiarioBO.java
│   │   ├── PedidoAjudaBO.java
│   │   ├── AtendimentoBO.java
│   │   └── ViaCepBO.java
│   ├── dao/
│   │   ├── EnderecoDAO.java
│   │   ├── DentistaDAO.java
│   │   ├── ColaboradorDAO.java
│   │   ├── BeneficiarioDAO.java
│   │   ├── PedidoAjudaDAO.java
│   │   └── AtendimentoDAO.java
│   └── vo/
│       ├── Endereco.java
│       ├── Dentista.java
│       ├── Colaborador.java
│       ├── Beneficiario.java
│       ├── PedidoAjuda.java
│       ├── Atendimento.java
│       ├── Conexao.java
│       ├── Sexo.java (enum)
│       ├── StatusPedido.java (enum)
│       └── TipoEndereco.java (enum)
└── test/
    ├── EnderecoTeste.java
    ├── DentistaTeste.java
    ├── ColaboradorTeste.java
    ├── BeneficiarioTeste.java
    ├── PedidoTeste.java
    └── AtendimentoTeste.java
```

## Boas Práticas Implementadas

- ✅ Separação em camadas (View → Controller → BO → DAO)
- ✅ Padrão DAO com PreparedStatement
- ✅ Try-with-resources para conexões
- ✅ Mapeamento de ResultSet em método específico
- ✅ Tratamento de exceções com mensagens de domínio
- ✅ Enums para valores de domínio (Sexo, StatusPedido, TipoEndereco)
- ✅ Validações em camada BO (Business Objects)
- ✅ Integração com API externa (ViaCep)
- ✅ Catálogos fixos (Especialidade/Programa Social) como dados de referência somente leitura

## Requisitos Sprint 3 - Validação Final

| Requisito | Status | Evidência |
|-----------|--------|-----------|
| 6 classes modelo | ✅ | Endereco, Dentista, Colaborador, Beneficiario, PedidoAjuda, Atendimento |
| CRUD em DAO | ✅ | Todos implementados (Atendimento sem DELETE) |
| +4 métodos lógica negócio | ✅ | 6+ métodos em BOs |
| DAO → BO → Controller → View | ✅ | Fluxo MVC em todos os módulos |
| Validações em BO | ✅ | Validação de CPF, CEP, enums, relacionamentos |
| Teste com main() | ✅ | 8 classes de teste (inclui Especialidade e Programa Social) |
| Conexão ao Banco | ✅ | Oracle JDBC |

## Próximos Passos para Documentação

1. **Diagrama de Classes**: Atualizar com 6 classes e relacionamentos
2. **MER**: Atualizar com tabelas de atendimento, idDentista, beneficiário
3. **Protótipos**: Telas para cada CRUD
4. **Scripts SQL**: DDL e DML para todas as tabelas

