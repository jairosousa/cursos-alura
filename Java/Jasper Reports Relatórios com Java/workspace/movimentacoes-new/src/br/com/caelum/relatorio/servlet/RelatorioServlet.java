package br.com.caelum.relatorio.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.relatorio.ConnectionFactory;
import br.com.caelum.relatorio.GeradorRelatorio;

/**
 * Servlet implementation class RelatorioServlet
 */
@WebServlet("/gastos")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection connection = new ConnectionFactory().getConnection();

			//Aqui gera o PDF.
			//O arquivo .jasper se encontra na pasta /WEB-INF/jasper/movimentacoes.jasper
			//Você pode utilizar a classe GeradorRelatorio que j‡ existe no projeto.
			
			String nome = request.getServletContext().getRealPath("/WEB-INF/jasper/gasto_por_mes.jasper");
			Map<String, Object> parametros = new HashMap<String, Object>();
			
			GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, connection);
            gerador.geraPDFParaOutputStream(response.getOutputStream());

			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		} 
	}

}
