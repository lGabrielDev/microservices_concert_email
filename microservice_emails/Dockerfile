FROM  openjdk:17

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR para dentro do container
COPY ./target/microservice_emails.jar ./microservice_emails.jar

# Cria o diretório de templates
RUN mkdir ./templates

# Copia os arquivos de templates para dentro do container
COPY ./src/main/resources/templates/* ./templates/

# Expõe a porta em que o Spring Boot vai rodar
EXPOSE 8081

# Comando para rodar o JAR
CMD [ "java", "-jar", "/app/microservice_emails.jar" ]