# 📅 Sistema de Agendamento de Serviços

Este projeto é um backend para um sistema de agendamento de serviços, desenvolvido com Java e Spring Boot. Ele permite o cadastro de usuários, criação de serviços por prestadores e agendamento de serviços por clientes.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI)
- Maven

---

## 📚 Funcionalidades

- Autenticação com JWT
- Cadastro e login de usuários
- Registro de serviços por prestadores
- Agendamento de serviços por clientes
- Listagem de agendamentos e serviços
- Documentação automática da API com Swagger
- Validações com Bean Validation

---

## 🏗️ Estrutura do Projeto

```
src
├── controller       # Endpoints REST
├── dto              # Objetos de transferência com validações
├── model            # Entidades JPA
├── repository       # Interfaces de acesso ao banco
├── service          # Regras de negócio
├── security         # JWT e configuração de segurança
└── exception        # Tratamento global de erros
```

---

## ⚙️ Como rodar o projeto

### Pré-requisitos

- Java 17 ou superior
- PostgreSQL
- Maven

### Passos:

1. Clone o repositório:
   ```bash
   git clone https://github.com/JVkh2002/Sistema-de-agendamento.git
   cd https://github.com/JVkh2002/Sistema-de-agendamento
   ```

2. Configure o banco PostgreSQL:
   - Crie um banco chamado `agendamento`
   - Crie um usuário com permissões (ex: `agendamento_user` / `senha123`)

3. Altere o `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/agendamento
   spring.datasource.username=agendamento_user
   spring.datasource.password=senha123
   ```

4. Compile e rode:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🔐 Autenticação

- **Login**: `POST /auth/login`
- **Token JWT** será retornado e deve ser usado no header:
  ```
  Authorization: Bearer {token}
  ```

---

## 📑 Documentação da API

Acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

---

## 📬 Endpoints principais

### Usuários
- `POST /auth/register` – Criação de usuário
- `POST /auth/login` – Login com e-mail e senha

### Serviços
- `GET /servicos`
- `POST /servicos` *(requer login do prestador)*

### Agendamentos
- `GET /agendamentos`
- `POST /agendamentos` *(requer login do cliente)*

