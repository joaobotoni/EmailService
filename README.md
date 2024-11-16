### SMTP mail server settings
<img src="https://img.shields.io/badge/-Spring%20Properties-333333?style=flat&logo=spring" alt="Spring Properties">

```yml
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=09002f86e2fffb
spring.mail.password=#########
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

#

### Migration 
<img src="https://img.shields.io/badge/-PostgreSQL-333333?style=flat&logo=postgresql" alt="PostgreSQL">

```sql
CREATE TABLE usuario(
id SERIAL PRIMARY KEY NOT NULL,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(10) NOT null
)
```

### Technologies used
#

* Java
* Spring boot
* JPA/Hibernate
* Java Mail Sander
* Flyway Migration
