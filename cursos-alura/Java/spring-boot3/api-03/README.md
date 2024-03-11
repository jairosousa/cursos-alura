# Voll.med Api

## [Trello](https://trello.com/b/O0lGCsKb/api-voll-med)

## [Layout das telas no Figma](https://www.figma.com/file/N4CgpJqsg7gjbKuDmra3EV/Voll.med?type=design&node-id=2-1007&mode=design)

## Rodar aplicação com profile

```shell
$ java -Dspring.profiles.active=prod -jar target/api-0.0.1-SNAPSHOT.jar
```
 
No windows colocar em aspas duplas
```shell
c: api>java "-Dspring.profiles.active=prod" "-DDATASOURCE_URL=jdbc:mysql://localhost/vollmed_api" "-DDATASOURCE_USERNAME=root" "-DDATASOURCE_PASSWORD=root" -jar target/api-0.0.1-SNAPSHOT.jar

```