# Образ с Maven и JDK 21 для сборки
FROM maven:3.9.11-eclipse-temurin-21 AS build
# Установка рабочей директории
WORKDIR /build
# Копируем исходники
COPY src /build/src
# Копируем pom.xml
COPY pom.xml /build/pom.xml
# Собираем проект
RUN mvn clean package

# Лёгкий рантайм-образ с JDK 21
FROM eclipse-temurin:21-alpine
# Копируем собранный JAR
COPY --from=build /build/target/*.jar /opt/app.jar
# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]