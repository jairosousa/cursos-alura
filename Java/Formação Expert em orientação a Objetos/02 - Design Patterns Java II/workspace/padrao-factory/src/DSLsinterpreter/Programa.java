package DSLsinterpreter;

import DSLsinterpreter.visitor.ImpressoraVisitor;
import DSLsinterpreter.visitor.Visitor;

public class Programa {

    public static void main(String[] args) {
        Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
        Expressao direita = new Soma(new Numero(2), new Multiplicacao(new Numero(3), new Numero(6)));

        Expressao conta = new Multiplicacao(esquerda, direita);

        int resultado = conta.avalia();
        System.out.println(resultado);

        Expressao raizQuadrada = new RaizQuadrada(new Numero(resultado));
        System.out.println(raizQuadrada.avalia());

        /**
         * Teste Padrão Visitor
         */
        Visitor visitor = new ImpressoraVisitor();

        conta.aceita(visitor);

        System.out.println("Raiz Quadrada");
        raizQuadrada.aceita(visitor);

    }
}
