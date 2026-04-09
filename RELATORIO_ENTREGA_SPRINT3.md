# Relatorio Geral de Entrega - Sprint 3 (FIAP Java)

Data: 09/04/2026
Projeto: Raiz do Bem

## 1) Diagnostico atual

Status geral de progresso estimado:
- Arquitetura e modelagem: 85% a 90%
- Implementacao de modulos e fluxos: 85% a 90%
- Documentacao final de entrega: 70% a 85% (dependendo dos prints e fechamento do PDF)

Resumo:
- O projeto atende bem a estrutura em camadas e os modulos principais.
- A estrategia de execucao por classes de teste com main e valida para demonstracao da sprint.
- O ponto mais sensivel para nota final e garantir compilacao/execucao sem bloqueios no ambiente do avaliador.

## 2) Requisitos Sprint 3 - Atendido x Pendente

### Atendidos
- Minimo de 6 classes de modelo com encapsulamento.
- Minimo de 4 metodos de logica de negocio.
- Classe de conexao com banco implementada.
- Camada DAO implementada para os modulos principais.
- Classes de teste com metodo main para simulacao.
- Arquitetura View -> Controller -> BO -> DAO -> VO preservada.

### Pendencias para fechamento com baixo risco
- Garantir que o projeto compile no ambiente final de entrega.
- Fechar o PDF com evidencias visuais (prints de fluxo e dos metodos logicos).
- Confirmar consistencia entre o que esta no PDF e o que esta no codigo (nomes, funcionalidades, fluxos e justificativas).

## 3) Pontos criticos que podem tirar nota

- Compilacao falhar no ambiente do avaliador.
- Procedimento de execucao incompleto no PDF.
- Falta de evidencia dos 4 metodos logicos obrigatorios.
- Inconsistencia entre regra declarada e implementacao real (exemplo: CRUD parcial sem justificativa).
- Nomenclatura/organizacao da entrega em ZIP diferente do que o PDF descreve.

## 4) Justificativas de dominio (recomendado manter no PDF)

- Atendimento sem delete:
  - Justificativa: preservacao de historico clinico e rastreabilidade de atendimento.
  - Enquadramento: modulo com C-R-U por regra de negocio.

- Catalogos de referencia:
  - Especialidade e Programa Social como dados de apoio com foco em listagem/consulta.

## 5) O que falta para sair de 85-90% para 95%+

- Compilacao validada sem erro no ambiente final.
- PDF com todos os itens obrigatorios da rubrica completos e legiveis.
- Evidencia objetiva (print/trecho) de 4 metodos de negocio + resultado de execucao.
- Procedimento de execucao testado ponta a ponta (do setup ao run de testes).
- Revisao final de consistencia de nomes/arquivos antes de zipar.

## 6) Estimativa de nota

Cenario conservador:
- 75 a 85 pontos
- Quando houver documentacao boa, mas com risco tecnico de execucao/compilacao.

Cenario provavel (com fechamento de pendencias):
- 88 a 95 pontos
- Com compilacao estavel, justificativas claras e PDF completo.

Cenario excelente:
- 95 a 100 pontos
- Com checklist completo, evidencias fortes e entrega limpa/consistente.

## 7) Plano de acao para os proximos 2 dias

Dia 1 (tecnico):
- Validar compilacao do projeto no fluxo final de entrega.
- Garantir que os testes de demonstracao executam os fluxos escolhidos.
- Consolidar lista final dos 4 metodos logicos para documentacao.

Dia 2 (documentacao e submissao):
- Inserir prints finais no PDF (fluxo feliz e validacao de regra).
- Revisar checklist de rubric item a item.
- Montar ZIP final com estrutura limpa e nomes consistentes.

## 8) Checklist de pre-submissao

- Projeto compila.
- Banco configurado e conectado.
- Classes de teste executam os fluxos escolhidos.
- Quatro metodos logicos descritos com evidencia.
- MER e UML atualizados.
- Procedimento de execucao claro e reproduzivel.
- PDF final presente e nomeado corretamente no ZIP.
- Revisao final de coerencia entre codigo, README e PDF.
