package flyweight;

import org.jfugue.player.Player;

import java.util.List;

public class Piano {

    public void toca(List<Nota> musica) {
        Player player = new Player();

        StringBuffer musicaEmNotas = new StringBuffer();
        for (Nota nota : musica) {
            musicaEmNotas.append(nota.simbolo() + " ");
        }

        System.out.println(musicaEmNotas.toString());

        player.play(musicaEmNotas.toString());
    }
}
