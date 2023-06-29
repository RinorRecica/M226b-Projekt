package main;

import character.PlayerHealth;
import map.MapManager;
import player.Player;
import weapons.Weapon;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GamePanel extends JPanel implements Runnable {

    private long startTime;
    private long elapsedTime;

    //CollisionChecker
	MapManager mapM = new MapManager();

    // SCREEN EINSTELLUNGEN
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

    PlayerHealth playerHealth; // Spielerlebenspunkte
    Weapon playerWeapon; // Spielerwafe

    private Image playerImage; // Bild des Spielers
    private Image weaponImage; // Bild der Waffe des Spielers
    private Image swingImage; // Bild des Schwunges der Waffe

    private boolean isAttacking; // Flag, ob der Spieler angreift

    private int playerImageWidth = 40; // Breite des Spielerbildes
    private int playerImageHeight = 40; // Höhe des Spielerbildes

    private Player player; // Spieler

    private int infoBoxX = (screenWidth - 200) / 2; // X-Position der Info-Box (horizontal in der Mitte ausgerichtet)
    private int infoBoxY = 10; // Y-Position der Info-Box

    private Map<String, Image> weaponImages; // Bilder der Waffen

    private int swordOffsetX = 0; // Horizontale Verschiebung des Schwertes

    //Start Timer


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); // KeyListener zum Panel hinzufügen
        this.setFocusable(true);

        playerHealth = new PlayerHealth();
        playerWeapon = new Weapon("Holzschwert", 10, 1); // Beginnt mit Holzschwert
        player = new Player(playerWeapon, playerHealth);
        ImageIcon playerIcon = new ImageIcon("images/player/playerfront.png");
        Image originalPlayerImage = playerIcon.getImage();
        playerImage = originalPlayerImage.getScaledInstance(playerImageWidth, playerImageHeight, Image.SCALE_SMOOTH);

        // Lade und skalieren Sie die Waffenbilder
        weaponImages = new HashMap<>();
        String[] weaponNames = {"holzschwert", "knochenschwert",
                "steinschwert", "bronzeschwert", "eisenschwert",
                "stahlschwert", "titanschwert", "obsidianschwert",
                "diamantschwert", "vibraniumschwert"};

        for (String weaponName : weaponNames) {
            String imagePath = "images/weapons/" + weaponName + ".png";
            ImageIcon weaponIcon = new ImageIcon(imagePath);
            Image originalWeaponImage = weaponIcon.getImage();
            Image scaledWeaponImage = originalWeaponImage.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
            weaponImages.put(weaponName.toLowerCase(), scaledWeaponImage);
        }

        // Lade das Schwungbild der Waffe
        String swingImagePath = "images/weapons/holzschwert-swing.png";
        ImageIcon swingIcon = new ImageIcon(swingImagePath);
        Image originalSwingImage = swingIcon.getImage();
        swingImage = originalSwingImage.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);

        Timer attackTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.isAttacking()) {
                    // Aktualisiere die Position des Schwertes
                    swordOffsetX += 5;
                    if (swordOffsetX > 10) {
                        swordOffsetX = -10; // Zurück zur Startposition
                    }
                    repaint();
                }
            }
        });

        attackTimer.start();

    }

    public void startGameThread() {
        startTime = System.currentTimeMillis(); // Timer starten
        gameThread = new Thread(this);
        gameThread.start(); // Spiel-Thread starten
    }


        public void run () {
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

        // Update die elapsed time
        elapsedTime = (System.currentTimeMillis() - startTime) / 1000;

        if (keyH.oben) {
            playerY -= playerSpeed; // Spieler nach oben bewegen
        } else if (keyH.unten) {
            playerY += playerSpeed; // Spieler nach unten bewegen
        } else if (keyH.links) {
            playerX -= playerSpeed; // Spieler nach links bewegen
        } else if (keyH.rechts) {
            playerX += playerSpeed; // Spieler nach rechts bewegen
        }

        // Überprüfe, ob der Spieler einen Gegner getötet hat und aktualisiere die Waffe entsprechend
        if (playerKilledEnemy()) {
            playerWeapon.upgrade();
        }
        // Überprüfe, ob die Angriffstaste gedrückt wurde und setze das Waffenbild entsprechend
        if (keyH.isAngriff()) {
            player.attack();
        } else {
            player.stopAttack();
        }
    }

    // Diese Methode sollte überprüfen, ob der Spieler einen Gegner getötet hat
    // In diesem Beispiel wird sie immer "false" zurückgeben, da wir keine spezifischen Details haben, wie Gegner im Spiel getötet werden
    private boolean playerKilledEnemy() {
        // Implementieren Sie hier die Logik zum Überprüfen, ob der Spieler einen Gegner getötet hat
        return false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize); // Spieler zeichnen

        // Zeichne die Lebensanzeige
        playerHealth.drawHealthBar(g2);

        // Zeichnen des Spielers
        g.drawImage(playerImage, playerX, playerY, null);


        // Zeichnen des Bildes der Waffe des Spielers
        Image weaponImage = weaponImages.get(playerWeapon.getName().toLowerCase());
        if (weaponImage != null) {
            int weaponX = playerX + playerImageWidth - 27;
            int weaponY = playerY + (playerImageHeight - tileSize + 8) / 2;
            if (!player.isAttacking()) {
                g.drawImage(weaponImage, weaponX, weaponY, null);
            } else {
                if (swingImage != null) {
                    g.drawImage(swingImage, weaponX + swordOffsetX, weaponY, null);
                }
            }
        }


        // Hintergrund der Infobox zeichnen
        //g2.setColor(Color.black);
        //g2.fillRect(infoBoxX, infoBoxY, 200, 80);

        // Text in der Infobox zeichnen
        g2.setColor(Color.white);
        g2.drawString("Waffe: " + playerWeapon.getName(), infoBoxX + 10, infoBoxY + 20);
        g2.drawString("Reichweite: " + playerWeapon.getRange(), infoBoxX + 10, infoBoxY + 35);
        g2.drawString("Stärke: " + playerWeapon.getDamagePoints(), infoBoxX + 10, infoBoxY + 50);


        //<------------Timer Design---------->
        // Schriftgröße und Schriftart ändern
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5F); // Vergrößern Sie die Schriftgröße
        g.setFont(newFont);
        //Zeichne den Hintergrund für den Timer oben rechts
        g.setColor(Color.BLACK); // Wähle eine Farbe für den Hintergrund
        String zeitString = "Survival-timer: " + elapsedTime + "  Seconds";
        int stringBreite = g.getFontMetrics().stringWidth(zeitString);
        g.fillRect(screenWidth - stringBreite - 25, 15, stringBreite + 10, 30);
        // Zeichne den Timer oben rechts im Bildschirm
        g.setColor(Color.WHITE); // Stellen Sie sicher, dass die Farbe gut sichtbar ist
        g.drawString(zeitString, screenWidth - stringBreite - 20, 35);

        g2.dispose();
    }
}
