package entity;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Steuerung;

public class Player extends Entity{

	GamePanel gp;
	Steuerung keyH;

	public final int screenX;
	public final int screenY;

	public Player(GamePanel gp, Steuerung keyH) {

		this.gp = gp;
		this.keyH = keyH;

		screenX = gp.screenWidth/2 - (gp.tileSize / 2);
		screenY = gp.screenHeight/2 - (gp.tileSize / 2);

		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {

		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";

	}

	public void getPlayerImage() {

		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			schwertl = ImageIO.read(getClass().getResourceAsStream("/player/holzschwert.png"));



		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	//update funktion was passiert wenn (?funktion?) taste gedrückt isz
	public void update() {

		if(keyH.oben == true || keyH.unten == true ||
				keyH.links == true || keyH.rechts == true) {


			if(keyH.oben == true) {
				direction = "up";
			}
			else if(keyH.unten == true) {
				direction = "down";

			}
			else if(keyH.links == true) {
				direction = "left";

			}
			else if(keyH.rechts == true) {
				direction = "right";

			}

			//Check TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);

			//IF collision is FALSE, PLAYER can move
			if(collisionOn == false) {
				switch(direction) {
					case"up": worldY -= speed;break;
					case"down": worldY+= speed;break;
					case"left": worldX -= speed;break;
					case"right": worldX += speed;break;
				}
			}



			//dadurch dass wir update 60mal pro sekunde aufrufen-
			//jede pro frame countet++ spriteCounter! dadurch dass das so schnell geschieht müüsen wir das-
			//-runterbrechen auf alle 11 frames. alles down bellow.
			//dadurch das diess non stop geschah mussten wir funktion UPDATE if elsen. so dass nuuuur wenn keyH(up, down. left, right)Tastegedrückt-
			// erst dann soll es counten und Update updaten!

			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		BufferedImage schwertImage = schwertl; // Schwertbild

		switch(direction) {
			case "up":
				if(spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
				break;
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
				break;
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image = right2;
				}
				break;
		}
		// Erst das Bild des Spielers zeichnen
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		// Dann das Schwertbild zeichnen, man muss die Koordinaten eventuell anpassen.
		g2.drawImage(schwertImage, screenX, screenY, gp.tileSize, gp.tileSize, null);

	}}










