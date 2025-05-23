# User API 🚀

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.0-green?logo=springboot" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Database-MySQL-orange" alt="MySQL" />
  <img src="https://img.shields.io/badge/Build-Maven-red" alt="Maven" />
</p>

---

## 📖 Sobre o projeto

<p>Este projeto é uma API RESTful para gerenciamento de usuários, construída com <strong>Spring Boot</strong>. Permite operações CRUD completas com validações, tratamento de exceções personalizadas e documentação detalhada usando JavaDoc.</p>

---

## 🔧 Tecnologias utilizadas

<ul>
  <li>Java 21</li>
  <li>Spring Boot 3+</li>
  <li>Spring Data JPA</li>
  <li>H2 (pode implemenar um banco real caso deseje)</li>
  <li>Jakarta Validation (Bean Validation)</li>
  <li>JavaDoc para documentação</li>
  <li>Maven para gerenciamento de dependências</li>
</ul>

---

## 🚀 Funcionalidades

<table>
  <thead>
    <tr>
      <th>Endpoint</th>
      <th>Descrição</th>
      <th>HTTP Method</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>/users</td>
      <td>Lista todos os usuários</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/users/{id}</td>
      <td>Busca usuário por ID</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/users/username/{username}</td>
      <td>Busca usuário por username</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/users</td>
      <td>Criar um novo usuário</td>
      <td>POST</td>
    </tr>
    <tr>
      <td>/users/{id}</td>
      <td>Atualizar usuário existente</td>
      <td>PUT</td>
    </tr>
    <tr>
      <td>/users/{id}</td>
      <td>Deletar usuário</td>
      <td>DELETE</td>
    </tr>
  </tbody>
</table>

---

## 🚨 Tratamento de Erros

<ul>
  <li><code>DuplicateEmailException</code>: Captura tentativas de registrar emails repetidos.</li>
  <li><code>DuplicateUsernameException</code>: Captura tentativas de registrar usernames repetidos.</li>
  <li><code>ResourceNotFoundException</code>: Captura tentativas de buscar recursos inexistentes.</li>
  <li>Retorna mensagens de erro customizadas em JSON com código HTTP apropriado.</li>
</ul>

---

## 📚 Documentação do Código

Toda a base do código está documentada com JavaDoc, incluindo:

<ul>
  <li>Classes</li>
  <li>Métodos</li>
  <li>Exceções personalizadas</li>
  <li>DTOs e Models</li>
</ul>

---

## 🛠 Como rodar o projeto

<ol>
  <li>Clone o repositório: <code>git clone https://github.com/DaniloAlves1902/userapi</code></li>
  <li>Configure o banco de dados no <code>application.properties</code></li>
  <li>Execute a aplicação com: <code>mvn spring-boot:run</code> ou pelo seu IDE favorito</li>
  <li>Acesse os endpoints via <code>http://localhost:8080/users</code></li>
</ol>

---

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias e correções.

---

## 📄 Licença

MIT License &copy; 2025 Danilo Alves

---

<p align="center">Feito com ❤️ usando Spring Boot e Java</p>
