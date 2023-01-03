package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrapper {

	public static void main(String[] args) {

		Integer idadeRef = Integer.valueOf(29); // autoboxing
		System.out.println(idadeRef.intValue()); // unboxing

		Double dRef = Double.valueOf(3.2); // autoboxing
		System.out.println(dRef.doubleValue()); //unboxing
		
		Boolean bRef = Boolean.TRUE;
		System.out.println(bRef.booleanValue());
		
		
		Number refNumero = Integer.valueOf(29);
		
		List<Number> lista = new ArrayList<>();
		lista.add(29);
		lista.add(32.5f);
		lista.add(0);
		
	}

}
