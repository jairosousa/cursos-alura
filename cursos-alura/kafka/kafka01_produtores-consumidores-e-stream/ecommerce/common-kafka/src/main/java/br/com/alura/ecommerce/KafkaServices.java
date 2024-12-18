package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 17:41
 *
 */

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.swing.Spring;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaServices<T> implements Closeable {

  private final KafkaConsumer<String, T> consumer;
  private final ConsumerFunction parse;

  KafkaServices(String groupId, String topic, ConsumerFunction parse, Class<T> type, Map<Spring, String> properties) {
    this(parse, groupId, type, properties);
    consumer.subscribe(Collections.singletonList(topic));
  }

  KafkaServices(String groupId, Pattern topic, ConsumerFunction parse, Class<T> type, Map<Spring, String> properties) {
    this(parse, groupId, type, properties);
    consumer.subscribe(topic);
  }

  private KafkaServices(ConsumerFunction parse, String groupId, Class<T> type, Map<Spring, String> properties) {
    this.parse = parse;
    this.consumer = new KafkaConsumer<>(getProperties(type, groupId, properties));
  }

  void run() {
    while (true) {
      var records = consumer.poll(Duration.ofMillis(100));
      if (!records.isEmpty()) {
        System.out.println("Encontrei " + records.count() + " registros");
        for (var record : records) {
          parse.consume(record);
        }
      }
    }
  }

  private Properties getProperties(Class<T> type, String groupId,
      Map<Spring, String> overrideProperties) {
    var properties = new Properties();
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties
        .setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        GsonDeserializer.class.getName());
    properties
        .setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG,
        groupId +"/" + UUID.randomUUID().toString());
    properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
    properties.setProperty(GsonDeserializer.TYPE_CONFIG, type.getName());
    properties.putAll(overrideProperties);

    return properties;
  }

  @Override
  public void close() {
    this.consumer.close();
  }
}
