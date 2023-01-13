# See: https://spring.io/guides/gs/spring-boot-docker/#_containerize_it

FROM maven:3-jdk-11

WORKDIR /app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run
