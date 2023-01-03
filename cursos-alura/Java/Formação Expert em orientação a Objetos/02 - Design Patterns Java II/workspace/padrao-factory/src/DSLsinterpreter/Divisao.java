package DSLsinterpreter;

import DSLsinterpreter.visitor.Visitor;

public class Divisao implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Divisao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int avalia() {
        int resultadoDaEsquerda = esquerda.avalia();
        int resultadoDaDireita = direita.avalia();
        return resultadoDaDireita == 0 ? 0 : resultadoDaEsquerda / resultadoDaDireita;
    }

    @Override
    public void aceita(Visitor visitor) {
        visitor.visitaDivisao(this);
    }

    public Expressao getEsquerda() {
        return esquerda;
    }

    public Expressao getDireita() {
        return direita;
    }
}
