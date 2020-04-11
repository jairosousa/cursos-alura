package chainofresponsibility.respostaservidor;

public class RespostaEmXML implements Resposta {

	private Resposta resposta;

	public RespostaEmXML(Resposta resposta) {
		this.resposta = resposta;
	}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.XML) {
			System.out.println("<conta><titular>" + conta.getTitular() + "</titulat>" + "<saldo>" + conta.getSaldo()
					+ "</saldo></conta>");
		} else {
			resposta.responde(req, conta);
		}
	}

	@Override
	public void setProxima(Resposta resposta) {
		this.resposta = resposta;
	}

}
