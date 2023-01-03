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
      try (var emailDispacher = new KafkaDispacher<Email>()) {
        var email = Math.random() + "@email.com";
        for (var i = 0; i < 10; i++) {

          var orderId = UUID.randomUUID().toString();
          var amount = BigDecimal.valueOf(Math.random() * 5000 + 1);

          var order = new Order(orderId, amount, email);
          orderDispacher.send("ECOMMERCE_NEW_ORDER", email, order);

          var emailCode = new Email("Thanks you for order! We are processing your order",
              "Corpo do email");

          emailDispacher.send("ECOMMERCE_SEND_EMAIL", email, emailCode);
        }
      }
    }
  }
}
