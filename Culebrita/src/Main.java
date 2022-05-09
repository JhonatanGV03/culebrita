import juego.Tablero;
import juego.Ventana;

public class Main {
    public static void main(String[] args) {

        //Ventana culebrita = new Ventana();

        Tablero tablero = new Tablero();

        int i = (int) (Math.random() * 10);
        int j = (int) (Math.random() * 10);
        tablero.setFila(i);
        tablero.setColumna(j);

        String k= tablero.toString();
        System.out.println(k);

    }

}
