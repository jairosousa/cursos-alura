package bridges;

public class Programa {

    public static void main(String[] args) {
        Mapa mapa = new GoogleMaps();
        mapa.devolveMapa("Rua Isaac");
        /**
         * Repare que essa interface é uma "ponte"
         * para a implementação concreta.
         * O nome desse padrão de projeto é justamente esse: Bridge.
         */
    }
}
