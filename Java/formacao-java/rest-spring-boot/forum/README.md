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
