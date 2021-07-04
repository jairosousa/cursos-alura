package br.com.alura.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @Author: Jairo Nascimento on 04/07/2021 - 16:47
 */
public class CreateUserService {

  private final Connection connection;

  public CreateUserService() throws SQLException {
    String url = "jdbc:sqlite:target/users_database.db";
    this.connection = DriverManager.getConnection(url);
    try {
      this.connection.createStatement().execute("CREATE TABLE Users ("
          + "uuid VARCHAR(200) PRIMARY KEY,"
          + "email VARCHAR(200))");
    }catch (SQLException e) {
      // be careful, the sql could be wrong, be realy careful!!
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws SQLException {
    var userService = new CreateUserService();
    try (var service = new KafkaServices<>(CreateUserService.class.getSimpleName(),
        "ECOMMERCE_NEW_ORDER",
        userService::parse,
        Order.class, new HashMap<>())) {
      service.run();
    }
  }

  private void parse(ConsumerRecord<String, Order> record) throws SQLException {
    System.out.println("Processing new order, checking for new user");
    System.out.println(record.key());
    System.out.println(record.value());
    System.out.println(record.partition());
    System.out.println(record.offset());
    var order = record.value();

    if (isNewUser(order.getEmail())) {
      insertNewUser(order.getEmail());
    }

    System.out.println("Order processed: " + order);
  }

  private void insertNewUser(String email) throws SQLException {
    var insert = connection.prepareStatement("INSERT INTO Users (uuid, email) VALUES (?,?)");
    insert.setString(1, UUID.randomUUID().toString());
    insert.setString(2, email);
    insert.execute();
    System.out.println("Usuario uuid e " + email + " adicionado");
  }

  private boolean isNewUser(String email) throws SQLException {
    var exists = connection.prepareStatement("SELECT uuid FROM Users WHERE email = ? LIMIT 1");
    exists.setString(1, email);
    var result = exists.executeQuery();
    return !result.next();
  }

}
