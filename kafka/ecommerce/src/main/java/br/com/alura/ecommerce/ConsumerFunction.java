package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 17:49
 *
 */

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction {

  void consume(ConsumerRecord<String, String> record);
}
