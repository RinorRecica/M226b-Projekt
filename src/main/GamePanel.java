package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

import character.PlayerHealth;
import tile.tilesManager;
import opponent.Enemy;
import tile.TilesManager;

import entity.Player;
import main.CollisionChecker;
import tile.Tile;

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

    TilesManager tileM = new TilesManager(this);
    Steuerung keyH = new Steuerung();
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);


    public Player player = new Player(this, keyH);

    //Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    private List<Enemy> enemies; // Liste der Gegner

  PlayerHealth playerHealth; // Spielerlebenspunkte

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        playerHealth = new PlayerHealth();

        enemies = new ArrayList<>(); // Initialisiere die Liste der Gegner

        Timer enemySpawnTimer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnEnemies(5); // Alle 10 Sekunden 5 Gegner spawnen
            }
        });

        enemySpawnTimer.start();
    }

    private void spawnEnemies(int count) {
        Random random = new Random();
        int maxSpawnX = maxWorldCol - 2; // Maximale X-Koordinate für das Spawnen der Gegner
        int maxSpawnY = maxWorldRow - 2; // Maximale Y-Koordinate für das Spawnen der Gegner

        for (int i = 0; i < count; i++) {
            int spawnX = random.nextInt(maxSpawnX) + 1; // Zufällige X-Koordinate innerhalb des Spielfelds (ohne Ränder)
            int spawnY = random.nextInt(maxSpawnY) + 1; // Zufällige Y-Koordinate innerhalb des Spielfelds (ohne Ränder)

            Enemy enemy = new Enemy(spawnX * tileSize, spawnY * tileSize); // Multipliziere mit tileSize, um die Pixelkoordinaten zu erhalten
            enemies.add(enemy);
        }
    }



    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        spawnEnemies(5); // Gegner beim Start initialisieren
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


        for (Enemy enemy : enemies) {
            enemy.move(player);
        }


    }
    //Charakter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);


        List<Enemy> enemiesToDraw = new ArrayList<>(enemies); // Kopie der enemies-Liste erstellen

        for (Enemy enemy : enemiesToDraw) {
            enemy.draw(g2);
        }

        g2.dispose();
    }
}
