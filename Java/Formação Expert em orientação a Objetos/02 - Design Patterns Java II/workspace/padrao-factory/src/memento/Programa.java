package memento;

import java.util.Calendar;

public class Programa {

    public static void main(String[] args) {

        Historico historico = new Historico();

        Contrato c1 = new Contrato(Calendar.getInstance(), "Jairo", TipoContrato.NOVO);
        historico.adiciona(c1.salvaEstado());

        c1.avanca();
        historico.adiciona(c1.salvaEstado());
        System.out.println(c1.getTipo());

        c1.avanca();
        historico.adiciona(c1.salvaEstado());
        System.out.println(c1.getTipo());

        c1.avanca();
        historico.adiciona(c1.salvaEstado());

        Estado estadoAnt = historico.pega(1);

        System.out.println(estadoAnt.getContrato().getTipo());
        System.out.println(c1.getTipo());

        c1.restaura(historico.pega(0));

        System.out.println(c1.getTipo());
    }
}
