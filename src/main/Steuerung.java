package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Steuerung implements KeyListener{

    //Eingabe variablen
    public boolean oben, unten, links, rechts;
    private boolean angriff; // Flag für Angriff
    public void keyTyped(KeyEvent e) {
    }

    //Tasten gedrückt event
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            oben = true;
        }
        if(code == KeyEvent.VK_DOWN){
            unten = true;
        }
        if(code == KeyEvent.VK_LEFT){
            links = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            rechts = true;
        }
        if (code == KeyEvent.VK_SPACE) {
            angriff = true;
        }

    }

    //testen logelassen event
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            oben = false;
        }
        if(code == KeyEvent.VK_DOWN){
            unten = false;
        }
        if(code == KeyEvent.VK_LEFT){
            links = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            rechts = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            angriff = false;
        }
    }


    // Getter für das Attribut "angriff"
    public boolean isAngriff() {
        return angriff;
    }

}
