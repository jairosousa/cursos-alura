package default_methods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Principal {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        Comparator<String> comparador = new ComparadorDeStringPorTamanho();
//        Collections.sort(palavras, comparador);

        palavras.sort(comparador);
//        System.out.println(palavras);
        Consumer<String> consumidor = new ConsumidorDeString();
        palavras.forEach(consumidor);

        UnaryOperator<String> operator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return "teste: " + s;
            }
        };

        palavras.replaceAll(operator);

        palavras.forEach(consumidor);
    }


}

class ComparadorDeStringPorTamanho implements Comparator<String> {

    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }

}

class ConsumidorDeString implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}
