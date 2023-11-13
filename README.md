# booksFag

## Objetivo:

O objetivo deste trabalho é a criação de uma aplicação utilizando Spring Boot. O objetivo da aplicação foi deixado em aberto, podendo ser escolhido pelo aluno.

## Descrição:

A aplicação escolhida foi um sistema de cadastro de livros, onde o usuário pode cadastrar, editar, excluir e listar os livros cadastrados. Também é possível fazer a busca dos livros pelos status e pelos autores, assim como guardar o progresso de leitura de cada livro. A ideia foi tirada de sites como anilist.co e myanimelist.net, onde é possível cadastrar e guardar o progresso de animes e mangás.

## Tecnologias utilizadas:

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)

## Como executar:

### Clonando o projeto

No terminal execute o comando na pasta desejada
- Se estiver usando HTTPS: 

```bash
   git clone https://github.com/FlavioZanoni/booksFag.git
```

- Se estiver usando SSH: 

```bash
   git clone git@github.com:FlavioZanoni/booksFag.git
```

### De cd até o projeto

```bash
   cd booksFag
```

### Docker

O projeto pode ser executado de várias maneiras, porém para facilitar o processo de desenvolvimento e deploy, foi utilizado o Docker, onde é possível executar o projeto e o banco de dados com apenas um comando.
Para executar a aplicação com o Docker, é necessário ter o mesmo instalado na máquina. Após isso, basta executar o comando:

```bash
    docker-compose up
```

O comando ira baixar as imagens necessarias e executar os containers, apos isso a aplicaçao estara disponivel no endereço
[http://localhost:8080](http://localhost:8080)

### 1. Obter Todos os Livros

- **URL**: `/books`
- **Método**: `GET`
- **Descrição**: Retorna uma lista de todos os livros.

### 2. Obter Livro por ID

- **URL**: `/books/{id}`
- **Método**: `GET`
- **Parâmetros da URL**:
  - `id`: ID do livro
- **Descrição**: Retorna um livro específico pelo seu ID.

### 3. Criar Novo Livro

- **URL**: `/books`
- **Método**: `POST`
- **Corpo da Requisição**: Objeto `Book` em JSON
- **Descrição**: Cria um novo livro.

### 4. Atualizar Livro

- **URL**: `/books/{id}`
- **Método**: `PUT`
- **Parâmetros da URL**:
  - `id`: ID do livro
- **Corpo da Requisição**: Objeto `Book` atualizado em JSON
- **Descrição**: Atualiza um livro existente.

### 5. Deletar Livro

- **URL**: `/books/{id}`
- **Método**: `DELETE`
- **Parâmetros da URL**:
  - `id`: ID do livro
- **Descrição**: Deleta um livro pelo seu ID.

### 6. Atualizar Progresso de Leitura

- **URL**: `/books/{id}/progress/{currentPage}`
- **Método**: `POST`
- **Parâmetros da URL**:
  - `id`: ID do livro
  - `currentPage`: Página atual de leitura
- **Descrição**: Atualiza o progresso de leitura de um livro.

### 7. Atualizar Status do Livro

- **URL**: `/books/{id}/status/{status}`
- **Método**: `POST`
- **Parâmetros da URL**:
  - `id`: ID do livro
  - `status`: Novo status do livro
- **Descrição**: Atualiza o status de um livro.

### 8. Obter Livros por Status

- **URL**: `/books/status/{status}`
- **Método**: `GET`
- **Parâmetros da URL**:
  - `status`: Status do livro
- **Descrição**: Retorna livros com um determinado status.

### 9. Obter Livros por Autor

- **URL**: `/books/author/{author}`
- **Método**: `GET`
- **Parâmetros da URL**:
  - `author`: Nome do autor
- **Descrição**: Retorna livros de um determinado autor.
