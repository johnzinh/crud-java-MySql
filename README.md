CRUD em Java (Console)
Aplicação de console em Java que realiza operações básicas de CRUD (Create, Read, Update, Delete) em um banco de dados utilizando JDBC.

📌 Funcionalidades

Salvar usuário no banco de dados

Listar usuários cadastrados

Atualizar usuário (por ID)

Deletar usuário (por ID)

Gerenciamento seguro de conexão com o banco

🛠 Tecnologias

Java 24+

JDBC

MySQL (ou outro banco relacional configurado)

🚀 Como executar

Clone o repositório:

git clone https://github.com/seu-usuario/crud-java.git
cd crud-java


Configure seu banco de dados no arquivo de conexão (DatabaseConnection).

Compile e execute o projeto:

mvn clean install
java -jar target/crud-java.jar

📂 Estrutura do projeto
src/
 └── main/java/br/com/crud
      ├── aplication/Main.java       # Classe principal
      ├── dao/UsuarioDAO.java        # Operações CRUD
      ├── factory/DatabaseConnection # Conexão com o banco
      └── model/Usuarios.java        # Entidade Usuário

✨ Futuras melhorias

Validação de dados antes de salvar

Interface gráfica (JavaFX ou Swing)

API REST com Spring Boot
