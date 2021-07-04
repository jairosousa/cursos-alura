package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 15:48
 *
 */

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

  private final KafkaDispacher<Order> orderDispacher = new KafkaDispacher<>();

  public static void main(String[] args) {
    var fraudDetectorService = new FraudDetectorService();
    try(var service = new KafkaServices<>(FraudDetectorService.class.getSimpleName(),
        "ECOMMERCE_NEW_ORDER",
        fraudDetectorService::parse,
        Order.class, new HashMap<>())) {
      service.run();
    }
  }

  private void parse(ConsumerRecord<String, Order> record)
      throws ExecutionException, InterruptedException {
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
    var order = record.value();

    /**
     * pretending that the fraud happens when the amount is >= 4500
     */
    if (isFraud(order)) {
      System.out.println("Order is a fraud!!!" + order);
      orderDispacher.send("ECOMMERCE_ORDER_REJECTED", order.getEmail(), order);
    } else {
      orderDispacher.send("ECOMMERCE_ORDER_APPROVED", order.getEmail(), order);
      System.out.println("Approved: " + order);
    }
    System.out.println("Order processed");
  }

  private boolean isFraud(Order order) {
    return order.getAmount().compareTo(new BigDecimal("4500")) >= 0;
  }
}
