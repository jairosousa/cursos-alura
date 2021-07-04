# Ecommerce
Nesse curso utilizamos o Kafka via Docker esta configurado no Configmap no meu repositorio

## Execução

```
docker-compose -f docker-compose.yml up
```
## Acessar o bash do container

```
docker exec -it kafka /bin/sh
```
## Acessar diretorio kafka dentro container

```
$ cd /opt/bitnami/kafka/bin
```

## Criar os topicos
```
$ kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ECOMMERCE_NEW_ORDER
```
```
$ kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ECOMMERCE_SEND_EMAIL
```
```
$ kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ECOMMERCE_ORDER_APPROVED
```
```
$ kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ECOMMERCE_ORDER_REJECTED
```

## Listar os topicos criados
```
$ kafka-topics.sh --list --bootstrap-server localhost:9092
```

