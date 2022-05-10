package juego;

import javax.swing.*;
import java.awt.*;

public class Dibujar extends JPanel {
    int ALTO;
    int ANCHO;
    int anchoCulebra;
    int tamArray;
    int[][] culebrita;
    int tamUnidad;
    int valorChoque;

    public Dibujar(int ALTO, int ANCHO, int anchoCulebra, int tamArray, int tamUnidad, int valorChoque, int[][] culebrita) {
        this.ALTO = ALTO;
        this.ANCHO = ANCHO;
        this.anchoCulebra = anchoCulebra;
        this.tamArray = tamArray;
        this.tamUnidad = tamUnidad;
        this.valorChoque = valorChoque;
        this.culebrita = culebrita;
    }

    public void paint(Graphics g) {
        super.paint(g);

        setBackground(new Color (0xF2698300, true));
        g.setColor(new Color(0, 0, 0));

        for (int i = 0; i < ALTO; i= i + anchoCulebra) {
            g.drawLine(0, i, ANCHO, i);
        }
        for (int i = 0; i < ANCHO; i= i + anchoCulebra) {
            g.drawLine(i, 0, i, ALTO);
        }

        for (int i = 0; i < tamArray; i++) {
            for (int j = 0; j < tamArray; j++) {
                int colorearcolita = 0;
                if (culebrita[i][j] > 0 && culebrita[i][j] < 1000) {
                    g.setColor(new Color (60, 253, 0));

                    if ((i-1)>=0){
                        if ((culebrita[i-1][j] == culebrita[i][j] + 1) || (culebrita[i-1][j] == valorChoque)) {
                            g.fillRect((i* tamUnidad)-5, (j* tamUnidad)+5, tamUnidad, tamUnidad -10);
                            colorearcolita = 1;
                        }
                    }
                    if ((j-1) >= 0){
                        if (culebrita[i][j-1] == culebrita[i][j] + 1 || culebrita[i][j-1] == valorChoque) {
                            g.fillRect((i* tamUnidad)+5, (j* tamUnidad)-5, tamUnidad -10, tamUnidad);
                            colorearcolita = 1;
                        }
                    }
                    if ((i+1) < tamArray){
                        if (culebrita[i+1][j] == culebrita[i][j] + 1 || culebrita[i+1][j] == valorChoque) {
                            g.fillRect((i* tamUnidad)+5, (j* tamUnidad)+5, tamUnidad, tamUnidad -10);
                            colorearcolita = 1;
                        }
                    }
                    if ((j+1) < tamArray){
                        if (culebrita[i][j+1] == culebrita[i][j] + 1 || culebrita[i][j+1] == valorChoque) {
                            g.fillRect((i* tamUnidad)+5, (j* tamUnidad)+5, tamUnidad -10, tamUnidad);
                            colorearcolita = 1;
                        }
                    }
                    if (colorearcolita == 0){
                        g.fillRect((i* tamUnidad)+5, (j* tamUnidad)+5, tamUnidad -10 , tamUnidad -10) ;
                    }
                    if (culebrita[i][j] == 1){
                        g.setColor(new Color (60, 253, 0));
                        g.fillRect((i* tamUnidad)+8, (j* tamUnidad)+8, tamUnidad -16, tamUnidad -16);
                    }
                }else if (culebrita[i][j] == 1001){
                    g.setColor(new Color (209,39,22));
                    g.fillRect((i* tamUnidad)+5, (j* tamUnidad)+5, tamUnidad -10, tamUnidad -10);
                }else if (culebrita[i][j] == 1002){
                    g.fillRect((i* tamUnidad)+5, (j* tamUnidad)+5, tamUnidad -10, tamUnidad -10);
                    g.setColor(new Color (60, 253, 0));
                    g.fillRect((i* tamUnidad)+8, (j* tamUnidad)+8, tamUnidad -16, tamUnidad -16);
                }
            }
        }

    }
}