# Randon Plot Hook for Dungeon Masters

Este projeto é uma API em **Spring Boot** para mestres de RPG criarem aventuras personalizadas para suas sessões de jogo, com base nas características dos jogadores (NPCs). A ideia é permitir que os mestres insiram dados básicos sobre seus jogadores e usem essas informações para gerar prompts de inteligência artificial que ajudem a criar aventuras desafiadoras e interessantes para suas campanhas.

## Funcionalidades

- **Cadastro de Jogadores (NPCs)**: Mestres de RPG podem cadastrar as características dos seus jogadores (NPCs), incluindo nome, classe, raça, habilidades, etc.
- **Listagem de Jogadores**: É possível listar todos os jogadores cadastrados.
- **Atualização de Jogadores**: Os dados de um jogador podem ser atualizados conforme a evolução da campanha.
- **Exclusão de Jogadores**: O mestre pode deletar jogadores quando necessário.
- **Integração com IA**: O projeto utiliza as informações dos jogadores para gerar um "plot hook", ou enredo inicial, para a aventura, garantindo que os jogadores não morram logo na primeira sessão.

## Rotas Disponíveis

### 1. **/bemvindo**
- **Método**: GET
- **Descrição**: Retorna uma mensagem de boas-vindas.

### 2. **/novonpc**
- **Método**: POST
- **Descrição**: Cria um novo NPC (jogador).
- **Corpo da Requisição**: `CaracteristicasNPC` (JSON)

### 3. **/listar**
- **Método**: GET
- **Descrição**: Lista todos os NPCs cadastrados.

### 4. **/listar/{id}**
- **Método**: GET
- **Descrição**: Lista um NPC pelo ID.

### 5. **/atualizar/{id}**
- **Método**: PUT
- **Descrição**: Atualiza as informações de um NPC pelo ID.
- **Corpo da Requisição**: `CaracteristicasNPC` (JSON)

### 6. **/deletar/{id}**
- **Método**: DELETE
- **Descrição**: Deleta um NPC pelo ID.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para a construção da API.
    - `spring-boot-starter-web`: Para construir a API web.
    - `spring-boot-starter-data-jpa`: Para interação com o banco de dados utilizando JPA.
    - `spring-boot-starter-webflux`: Para suporte à programação reativa (se necessário no futuro).
    - `spring-boot-devtools`: Para desenvolvimento rápido com recarga automática.
    - `spring-boot-starter-test`: Para testes unitários e de integração.

- **Banco de Dados**:
    - `H2`: Banco de dados embutido para testes e desenvolvimento.
    - **Flyway**: Para migração de banco de dados.

- **Outras Dependências**:
    - **Lombok**: Para reduzir a verbosidade do código (geração de getters, setters, etc.).
    - **SpringDoc OpenAPI**: Para gerar documentação interativa da API utilizando Swagger.
    - **Reactor-Test**: Para testar fluxos reativos.


## Fase Atual do Projeto

Este projeto encontra-se em fase inicial, com **30% concluído**. As funcionalidades básicas de cadastro, listagem, atualização e exclusão de NPCs já estão implementadas. A parte da integração com inteligência artificial continua em desenvolvimento.

## Como Rodar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/ReaperCord/randonainpc.git
    ```

2. Acesse a pasta do projeto:
    ```bash
    cd randonainpc
    ```

3. Importe o projeto para o seu IDE (ex: IntelliJ IDEA ou Eclipse).

4. Configure seu banco de dados no `application.properties`.

5. Execute o projeto com o comando:
    ```bash
    ./mvnw spring-boot:run
    ```

6. Acesse a API via Swagger em: `http://localhost:8080/swagger-ui.html`


## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.