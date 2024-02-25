## ✅ How to run
### 1) Prerequisites
Backend server of "All Ears" is a `Spring Boot` application and requires `JDK 17` & `Spring Boot 3.X`. Make sure to have the correct dependencies for the project.
- java version: "17.0.6" 2023-01-17 LTS
- Spring boot version: 3.2.2
- Project: Gradle-Groovy
- IntelliJ IDEA or eclipse
- MySQL Workbrench

### 2) Clone
Clone this repository to your local computer using:
```bash
git clone https://github.com/TeamAllways-AllEars/All-Ears_Server.git
```

### 3) GCP resource
Backend server of "All Ears" uses **GCP VM E2 instance** for hosting and **GCP Cloud SQL MySQL 8.0 Engine** for DB. Make Cloud SQL instance with **MySQL 8.0 Engine** and add your local computer IP to **Authorized networks**.
- Cloud SQL engine: MySQL 8.0
- Authorized networks: your local computer IP or `0.0.0.0/0` (for testing)
- How to connect: An external, internet-accessible (Public) IP address.

Also, to run your own backend server, make a GCP VM instance and attach a **static external IP** to the VM instance. The information for the **static external IP** should be provided to the Android client (refer to [All-Ears_Android](https://github.com/TeamAllways-AllEars/All-Ears_Android) repository). You should also create a new **firewall rule** allowing `IPv4 0.0.0.0/0, TCP 8080` and `IPv6 ::/0, TCP 8080` for inbound traffic, and apply it to the VM instance of the SpringBoot backend server.
- Machine series: E2(choose higher spec for high traffic volume)
- Firewall rule: allow `IPv4 0.0.0.0/0, TCP 8080` and `IPv6 ::/0, TCP 8080`
- Make static external IP

### 4) Setup
To run this code with your GCP resource, please copy the code below and make `allEars\src\main\resources\application.yml` file (❗Do not change the directory or file name❗) inside of your project. After that, fill the **parentheses** with info of your `GCP Cloud SQL`.

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

- Change the value of the `ddl-auto` variable inside `application.yml` to `update` or `create` for on first execution, and `none` for the second.
- Run `AllEarsApplication`

## ⚙️ Architecture
<div>
  <img alt="Spring Boot" src ="https://img.shields.io/badge/spring boot-6DB33F.svg?&style=for-the-badge&logo=springboot&logoColor=white"/>
  <img alt="GCP VM" src ="https://img.shields.io/badge/GCP VM-4285F4.svg?style=for-the-badge&logo=googlecloud&logoColor=white"/>
  <img alt="GCP Cloud SQL" src ="https://img.shields.io/badge/GCP Cloud SQL-4285F4.svg?style=for-the-badge&logo=googlecloud&logoColor=white"/>
</div>

<img width="1920" alt="allears-architecture-backend" src="https://github.com/TeamAllways-AllEars/All-Ears_Server/assets/89632139/fb35f694-3ce7-4841-9eb2-f032fc15a136">

