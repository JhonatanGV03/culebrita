package juego;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Juego juego = new Juego();

    public Ventana() {
        this.setTitle("Culebrita");
        this.setIconImage(new ImageIcon(getClass().getResource("/img/snake_96px.png")).getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.pack();
        this.setVisible(true);
        this.setSize(500, 500);
        this.add(juego);
        juego.setBackground(new Color(74, 252, 52, 236));
        //this.setLocationRelativeTo(null);
    }
}
