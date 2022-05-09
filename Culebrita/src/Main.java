import juego.Tablero;
import juego.Ventana;

public class Main {
    public static void main(String[] args) {

        Ventana culebrita = new Ventana();

        Tablero tablero = new Tablero();

        String k= tablero.toString();
        System.out.println(k);

    }

}
