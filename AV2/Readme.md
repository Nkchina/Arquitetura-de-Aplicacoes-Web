# Sistema de Autenticação e Autorização de E-commerce
## Descrição do Microsserviço
Este sistema de autenticação e autorização foi desenvolvido para uma aplicação de e-commerce, garantindo que apenas usuários autenticados e autorizados tenham acesso aos recursos da aplicação. Ele é responsável pelo registro, login, geração de tokens JWT e controle de acesso baseado em diferentes roles de usuário.

## Diagrama da Arquitetura
### Link: https://www.figma.com/board/mYXBvOpuI2RVHGt6bQTryz/Untitled?node-id=0-1&t=vlliNY90o8TPDyn5-1
![image](https://github.com/Nkchina/Arquitetura-de-Aplicacoes-Web/assets/94817330/087d5955-ea63-42f4-b43a-32a896e1cc49)

## Guia de Bordo e Desenvolvimento
### Pré-requisitos
- Java 22
- Spring Boot 3.3.1
- Maven 3.6+
- Banco de Dados (MongoDB Compass)

## Fluxo de Solicitação e Endpoints
### Auth Service
- Registro de Usuário: POST /api/auth/register
- Login: POST /api/auth/login
- 
### Admin Service
- Criação de Usuário: POST /admin/users
- Atualização de Usuário: PUT /admin/users/{id}
- Exclusão de Usuário: DELETE /admin/users/{id}
- 
### Manager Service
- Criação de Produto: POST /manager/products
- Atualização de Produto: PUT /manager/products/{id}
- Exclusão de Produto: DELETE /manager/products/{id}
- 
### Seller Service
- Criação de Pedido: POST /seller/orders
- Atualização de Pedido: PUT /seller/orders/{id}
- Exclusão de Pedido: DELETE /seller/orders/{id}
- 
### Customer Service
- Catálogo de Produtos: GET /customer/products
- Histórico de Pedidos: GET /customer/orders

### Dependências do Serviço
- Banco de Dados: MongoDB para armazenar informações de usuários, produtos, pedidos, etc.
