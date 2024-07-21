package entity;

import Telas.Tela;
import main.KeyHandler;
import main.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Guerreiro extends Personagem{

    public final int screenX;
    public final int screenY;

    public int chaveColetada = 0;

    public Guerreiro(String nome, int saude, int nivel, int ataque, Tela tj, KeyHandler keyH){
        super(nome,saude,nivel, ataque, tj, keyH);

        screenX = tj.screenWidth/2 - (tj.tileSize/2);
        screenY = tj.screenHeight/2 - (tj.tileSize/2);



        //area de colisão do jogador
        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 9;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY =  solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;

        setDefaultValues();
        getGuerreiro();
    }
    public void setDefaultValues(){
        worldX = tj.tileSize * 23;
        worldY = tj.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getGuerreiro(){

            up1 = configImagem("guerreiro_up1");
            up2 = configImagem("guerreiro_up2");
            down1 = configImagem("guerreiro_down1");
            down2 = configImagem("guerreiro_down2");
            left1 =  configImagem("guerreiro_left1");
            left2 = configImagem("guerreiro_left2");
            right1 = configImagem("guerreiro_right1");
            right2 = configImagem("guerreiro_right2");
    }

    public BufferedImage configImagem(String imageName){
        Utils ut = new Utils();
        BufferedImage image = null;

        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Guerreiro/" + imageName + ".png")));
            image = ut.scaleImage(image, tj.tileSize,tj.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
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
           String itemName = tj.itens[i].name;

           switch (itemName){
               case "Chave":
                   chaveColetada++;
                   tj.itens[i] = null; // faz a chave desaparecer do mapa
                   tj.iu.mostrarMensagem("Você pegou uma chave!");
                   break;
               case "Porta":
                   if(chaveColetada > 0){
                       tj.itens[i] = null;
                       chaveColetada--;
                       tj.iu.mostrarMensagem("Parabéns, você abriu a porta");
                   }else{
                       tj.iu.mostrarMensagem("Colete a chave para abrir a porta");
                   }
                   System.out.println("Chave"+ chaveColetada);
                   break;
               case "Baú":
                   tj.iu.finalJogo = true;
                   break;

           }
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
