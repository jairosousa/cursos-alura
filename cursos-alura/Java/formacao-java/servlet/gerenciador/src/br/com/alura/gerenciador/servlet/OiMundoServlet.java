package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi", loadOnStartup=1)
public class OiMundoServlet extends HttpServlet {

	public OiMundoServlet() {
//		System.out.println("Criando Oi Mundo servlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Oi mundo!! Parab�ns voc� escreveu o primeiro servlets</h1>");
		out.println("</body>");
		out.println("</html>");

		System.out.println("O Servelt OiMundoServlet foi chamdado");
	}

}
