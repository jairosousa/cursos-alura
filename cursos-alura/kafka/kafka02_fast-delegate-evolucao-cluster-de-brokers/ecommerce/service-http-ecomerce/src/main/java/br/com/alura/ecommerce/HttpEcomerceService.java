package br.com.alura.ecommerce;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @Author: Jairo Nascimento on 04/07/2021 - 19:32
 */
public class HttpEcomerceService {

  public static void main(String[] args) throws Exception {
    var server = new Server(8080);
    var context = new ServletContextHandler();
    context.setContextPath("/");
    context.addServlet(new ServletHolder(new NewOrderServlet()),"/new");

    server.setHandler(context);

    server.start();
    server.join();
  }

}
