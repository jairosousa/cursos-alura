package br.com.alura;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestaMap {

	public static void main(String[] args) {

		Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");
        
        pessoas.keySet().forEach(idade -> System.out.println(idade));
        pessoas.values().forEach(nome -> System.out.println(nome));
        
        System.out.println("========================");
        
        Map<String, Integer> nomesParaIdade = new HashMap<>();
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);
        
        nomesParaIdade.keySet().forEach(nome -> System.out.println(nome));
        nomesParaIdade.values().forEach(idade -> System.out.println(idade));

        System.out.println("==========Associação==============");
        
        Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();
        
        for (Entry<String, Integer> associacao : associacoes) {
            System.out.println(associacao.getKey() + " - " + associacao.getValue());
        }
        
	}

}
