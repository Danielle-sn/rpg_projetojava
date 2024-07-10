package entity;

import main.Tela;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Guerreiro extends Personagem{

    public final int screenX;
    public final int screenY;

    public Guerreiro(String nome, int saude, int nivel, int ataque, Tela tj, KeyHandler keyH){
        super(nome,saude,nivel, ataque, tj, keyH);

        screenX = tj.screenWidth/2 - (tj.tileSize/2);
        screenY = tj.screenHeight/2 - (tj.tileSize/2);

        //area de colisão do jogador
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 32;
        solidArea.height = 32;

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
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/guerreiro_right2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
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
        g2.drawImage(image, screenX, screenY, tj.tileSize, tj.tileSize, null);

    }

}
