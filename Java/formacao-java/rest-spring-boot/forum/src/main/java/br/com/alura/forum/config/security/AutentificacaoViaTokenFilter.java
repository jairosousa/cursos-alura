package br.com.alura.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.forum.modelo.Usuario;

/**
 * Classe responsavel para recuperar os token das requisições do usuario
 * autenticado
 * 
 * @author jnasciso
 * @date outubro/2019
 */
public class AutentificacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;

	public AutentificacaoViaTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Recupera o token na requisiçao
		String token = recuperarToken(request);

		// Validando o token
		boolean valido = tokenService.isTokenValido(token);

		// Autenticando o cliente via Spring Security
		if (valido) {
			autenticarCliente(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticarCliente(String token) {
		Usuario usuario = tokenService.getUsuario(token);
		
		System.out.println(usuario.getEmail());
		
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	private String recuperarToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
