package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 13:55
 *
 */

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    try (var dispacher = new KafkaDispacher()) {
      var key = UUID.randomUUID().toString();

      var value = key + "1236,123695,7856952364";
      dispacher.send("ECOMMERCE_NEW_ORDER", key, value);

      var email = "Thanks you for order! We are processing your order";
      dispacher.send("ECOMMERCE_SEND_EMAIL", key, email);
    }
  }
}
