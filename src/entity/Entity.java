package entity;

import main.GamePanel;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

    public int solidAreaDefaultX, solidAreaDefaultY;

    public int worldX, worldY;
    public int speed;


    public BufferedImage up1, down1, left1, right1, up2, down2, left2, right2, schwertl;
    public String direction;


    public int spriteCounter = 0;
    public int spriteNum = 1;

    //durchsichtige hitbox
    public Rectangle solidArea;
    public boolean collisionOn = false;



}
