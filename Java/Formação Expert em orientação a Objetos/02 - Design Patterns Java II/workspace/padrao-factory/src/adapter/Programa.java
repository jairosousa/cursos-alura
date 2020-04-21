package adapter;

import java.util.Calendar;

public class Programa {

    public static void main(String[] args) {

        Relogio relogio = new RelogioSistema();

        Calendar agora = relogio.hoje();

        /**
         * Quando temos um conjunto de classes legadas,
         * que achamos que seu uso vai sujar o novo sistema,
         * criamos um "adaptador" que facilita sua utilização.
         * O nome desse padrão de projetos é Adapter.
         */
    }
}
