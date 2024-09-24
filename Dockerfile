# Usando a imagem base do Ubuntu
FROM ubuntu:latest AS build

# Atualizando a lista de pacotes
RUN apt-get update

# Instalando o JDK 21
RUN apt-get install -y openjdk-21-jdk

# Instalando o Maven
RUN apt-get install -y maven

# Define o diretório de trabalho
WORKDIR /app

# Copiando o código-fonte para a imagem
COPY . .

# Construindo o projeto
RUN mvn clean install -DskipTests

# Usando a imagem base do OpenJDK 21 slim para o runtime
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Expondo a porta 8080
EXPOSE 8080

# Copiando o JAR gerado na etapa de build para a imagem final
COPY --from=build /app/target/gestao-estoque-*.jar app.jar

# Definindo o comando de entrada para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]




