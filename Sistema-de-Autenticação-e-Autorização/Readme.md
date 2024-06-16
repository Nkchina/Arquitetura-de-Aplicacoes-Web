# Sistema de Autenticação e Autorização com JWT
Este projeto é uma API REST que utiliza JSON Web Tokens (JWT) para autenticação e autorização. Implementado com Spring Boot, ele fornece endpoints para login, extração de nome de usuário e controle de acesso baseado em roles.

## Índice
1. [Introdução](#introdução)
2. [Instalação](#instalação)
3. [Uso](#uso)
4. [Funcionalidades](#funcionalidades)
   - [Capturas de Tela e Diagramação](#capturas-de-tela-e-diagramação)
5. [Contribuindo](#contribuindo)
6. [Licença](#licença)

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
1. Exemplo de requisição:
   ```bash
   curl -X POST http://localhost:8080/login
   -H "Content-Type: application/json"
   -d '{"username":"Nicolas","password":"2820"}'
A resposta será um token JWT que pode ser utilizado para acessar endpoints protegidos.

**Acesso aos Endpoints**
- GET /username/{token}: Obtém o nome de usuário a partir de um token JWT.
- GET /user: Retorna informações do usuário autenticado.
- GET /admin: Apenas usuários com a role ADMIN podem acessar este endpoint.
- GET /moderador: Apenas usuários com a role MODERADOR podem acessar este endpoint.
- GET /comum: Apenas usuários com a role COMUM podem acessar este endpoint.

2. Exemplos de requisições para acessar os endpoints protegidos:
   ```bash
   # Obter nome de usuário a partir do token
   curl -X GET http://localhost:8080/username/{token}

   # Acessar informações do usuário autenticado
   curl -X GET http://localhost:8080/user \
     -H "Authorization: {"username":"Nicolas","password":"2820"}"

   # Acessar endpoint restrito para administradores
   curl -X GET http://localhost:8080/admin \
     -H "Authorization: {"username":"Nicolas","password":"2820"}"

   # Acessar endpoint restrito para moderadores
   curl -X GET http://localhost:8080/moderador \
     -H "Authorization: {"username":"João","password":"1234"}"

   # Acessar endpoint restrito para usuários comuns
   curl -X GET http://localhost:8080/comum \
     -H "Authorization: {"username":"José","password":"8080"}"
Substitua {token} pelo token JWT obtido durante a autenticação.

## Funcionalidades
- Autenticação utilizando JWT
- Autorização baseada em roles (usuário, admin, moderador e comum)
- Endpoints seguros e públicos

### Capturas de Tela e Diagramação
- **Diagrama:**
  Link: <https://www.figma.com/board/SFhCLj11aeZKaLONt2fh9u/Untitled?node-id=0-1&t=CWHbD68tN5vsRJhc-1>
  ![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/52eb8511-9b8f-46e8-8d11-33364fff72a6)

Aqui estão algumas capturas de tela das funcionalidades:

- **Login:**  
![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/a1c9b6a2-b78e-4b68-adab-15e090e066d0)

- **Extração de Nome de Usuário:**  
![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/8b907a9c-ad76-4418-b6b5-940b7ffa46a5)

- **Acesso ao Endpoint do Comum:**  
![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/669f727b-f36e-4363-b053-3d04da3d64de)

- **Acesso ao Endpoint do Administrador:**  
![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/24657371-3009-45c4-b3fd-0574cf0ac52f)

- **Acesso ao Endpoint do Moderador:**
![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/64fae12c-f23c-42ff-89fc-9912257d337d)

## Contribuindo
Para contribuir com este projeto, siga estas etapas:
- Faça um fork do projeto.
- Crie uma branch para sua feature (git checkout -b feature/nova-feature).
- Commit suas alterações (git commit -m 'Adiciona nova feature').
- Faça um push para a branch (git push origin feature/nova-feature).
- Abra um Pull Request.

## Licença
MIT License

Copyright (c) [year] [fullname]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

