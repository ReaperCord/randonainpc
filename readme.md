# Randon Plot Hook for Dungeon Masters

Randon Plot Hook for Dungeon Masters é uma API em **Spring Boot** desenvolvida para auxiliar mestres de RPG na criação de aventuras personalizadas com base nas características dos jogadores (NPCs). Este projeto permite o cadastro, listagem, atualização e exclusão de NPCs, além de gerar enredos iniciais de campanhas de forma dinâmica e rápida.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- H2 Database
- Flyway (migração do banco de dados)
- Lombok
- SpringDoc OpenAPI (documentação da API)

## Funcionalidades
- Cadastro, listagem, atualização e exclusão de NPCs.
- Geração dinâmica de enredos iniciais para campanhas.
- Integração com IA para geração de enredos personalizados.
- Documentação da API acessível via Swagger UI.
- Banco de dados H2 em memória com migrações gerenciadas pelo Flyway.

## Rotas Disponíveis
### 1. **/bemvindo** (GET)
Retorna uma mensagem de boas-vindas.

### 2. **/novonpc** (POST)
Cria um novo NPC com dados enviados via JSON (`CaracteristicasNPC`).

### 3. **/listar** (GET)
Lista todos os NPCs cadastrados.

### 4. **/listar/{id}** (GET)
Lista um NPC específico pelo ID.

### 5. **/atualizar/{id}** (PUT)
Atualiza um NPC existente pelo ID com os dados enviados via JSON (`CaracteristicasNPC`).

### 6. **/deletar/{id}** (DELETE)
Deleta um NPC específico pelo ID.

## Como Executar o Projeto
1. Clone o repositório:
```bash
 git clone https://github.com/ReaperCord/randonainpc.git
```
2. Navegue até a pasta do projeto:
```bash
 cd randonainpc
```
3. Compile e execute o projeto com Maven:
```bash
 ./mvnw spring-boot:run
```
4. Acesse a documentação da API em:
```
 http://localhost:8080/swagger-ui/index.html
```

## Banco de Dados
O projeto utiliza o banco de dados H2 em memória. As migrações são gerenciadas pelo Flyway e aplicadas automaticamente na inicialização.

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## Licença
Este projeto é distribuído sob a Licença MIT. Consulte o arquivo LICENSE para mais detalhes.

## Status do Projeto
✅ Projeto concluído.
