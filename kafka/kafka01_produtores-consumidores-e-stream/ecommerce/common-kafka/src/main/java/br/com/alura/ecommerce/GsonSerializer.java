package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 19:23
 *
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Serializer;

public class GsonSerializer<T> implements Serializer<T> {

  private final Gson gson = new GsonBuilder().create();

  @Override
  public byte[] serialize(String s, T obj) {
    return gson.toJson(obj).getBytes();
  }
}
