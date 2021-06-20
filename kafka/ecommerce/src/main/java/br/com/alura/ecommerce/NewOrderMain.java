package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 13:55
 *
 */

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    try (var orderDispacher = new KafkaDispacher<Order>()) {
      try(var emailDispacher = new KafkaDispacher<String>()) {
      var userId = UUID.randomUUID().toString();
      var orderId = UUID.randomUUID().toString();
      var amount = BigDecimal.valueOf(Math.random() * 5000 + 1);

      var order = new Order(userId, orderId, amount);
        orderDispacher.send("ECOMMERCE_NEW_ORDER", userId, order);

      var email = "Thanks you for order! We are processing your order";
        emailDispacher.send("ECOMMERCE_SEND_EMAIL", userId, email);
      }
    }
  }
}
