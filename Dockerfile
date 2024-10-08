# Etapa de build
FROM ubuntu:latest AS build

# Atualizando a lista de pacotes e instalando Java e Maven
RUN apt-get update && apt-get install -y openjdk-21-jdk maven

# Define o diretório de trabalho
WORKDIR /app

# Copiando o código-fonte e o arquivo .env para a imagem
COPY . .

# Construindo o projeto
RUN mvn clean install -DskipTests

# Usando a imagem base do OpenJDK 21 slim para o runtime
FROM openjdk:21-slim

# Define o diretório de trabalho
WORKDIR /app

# Expondo a porta 8080
EXPOSE 8080

# Copiando o JAR gerado na etapa de build e o arquivo .env para a imagem final
COPY --from=build /app/target/gestao-estoque-*.jar app.jar
COPY --from=build /app/.env ./

# Definindo o comando de entrada para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]












