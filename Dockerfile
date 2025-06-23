FROM eclipse-temurin:21-jdk-jammy
WORKDIR /target  # Рабочая директория, которую проверяет Sliplane
COPY target/*.jar /target/app.jar  # Копируем JAR в /target
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/target/app.jar"]
