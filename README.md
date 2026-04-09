# Raiz do Bem - Challenge FIAP Sprint 3

Projeto Java (console) com arquitetura em camadas para gestão de atendimento odontológico social.

**Versão**: 1.2.0  
**Status**: ✅ Código 100% Funcional (Sprint 3)  
**Última Validação**: 09/04/2026 - CRUD Endereço Completo + ViaCep + Gson

## Status Atual do Projeto

- Código-fonte principal validado e funcional.
- CRUD completo do módulo `Endereço` comprovado por execução no console.
- Integração `ViaCep + Gson` validada sem conflitos.
- Classe utilitária `Validacao` adicionada para centralizar validação de CPF.
- PDF e UML atualizados com regras de negócio e evidências de execução.
- Front-end demonstrativo publicado no Vercel com login fictício para apresentação visual.
- Projeto em fase final de refinamento documental antes do versionamento definitivo.

**Progresso estimado atual**: 97% a 98% concluído.

## Visão Geral

- Arquitetura: View → Controller → BO → DAO → VO (Domain Driven Design)
- Banco: Oracle via JDBC
- Integração Externa: ViaCep API + Gson 2.10.1
- Foco da Sprint 3: Código funcional + documentação completa
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

### Classes de apoio
- `Validacao`: validações reutilizáveis, como CPF, para apoiar diferentes controllers sem duplicar regra.

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

## Links e Ambiente de Demonstração

- Repositório GitHub: incluir o link do projeto final aqui.
- Front-end demonstrativo no Vercel: incluir o link do site aqui.

### Observação importante
O front-end no Vercel é uma versão demonstrativa, usada apenas para exibição visual do sistema.
O login disponível é fictício e não representa autenticação real de produção.

## Requisitos Sprint 3 - Status

| Requisito | Status atual | Evidência |
|-----------|--------------|-----------|
| Minimo de 6 classes modelo | ✅ Atendido (8 classes) | EnderecoTeste.java |
| Minimo de 4 métodos de negócio | ✅ Atendido (8 métodos) | Validações confirmadas |
| Classe de conexão com banco | ✅ Atendido | Conexao.java funcionando |
| Camada DAO com CRUD funcional | ✅ Atendido (7 DAOs) | CRUD Endereço validado 09/04 |
| Classes de teste com main | ✅ Atendido (8 testes) | Execução console OK |
| Integração ViaCep + Gson | ✅ Atendido | CEP 01310900 → Avenida Paulista |

## Métodos de Negócio para Evidência no PDF

- EnderecoBO.validarEndereco
- BeneficiarioBO.adicionar
- PedidoAjudaBO.validarStatus
- AtendimentoBO.validarAtendimento
- Validacao.validarCpf

## Tempo estimado para finalização

Com o código já validado e a documentação principal atualizada, o tempo restante estimado é curto: entre 2 e 4 horas para revisão final, conferência de consistência entre PDF/README/relatório e fechamento do ZIP de entrega.

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