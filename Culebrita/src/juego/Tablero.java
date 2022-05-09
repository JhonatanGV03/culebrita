package juego;


public class Tablero {
    private int fila;
    private int columna;
    private final int [][] tablero = new int[16][16];

    public Tablero() {
;
    }

    public int[][] tablero () {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                tablero[i][j] = 0;
            }
        }
        setManzana();
        return tablero;
    }

    public void setManzana() {
        tablero[fila][columna] = -1;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        this.tablero();
        String k="";
        for (int i = 0; i < 16; i++) {
            k+="\n";
            for (int j = 0; j < 16; j++) {
                k+=tablero[i][j]+" ";
            }
        }
        return k;
    }

}
