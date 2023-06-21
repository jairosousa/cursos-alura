# User-API

GitHub: [https://github.com/ezambomsantana/java-back-end-livro](https://github.com/ezambomsantana/java-back-end-livro)

## Docker

Gerar imagem Docker

```shell
$ docker build -t jnsousa/user-api .
```

### Postgresql

```shell
$ docker run -d --name postgres_dev -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
``` 

Expor serviço

```shell
$ kubectl port-forward svc/postgres 5000:5432
```

ou

```shell
$ minikube service <service-name> --url
```

## Registro Imegens docker
Se você estiver usando o minikube, será necessária mais uma
pequena configuração: o minikube cria um registro do Docker
próprio, e não usa o da máquina hospedeira, por isso, é necessário
configurar o terminal para utilizar o registro do minikube com o
comando `eval $(minikube docker-env)` . Isso vale apenas para
o terminal corrente, isto é, se for aberto outro terminal, ele voltará
a acessar o registro da máquina hospedeira. Depois desse
comando, é possível criar as imagens dos microsserviços

## Token Dashiboard

```shell
$ kubectl -n kubernetes-dashboard create token admin-user
```