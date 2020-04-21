package DSLsinterpreter.visitor;

import DSLsinterpreter.*;

public interface Visitor {

    void visitaSoma(Soma soma);

    void visitaSubtracao(Subtracao subtracao);

    void visitaMultiplicacao(Multiplicacao multiplicacao);

    void visitaDivisao(Divisao divisao);

    void visitaRaizQuadrada(RaizQuadrada raizQuadrada);

    void visitaNumero(Numero numero);
}
