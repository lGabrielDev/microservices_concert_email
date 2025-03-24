FROM  openjdk:17

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR para dentro do container
COPY ./target/microservice_concerts.jar ./microservice_concerts.jar

# Expõe a porta em que o Spring Boot vai rodar
EXPOSE 8080

# Comando para rodar o JAR
CMD [ "java", "-jar", "/app/microservice_concerts.jar" ]