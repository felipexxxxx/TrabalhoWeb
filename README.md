# 📄 Projeto de Reservas de Passeios de Buggy

## 📜 **Descrição Geral**
Este é um projeto universitário desenvolvido com o objetivo de criar um site de reservas de passeios de buggy, utilizando **Spring Boot**, **Spring Security**, **HTML**, **CSS**, **JavaScript**, **Bootstrap** e **MySQL**.

## 📊 **Arquitetura do Sistema**

- **Front-end:**
  - Linguagens: HTML, CSS, JavaScript.
  - Frameworks/Libraries: Bootstrap para design responsivo.
  - Arquivos: Várias páginas HTML, arquivos JS para interatividade, e arquivos CSS para estilização.

- **Back-end:**
  - Linguagem: Java.
  - Frameworks: Spring Boot para API REST, Spring Security para autenticação.
  - Banco de Dados: MySQL.

## 📂 **Estrutura de Arquivos**

### **1. Scripts de Banco de Dados**
- `V1__create_tables_usuario.sql`: Criação da tabela de usuários.
- `V2__create_tables_passeio.sql`: Criação da tabela de passeios.
- `V3__create_tables_reserva.sql`: Criação da tabela de reservas.

### **2. Back-End (Java)**
#### **Configuração de Segurança**
- `SecurityConfig.java`: Configuração de segurança do Spring Security.
- `CorsConfig.java`: Configurações de CORS.
- `SecurityFilter.java`: Filtro de segurança para requisições HTTP.

#### **Serviços e Controladores**
- `UserController.java`: Controlador responsável por endpoints relacionados ao usuário.
- `PasseioController.java`: Controlador responsável por endpoints relacionados aos passeios.
- `ReservaController.java`: Controlador de reservas de passeios.
- `PasseioService.java`, `UserService.java`, `ReservaService.java`: Serviços com regras de negócio.

#### **Repositórios (Repositories)**
- `UserRepository.java`, `PasseioRepository.java`, `ReservaRepository.java`: Interfaces para manipulação de dados.

#### **Classes de Domínio (Entities)**
- `User.java`: Representação da entidade "usuário".
- `Passeio.java`: Representação da entidade "passeio".
- `Reserva.java`: Representação da entidade "reserva".

#### **Exceções Personalizadas**
- `DuplicateException.java`: Exceção para erros de duplicidade.
- `GlobalExceptionHandler.java`: Tratamento global de erros.

### **3. Front-End (HTML/CSS/JS)**
#### **Páginas HTML**
- `index.html`: Página principal com seções de apresentação e passeios.
- `login.html` e `criarConta.html`: Páginas de login e criação de conta.
- `paginaADM.html`: Painel administrativo.
- `PaginaProduto.html`, `PaginaPagamento.html`, `ResumoPedido.html`: Páginas de detalhes do passeio, pagamento e resumo da compra.

#### **Arquivos de Estilo (CSS)**
- `bootstrap.min.css`: Biblioteca Bootstrap.
- `style.css`: Estilo global.
- `CriarPasseio.css`, `Perfil2.css`, `PaginaProduto.css`, `loginadm.css`: Estilos para páginas específicas.

#### **Arquivos JavaScript (Interação)**
- `main.js`: Scripts de animações e funcionalidades gerais.
- `auth.nav.js`: Controle de autenticação na navbar.
- `api.js`: Serviço de comunicação com a API (autenticação, passeios e reservas).
- `admpasseio.js`, `passeios.js`: Scripts para gerenciamento de passeios e exibição.
- `booking.js`: Script para realizar reservas.
- `pagamento.js`: Script para finalizar pagamento e confirmação.

### **4. DTOs (Data Transfer Objects)**
- `NewUserDTO.java`: DTO para criação de novos usuários.
- `CreatePasseioDTO.java`: DTO para criação de passeios.
- `LoginDTO.java`, `LoginResponseDTO.java`: DTOs para autenticação.
- `ReservaDTO.java`, `UserTokenDTO.java`: DTOs para reservas e tokens de usuário.

## 🛠️ **Funcionalidades**
- **Usuário Cliente:**
  - Criar conta e realizar login.
  - Visualizar passeios disponíveis.
  - Reservar passeios e acompanhar status.

- **Admin:**
  - Gerenciar passeios (criar, editar e deletar).
  - Visualizar todas as reservas realizadas.

## 🔒 **Autenticação e Segurança**
- Implementação de autenticação via JWT (JSON Web Token).
- Autorização com controle de acesso baseado em papéis (ADM e CLIENTE).
- Controle de sessão utilizando `localStorage` no front-end.

## 🛠️ **APIs REST**

### Endpoints Principais

#### **Usuários**
- `POST /user`: Criação de usuário.
- `POST /user/login`: Autenticação.

#### **Passeios**
- `GET /passeio`: Listar passeios.
- `POST /passeio`: Criar passeio.
- `PUT /passeio/{id}`: Atualizar passeio.
- `DELETE /passeio/{id}`: Deletar passeio.

#### **Reservas**
- `POST /reserva`: Criar reserva.
- `GET /reserva`: Listar todas as reservas (admin).
- `DELETE /reserva/{id}`: Cancelar reserva.
- `PUT /reserva/confirmar/{id}`: Confirmar reserva (pagamento).

## 🛠️ **Configuração e Execução**

### **Passos para Executar o Projeto:**
1. Clone o repositório.
2. Configure o banco de dados MySQL.
3. Configure as variáveis de ambiente no `application.properties`.
4. Execute a aplicação Spring Boot.
5. Abra o front-end pelo `index.html` via localhost.



## 💡 **Conclusão**
Este projeto demonstra o uso de várias tecnologias modernas para criar um sistema de passeios e reservas robusto e eficiente, com funcionalidades completas tanto para clientes quanto para administradores.


