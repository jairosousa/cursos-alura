package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 15:48
 *
 */

import java.util.HashMap;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

  public static void main(String[] args) {
    var fraudDetectorService = new FraudDetectorService();
    try(var service = new KafkaServices<>(FraudDetectorService.class.getSimpleName(),
        "ECOMMERCE_NEW_ORDER",
        fraudDetectorService::parse,
        Order.class, new HashMap<>())) {
      service.run();
    }
  }

  private void parse(ConsumerRecord<String, Order> record) {
    System.out.println("----------------------------------------");
    System.out.println("Processing new order, checking for fraud");
    System.out.println(record.key());
    System.out.println(record.value());
    System.out.println(record.partition());
    System.out.println(record.offset());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Order processed");
  }
}
