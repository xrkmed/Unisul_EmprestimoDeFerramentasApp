# Projeto A3: Sistema de Empréstimo de Ferramentas
<div align="center" style="display: flex; flex-wrap: nowrap">
  <img src="https://cdn.iconscout.com/icon/free/png-256/java-60-1174953.png"  alt="Java logo"><img src="https://cdn.iconscout.com/icon/free/png-256/free-mysql-21-1174941.png?f=webp&w=256" alt="MySQL logo">
</div>
<br>
<center>
Este projeto é um sistema de empréstimo de ferramentas desenvolvido em Java e integrado com o banco de dados MySQL. Ele permite que os usuários cadastrem e gerenciem empréstimos de ferramentas, mantendo um registro organizado e acessível.</center>

## 🚀 Funcionamento

O projeto consiste em duas partes principais: a aplicação Java e o banco de dados MySQL.

### Aplicação Java

A aplicação Java é responsável pela lógica de negócio do sistema. Ela oferece uma interface para que os usuários possam interagir com o sistema. Através da interface, é possível realizar as seguintes operações:

1. Cadastro de usuários: os usuários podem se cadastrar no sistema fornecendo informações como nome e telefone.

2. Cadastro de ferramentas: os usuários podem cadastrar novas ferramentas informando seu nome, fabricante e valor.

3. Cadastro de fabricante: os usuários podem cadastrar novos fabricantes inserindo o nome da fabricante e optando por buscar pelo CNPJ.

4. Empréstimo de ferramentas: os usuários podem registrar o empréstimo de uma ferramenta disponível. O registro é criado indicando o amigo beneficiado pelo empréstimo, as ferramentas emprestadas e a data prevista de devolução.

5. Devolução de ferramentas: os usuários podem registrar a devolução de uma ferramenta emprestada. O sistema atualiza automaticamente a disponibilidade da ferramenta.

6. Listagem de empréstimos: os usuários podem listar todos os empréstimos em andamento, visualizando informações como o nome da ferramenta, o usuário responsável e a data prevista de devolução.

### Banco de Dados MySQL

O banco de dados MySQL é responsável pelo armazenamento persistente dos dados do sistema. Ele é utilizado pela aplicação Java para salvar as informações dos usuários, das ferramentas e dos empréstimos. O MySQL oferece recursos avançados de gerenciamento de dados, garantindo a integridade e a segurança das informações.

## 💻 Como usar o projeto

Para utilizar o projeto, siga as instruções abaixo:

1. Clone o repositório para o seu ambiente local:
git clone https://github.com/xrkmed/Unisul_EmprestimoDeFerramentasApp.git

2. Certifique-se de ter o Java e o MySQL instalados em seu sistema.

3. Crie um banco de dados no MySQL com o nome "emprestimo_ferramentas_db".

4. Execute o script SQL fornecido no diretório `schema` para criar as tabelas necessárias no banco de dados.

5. Configure as credenciais de acesso ao banco de dados no arquivo `config.properties`.

6. Compile e execute a aplicação Java utilizando a sua IDE favorita

7. Agora você pode interagir com o sistema.


