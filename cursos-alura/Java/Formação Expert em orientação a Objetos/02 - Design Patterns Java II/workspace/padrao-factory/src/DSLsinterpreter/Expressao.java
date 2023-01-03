package DSLsinterpreter;

import DSLsinterpreter.visitor.Visitor;

public interface Expressao {

    int avalia();

    void aceita(Visitor visitor);
}
