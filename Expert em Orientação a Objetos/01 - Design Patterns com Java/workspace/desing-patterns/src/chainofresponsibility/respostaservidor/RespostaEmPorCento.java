package chainofresponsibility.respostaservidor;

public class RespostaEmPorCento implements Resposta {

	private Resposta resposta;

	public RespostaEmPorCento(Resposta resposta) {
		this.resposta = resposta;
	}

	public RespostaEmPorCento() {
	}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.PORCENTO) {
			System.out.println(conta.getTitular() + "%" + conta.getSaldo());
		} else {
			resposta.responde(req, conta);
		}

	}

	@Override
	public void setProxima(Resposta resposta) {
		this.resposta = resposta;
	}

}
