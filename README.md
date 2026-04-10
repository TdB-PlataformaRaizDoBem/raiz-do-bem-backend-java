# Raiz do Bem - Challenge FIAP Sprint 3

Projeto Java em console com arquitetura em camadas para gestão de atendimento odontológico social, desenvolvido com foco em persistência Oracle, regras de negócio na camada BO, melhoria de UX no fluxo do console e documentação de entrega da Sprint 3.

**Versão**: 1.6.1  
**Status**: ✅ Projeto finalizado para submissão, com UX do código refinada  
**Última Validação**: 10/04/2026 - Fluxos de Dentista, Atendimento e Pedido validados em console

## Status Atual do Projeto

- Backend Java validado e funcional.
- Módulo `Endereço` com CRUD completo comprovado em execução real.
- Integração `ViaCep + Gson` validada sem conflitos.
- Classe utilitária `Validacao` usada para centralizar validação de CPF.
- Módulos `ProgramaSocial` e `Especialidade` validados como catálogos de apoio/listagem.
- Nova validação de triagem no `Pedido de Ajuda`: solicitantes do sexo masculino com idade igual ou superior a 18 anos são marcados como `REJEITADO` na criação.
- Módulo `Beneficiário` validado com listagem, busca por CPF, listagem por programa, listagem por cidade, atualização e exclusão.
- Módulo `Dentista` validado com ciclo completo: criação, listagem, busca por CPF, listagem por disponíveis, atualização e exclusão.
- Módulo `Atendimento` validado com criação, listagem, busca por CPF e atualização/finalização.
- Front-end demonstrativo publicado no Vercel com login fictício para apoio visual.
- Documentação alinhada para fechamento da Sprint 3 e submissão final.
- Mensagens de console e validações de entrada revisadas para deixar o uso mais claro durante a demonstração.

**Progresso estimado atual**: 100% concluído para entrega.

## Visão Geral

- Arquitetura: `View → Controller → BO → DAO → VO` (Domain Driven Design)
- Banco: Oracle via JDBC
- Integração externa: ViaCep API + Gson 2.10.1
- Foco da Sprint 3: código funcional + documentação completa + validações de fluxo + fechamento final de UX no console
- Documento de entrega atual: `Sprint03Java-Andamento.pdf` (cópia de submissão: `Sprint3_FIAP_Java.pdf`)

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

### Núcleo da solução
- `Endereço`
- `Dentista`
- `Colaborador`
- `Pedido de Ajuda`
- `Beneficiário`
- `Atendimento`

### Endereço
- CRUD completo
- Regras BO: validarCep, validarEndereco, validarTipoEndereco

### Dentista
- CRUD completo
- Regras BO: validarDentista, validaAtualizaDentista
- Fluxos validados em console: listagem, criação, busca por CPF, listagem por disponibilidade, atualização e exclusão.

### Colaborador
- CRUD completo
- Regras BO: validarColaborador, validarNovoColaborador

### Pedido de Ajuda
- CRUD completo
- Regras BO: validarPedido, validarStatus, validarCpf, validarNovoPedido
- Regra de triagem adicional: pedidos de homens com idade >= 18 anos podem ser automaticamente rejeitados na criação, conforme validação aplicada na controller.

### Beneficiário
- CRUD completo
- Regra BO crítica: criação a partir de pedido aprovado
- Fluxos validados em console: listagem, busca por CPF, listagem por programa, listagem por cidade, atualização e exclusão.

### Atendimento
- CRUD parcial intencional: C-R-U
- Sem delete por regra de negócio (preservação de histórico)
- Fluxos validados em console: criação, listagem, busca por CPF e atualização com encerramento.

### Catálogos de apoio
- Especialidade e Programa Social: leitura/listagem

### Classes de apoio
- `Validacao`: validações reutilizáveis, como CPF, para apoiar diferentes controllers sem duplicar regra.

## Validações recentes já comprovadas

- CRUD completo do módulo `Endereço` com criação, listagem, busca por ID, busca por cidade, atualização e exclusão.
- Integração com ViaCep retornando endereço real a partir do CEP.
- Listagem funcional dos módulos de apoio `ProgramaSocial` e `Especialidade`.
- Fluxo MVC validado com entrada pelo console e persistência Oracle.
- Regra adicional de negócio validada no `Pedido de Ajuda`: solicitantes do sexo masculino com 18 anos ou mais são cadastrados com status `REJEITADO`.
- Fluxo de `Beneficiário` validado com listagem, busca por CPF, listagem por programa, listagem por cidade, atualização e exclusão.
- Fluxo de `PedidoTeste` validado com criação, listagem, atualização, exclusão e confirmação por query.
- Fluxo de `Dentista` validado com ciclo completo de CRUD em console.
- Fluxo de `Atendimento` validado com criação, busca por CPF e finalização via update.
- Fluxo central `PedidoAjuda -> Beneficiário -> Atendimento` consolidado com evidências no PDF.

