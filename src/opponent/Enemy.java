package opponent;

import entity.Entity;
import entity.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Objects;
import java.util.Random;

public class Enemy extends Entity {
    private static final String[] DIRECTIONS = {"up", "down", "left", "right"};
    private static final int IMAGE_COUNT = 2;
    private static final int SPEED = 2;


    private String currentDirection;

    public Enemy(int startX, int startY) {
        worldX = startX;
        worldY = startY;
        speed = SPEED;

        loadImages();
        initialize();
    }


    private void loadImages() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("opp_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        Random random = new Random();
        currentDirection = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
    }

    public void move(Player player) {
        int playerX = player.worldX;
        int playerY = player.worldY;

        int dx = playerX - worldX; // Differenz zwischen Spieler-X und Gegner-X
        int dy = playerY - worldY; // Differenz zwischen Spieler-Y und Gegner-Y

        if (dx != 0 || dy != 0) {
            double angle = Math.atan2(dy, dx); // Winkel zwischen Gegner und Spieler berechnen
            double vx = speed * Math.cos(angle); // X-Komponente der Geschwindigkeit berechnen
            double vy = speed * Math.sin(angle); // Y-Komponente der Geschwindigkeit berechnen

            worldX += (int) vx; // Gegner in X-Richtung bewegen
            worldY += (int) vy; // Gegner in Y-Richtung bewegen
        }
    }


    public void draw(Graphics2D g) {
        BufferedImage image = null;

        switch (currentDirection) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g.drawImage(image, worldX, worldY, null);
    }
}

