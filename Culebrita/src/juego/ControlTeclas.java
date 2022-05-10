package juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControlTeclas extends KeyAdapter {
    private int tecla;



    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                tecla = KeyEvent.VK_SPACE;
                break;
            case KeyEvent.VK_UP:
                if(tecla != KeyEvent.VK_DOWN){
                    tecla = KeyEvent.VK_UP;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(tecla != KeyEvent.VK_UP){
                    tecla = KeyEvent.VK_DOWN;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(tecla != KeyEvent.VK_RIGHT){
                    tecla = KeyEvent.VK_LEFT;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(tecla != KeyEvent.VK_LEFT){
                    tecla = KeyEvent.VK_RIGHT;
                }
                break;
        }
    }

    public int getTecla() {
        return tecla;
    }

}
