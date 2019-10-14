package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

public class ProjetoTest {

	@Test
	public void testaQueAConexaoComOServidorLocalFunciona() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);

		System.out.println(conteudo);

		Assert.assertTrue(conteudo.contains("Minha Loja"));

	}

}
