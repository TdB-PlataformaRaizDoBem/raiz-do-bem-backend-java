# Raiz do Bem - Challenge FIAP Spring 3

Projeto Java (MVC puro, sem framework) desenvolvido para o Challenge FIAP em parceria com a Turma do Bem.

## Status do Projeto

- **Atualizado em**: 07/04/2026
- **Sprint**: 3 (FINALIZADO)
- **Versão**: 1.5.3 (commit ready)
- **Banco de dados**: Oracle via JDBC (19.0+)
- **Status**: ✅ CRUDs validados + Documentação Sprint 3 completa
- **Ponto de entrada**: `Main` para menu ou classes de teste (main) para validação
- **Documentação**: PDF com UML, MER, arquitetura, protótipos e procedimentos

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

## Documentação Sprint 3 - Arquivo de Entrega

**Arquivo**: `Sprint03Java-Andamento.pdf`

Contém obrigatoriamente:

### 📋 Estrutura do PDF

1. **Capa** - Nome da equipe, integrantes (RM), projeto
2. **Sumário** - Índice com páginas
3. **Introdução** - Contexto da ONG Turma do Bem e problema resolvido
4. **Objetivo e Escopo** - Descrição clara da solução
5. **Funcionalidades Implementadas** - Lista por módulo (Endereço, Dentista, Colaborador, Beneficiário, PedidoAjuda, Atendimento)
6. **Visualização de Telas** - Screenshots do sistema com explicações
7. **Métodos com Lógica de Negócio** - 4+ métodos com:
   - Print do código-fonte
   - Explicação da lógica de negócio implementada
   - Exemplo: `validarEndereco()`, `adicionar()` (Beneficiário), `validarStatus()`, `validarAtendimento()`
8. **MER (Modelo Entidade-Relacionamento)** - Diagrama do Oracle DB com todas as tabelas
9. **Arquitetura em Camadas** - Diagrama mostrando View → Controller → BO → DAO → BD
10. **Diagrama UML Completo** - Classes com atributos + métodos de lógica implementados
11. **Procedimentos para Execução**:
    - Ferramentas necessárias (IDE, JDK, Oracle)
    - Versões requeridas
    - Passo a passo de configuração
    - Scripts SQL para banco
12. **Demonstração do Programa** - Screenshots da execução

### 📦 Arquivos de Entrega

```
RaizDoBem.zip
├── Spring03Java-Andamento.pdf       (Documentação obrigatória)
├── VALIDACAO_FINAL.md               (Checklist de validação)
├── GUIA_DOCUMENTACAO.md             (Referência de funcionalidades)
├── README.md                        (Este arquivo)
└── src/RaizDoBem/                   (Código-fonte completo)
    ├── controller/                  (8 Controllers)
    ├── model/
    │   ├── bo/                      (9 Business Objects)
    │   ├── dao/                     (10 Data Access Objects)
    │   └── vo/                      (Entidades + Enums)
    ├── view/                        (Views para entrada/saída)
    ├── test/                        (Classes de teste com main)
    └── Main.java                    (Ponto de entrada)
```

## Métodos com Lógica de Negócio Implementados

### 1️⃣ **EnderecoBO.validarEndereco()**
```java
public Endereco validarEndereco(String cep, String numero, TipoEndereco tipoEndereco) {
    // Integração ViaCep: busca automática de dados
    // Valida CEP, monta objeto com logradouro, bairro, cidade, estado
}
```
**Propósito**: Reduz entrada manual do usuário, integra com API externa

### 2️⃣ **BeneficiarioBO.adicionar()**
```java
public void adicionar(int idPedidoAjuda, int idProgramaSocial) {
    // Busca PedidoAjuda aprovado
    // Cria Beneficiário apenas se status == APROVADO
    // Transfere dados pessoais e endereço
}
```
**Propósito**: Automatiza fluxo de negócio (Pedido → Beneficiário)

### 3️⃣ **PedidoAjudaBO.validarStatus()**
```java
public StatusPedido validarStatus(int status) {
    // Converte int (1, 2, 3) para enum (PENDENTE, APROVADO, REJEITADO)
    return StatusPedido.values()[status - 1];
}
```
**Propósito**: Validação e conversão de tipo para domínio

