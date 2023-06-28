package main;


import entity.Entity;

public class CollisionChecker {

    GamePanel gp; // Referenz auf das GamePanel

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;

    }
    int tileNum1, tileNum2; // Variablen zur Speicherung der Kachelnummern
    public void checkTile(Entity entity) {
        // Überprüft die Kollision zwischen einer Entität und den Kacheln

        int entityLeftx = entity.x + entity.solidArea.x;
        int entityRightx = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopy = entity.y + entity.solidArea.y;
        int entityBottomy = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftx/gp.tileSize;
        int entityRightCol = entityRightx/gp.tileSize;
        int entityTopRow = entityTopy/gp.tileSize;
        int entityBottomRow = entityBottomy/gp.tileSize;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopy - entity.speed) / gp.tileSize;
                tileNum1 = gp.mapM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.mapM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.mapM.tile[tileNum1].collision || gp.mapM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomy + entity.speed) / gp.tileSize;
                tileNum1 = gp.mapM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.mapM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.mapM.tile[tileNum1].collision || gp.mapM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftx - entity.speed) / gp.tileSize;
                tileNum1 = gp.mapM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.mapM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.mapM.tile[tileNum1].collision || gp.mapM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightx + entity.speed) / gp.tileSize;
                tileNum1 = gp.mapM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.mapM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.mapM.tile[tileNum1].collision || gp.mapM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }
}
