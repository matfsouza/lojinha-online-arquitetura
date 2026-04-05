# Simulação Lojinha Online 🛒

Este repositório contém a entrega da atividade prática sobre Arquitetura de Software. O projeto consiste na modelagem e simulação em Java de um sistema de vendas online utilizando uma arquitetura cliente-servidor monolítica.

## 🗂️ 1. Estrutura do projeto

O projeto foi organizado separando as responsabilidades lógicas em pacotes, mesmo tratando-se de um monolito:

- `/diagramas`: Contém as imagens exportadas do Diagrama de Atividades e do Modelo Entidade-Relacionamento (DER).
- `/src/models`: Classes de domínio que representam a estrutura de dados e regras básicas (`Cliente`, `Produto`, `Pedido`).
- `/src/services`: Classes responsáveis pela lógica de negócio e integração externa (`SistemaPagamentoExterno`).
- `LojinhaOnlineSimulacao.java`: Classe principal que orquestra a simulação e o fluxo de compra do cliente.

## 🏛️ 2. Principais decisões arquiteturais

O sistema foi concebido utilizando o estilo **Cliente-Servidor Monolítico**. 

**Decisão:** Centralizar todas as regras de negócio (carrinho, validação e comunicação de pagamento) em um único bloco de código backend.
**Justificativa:** Para o contexto atual de uma "lojinha online" simulada, uma arquitetura monolítica é a escolha mais eficiente. Ela reduz a complexidade de implantação (*deploy*), elimina a latência de comunicação interna na rede que existiria em microsserviços, e simplifica o rastreamento de bugs durante a fase inicial do projeto.

## ⚙️ 3. Onde e como o Singleton foi aplicado

O Padrão de Projeto Criacional **Singleton** foi aplicado estritamente na classe `SistemaPagamentoExterno`.

- **Como foi aplicado:** A classe possui um construtor privado, uma variável estática interna que guarda a sua única instância, e um método público estático (`getInstancia()`) que controla a criação e o acesso a esse objeto.
- **Onde e Por Quê:** Foi aplicado na simulação de comunicação com o Gateway de Pagamento. Como conexões com APIs financeiras externas são custosas para o servidor e consomem portas de rede, o Singleton garante que **apenas uma instância** dessa classe exista durante toda a execução da aplicação, centralizando o controle das transações e evitando o desperdício de memória que ocorreria se cada novo pedido criasse uma nova conexão.
