package state.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import strategy.imposto.Item;

public class Orcamento {

	protected double valor;

	private final List<Item> itens;

	protected EstadoDeUmOrcamento estadoAtual;

	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
		this.estadoAtual = new EmAprovacao();
	}

	public double getValor() {
		return valor;
	}

	/**
	 * Lista n�o pode ser modificada externamente
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

	public void aplicaDescontoExtra() {
		// 1� Regra: se or�amento estiver em stado de aprova��o o desconto ser� de 5%
		// 2� Regra: se or�amento estiver em stado de aprovado o desconto ser� de 2%
		estadoAtual.aplicaDescontoExtra(this);
	}

	// Os metodos para mudan�a de estado
	public void aprova() {
		estadoAtual.aprova(this);
	}

	public void reprova() {
		estadoAtual.reprova(this);
	}

	public void finaliza() {
		estadoAtual.finaliza(this);
	}

}
