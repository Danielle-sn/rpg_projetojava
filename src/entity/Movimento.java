package entity;

import Telas.Tela;
import main.KeyHandler;

public class Movimento {
    private Tela tj;
    private KeyHandler keyH;
    private Entity entity;

    int chaveColetada = 0;

    public Movimento(Tela tj, KeyHandler keyH, Entity entity) {
        this.tj = tj;
        this.keyH = keyH;
        this.entity = entity;
    }

    public void setDefaultValues() {
        entity.worldX = tj.tileSize * 23;
        entity.worldY = tj.tileSize * 21;
        entity.speed = 4;
        entity.direction = "down";
    }

    public void update(){
       // System.out.println("Atualizando movimento...");
        if (tj == null) {
            System.out.println("Tela não foi inicializada.");
            return;
        }
        // esse método está  dentro do loop então é chamado 60 vezes por segundo
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){

            if(keyH.upPressed) {
                entity.direction  = "up";
            }
            else if (keyH.downPressed) {
                entity.direction  = "down";
            }

            else if (keyH.leftPressed){
                entity.direction  = "left";
            }
            else {
                entity.direction  = "right";
            }
            //checando a colisao do tile
            entity.collisionOn = false;
            tj.checandoColisao.checarTile(tj.guerreiro);

            // checando a colisão com os objetos
            int itemIndex = tj.checandoColisao.checarItem(tj.guerreiro,true);
            pegarItem(itemIndex);


            // se colisão é falsa, jogador pode se mover
            if( entity.collisionOn == false){
                switch(entity.direction){
                    case "up":
                        entity.worldY -=  entity.speed;
                        break;
                    case "down":
                        entity.worldY +=  entity.speed;
                        break;
                    case "left":
                        entity.worldX -=  entity.speed;
                        break;
                    case "right":
                        entity.worldX +=  entity.speed;
                        break;
                }
            }

            entity.spriteCounter++;
            if ( entity.spriteCounter > 12){
                if( entity.spriteNum == 1){
                    entity.spriteNum = 2;
                }
                else if( entity.spriteNum == 2){
                    entity.spriteNum = 1;
                }
                entity.spriteCounter = 0;
            }

        }
    }

    public void pegarItem(int i){
        if (i != 999){
            String itemName = tj.itens[i].name;

            switch (itemName){
                case "Chave":
                    chaveColetada++;
                    tj.itens[i] = null; // faz a chave desaparecer do mapa
                    System.out.println("Chave"+ chaveColetada);
                    break;
                case "Porta":
                    if(chaveColetada > 0){
                        tj.itens[i] = null;
                        chaveColetada--;
                    }
                    System.out.println("Chave"+ chaveColetada);
                    break;

            }
        }
    }

}

