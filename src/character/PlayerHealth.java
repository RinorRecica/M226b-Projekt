package character;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class PlayerHealth {
    private int healthPoints; // Lebenspunkte

    private ImageIcon vollesHerzImage;
    private ImageIcon halbesHerzImage;
    private ImageIcon leeresHerzImage;

    private int x; // X-Position des Rechtecks
    private int y; // Y-Position des Rechtecks
    private int width; // Breite des Rechtecks
    private int height; // Höhe des Rechtecks

    public boolean collidesWith(Rectangle other) {
        return getBounds().intersects(other);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public PlayerHealth() {
        healthPoints = 6; // Startwert für die Lebenspunkte (3 Herzen, wenn man getroffen wird halbes Herz Abzug)
        vollesHerzImage = new ImageIcon("images/heart/heart_voll.png");
        halbesHerzImage = new ImageIcon("images/heart/heart_halb.png");
        leeresHerzImage = new ImageIcon("images/heart/heart_leer.png");

    }
    //healthPoints ist die aktuelle Lebensanzeige
    public int getHealthPoints() {
        return healthPoints;
    }

    public void addHealthPoints(int points) {
        healthPoints += points;
        if (healthPoints > 6) {
            healthPoints = 6; // Maximalwert für Lebenspunkte begrenzen
        }
    }

    public void subtractHealthPoints(int points) {
        healthPoints -= points;
        if (healthPoints < 0) {
            healthPoints = 0; // Minimalwert für Lebenspunkte begrenzen
        }
    }

    
 //----------------------------------- DESIGN & POSITIONIERUNG DER HERZEN ----------------------------------------------//
    
    public void drawHealthBar(Graphics2D g2) {
        int x = 10; // X-Position der Herzen
        int y = 10; // Y-Position der Herzen

        for (int i = 0; i < 3; i++) {
            if (healthPoints >= (i + 1) * 2) {
                drawFullHeart(g2, x, y);
            } else if (healthPoints >= (i * 2 + 1)) {
                drawHalfHeart(g2, x, y);
            } else {
                drawEmptyHeart(g2, x, y);
            }
            x += 45; // Abstand zwischen den Herzen
        }
    }

    private void drawEmptyHeart(Graphics2D g2, int x, int y) {
        int heartWidth = 40; // Breite des Herz-Images
        int heartHeight = 40; // Höhe des Herz-Images
        g2.drawImage(leeresHerzImage.getImage(), x, y, heartWidth, heartHeight, null);
    }

    private void drawFullHeart(Graphics2D g2, int x, int y) {
        int heartWidth = 40; // Breite des Herz-Images
        int heartHeight = 40; // Höhe des Herz-Images
        g2.drawImage(vollesHerzImage.getImage(), x, y, heartWidth, heartHeight, null);
    }

    private void drawHalfHeart(Graphics2D g2, int x, int y) {
        int heartWidth = 40; // Breite des Herz-Images
        int heartHeight = 40; // Höhe des Herz-Images
        g2.drawImage(halbesHerzImage.getImage(), x, y, heartWidth, heartHeight, null);
    }

}
