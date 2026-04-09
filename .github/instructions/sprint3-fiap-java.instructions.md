---
description: "Use quando a tarefa envolver finalizacao da Sprint 3 FIAP Java, validacao de requisitos, CRUD DAO, metodos de negocio, testes com main e documentacao PDF de entrega."
name: "Sprint 3 FIAP Java Checklist"
---
# Checklist Operacional da Sprint 3

## 1) Cobertura tecnica obrigatoria
- Confirmar existencia de pelo menos 6 classes de modelo com encapsulamento adequado.
- Confirmar no minimo 4 metodos de negocio com regras relevantes na camada BO.
- Confirmar classe de conexao com banco funcional.
- Confirmar DAO com operacoes Create, Read, Update e Delete para os modulos aplicaveis.
- Confirmar classes de teste com main que exercitem as regras de negocio.

## 2) Regras de implementacao
- Regra de negocio fica na BO.
- DAO deve conter apenas persistencia e mapeamento.
- Controller deve orquestrar, sem carregar regra de negocio pesada.
- View e classes de teste devem demonstrar uso real dos fluxos.

## 3) Definicao de pronto para cada modulo
- Compila sem erro.
- CRUD validado (ou justificativa explicita quando o dominio nao exigir delete).
- Pelo menos um teste de caminho feliz e um de validacao de erro.
- Evidencia do metodo logico disponivel para documentacao (print ou trecho objetivo).

## 4) Suporte ao PDF da entrega
Sempre conferir se o que foi implementado esta refletido na documentacao:
- Objetivo e escopo coerentes com o sistema atual.
- Funcionalidades listadas por modulo.
- Quatro metodos logicos explicados com evidencia.
- Procedimento de execucao atualizado (ferramentas, versoes, importacao e execucao).
- PDF encontra-se na raiz do repositorio e nomeado como "Sprint3_FIAP_Java.pdf".

## 5) Padrao de resposta esperado do agente
Ao finalizar qualquer solicitacao da Sprint 3, responder com:
- Itens atendidos do requisito.
- Pendencias encontradas.
- Riscos de penalidade.
- Proximos passos objetivos para fechamento da entrega.