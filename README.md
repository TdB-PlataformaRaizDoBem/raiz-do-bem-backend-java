# Raiz do Bem - Challenge FIAP Sprint 3

Projeto Java (console) com arquitetura em camadas para gestão de atendimento odontológico social.

## Visão Geral

- Arquitetura: View -> Controller -> BO -> DAO -> VO
- Banco: Oracle via JDBC
- Foco da Sprint 3: código funcional + documentação completa
- Documento de entrega atual: Sprint03Java-Andamento.pdf

## Estrutura do Projeto

```text
src/RaizDoBem/
├── controller/   (orquestração de fluxo)
├── model/
│   ├── bo/       (regras de negócio e validações)
│   ├── dao/      (SQL, CRUD e mapeamento)
│   └── vo/       (entidades e enums)
├── test/         (classes com main para simulação)
└── view/         (entrada/saída via console)
```

## Módulos da Sprint 3

### Endereço
- CRUD completo
- Regras BO: validarCep, validarEndereco, validarTipoEndereco

### Dentista
- CRUD completo
- Regras BO: validarDentista, validaAtualizaDentista

### Colaborador
- CRUD completo
- Regras BO: validarColaborador, validarNovoColaborador

### Pedido de Ajuda
- CRUD completo
- Regras BO: validarPedido, validarStatus, validarCpf, validarNovoPedido

### Beneficiário
- CRUD completo
- Regra BO crítica: criação a partir de pedido aprovado

### Atendimento
- CRUD parcial intencional: C-R-U
- Sem delete por regra de negócio (preservação de histórico)

### Catálogos de apoio
- Especialidade e Programa Social: leitura/listagem

## Execução

### 1) Configuração do banco

Copie o arquivo de exemplo e ajuste credenciais:

```bash
cp config.properties.example config.properties
```

Conteúdo esperado:

```properties
db.driver=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@SEU_IP:1521:XE
db.user=usuario
db.password=senha
```

### 2) Compilar

```bash
javac -encoding UTF-8 src/RaizDoBem/**/*.java
```

### 3) Executar por classe de teste

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

Observação: as classes de teste foram usadas como ponto de entrada da validação da Sprint 3.

## Requisitos Sprint 3 - Status

| Requisito | Status atual |
|-----------|--------------|
| Minimo de 6 classes modelo | Atendido |
| Minimo de 4 métodos de negócio | Atendido |
| Classe de conexão com banco | Atendido |
| Camada DAO com CRUD funcional nos módulos aplicáveis | Atendido (Atendimento sem delete por regra de domínio) |
| Classes de teste com main | Atendido |

## Métodos de Negócio para Evidência no PDF

- EnderecoBO.validarEndereco
- BeneficiarioBO.adicionar
- PedidoAjudaBO.validarStatus
- AtendimentoBO.validarAtendimento

## Tecnologias

- Java
- Oracle JDBC
- Gson (integração ViaCep)

## Entrega

Arquivo de documentação atual no repositório:

- Sprint03Java-Andamento.pdf

Empacotamento sugerido:

```text
RaizDoBem.zip
├── Sprint03Java-Andamento.pdf
├── README.md
└── src/
```

## Equipe

- Murilo Ayabe Severino
- Paulo Cavalcante Caroba
- Renan da Silva Paulino

Turma: 1TDSPS
Instituição: FIAP