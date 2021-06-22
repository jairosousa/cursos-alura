# API Forum

#### senha: 123456

#### ativar profile por argumeto (VM Options)
-Dspring.profiles.active=dev

#### Gerar Build
mvn clean package

#### Rodar jar em modo produção
```
java -jar -Dspring.profiles.active=prod forum.jar
```
Passando as variaveis de ambientes
```
java -jar DFORUM_DATABASE_URL=jdbc:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=rm'!@N=Ke!~p8VTA2ZRK~nMDQX5Uvm!m' forum.jar
```

## Deploy tradicional com arquivo war

1. No arquivo pom inserir a seguinte tag

```xml
<packaging>war</packaging>
```

Inserir também a dependencies do container no caso tomcat
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
  <scope>provided</scope>
</dependency>
```

2. Fazer alteração na class main do projeto
```java
@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class ForumApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ForumApplication.class);
	}
}
```

## Gerar imagem Docker do projeto
```
Docker build -t jnsousa/alura-forum .
```
