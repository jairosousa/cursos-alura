package br.com.alura.ecommerce;/*
 *
 * @Author: Jairo Nascimento on 20/06/2021 - 20:13
 *
 */

public class Email {

  private final String subject, body;

  public Email(String subject, String body) {
    this.subject = subject;
    this.body = body;
  }

  @Override
  public String toString() {
    return "Email{" +
        "subject='" + subject + '\'' +
        ", body='" + body + '\'' +
        '}';
  }
}
