package br.com.alura.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Jairo Nascimento on 04/07/2021 - 19:38
 */
public class NewOrderServlet extends HttpServlet {

  private final KafkaDispacher<Order> orderDispacher = new KafkaDispacher<>();
  private final KafkaDispacher<Email> emailDispacher = new KafkaDispacher<>();

  @Override
  public void destroy() {
    super.destroy();
    orderDispacher.close();
    emailDispacher.close();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      // we are not caring about any security issues, we are only
      // showing how to use http as a starting point.

      var email = req.getParameter("email");
      var amount = new BigDecimal(req.getParameter("amount"));
      var orderId = UUID.randomUUID().toString();

      var order = new Order(orderId, amount, email);
      orderDispacher.send("ECOMMERCE_NEW_ORDER", email, order);

      var emailCode = new Email("Thanks you for order! We are processing your order",
          order.toString());

      emailDispacher.send("ECOMMERCE_SEND_EMAIL", email, emailCode);

      System.out.println("New order send successfully");
      resp.setStatus(HttpServletResponse.SC_OK);
      resp.getWriter().println("New order send: " + order);

    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
      throw new ServletException(e);
    }

  }
}
