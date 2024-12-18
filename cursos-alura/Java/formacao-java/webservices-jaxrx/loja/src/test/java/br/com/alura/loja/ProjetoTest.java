package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {
	
	private HttpServer server;

	@Before
	public void startServidor() {
		server = Servidor.InicializaServidor();
	}

	@After
	public void stopServidor() {
		server.stop();
	}
	
	@Test
	public void testeQueBuscaUmProjetoTrazOProjetoEsperado(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos/1").request().get(String.class);
		
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);

		Assert.assertEquals("Minha Loja", projeto.getNome());
	}

	@Test
	public void testaQueAConexaoComOServidorLocalFunciona() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);

		System.out.println(conteudo);

		Assert.assertTrue(conteudo.contains("Minha Loja"));

	}

}
