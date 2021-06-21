package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 15:48
 *
 */

import java.util.HashMap;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

  public static void main(String[] args) {
    var emailService = new EmailService();
    try (var service = new KafkaServices(EmailService.class.getSimpleName(),
        "ECOMMERCE_SEND_EMAIL", emailService::parse, Email.class, new HashMap<>())) {
      service.run();
    }
  }

  private void parse(ConsumerRecord<String, Email> record) {
    System.out.println("----------------------------------------");
    System.out.println("Send email");
    System.out.println(record.key());
    System.out.println(record.value());
    System.out.println(record.partition());
    System.out.println(record.offset());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Email enviado");
  }

}
