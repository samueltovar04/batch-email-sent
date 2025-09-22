# batch-email-sent

This project uses Quarkus, the Supersonic Subatomic Java Framework.
git clone https://github.com/tu-usuario/nombre-del-repo.git
cd nombre-del-repo

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/batch-email-sent-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

```Levantar los Servicios con Docker Compose
Este comando iniciará los contenedores de MySQL, Elasticsearch y Kibana. El script SQL para crear la tabla con la columna status y los datos dummy se ejecutará automáticamente.

Bash

docker-compose up -d

docker-compose up --build
```
## Related Guides

- **Proceso Batch Reactivo**: Ejecución periódica (cada 30 minutos) de un proceso de lectura y notificación.
- **Java Nativo con GraalVM**: Compilado a código nativo para un inicio ultrarrápido y un bajo consumo de memoria.
- **Clean Architecture**: Separación de responsabilidades en capas (Dominio, Aplicación, Infraestructura) para una alta mantenibilidad.
- **Persistencia Reactiva**: Uso de **Hibernate Reactive con Panache** para interactuar de forma no bloqueante con la base de datos MySQL, filtrando datos por el campo `status`.
- **Envío de Correos Asíncrono**: Utilización de **Quarkus Mailer** para enviar notificaciones de manera eficiente y no bloqueante.
- **Plantillas de Mensajes**: Generación del cuerpo del correo a partir de plantillas XML usando **Quarkus Qute**.
- **Observabilidad**: Integración con **Kibana** para el monitoreo de logs y métricas.
- **Despliegue Local con Docker Compose**: Configuración de un entorno de desarrollo local que incluye MySQL, Elasticsearch y Kibana.
- **Herramientas Adicionales**: Uso de **Lombok** para reducir código repetitivo y **MapStruct** para la conversión entre entidades de persistencia y de dominio.

## Provided Code
- Java 17+
- Docker y Docker Compose
- Maven 3.8.1+
### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### REST Data with Panache

Generating Jakarta REST resources with Panache

[Related guide section...](https://quarkus.io/guides/rest-data-panache)

Estructura de la Arquitectura (Clean Architecture)
La estructura del código sigue un patrón de capas concéntricas, donde cada capa depende de la capa que está directamente debajo de ella. .

src/main/java/com/example/domain: Contiene la lógica de negocio central, con la entidad pura User.

src/main/java/com/example/application: Define los casos de uso y las interfaces de los puertos.

src/main/java/com.example.infrastructure: Implementa los puertos, se conecta a servicios externos (BD, correo) y contiene la entidad de persistencia UserEntity.

src/main/java/com.example.interface: Activa el proceso (ej. BatchScheduler.java).