## O que ainda falta concluir

- Conferência final dos prints/evidências usados na documentação.
- Fechamento do versionamento final no GitHub com commit e tag de referência.
- Última leitura do PDF para validar capa, sumário, links e nomes de arquivo.
- Revisão ortográfica final das legendas e textos do PDF.

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

**Observação**: As classes de teste foram usadas como ponto de entrada da validação da Sprint 3.

### 4) Validação de Integração ViaCep + Gson (Comprovado 09/04/2026)

**Classe**: `EnderecoTeste.java`  
**Evidência**: CRUD Completo com Integração Externa

```
✅ CREATE - Novo Endereço via ViaCep
   Input: CEP 01310900, Número 556, Tipo: Profissional
   Output: Avenida Paulista, 556 - Cep: 01310900 | São Paulo - SP

✅ READ - Listar Todos (13 endereços + novo)
   Registros exibidos com ID, logradouro, CEP, cidade, tipo

✅ READ - Buscar por ID (ID: 22)
   Encontrado: Avenida Paulista, 556 - Cep: 01310900

✅ READ - Filtrar por Cidade (Belo Horizonte)
   Retornados 2 endereços da cidade especificada

✅ UPDATE - Atualizar ID 22
   Novo CEP: 01419002, Número: 789, Tipo: Profissional
   Mensagem: "Endereço 22 atualizado com sucesso!!!"

✅ DELETE - Excluir ID 22
   Mensagem: "Endereço 22 excluído com sucesso!!!"
   Verificação: Endereço não aparece mais na listagem final

Biblioteca Gson 2.10.1: ✅ SEM CONFLITOS
Banco Oracle JDBC: ✅ CONECTADO
Fluxo MVC: ✅ COMPLETO
```

### 5) Validação do Fluxo de Pedido de Ajuda (Comprovado 09/04/2026)

**Classe**: `PedidoTeste.java`

```
✅ CREATE - Novo pedido de ajuda
   Input: CPF 88899983867, nome Ian Souza Mota, nascimento 19/10/1972, sexo masculino
   Output: Pedido de ajuda criado com status REJEITADO pela regra de triagem

✅ READ - Listar todos os pedidos
   Registros exibidos com status, data, CPF e descrição

✅ READ - Consulta de confirmação via query
   Verificado pedido específico no banco após criação/atualização

✅ UPDATE - Atualizar pedido por ID
   ID 61 atualizado para status APROVADO com dentista responsável

✅ DELETE - Excluir pedido por ID
   ID 5 removido com sucesso

✅ READ - Listagem final
   Pedido excluído não aparece mais; pedido 62 permanece com REJEITADO

Regra de triagem: ✅ aplicada na criação
Fluxo console: ✅ validado no terminal da IDE
```

## Links e Ambiente de Demonstração

- Repositório GitHub: incluir o link do projeto final aqui.
- Front-end demonstrativo no Vercel: incluir o link do site aqui.

### Observação importante
O front-end no Vercel é uma versão demonstrativa, usada apenas para exibição visual do sistema.
O login disponível é fictício e não representa autenticação real de produção.

## Requisitos Sprint 3 - Status

| Requisito | Status atual | Evidência |
|-----------|--------------|-----------|
| Minimo de 6 classes modelo | ✅ Atendido | Classes VO principais do domínio |
| Minimo de 4 métodos de negócio | ✅ Atendido | Validações confirmadas nas BOs |
| Classe de conexão com banco | ✅ Atendido | Conexao.java funcionando |
| Camada DAO com CRUD funcional | ✅ Atendido | CRUD Endereço e Pedido validados 09/04 |
| Classes de teste com main | ✅ Atendido | Execução console OK |
| Integração ViaCep + Gson | ✅ Atendido | CEP 01310900 → Avenida Paulista |

## Métodos de Negócio para Evidência no PDF

- EnderecoBO.validarEndereco
- BeneficiarioBO.adicionar
- PedidoAjudaBO.validarStatus
- AtendimentoBO.validarAtendimento
- Validacao.validarCpf
- PedidoAjudaController.adicionar (triagem por idade/sexo na criação)
- PedidoTeste.java (criação, listagem, atualização, exclusão e confirmação por query)

## Tempo estimado para finalização

Com o código já validado e a documentação principal consolidada, o tempo restante é apenas de conferência final do PDF, links e empacotamento da entrega.

## Tecnologias

- **Java**: JDK 24.0.1
- **Oracle JDBC**: ojdbc11.jar (Oracle JDBC 11.2.0.4.0)
- **Gson**: 2.10.1 (Desserialização JSON ViaCep)
- **IDE**: IntelliJ IDEA 2025.1.1
- **Banco**: Oracle Database 11g XE

## Equipe

- Murilo Ayabe Severino
- Paulo Cavalcante Caroba
- Renan da Silva Paulino

Turma: 1TDSPS
Instituição: FIAP