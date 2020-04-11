package strategy.imposto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

	private final double valor;

	private final List<Item> itens;

	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
	}

	public double getValor() {
		return valor;
	}

	/**
	 * Lista não pode ser modificada externamente
	 * 
	 * @return
	 */
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	/**
	 * Adiciona um item em uma lista
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		itens.add(item);
	}

	/**
	 * Verificar se o item esta lista
	 */
	public boolean contemItemDeNome(String nomeDoItem) {
		for (Item item : itens) {
			if (item.getNome().equals(nomeDoItem)) {
				return true;
			}
		}

		return false;
	}

}
