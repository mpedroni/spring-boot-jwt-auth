# spring-boot-jwt-auth

Este repositório contém um exemplo de como implementar uma autenticação baseada em tokens JWT em uma API REST desenvolvida com Spring Boot utilizando o Spring Security.

Projeto desenvolvido em conjunto com o [blog post](https://blog.mpedroni.com/autentica%C3%A7%C3%A3o-baseada-em-jwt-com-spring-security-6-6e942995061d?source=friends_link&sk=0d40dbcafb03cb38ecc80a9b413ee1eb). Recomendo a leitura do post se quiser entender melhor como a implementação funciona.

## Tecnologias utilizadas

- Java 21
- Spring Boot 3
- Spring Security 6
- Gradle 8.5

## Executando a aplicação

Para executar a aplicação, basta executar o comando:

```shell
./gradlew :bootRun
```

## Rotas da aplicação

### POST /login
Rota responsável por receber as credencias de um usuário e, caso sejam válidas, retornar um token JWT para o usuário.
```json
{
  "email": "john@doe.com",
  "password": "password@1234"
}
```

### GET /books

Retorna uma lista estática de livros. É uma rota protegida e exige que um token JWT válido seja passado no header `Authorization` da request. O token deve ser gerado através da rota [`/login`](#post-login).
