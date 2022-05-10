package juego;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Random;

public class Juego extends JFrame {
//Juego juego = new Juego();


    ControlTeclas teclas = new ControlTeclas();
    private int tecla = teclas.getTecla();
    private final int tamArray = 16;
    private final int tamUnidad = 30;
    private final int ANCHO = tamArray * tamUnidad;
    private final int ALTO = tamArray * tamUnidad;

    int anchoCulebra = tamUnidad;
    private int banderaCulebra = 0;
    private int imayor = 1;
    private int jmayor = 1;
    private static int culebraMayor = 1;

    private int valorManzana = 1001;
    private int valorChoque = 1002;
    private int frecuencia = 400;
    private int gameOver = 0;
    private int pausa = 0;
    private int puntos = 0;

    private int[][] culebrita = new int[tamArray][tamArray];
    private Dibujar dibujar = new Dibujar(ALTO, ANCHO, anchoCulebra, tamArray, tamUnidad, valorChoque, culebrita);

    public Juego() {

        ventana();

        this.addKeyListener(teclas);
        crearCulebra();
        generarManzana();
        acciones();

    }
    public void ventana() {
        setTitle("Culebrita");
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/snake_96px.png"))).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setSize(ANCHO + 16, ALTO + 39);
        setLocationRelativeTo(null);
    }
    public void crearCulebra() {

        for (int i = 0; i < tamArray; i++) {
            for (int j = 0; j < tamArray; j++) {
                culebrita[i][j] = 0;
            }
        }

        culebrita[((tamArray -(tamArray % 2)) / 2) +1] [(tamArray - (tamArray % 2)) / 2] = 1;
        culebrita[((tamArray -(tamArray % 2)) / 2) ] [(tamArray - (tamArray % 2)) / 2] = 2;
        culebrita[((tamArray -(tamArray % 2)) / 2) -1] [(tamArray - (tamArray % 2)) / 2] = 3;
        culebrita[((tamArray -(tamArray % 2)) / 2) -2] [(tamArray - (tamArray % 2)) / 2] = 4;

        imayor = ((tamArray -(tamArray % 2)) / 2) -2;
        jmayor = ((tamArray - (tamArray % 2)) / 2);
        culebraMayor = 4;
        getContentPane().add(dibujar);
    }
    public void generarManzana() {
        Random random = new Random();
        int comidaX = random.nextInt(tamArray);
        int comidaY = random.nextInt(tamArray);

        if (culebrita[comidaX][comidaY] == 0) {
            culebrita[comidaX][comidaY] = valorManzana;
        } else {
            generarManzana();
        }
    }
    public void acciones() {
        long tiempo = 0;
        while (gameOver == 0) {

            if ((System.currentTimeMillis() - tiempo) > frecuencia) {
                if (tecla == KeyEvent.VK_SPACE) {
                    pausa = 1;
                }else{
                    pausa = 0;
                }

                if (pausa == 0) {
                    moverArAbID();
                }


                dibujar.repaint();
                tiempo = System.currentTimeMillis();
            }
        }
        perdio();
    }
    public void perdio() {
        ImageIcon icono = new ImageIcon("/img/snake_96px.png");
        int res = JOptionPane.showConfirmDialog(null, "Perdiste\n Tu puntaje es: " + puntos + "\n ¿Desea jugar de nuevo?\"", "GameOver",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, icono);
        if (res == JOptionPane.YES_OPTION) {
            Juego juego = new Juego();
        }else{
            System.exit(0);
        }

    }

    public void moverArAbID() {

        for(int i = 0; i < tamArray; i++){
            for(int j = 0; j < tamArray; j++){

                if(culebrita[i][j] == 1 && banderaCulebra == 0){

                    if (tecla == KeyEvent.VK_RIGHT) {
                        if (i + 1 < tamArray) {
                            if (culebrita[i + 1][j] == 1001) {
                                generarManzana();
                            }
                            else{
                                culebrita[imayor][jmayor] = 0;
                            }

                            for (int k = 0; k < tamArray; k++) {
                                for (int l = 0; l < tamArray; l++) {
                                    if (culebrita[k][l]>0 && culebrita[k][l]<1000) {
                                        culebrita[k][l]++;
                                    }
                                }
                            }
                            if (culebrita[i + 1][j] > 0 && culebrita[i + 1][j] < 1000) {
                                culebrita[i+1][j] = valorChoque; gameOver=1;
                            } else {
                                culebrita[i + 1][j] = 1;
                            }
                            banderaCulebra = 1;
                        }else{
                            gameOver = 1;
                        }
                    }
                    if (tecla == KeyEvent.VK_LEFT) {
                        if (i - 1 >= 0) {
                            if (culebrita[i - 1][j] == 1001) {
                                generarManzana();
                            }
                            else{
                                culebrita[imayor][jmayor] = 0;
                            }
                            for (int k = 0; k < tamArray; k++) {
                                for (int l = 0; l < tamArray; l++) {
                                    if (culebrita[k][l]>0 && culebrita[k][l]<1000) {
                                        culebrita[k][l]++;
                                    }
                                }
                            }
                            if(culebrita[i-1][j] > 0 && culebrita[i-1][j] < 1000){
                                culebrita[i-1][j] = 1002; gameOver=1;
                            }else{
                                culebrita[i - 1][j] = 1;
                            }
                            banderaCulebra = 1;
                        }else{
                            gameOver = 1;
                        }
                    }
                    if (tecla == KeyEvent.VK_UP){
                        if (j - 1 >= 0) {
                            if (culebrita[i][j - 1] == 1001) {
                                generarManzana();
                            }else{
                                culebrita[imayor][jmayor] = 0;
                            }
                            for (int k = 0; k < tamArray; k++) {
                                for (int l = 0; l < tamArray; l++) {
                                    if (culebrita[k][l]>0 && culebrita[k][l]<1000) {
                                        culebrita[k][l]++;
                                    }
                                }
                            }
                            if(culebrita[i][j-1] > 0 && culebrita[i][j-1] < 1000){
                                culebrita[i][j-1] = 1002; gameOver=1;
                            }else{
                                culebrita[i][j - 1] = 1;
                            }
                            banderaCulebra = 1;
                        }else{
                            gameOver = 1;
                        }
                    }
                    if (tecla == KeyEvent.VK_DOWN){
                        if (j + 1 < tamArray) {
                            if (culebrita[i][j + 1] == 1001) {
                                generarManzana();
                            }else{
                                culebrita[imayor][jmayor] = 0;
                            }
                            for (int k = 0; k < tamArray; k++) {
                                for (int l = 0; l < tamArray; l++) {
                                    if (culebrita[k][l]>0 && culebrita[k][l]<1000) {
                                        culebrita[k][l]++;
                                    }
                                }
                            }
                            if(culebrita[i][j+1] > 0 && culebrita[i][j+1] < 1000){
                                culebrita[i][j+1] = 1002; gameOver=1;
                            }else{
                                culebrita[i][j + 1] = 1;
                            }
                            banderaCulebra = 1;
                        }else{
                            gameOver = 1;
                        }
                    }
                }
            }
        }
        banderaCulebra = 0;
        obtenerCulebraMayor();
    }
    public void obtenerCulebraMayor() {
        for (int i = 0; i < tamArray; i++) {
            for (int j = 0; j < tamArray; j++) {
                if (culebrita[i][j] >= culebraMayor && culebrita[i][j] < 1000) {
                    culebraMayor = culebrita[i][j];
                    imayor = i;
                    jmayor = j;
                }
            }
        }
    }

}
