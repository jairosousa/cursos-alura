package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 19:53
 *
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;

public class GsonDeserializer<T> implements Deserializer<T> {

  public static final String TYPE_CONFIG = "br.com.alura.ecommerce.type_config"; // string qualquer
  private final Gson gson = new GsonBuilder().create();
  private Class<T> type;

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    String typeName = String.valueOf(configs.get(TYPE_CONFIG));
    try {
      this.type = (Class<T>) Class.forName(typeName);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Type for deseralization doesa not exists in the classpath", e);
    }
  }

  @Override
  public T deserialize(String s, byte[] bytes) {
    return gson.fromJson(new String(bytes), type);
  }
}
