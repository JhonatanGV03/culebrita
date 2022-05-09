package juego;

import java.awt.event.KeyEvent;

public class ControlTeclas extends java.awt.event.KeyAdapter {
    private String direccion;



    public ControlTeclas() {

    }

    @Override

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(direccion != "D") {
                    direccion = "I";
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(direccion != "I") {
                    direccion = "D";
                }
                break;
            case KeyEvent.VK_UP:
                if(direccion != "AB") {
                    direccion = "AR";
                }
                break;
            case KeyEvent.VK_DOWN:
                if(direccion != "AR") {
                    direccion = "AB";
                }
                break;
        }
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
