package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}

	public void doFilter(ServletRequest servetRequest, ServletResponse ServletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");

		// fazer cast para HttpSevlet
		HttpServletRequest request = (HttpServletRequest) servetRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;

		String paramAcao = request.getParameter("acao");

		HttpSession sessao = request.getSession();

		boolean usuarioNaoestalogado = sessao.getAttribute("usuarioLogado") == null;
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

		if (ehUmaAcaoProtegida && usuarioNaoestalogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		chain.doFilter(request, response);
	}

}
