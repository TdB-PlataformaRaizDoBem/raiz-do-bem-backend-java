# Raiz do Bem - Challenge FIAP 2025-2026 (1o ano ADS)

Projeto Java desenvolvido em colaboração com a ONG Turma do Bem para o Challenge FIAP 2025-2026.

## 📌 Status Atual do Projeto

**Versão:** `v1.2.0`  
**Data última atualização:** Abril 2026  
**Banco de Dados:** ✅ Finalizado  
**Prazo para finalizar back-end:** Próxima sexta (7 dias)

## ✅ O que já está funcionando

### Módulo Endereço (COMPLETO E TESTADO)
- ✅ CRUD completo integrado ao Oracle
- ✅ Validação via ViaCepController (integração com API externa)
- ✅ Fluxo correto View → Controller → BO → DAO
- ✅ Testes manuais via MenuInicial (opção 6)
- ✅ Estrutura pronta para ser replicada em outros módulos

### Infraestrutura Geral
- Estrutura em 3 camadas com separação de responsabilidades:
  - `view/` (menus e entrada de dados)
  - `controller/` (integração entre view e regras de negócio)
  - `model/bo/` (Business Objects - validações e regras)
  - `model/dao/` (persistência em banco de dados)
  - `model/vo/` (entidades/objetos de domínio)
- Conexão com banco Oracle via JDBC (`ojdbc11`)
- MenuInicial.java centraliza toda navegação
- config.properties para configuração de conexão

## 🔄 Padrão de Desenvolvimento (IMPORTANTE!)

### Estrutura que DEVE ser replicada em todos os módulos:

```java
// Pattern estabelecido no módulo Endereço:

// 1. VIEW (classe com menu() e métodos de entrada)
public class MinhaView {
    private Scanner sc = new Scanner(System.in);
    
    // Métodos de captura de entrada
    public String entradaCep() { ... }
    public int entradaId() { ... }
    
    // Menu interativo
    public int exibirMenu() { ... }
    
    // IMPORTANTE: Método menu() que faz o loop
    public void menu() {
        MinhaController controller = new MinhaController(this);
        int opcao;
        do {
            opcao = exibirMenu();
            if(opcao != 7 && opcao != 0) {
                controller.executar();
            }
        } while(opcao != 7 && opcao != 0);
    }
}

// 2. CONTROLLER (integra view e BO)
public class MinhaController {
    private MinhaView view;
    private MinhaBO bo;
    
    public void executar() {
        int retornoMenu = view.exibirMenu();
        // Switch com cases para cada opção
        // SEMPRE usar BO para lógica de negócio
    }
}

// 3. BO (Business Objects - validações)
public class MinhaBO {
    private MinhaDAO dao = new MinhaDAO();
    
    public void criar(Entidade obj) {
        if(validar(obj)) {
            dao.adicionar(obj);
        }
    }
}

// 4. DAO (persistência - CRUD)
public class MinhaDAO {
    public void adicionar(Entidade obj) { ... }
    public Entidade buscarPorId(int id) { ... }
    public List<Entidade> listarTodos() { ... }
    public void atualizar(int id, Entidade obj) { ... }
    public void excluir(int id) { ... }
}
```

## 📋 Checklist de Tarefas (Próxima Sexta)

### Fase 1: Validar Módulo Endereço
- [ ] Testar criação de endereço via MenuInicial → opção 6
- [ ] Testar listagem de todos
- [ ] Testar busca por ID
- [ ] Testar busca por cidade
- [ ] Testar atualização
- [ ] Testar exclusão
- [ ] Validar integração com ViaCep

### Fase 2: Replicar em Outros Módulos
Padrão: **View → Controller → BO → DAO**

Módulos pendentes (aplicar o padrão de Endereço):
- [ ] **BeneficiarioController** 
  - Método `menu()` em BeneficiarioView
  - Usar BO para validações
  - Refatorar controller para não chamar método inexistente
  
- [ ] **DentistaController**
  - Mesmo padrão de Beneficiário
  - Validações específicas
  
- [ ] **AtendimentoController**
  - Mesmo padrão
  - Integração com Beneficiário e Dentista
  
- [ ] **PedidoAjudaController**
  - Mesmo padrão
  - Integração com Beneficiário

- [ ] **ColaboradorController** (se aplicável)

### Fase 3: Testes de Integração
- [ ] Testar MenuInicial com todos os módulos
- [ ] Validar fluxo completo de cada módulo
- [ ] Testar casos de erro (CEP inválido, ID não existe, etc)

## 🛠️ Como Executar

### 1. Configuração Inicial
```bash
# Copiar arquivo de configuração
cp config.properties.example config.properties

# Editar config.properties com suas credenciais Oracle
# db.user=seu_usuario
# db.password=sua_senha
# db.url=sua_url_banco
```

### 2. Executar Projeto
```
RaizDoBem.test.TestMenuInicial
```

### 3. Navegar no Menu
```
Menu Inicial → Opção 6 (Endereços) → Testar CRUD
```

## 🏗️ Estrutura do Projeto

```
src/RaizDoBem/
├── controller/          (lógica de aplicação)
│   ├── EnderecoController.java        ✅ Pronto (use como referência)
│   ├── BeneficiarioController.java    ⚠️  Pendente refatoração
│   ├── DentistaController.java        ⚠️  Pendente refatoração
│   ├── AtendimentoController.java     ⚠️  Pendente refatoração
│   └── ...
├── model/
│   ├── bo/              (business objects)
│   │   └── EnderecoBO.java            ✅ Pronto
│   ├── dao/             (data access objects)
│   │   └── EnderecoDAO.java           ✅ Pronto
│   └── vo/              (value objects - entidades)
│       ├── Endereco.java              ✅ Pronto
│       └── ...
├── view/                (interface com usuário)
│   ├── EnderecoView.java              ✅ Pronto (use como referência)
│   ├── MenuInicial.java               ✅ Pronto
│   └── ...
└── test/
    ├── TestMenuInicial.java           (entrada principal)
    └── TestMenuEndereco.java          ✅ Testes de endereço
```

## 🔐 Boas Práticas Implementadas

- ✅ DAO com PreparedStatement e parâmetros seguros (previne SQL injection)
- ✅ Try-with-resources para fechamento automático de recursos
- ✅ Separação em camadas (View/Controller/BO/DAO)
- ✅ Tratamento de exceções com mensagens de erro úteis
- ✅ Padrão builder em Value Objects (setters em cadeia)
- ✅ Mapeamento de ResultSet centralizado em método `mapeamento()`

## 📚 Tecnologias

| Tecnologia | Versão |
|-----------|--------|
| Java | JDK 24 |
| Oracle Database | Enterprise Edition |
| JDBC | ojdbc11.jar |
| IDE | IntelliJ IDEA |

## 📞 Integração com Serviços Externos

- **ViaCepController**: Integração com API ViaCep para validação e busca de endereços por CEP
  - URL: https://viacep.com.br/ws/{CEP}/json/
  - Retorna: Logradouro, Bairro, Localidade, UF

## 🎯 Próximas Ações (Ordem de Prioridade)

1. **HOJE**: Validar módulo Endereço funcionando 100%
2. **DIAS 2-3**: Refatorar BeneficiarioController seguindo padrão
3. **DIAS 4-5**: Refatorar DentistaController e AtendimentoController
4. **DIAS 6-7**: Testes finais e ajustes

## 📝 Versões

- **v1.1.0** - CRUD de Endereço integrado ao Oracle
- **v1.2.0** - Endereço finalizado + padrão documentado para replicação