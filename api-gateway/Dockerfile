#Especifico el jdk que voy a utilizar
FROM openjdk:17-jdk-slim

#Creamos el directorio de trabajo dentro del contenedor
WORKDIR /app

#Copiamos el archivo JAR al contenedor
COPY target/api-gateway-0.0.1.jar app.jar

#Exponemos el puerto en el que corre el servicio
EXPOSE 443

#Comando para ejecutar la aplicacion
ENTRYPOINT ["java", "-jar", "app.jar"]