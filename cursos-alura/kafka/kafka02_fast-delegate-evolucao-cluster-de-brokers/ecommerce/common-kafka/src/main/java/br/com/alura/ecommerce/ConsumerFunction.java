package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 17:49
 *
 */

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction<T> {
  void consume(ConsumerRecord<String, T> record)
      throws Exception;
}
