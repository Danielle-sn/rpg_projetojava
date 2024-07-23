package entity;

import main.KeyHandler;
import Telas.Tela;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Jogador extends Entity {
    public final int screenX;
    public final int screenY;

    public Jogador(String nome, int forca, int agilidade, int dexterity, int ataque, int nivel, int saude, int exp, int nextLevelExp, int currentWeapon, Tela tj, KeyHandler keyH) {
        super(nome, forca, agilidade, dexterity, ataque, nivel, saude, exp, nextLevelExp, currentWeapon, tj, keyH);

        screenX = tj.screenWidth / 2 - (tj.tileSize / 2);
        screenY = tj.screenHeight / 2 - (tj.tileSize / 2);
    }


    public void setDefaultValues(){
        worldX = tj.tileSize * 23;
        worldY = tj.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void update(){

        // esse método está  dentro do loop então é chamado 60 vezes por segundo
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){

            if(keyH.upPressed) {
                direction  = "up";
            }
            else if (keyH.downPressed) {
                direction  = "down";
            }

            else if (keyH.leftPressed){
                direction  = "left";
            }
            else {
                direction  = "right";
            }
            //checando a colisao do tile
            collisionOn = false;
            tj.checandoColisao.checarTile(this);

            // checando a colisão com os objetos
            int itemIndex = tj.checandoColisao.checarItem(this,true);
            pegarItem(itemIndex);

            //checando colisão com o npc
            int npcIndex = tj.checandoColisao.checarEntity(this,tj.npc);
            interacaoNpc(npcIndex);

            //checando colisão com o inimigo
            int esqueletoIndex = tj.checandoColisao.checarEntity(this,tj.esqueleto);
            contatoEsqueleto(esqueletoIndex);

            // se colisão é falsa, jogador pode se mover
            if(collisionOn == false){
                switch(direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }
    }
    public void pegarItem(int i){
        if (i != 999){
//           String itemName = tj.itens[i].name;
//
//           switch (itemName){
//               case "Chave":
//                   chaveColetada++;
//                   tj.itens[i] = null; // faz a chave desaparecer do mapa
//                   tj.iu.mostrarMensagem("Você pegou uma chave!");
//                   break;
//               case "Cristal Mágico":
//                   cristalColetado++;
//                   tj.itens[i] = null; // faz a chave desaparecer do mapa
//                   tj.iu.mostrarMensagem("Você pegou um cristal!");
//                   break;
//               case "Porta":
//                   if(chaveColetada > 0){
//                       tj.itens[i] = null;
//                       chaveColetada--;
//                       tj.iu.mostrarMensagem("Parabéns, você abriu a porta");
//                   }else{
//                       tj.iu.mostrarMensagem("Colete a chave para abrir a porta");
//                   }
//                   System.out.println("Chave"+ chaveColetada);
//                   break;
//               case "Baú":
//                   tj.iu.finalJogo = true;
//                   break;
//
//           }
        }
    }
    public void interacaoNpc(int i){
        if(i != 999){
            System.out.println("tocando o npc");

        }
    }
    public void contatoEsqueleto(int i){
        if(i != 999){
            //life -= 1;
        }
    }


    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, tj.tileSize, tj.tileSize);
        BufferedImage image = null;

        switch(direction){
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2 ){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;

        }
        g2.drawImage(image, screenX, screenY, null);

    }


}
