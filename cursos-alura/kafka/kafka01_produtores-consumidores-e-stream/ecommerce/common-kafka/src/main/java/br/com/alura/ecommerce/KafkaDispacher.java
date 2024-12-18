package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 18:23
 *
 */

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

class KafkaDispacher<T> implements Closeable {

  private final KafkaProducer<String, T> producer;

  KafkaDispacher() {
    this.producer = new KafkaProducer<>(properties());
  }

  private static Properties properties() {
    var properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties
        .setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        GsonSerializer.class.getName());

    return properties;
  }

  public void send(String topic, String key, T value)
      throws ExecutionException, InterruptedException {
    var record = new ProducerRecord<>(topic, key, value);
    producer.send(record, getCallback()).get();
  }

  private Callback getCallback() {
    return (data, ex) -> {
      if (ex != null) {
        ex.printStackTrace();
        return;
      }
      System.out.println(
          "SUCESSO ENVIANDO " + data.topic() + ":::partition " + data.partition() + "/ offset "
              + data.offset() + "/ time " + data.timestamp());
    };
  }

  @Override
  public void close() {
    this.producer.close();
  }
}
