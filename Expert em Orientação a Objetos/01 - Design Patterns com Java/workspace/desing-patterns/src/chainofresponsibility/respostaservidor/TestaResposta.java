package chainofresponsibility.respostaservidor;

public class TestaResposta {

	public static void main(String[] args) {
		
		Requisicao req = new Requisicao(Formato.PORCENTO);
		Conta conta = new Conta("Jairo", 500.0);
		
		Resposta r3 = new RespostaEmPorCento();
		Resposta r2 = new RespostaEmCSV(r3);
		Resposta r1 = new RespostaEmXML(r2);
		
//		r1.setProxima(r2);
//		r2.setProxima(r3);
		
		r1.responde(req, conta);

	}

}
