package DSLsinterpreter;

import DSLsinterpreter.visitor.Visitor;

public class RaizQuadrada implements Expressao {

    private Numero numero;

    public RaizQuadrada(Numero numero) {
        this.numero = numero;
    }

    @Override
    public int avalia() {
        int num = numero.avalia();

        return (int) Math.sqrt(num);
    }

    @Override
    public void aceita(Visitor visitor) {
        visitor.visitaRaizQuadrada(this);
    }

    public Numero getNumero() {
        return numero;
    }
}
