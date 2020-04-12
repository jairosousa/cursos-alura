package builder;

public class ItemDaNotaBuider {
	
	private String nome;
	private double valor;

	public ItemDaNotaBuider comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ItemDaNotaBuider comValor(double valor) {
		this.valor = valor;
		return this;
	}
	
	public ItemDaNota constroi() {
		return new ItemDaNota(nome, valor);
	}

}
