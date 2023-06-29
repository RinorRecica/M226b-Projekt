package props;

import character.PlayerHealth;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.imageio.ImageIO;

public class Apples {
    private List<Rectangle> goodApplePositions;
    private List<Rectangle> badApplePositions;
    private BufferedImage goodAppleImage;
    private BufferedImage badAppleImage;
    private Random random;

    public Apples() {
        goodApplePositions = new ArrayList<>();
        badApplePositions = new ArrayList<>();
        random = new Random();

        try {
            goodAppleImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("images/apple_gut.png")));
            badAppleImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("images/apple_schlecht.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateGoodApple(int mapWidth, int mapHeight) {
        int x = random.nextInt(mapWidth - goodAppleImage.getWidth());
        int y = random.nextInt(mapHeight - goodAppleImage.getHeight());

        Rectangle goodApplePosition = new Rectangle(x, y, goodAppleImage.getWidth(), goodAppleImage.getHeight());
        goodApplePositions.add(goodApplePosition);
    }

    public void generateBadApple(int mapWidth, int mapHeight) {
        int x = random.nextInt(mapWidth - badAppleImage.getWidth());
        int y = random.nextInt(mapHeight - badAppleImage.getHeight());

        Rectangle badApplePosition = new Rectangle(x, y, badAppleImage.getWidth(), badAppleImage.getHeight());
        badApplePositions.add(badApplePosition);
    }

    public void checkCollision(PlayerHealth playerHealth) {
        for (Rectangle goodApplePosition : goodApplePositions) {
            if (playerHealth.collidesWith(goodApplePosition)) {
                playerHealth.addHealthPoints(1);
                goodApplePositions.remove(goodApplePosition);
                break; // Nur eine gute Apfelkollision pro Durchlauf
            }
        }

        for (Rectangle badApplePosition : badApplePositions) {
            if (playerHealth.collidesWith(badApplePosition)) {
                playerHealth.subtractHealthPoints(1);
                badApplePositions.remove(badApplePosition);
                break; // Nur eine schlechte Apfelkollision pro Durchlauf
            }
        }
    }

    public void drawApples(Graphics2D g2) {
        for (Rectangle goodApplePosition : goodApplePositions) {
            g2.drawImage(goodAppleImage, goodApplePosition.x, goodApplePosition.y, null);
        }

        for (Rectangle badApplePosition : badApplePositions) {
            g2.drawImage(badAppleImage, badApplePosition.x, badApplePosition.y, null);
        }
    }
}

