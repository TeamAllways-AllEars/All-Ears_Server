# Install
Backend server of "All Ears" is a `Spring Boot` application and requires `JDK 17` & `Spring Boot 3.X`. Make sure to have the correct dependencies for the project.
- java version: "17.0.6" 2023-01-17 LTS
- Spring boot version: 3.2.2
- Project: Gradle-Groovy

# Architecture
<img width="1162" alt="allears-architecture-backend" src="https://github.com/TeamAllways-AllEars/All-Ears_Server/assets/89632139/3c5d2b2f-0bda-4af1-b684-02449a931bfd">

Backend server of "All Ears" uses **GCP VM E2 instance** for hosting and **GCP Cloud SQL MySQL 8.0 Engine** for DB. 
To run this code with your GCP resource, please make `allEars\src\main\resources\application.yml` file and provide the info of your `GCP Cloud SQL` into it. 

```yaml
spring:
  # GCP Cloud SQL
  datasource:
    url: jdbc:mysql://<your_db_instance_ip>:3306/<your_db_name>?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
    username: <your_db_instance_username>  # default is root
    password: <your_db_instance_password>
    driver-class-name: com.mysql.cj.jdbc.Driver
  # hibernate
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
```
