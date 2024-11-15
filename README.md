### SMTP mail server settings

```yml
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=09002f86e2fffb
spring.mail.password=247dd9628f6340
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Migration

```sql
CREATE TABLE usuario(
id SERIAL PRIMARY KEY NOT NULL,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(10) NOT null
)
```
