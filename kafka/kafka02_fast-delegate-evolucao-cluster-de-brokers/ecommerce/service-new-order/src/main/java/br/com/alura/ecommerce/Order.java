package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 19:07
 *
 */

import java.math.BigDecimal;

public class Order {

  private final String orderId;
  private final String email;
  private final BigDecimal amount;

  public Order(String orderId, BigDecimal amount, String email) {
    this.orderId = orderId;
    this.amount = amount;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Order{" +
        ", orderId='" + orderId + '\'' +
        ", email='" + email + '\'' +
        ", amount=" + amount +
        '}';
  }
}
