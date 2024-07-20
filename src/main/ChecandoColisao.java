package main;

import Telas.Tela;
import entity.Entity;

public class ChecandoColisao {
    Tela tj;
    public ChecandoColisao(Tela tj){
        this.tj =tj;
    }
    public void checarTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorlY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/ tj.tileSize;
        int entityRightCol = entityRightWorldX/ tj.tileSize;
        int entityTopRow = entityTopWorldY/ tj.tileSize;
        int entityBottomRow = entityBottomWorlY/ tj.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = tj.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(tj.tileM.tile[tileNum1].collision == true || tj.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorlY + entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = tj.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(tj.tileM.tile[tileNum1].collision == true || tj.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = tj.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(tj.tileM.tile[tileNum1].collision == true || tj.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = tj.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(tj.tileM.tile[tileNum1].collision == true || tj.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }


    }
}
