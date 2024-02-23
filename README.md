## ⬇️ Install
Backend server of "All Ears" is a `Spring Boot` application and requires `JDK 17` & `Spring Boot 3.X`. Make sure to have the correct dependencies for the project.
- java version: "17.0.6" 2023-01-17 LTS
- Spring boot version: 3.2.2
- Project: Gradle-Groovy

## ⚙️ Architecture
<div>
  <img alt="Spring Boot" src ="https://img.shields.io/badge/spring boot-6DB33F.svg?&style=for-the-badge&logo=springboot&logoColor=white"/>
  <img alt="GCP VM" src ="https://img.shields.io/badge/GCP VM-4285F4.svg?style=for-the-badge&logo=googlecloud&logoColor=white"/>
  <img alt="GCP Cloud SQL" src ="https://img.shields.io/badge/GCP Cloud SQL-4285F4.svg?style=for-the-badge&logo=googlecloud&logoColor=white"/>
</div>

<img width="1920" alt="allears-architecture-backend" src="https://github.com/TeamAllways-AllEars/All-Ears_Server/assets/89632139/fb35f694-3ce7-4841-9eb2-f032fc15a136">

Backend server of "All Ears" uses **GCP VM E2 instance** for hosting and **GCP Cloud SQL MySQL 8.0 Engine** for DB. 
To run this code with your GCP resource, please copy the code below and make `allEars\src\main\resources\application.yml` file (❗Do not change the directory or file name❗) inside of your project. After that, provide the info of your `GCP Cloud SQL` into it.

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
