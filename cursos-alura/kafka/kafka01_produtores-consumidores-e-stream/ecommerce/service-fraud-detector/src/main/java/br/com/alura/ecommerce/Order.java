package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 19:07
 *
 */

import java.math.BigDecimal;

public class Order {

  private final String userId, orderId;
  private final BigDecimal amount;

  public Order(String userId, String orderId, BigDecimal amount) {
    this.userId = userId;
    this.orderId = orderId;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Order{" +
        "userId='" + userId + '\'' +
        ", orderId='" + orderId + '\'' +
        ", amount=" + amount +
        '}';
  }
}
