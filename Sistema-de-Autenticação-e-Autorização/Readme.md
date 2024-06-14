# Sistema de Autenticação e Autorização com JWT

Este projeto é uma API REST que utiliza JSON Web Tokens (JWT) para autenticação e autorização. Implementado com Spring Boot, ele fornece endpoints para login, extração de nome de usuário e controle de acesso baseado em roles.

## Índice

1. [Introdução](#introdução)
2. [Instalação](#instalação)
3. [Uso](#uso)
4. [Funcionalidades](#funcionalidades)
   - [Capturas de Tela](#capturas-de-tela)
5. [Contribuindo](#contribuindo)
6. [Licença](#licença)
7. [Autores](#autores)
8. [Agradecimentos](#agradecimentos)

## Introdução

Este projeto demonstra como configurar autenticação JWT em uma API REST com Spring Boot. Ele inclui exemplos de configuração de segurança, geração e validação de tokens JWT, e controle de acesso baseado em roles.

## Instalação

Para instalar e configurar o projeto, siga as etapas abaixo:

1. Clone o repositório:
   ```sh
   git clone https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web.git
   cd Arquitetura-de-Aplicacoes-Web
2. Instale as dependências utilizando Maven:
   ```bash
    mvn install
3. Execute a aplicação utilizando Maven:
   ```bash
    mvn spring-boot:run
O servidor será iniciado em `http://localhost:8080`.

## Uso

### Autenticação

Para autenticar um usuário e obter um token JWT, envie uma requisição POST para `/login` com um JSON contendo `username` e `password`.
   Exemplo de requisição:
   ```bash
   curl -X POST http://localhost:8080/login
   -H "Content-Type: application/json"
   -d '{"username":"Nicolas","password":"2820"}'
