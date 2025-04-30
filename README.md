# CarLog - Controle de Veículos

O **CarLog** é uma aplicação para gerenciar informações sobre veículos e usuários, permitindo o controle de frotas de forma eficiente. Este projeto utiliza **Spring Boot**, **Thymeleaf**, e **MySQL** como principais tecnologias.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes softwares instalados em sua máquina:

1. **Java 17** ou superior ([Download](https://www.oracle.com/java/technologies/javase-downloads.html))
2. **Maven** ([Download](https://maven.apache.org/download.cgi)) ou utilize o wrapper `mvnw` incluído no projeto.
3. **MySQL** ([Download](https://dev.mysql.com/downloads/installer/))
4. Um editor de código, como **Visual Studio Code** ([Download](https://code.visualstudio.com/)).

## Configuração do Banco de Dados

#### 1. Inicie o servidor MySQL.
#### 2. Crie um banco de dados chamado `carlog`:
```sql
CREATE DATABASE carlog;
```
#### 3. Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/carlog
    spring.datasource.username=carlog
    spring.datasource.password=123456 
    ```


`Nota:` Certifique-se de que o usuário carlog e a senha 123456 existem no MySQL. Caso contrário, ajuste as credenciais ou crie o usuário no MySQL:

  ```sql
  CREATE USER 'carlog'@'localhost' IDENTIFIED BY '123456';
  GRANT ALL PRIVILEGES ON carlog.* TO 'carlog'@'localhost';
  FLUSH PRIVILEGES;
  ```

## Passo a Passo para Executar a Aplicação
### 1. Clone o Repositório
Clone este repositório em sua máquina local:
```sh
git clone <https://github.com/femori90/Car-Log>
cd Car-Log
```

### 2. Compile e Instale as Dependências
Se você tiver o Maven instalado globalmente, execute:
```sh
mvn clean install
```

Caso contrário, utilize o Maven Wrapper incluído no projeto:
No Windows: 
```sh 
mvnw.cmd clean install
```
No Linux/Mac:
```sh 
./mvnw clean install
```

### 3. Execute a Aplicação
Para iniciar a aplicação, execute: 
```sh
mvn spring-boot:run
```

Ou, utilizando o Maven Wrapper:

No Windows: 
```sh
mvnw.cmd spring-boot:run
```

No Linux/Mac: 
```sh
./mvnw spring-boot:run
```

A aplicação estará disponível em: http://localhost:8080

### 4. Acessando a Aplicação
Página Inicial: http://localhost:8080/home

Login: http://localhost:8080/login

### Estrutura do Projeto
java: Contém o código-fonte da aplicação.
templates: Contém os arquivos HTML Thymeleaf.
src/main/resources/application.properties: Configurações da aplicação.
pom.xml: Gerenciamento de dependências do Maven.

## Tecnologias Utilizadas
* **Java 17**
* **Spring Boot 3.4.4**
* **Thymeleaf**
* **MySQL**
* **Bootstrap 5**

## Problemas Comuns
### 1. Erro de Conexão com o Banco de Dados:
- Verifique se o MySQL está rodando.

- Confirme as credenciais no arquivo application.properties.

### 2. Porta 8080 em Uso:
- Altere a porta no arquivo application.properties:
```sh 
server.port=8081
```

### 3. Erro de Versão do Java:
- Certifique-se de que o Java 17 ou superior está instalado e configurado como padrão.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

    1. Faça um clone do repositório (`git clone https://github.com/femori90/Car-Log`)
    2. Crie sua branch de funcionalidade (`git checkout -b feature/recurso`)
    3. Faça commit das suas alterações (`git commit -m "Adicionando uma nova funcionalidade {descreva brevemente a funcionalidade}"`)
    4. Faça um push para a branch (`git push origin feature/recurso`)
    5. Crie um novo Pull Request
    6. Notique um aprovador do repositório, para que ele possa fazer o `code review` 

## Licença
Este projeto é licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.

Este arquivo `README.md` fornece instruções claras e detalhadas para que qualquer pessoa consiga configurar e executar a aplicação localmente.

## Autores

- Matheus Sampaio de Oliveira [@blancoTrevizan](https://github.com/blancoTrevizan)

- Felipe Morishita [@femori90](https://github.com/femori90)

