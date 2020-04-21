package flyweight;

import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        NotasMusicais notas = new NotasMusicais();

        List<Nota> musica = Arrays.asList(
          notas.pega("do"),
          notas.pega("dosustenido"),
          notas.pega("re"),
          notas.pega("mi"),
          notas.pega("fa"),
          notas.pega("fa"),
          notas.pega("do"),
          notas.pega("re"),
          notas.pega("do"),
          notas.pega("re"),
          notas.pega("re")
        );

        Piano piano = new Piano();
        piano.toca(musica);

    }
}
