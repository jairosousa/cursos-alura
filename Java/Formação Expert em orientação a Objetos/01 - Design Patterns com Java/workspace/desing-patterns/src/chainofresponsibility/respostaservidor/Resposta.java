package chainofresponsibility.respostaservidor;

public interface Resposta {

	void responde(Requisicao req, Conta conta);
	void setProxima(Resposta resposta);
}
