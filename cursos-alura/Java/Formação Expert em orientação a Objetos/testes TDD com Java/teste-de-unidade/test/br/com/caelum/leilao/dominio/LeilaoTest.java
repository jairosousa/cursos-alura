package br.com.caelum.leilao.dominio;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import org.junit.Before;
import org.junit.Test;

import static br.com.caelum.leilao.mather.LeilaoMatcher.temUmLance;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LeilaoTest {

	private Usuario steveJobs;
	private Usuario steveWozniak;
	private Usuario billGates;

	@Before
	public void setUp() {
		steveJobs = new Usuario("Steve Jobs");
		steveWozniak = new Usuario("Steve Wozniak");
		billGates = new Usuario("Bill Gates");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRecusarLancesComValorDeZero() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo")
				.lance(steveJobs, 0)
				.constroi();
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRecusarLancesComValorNegativo() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo").lance(steveJobs, -1000).constroi();
	}

	/**
	 * Matcher customizado
	 */
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.constroi();
		
		assertEquals(0, leilao.getLances().size());
		
		Lance lance = new Lance(steveJobs, 2000.0);
		
		leilao.propoe(lance);

		assertThat(leilao.getLances().size(), equalTo(1));
		assertThat(leilao.getLances().get(0).getValor(), equalTo(2000.0));
		assertThat(leilao, temUmLance(lance));
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.lance(steveJobs, 2000.0)
				.lance(steveWozniak, 3000.0)
				.constroi();

		assertThat(leilao.getLances().size(), equalTo(2));
		assertThat(leilao.getLances().get(0).getValor(), equalTo(2000.0));
		assertThat(leilao.getLances().get(1).getValor(), equalTo(3000.0));
	}

	@Test
	public void naoDeveaceitarDoisLancesSequidosDoMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.lance(steveJobs, 2000.0)
				.lance(steveJobs, 3000.0)
				.constroi();
		
		assertThat(leilao.getLances().size(), equalTo(1));
		assertThat(leilao.getLances().get(0).getValor(), equalTo(2000.0));
	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.lance(steveJobs, 2000.0)
				.lance(billGates, 3000.0)
				.lance(steveJobs, 4000.0)
				.lance(billGates, 5000.0)
				.lance(steveJobs, 6000.0)
				.lance(billGates, 7000.0)
				.lance(steveJobs, 8000.0)
				.lance(billGates, 9000.0)
				.lance(steveJobs, 10000.0)
				.lance(billGates, 11000.0)
				.lance(steveJobs, 12000.0) // deve ser ignorado
				.constroi();

		assertThat(leilao.getLances().size(), equalTo(10));
		assertThat(leilao.getLances().get(leilao.getLances().size() - 1).getValor(),equalTo(11000.0));

	}

	@Test
	public void deveDobrarOUltimoLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.lance(steveJobs, 2000.0)
				.lance(billGates, 3000.0)
				.lance(steveJobs, 4000.0)
				.lance(billGates, 5000.0)
				.lance(steveJobs, 6000.0)
				.lance(billGates, 7000.0)
				.constroi();
		
		leilao.dobrarLance(steveJobs);
		leilao.dobrarLance(billGates);

		assertThat(leilao.getLances().size(), equalTo(8));
		assertThat(leilao.getLances().get(leilao.getLances().size() - 2).getValor(), equalTo(12000.0));
		assertThat(leilao.getLances().get(leilao.getLances().size() - 1).getValor(), equalTo(14000.0));

	}

	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();

		leilao.dobrarLance(steveJobs);

		assertEquals(0, leilao.getLances().size());
	}
	
}
