package br.com.bytebank.banco.modelo;

public class GuardadorDeReferencias {

	private Object[] referencias;

	private int posicaoLivre;

	public GuardadorDeReferencias() {
		this.referencias = new Object[10];
	}

	public void adiciona(Object ref) {
		this.referencias[this.posicaoLivre] = ref;
		posicaoLivre++;
	}

	public int getQuantidadeDeElementos() {
		return this.posicaoLivre;
	}

	public Object getReferencia(int i) {
		return this.referencias[i];
	}
}
