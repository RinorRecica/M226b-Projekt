package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import character.PlayerHealth;
import tile.tilesManager;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{

    //SCREEN EINSTELLUNGEN
    final int originalTileSize = 16; //16*16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48*48 Tile
    public final int maxScreenCol = 16; //columns 16x
    public final int maxScreenRow = 12; //Row 12x
    public final int screenWidth = tileSize * maxScreenCol; // 768 Pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixel

    //World SEttings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;



    // FPS
    int FPS = 60;

    tilesManager tileM = new tilesManager(this);
    Steuerung keyH = new Steuerung();
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);


    public Player player = new Player(this, keyH);

    //Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

  PlayerHealth playerHealth; // Spielerlebenspunkte

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        playerHealth = new PlayerHealth();
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }



    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;

            }

            if(timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }



    public void update() {

        player.update();

    }
    //Charakter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);
        playerHealth.drawHealthBar(g2); // Zeichne die Lebensanzeige

        g2.dispose();
    }
}
