# 🚗 Lava-Rápido API

API REST para gestão de lava-rápidos, focada em simular **regras reais de negócio**, organização de código e práticas próximas do mercado.

Este projeto **não é um exercício guiado**. Ele existe para ser construído em colaboração, com decisões técnicas discutidas e responsabilidades divididas.

---


## Objetivo do Projeto

Criar uma API back-end que permita gerenciar um lava-rápido de forma realista, cobrindo:

* Cadastro e gestão de clientes
* Cadastro de veículos
* Serviços de lavagem
* Fluxo de atendimento
* Base sólida para evolução (autenticação, testes, deploy)

O foco principal é **aprender fazendo**, mas com seriedade suficiente para virar **portfólio profissional**.

---

## Tecnologias Utilizadas

* Java
* Spring Boot
* JPA / Hibernate
* Banco de dados relacional
* API REST

*(A stack pode evoluir conforme decisões do time, mas sempre com justificativa técnica.)*

---

## ✅ O que já existe

Atualmente o projeto conta com:

* Estrutura inicial do back-end
* Entidades de domínio principais
* Camada de serviço separada
* Repositórios para persistência
* Endpoints REST funcionais
* Cadastro de clientes/carros

> Tudo que está no repositório **funciona de verdade** — não há código placeholder.

---

## O que ainda falta (oportunidades de contribuição)

Alguns exemplos de frentes abertas:

* Autenticação e autorização
* Validações de domínio mais rigorosas
* Testes automatizados
* Documentação da API (Swagger/OpenAPI)
* Refino de arquitetura
* Deploy (ambiente de homologação)

Esses pontos estão (ou estarão) organizados em **Issues**, para facilitar a colaboração.

---

## ▶️ Como rodar o projeto localmente

1. Clone o repositório:

```bash
git clone https://github.com/pk-hue/lava-rapido-api.git
```

2. Entre no diretório do projeto:

```bash
cd lava-rapido-api
```

3. Configure o banco de dados conforme o `application.properties`

4. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

5. A API ficará disponível em:

```
http://localhost:8080
```

---

## 🤝 Como contribuir

Este projeto busca **parceiros**, não colaboradores ocasionais.

Antes de contribuir:

1. Leia as Issues abertas
2. Escolha uma task e comente que pretende assumir
3. Discuta a abordagem antes de implementar
4. Abra um Pull Request bem descrito

Mais detalhes estão no arquivo `CONTRIBUTING.md`.

---

## Filosofia do Projeto

* Decisões técnicas são discutidas
* Código precisa ter justificativa
* Qualidade > quantidade
* Discordância é bem-vinda quando é técnica

Aqui ninguém está "mandando" — estamos **construindo juntos**.

---

## 📬 Contato

Se quiser contribuir, abra uma Issue ou entre em contato pelo GitHub.

— Pedro H.



