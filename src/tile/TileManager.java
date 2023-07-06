package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

      GamePanel gp;
      Tile[] tile;

      public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[30];

        getTileImage();
      }

      //Bilder einfügen in Arrays
      public void getTileImage() {
          try{
            //Grass/Ufer
              tile[0] = new Tile();
              tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river06.png"));

              tile[1] = new Tile();
              tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river08.png"));

              tile[2] = new Tile();
              tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river10.png"));

              tile[3] = new Tile();
              tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river05.png"));

              tile[4] = new Tile();
              tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/grass.gif"));

              tile[5] = new Tile();
              tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river11.png"));

              tile[6] = new Tile();
              tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river04.png"));

              tile[7] = new Tile();
              tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river12.png"));

              tile[8] = new Tile();
              tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/river02.png"));

              //Sand
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/sand.gif"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/gs2.gif"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/gs4.gif"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/gs6.gif"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tile/tiles/gs8.gif"));

          }catch (IOException e){
            e.printStackTrace();
          }
      }
      public void draw(Graphics2D g2){
        //1. Reihe
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 96, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 144, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 192, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 240, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 288, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 336, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 384, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 432, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 480, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 528, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 576, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 624, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 672, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 720, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 768, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 816, 0, gp.tileSize, gp.tileSize, null);

        //2. Reihe
        g2.drawImage(tile[3].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 48, gp.tileSize, gp.tileSize, null);

        //3. Reihe
        g2.drawImage(tile[3].image, 0, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[11].image, 144, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[11].image, 192, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 96, gp.tileSize, gp.tileSize, null);

        //4. Reihe
        g2.drawImage(tile[3].image, 0, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[10].image, 96, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[9].image, 144, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[9].image, 192, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[12].image, 240, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 144, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 144, gp.tileSize, gp.tileSize, null);

        //5. Reihe
        g2.drawImage(tile[3].image, 0, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[13].image, 144, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[13].image, 192, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 192, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 192, gp.tileSize, gp.tileSize, null);

        //6. Reihe
        g2.drawImage(tile[3].image, 0, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 240, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 240, gp.tileSize, gp.tileSize, null);

        //7. Reihe
        g2.drawImage(tile[3].image, 0, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 288, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 288, gp.tileSize, gp.tileSize, null);

        //8. Reihe
        g2.drawImage(tile[3].image, 0, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 336, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 336, gp.tileSize, gp.tileSize, null);

        //9. Reihe
        g2.drawImage(tile[3].image, 0, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 384, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 384, gp.tileSize, gp.tileSize, null);

        //10. Reihe
        g2.drawImage(tile[3].image, 0, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 432, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 432, gp.tileSize, gp.tileSize, null);

        //11. Reihe
        g2.drawImage(tile[3].image, 0, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 480, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 480, gp.tileSize, gp.tileSize, null);

        //12. Reihe
        g2.drawImage(tile[3].image, 0, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 528, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 528, gp.tileSize, gp.tileSize, null);


        //13. Reihe
        g2.drawImage(tile[3].image, 0, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 48, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 96, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 144, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 192, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 240, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 288, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 336, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 384, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 432, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 480, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 528, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 576, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 624, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 672, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 720, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[4].image, 768, 576, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[5].image, 816, 576, gp.tileSize, gp.tileSize, null);

        //14. Reihe
        g2.drawImage(tile[6].image, 0, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 48, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 96, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 144, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 192, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 240, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 288, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 336, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 384, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 432, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 480, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 528, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 576, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 624, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 672, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 720, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[8].image, 768, 624, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[7].image, 816, 624, gp.tileSize, gp.tileSize, null);


      }
}
