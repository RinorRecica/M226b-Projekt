
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
//ScreenHHHHH
public class GamePanel extends JPanel implements Runnable{

    //SCREEN EINSTELLUNGEN
    final int originalTileSize = 16; // Ursprüngliche Kachelgröße
    final int scale = 3; // Skalierungsfaktor für die Kachelgröße
    final int tileSize = originalTileSize * scale; // Skalierte Kachelgröße
    final int maxScreenCol = 16; // Maximale Anzahl an Kacheln in einer Spalte
    final int maxScreenRow = 12; // Maximale Anzahl an Kacheln in einer Zeile
    final int screenWidth = tileSize * maxScreenCol; // Breite des Bildschirms in Pixeln
    final int screenHeight = tileSize * maxScreenRow; // Höhe des Bildschirms in Pixeln

    Steuerung keyH = new Steuerung(); // KeyHandler-Objekt zur Tastatureingabe
    Thread gameThread; // Thread für das Spiel-Update und das Zeichnen

    int playerX = 400; // X-Position des Spielers
    int playerY = 400; // Y-Position des Spielers
    int playerSpeed = 5; // Geschwindigkeit des Spielers

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); // KeyListener zum Panel hinzufügen
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // Spiel-Thread starten
    }

    public void run() {
        while (gameThread != null) {
            update(); // Spiel-Update durchführen
            repaint(); // Panel neu zeichnen
            try {
                Thread.sleep(16); // ~60 FPS (ca. 16 Millisekunden Verzögerung pro Frame)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (keyH.oben) {
            playerY -= playerSpeed; // Spieler nach oben bewegen
        } else if (keyH.unten) {
            playerY += playerSpeed; // Spieler nach unten bewegen
        } else if (keyH.links) {
            playerX -= playerSpeed; // Spieler nach links bewegen
        } else if (keyH.rechts) {
            playerX += playerSpeed; // Spieler nach rechts bewegen
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize); // Spieler zeichnen
        g2.dispose();
    }

}
