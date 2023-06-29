package main;

import java.awt.*;
import java.awt.event.*;

public class SpielerPosition {

    private int x, y; // Spielerposition

    public SpielerPosition() {
        x = 0;
        y = 0;
    }

    public void aktualisierePosition(KeyEvent e, MouseEvent me) {
        if (e != null) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT) {
                x--;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                x++;
            } else if (keyCode == KeyEvent.VK_UP) {
                y--;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                y++;
            }
        }

        if (me != null) {
            int mouseX = me.getX();
            int mouseY = me.getY();

            x = mouseX;
            y = mouseY;
        }
    }

    public void fuehreAngriffAus(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_A) {
            System.out.println("Angriff nach links");
            // Füge hier den Code für den Angriff nach links hinzu
        } else if (keyCode == KeyEvent.VK_D) {
            System.out.println("Angriff nach rechts");
            // Füge hier den Code für den Angriff nach rechts hinzu
        } else if (keyCode == KeyEvent.VK_W) {
            System.out.println("Angriff nach oben");
            // Füge hier den Code für den Angriff nach oben hinzu
        } else if (keyCode == KeyEvent.VK_S) {
            System.out.println("Angriff nach unten");
            // Füge hier den Code für den Angriff nach unten hinzu
        }
    }

    public static void main(String[] args) {
        SpielerPosition spieler = new SpielerPosition();

        // Beispielcode für die Verwendung
        Frame frame = new Frame();
        frame.setSize(400, 400);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                spieler.aktualisierePosition(e, null);
                System.out.println("Spielerposition: (" + spieler.x + ", " + spieler.y + ")");
                spieler.fuehreAngriffAus(e);
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                spieler.aktualisierePosition(null, me);
                System.out.println("Spielerposition: (" + spieler.x + ", " + spieler.y + ")");
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}



