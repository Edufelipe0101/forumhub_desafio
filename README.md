# FórumHub API 🚀

API REST desenvolvida em Java com Spring Boot que simula o funcionamento de um fórum de dúvidas, permitindo o gerenciamento de tópicos, usuários e respostas, com autenticação e controle de acesso via JWT.

Projeto desenvolvido como parte do **Challenge Back-End – FórumHub (Alura)**, seguindo boas práticas de mercado.

---

## ✨ Funcionalidades

- Autenticação de usuários com JWT
- CRUD completo de tópicos
- Cadastro e listagem de usuários
- Criação e listagem de respostas vinculadas a tópicos
- Controle de acesso com Spring Security
- Documentação automática da API com Swagger (OpenAPI)

---

## 🛠 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- JWT  
- Flyway Migration  
- MySQL  
- Bean Validation  
- Swagger (springdoc-openapi)

---

## 🗄 Banco de Dados

- Banco relacional **MySQL**
- Versionamento do banco com **Flyway**
- Principais tabelas:
  - `usuarios`
  - `topicos`
  - `respostas`

---

## ▶️ Como Executar o Projeto

### Pré-requisitos
- Java 17+
- MySQL
- Maven

### 1️⃣ Criar o banco de dados
```sql
CREATE DATABASE forumhub;
```

### 2️⃣ Configurar application.properties
Configure as seguintes propriedades no seu arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

jwt.secret=SUA_CHAVE_SECRETA
jwt.expiration=2
```

### 3️⃣ Executar a aplicação
```bash
mvn spring-boot:run
```

A API estará disponível em:

`http://localhost:8080`

---

## 🔐 Autenticação

### Endpoint de login
`POST /login`

Exemplo de requisição:

```json
{
  "login": "usuario",
  "senha": "123456"
}
```

Utilize o token retornado no cabeçalho das demais requisições que exigem autenticação:

`Authorization: Bearer SEU_TOKEN`

---

## 📘 Documentação da API

O Swagger UI está disponível em:

`http://localhost:8080/swagger-ui.html`

Através dele é possível visualizar e testar todos os endpoints da API, inclusive os protegidos por JWT.

---

## 👨‍💻 Autor

**Eduardo Felipe**
Estudante e entusiasta de Back-End, com foco em Java e Spring Boot.

---

## 📌 Observação Final

Projeto desenvolvido com foco em boas práticas, segurança e organização de código, podendo ser utilizado como projeto de portfólio.
