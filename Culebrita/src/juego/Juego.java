package juego;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    private int fila;
    private int columna;
    private final Tablero tablero = new Tablero();


    public Juego() {

    }
    public void pintor(Graphics pintor){

    }

    public void generarManzana(){
        tablero.setFila((int) (Math.random()*15));
        tablero.setColumna((int) (Math.random()*15));
    }



}


