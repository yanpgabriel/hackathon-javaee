# Backend

### Pré-Requisitos *obrigatórios*:
 - Git
 - JDK 11+
 - Maven 3+

### Pré-Requisitos *opcionais*:
 - Docker (Caso queira usar o mysql que tem no projeto)
 - Docker Compose (Normalmente vem com o docker)

## Rodar a aplicação em modo de desenvolvimento
#### *Lembrando que precisa do MySQL já esta rodando!*

Use o seguinte comando para iniciar o servidor:
```shell script
./mvnw compile quarkus:dev
```

#### Alguns guias relacionados:
- Hibernate ORM (Implementação do JPA) ([guia](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html))
- RESTEasy JAX-RS ([guia](https://docs.jboss.org/resteasy/docs/3.0.9.Final/userguide/html_single/index.html))
- MySQL ([guia](https://dev.mysql.com/doc/))