### 4️⃣ **AtendimentoBO.validarAtendimento()**
```java
public Atendimento validarAtendimento(String descricao, int idBeneficiario, int idDentista) {
    // Cria Atendimento com dados iniciais
    // Seta dataInicial = LocalDate.now()
    return new Atendimento(descricao, idBeneficiario, idDentista);
}
```
**Propósito**: Validação e criação de atendimento com dados automáticos

### 5️⃣ **DentistaBO.validarDentista()**
```java
public Dentista validarDentista(String cro, String cpf, String nome, Sexo sexo,
                                String email, String telefone, String categoria,
                                int idEndereco, boolean disponivel) {
    return new Dentista(cro, cpf, nome, sexo, email, telefone, categoria, idEndereco, disponivel);
}
```
**Propósito**: Validação completa com enum Sexo e relacionamento com Endereço

### 6️⃣ **ColaboradorBO.validarColaborador()**
```java
public Colaborador validarColaborador(String cpf, String nome, LocalDate dataNascimento,
                                      LocalDate dataContratacao, String email) {
    return new Colaborador(cpf, nome, dataNascimento, dataContratacao, email);
}
```
**Propósito**: Validação de dados de colaborador (histórico de atendimentos)

## Próximos Passos para Evolução

1. **Interface Gráfica**: Migrar de console para Swing/JavaFX
2. **Relatórios**: Gerar relatórios em PDF (JasperReports)
3. **Dashboard**: Métricas de atendimentos por período/região
4. **Autenticação**: Login com controle de acessos
5. **API REST**: Expor funcionalidades via Spring Boot REST
6. **Mobile**: App para dentistas voluntários consultarem pacientes

### 5) Compilação e Execução Completa

```bash
# Diretório do projeto
cd src

# Compilar todas as classes
javac -encoding UTF-8 RaizDoBem/**/*.java

# Executar teste individual
java RaizDoBem.test.EnderecoTeste

# Executar menu principal
java RaizDoBem.Main
```

## Tecnologias e Dependências

| Tecnologia | Versão | Propósito |
|-----------|--------|----------|
| **Java** | 17.0+ | Linguagem principal |
| **Oracle JDBC** | 19.0+ | Driver de banco de dados |
| **Gson** | 2.8.9 | Parse JSON ViaCep |
| **Eclipse/IntelliJ/NetBeans** | Latest | IDE de desenvolvimento |

## Arquitetura em Camadas

```
USER
  ↓
┌─────────────────┐
│  VIEW (Console) │ ← Entrada: Scanner, println
├─────────────────┤
│  CONTROLLER     │ ← Orquestração: chamadas a BO
├─────────────────┤
│  BO             │ ← Lógica: validação, conversão, fluxos
├─────────────────┤
│  DAO            │ ← SQL: PreparedStatement, ResultSet
├─────────────────┤
│  BANCO ORACLE   │ ← Persistência: tabelas, constraints
└─────────────────┘
```

Cada camada conhece apenas a camada anterior (Dependency Inversion).

## Validação de Requisitos Sprint 3

✅ **Camada Modelo** (20 pts) - 6 classes + 4+ atributos cada, construtores, getters/setters
✅ **Métodos com Lógica** (20 pts) - 6 métodos com regras de negócio (validação, conversão, integração)
✅ **Conexão Banco** (10 pts) - Oracle JDBC com Conexao.getInstance()
✅ **CRUD em DAO** (20 pts) - Create, Read (busca + listagem), Update, Delete (exceto Atendimento)
✅ **Classes de Teste** (10 pts) - Classes com main() testando todas as operações
✅ **Tratamento de Exceções** - RuntimeException com mensagens de domínio

## Documentação (20 pts)

✅ **Capa, Sumário, Objetivo/Escopo**
✅ **Funcionalidades por módulo**
✅ **Protótipos de telas** (Figma)
✅ **4+ Métodos com print e explicação**
✅ **MER completo** (Oracle DB)
✅ **Diagrama UML** (atributos + métodos)
✅ **Arquitetura em camadas**
✅ **Procedimentos e scripts SQL**

## Integrantes da Equipe

- **Murilo Ayabe Severino** 
- **Paulo Cavalcante Caroba** 
- **Renan da Silva Paulino** 

**Turma**: 1TDSPS
**Instituição**: FIAP

## Licença

Projeto educacional desenvolvido para FIAP em parceria com a ONG Turma do Bem.

---

**Data de Finalização**: 07/04/2026
**Versão Final**: 1.5.3
**Status**: ✅ Pronto para submissão

