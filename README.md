# ForumHub
Projeto que simula um forum

_Um fórum é um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos_
# Descrição do Projeto

Este projeto possui cinco endpoints principais para gerenciar tópicos e autenticação.

## 1. Criar um Tópico

**URL:** `http://localhost:8080/topicos`  
**Método:** `POST`

**Requisitos no corpo em JSON:**
```json
{
    "titulo": "",
    "mensagem": "",
    "nomeCurso": "",
    "autor": ""
}
```
## 2. Detalhar um Único Tópico
**URL:** ` http://localhost:8080/topicos/{id}`

**Método:** `GET`

Este endpoint é utilizado para obter os detalhes de um tópico específico pelo seu id.

## 3. Listar Todos os Tópicos
**URL:** ` http://localhost:8080/topicos`

**Método:** `GET`

Este endpoint é utilizado para listar todos os tópicos.

## 4. Atualizar um Tópico
**URL:** ` http://localhost:8080/topicos/{id}`

**Método:** `PUT`

**Requisitos no corpo em JSON:**

```json
{
    "titulo": "",
    "mensagem": ""
}
```
Este endpoint é utilizado para atualizar um tópico específico pelo seu id. O corpo da requisição deve conter os campos titulo e/ou mensagem com os novos dados.

## 5. Excluir um Tópico
**URL:** ` http://localhost:8080/topicos/{id}`

**Método:** `DELETE`

Este endpoint é utilizado para excluir um tópico específ ico pelo seu id.

Endpoint para Autenticação
**URL:** ` http://localhost:8080/login`

**Método:** `POST`

**Requisitos no corpo em JSON:**
```json
{
    "login": "",
    "senha": ""
}
```

## Tecnologias Usadas
- Java (versão 17 em diante)
- Maven (Initializr utiliza a versão 4)
- Spring Boot
- Banco de dados MySQL
- Insomnia ou Postman
- Projeto em JAR
## Dependências
- Lombok

- Spring Web

- Spring Boot DevTools

- Spring Data JPA

- Flyway Migration

- MySQL Driver

- Validation

- Spring Security
