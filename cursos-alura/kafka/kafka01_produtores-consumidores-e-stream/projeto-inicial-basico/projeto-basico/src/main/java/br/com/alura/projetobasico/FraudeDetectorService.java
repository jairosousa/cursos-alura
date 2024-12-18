package br.com.alura.projetobasico;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @Autor Jairo Nascimento
 * @Created 10/04/2023 - 16:25
 */
public class FraudeDetectorService {

    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, String>(properties());
        consumer.subscribe(Collections.singletonList("ECOMMERCE_NEW_ORDER"));
        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));

            if (!records.isEmpty()) {
                System.out.println("Encontrei " + records.count() + " registros");
                for (var record : records) {
                    System.out.println("-----------------------------------");
                    System.out.println("Processing new order, checking for fraud");
                    System.out.println("KEY " + record.key());
                    System.out.println("VALOR " + record.value());
                    System.out.println("PARTIÇÃO " + record.partition());
                    System.out.println("OFFSET " + record.offset());

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        //ignore
                        e.printStackTrace();
                    }
                    System.out.println("Order processed");
                }

            }

        }
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudeDetectorService.class.getSimpleName());

        return properties;
    }
}
