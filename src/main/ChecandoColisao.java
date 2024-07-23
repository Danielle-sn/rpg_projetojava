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
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;


        int entityLeftCol = entityLeftWorldX/ tj.tileSize;
        int entityRightCol = entityRightWorldX/ tj.tileSize;
        int entityTopRow = entityTopWorldY/ tj.tileSize;
        int entityBottomRow = entityBottomWorldY/ tj.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = tj.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(tj.tileM.tile[tileNum1].collision || tj.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = tj.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(tj.tileM.tile[tileNum1].collision || tj.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = tj.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(tj.tileM.tile[tileNum1].collision || tj.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/tj.tileSize;
                tileNum1 = tj.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = tj.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(tj.tileM.tile[tileNum1].collision || tj.tileM.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
        }

    }
    public int checarItem(Entity entity, boolean jogador) {
        int index = 999;

        for (int i = 0; i < tj.itens.length; i++) {
            if (tj.itens[i] != null) {
                // pegar entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                // pegar object solid area position
                tj.itens[i].solidArea.x = tj.itens[i].worldX + tj.itens[i].solidArea.x;
                tj.itens[i].solidArea.y = tj.itens[i].worldY + tj.itens[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                }
                if (entity.solidArea.intersects(tj.itens[i].solidArea)) {
                    entity.collisionOn = true;
                    if (jogador) {
                        index = i;
                    }
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                tj.itens[i].solidArea.x = tj.itens[i].solidAreaDefaultX;
                tj.itens[i].solidArea.y = tj.itens[i].solidAreasDefaultY;
            }
        }
        return index;
        //checar se o jogador está tocando em algum item, se estiver vai retornar o index
    }
    public int checarEntity(Entity entity, Entity[] alvo){
        int index = 999;

        for (int i = 0; i < alvo.length; i++) {
            if (alvo[i] != null) {
                // pegar entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                // pegar object solid area position
                alvo[i].solidArea.x = alvo[i].worldX + alvo[i].solidArea.x;
                alvo[i].solidArea.y = alvo[i].worldY + alvo[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                break;
                case "down":
                    entity.solidArea.y += entity.speed;
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;
                    break;
                case "right":
                    entity.solidArea.x += entity.speed;

                    break;
            }
            if (entity.solidArea.intersects(alvo[i].solidArea)) {
                if (alvo[i] != entity) {
                    entity.collisionOn = true;
                    index = i;
                }

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                alvo[i].solidArea.x = alvo[i].solidAreaDefaultX;
                alvo[i].solidArea.y = alvo[i].solidAreaDefaultY;
            }
        }
        return index;


    }
    public void checarJogador(Entity entity) {
        int index = 999;
        // pegar entity solid area position
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;
        // pegar object solid area position
        tj.guerreiro.solidArea.x = tj.guerreiro.worldX + tj.guerreiro.solidArea.x;
        tj.guerreiro.solidArea.y = tj.guerreiro.worldY + tj.guerreiro.solidArea.y;

        switch (entity.direction) {
            case "up":
                entity.solidArea.y -= entity.speed;
                if (entity.solidArea.intersects(tj.guerreiro.solidArea)) {//metodo do Rectangle intersects: checa se os dois retangulos estão colidindo
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.solidArea.y += entity.speed;
                if (entity.solidArea.intersects(tj.guerreiro.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                if (entity.solidArea.intersects(tj.guerreiro.solidArea)) {
                    entity.collisionOn = true;
                    System.out.println("colisão left");
                }
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(tj.guerreiro.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        tj.guerreiro.solidArea.x = tj.guerreiro.solidAreaDefaultX;
        tj.guerreiro.solidArea.y = tj.guerreiro.solidAreaDefaultY;




    }
}
