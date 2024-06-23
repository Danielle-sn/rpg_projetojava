package entity;

import main.Tela;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Jogador extends Entity{
    Tela tj;
    KeyHandler keyH;
    public Jogador(Tela tj, KeyHandler keyH ){
        this.tj = tj;
        this.keyH = keyH;

        setDefaultValues();
        getJogador();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getJogador(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Jogador/guerreiro_right2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        // esse método está  dentro do loop então é chamado 60 vezes por segundo
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){

            if(keyH.upPressed == true) {
                direction  = "up";
                y -= speed;
            }
            else if (keyH.downPressed == true) {
                direction  = "down";
                y += speed;
            }

            else if (keyH.leftPressed == true){
                direction  = "left";
                x -= speed;
            }
            else if (keyH.rightPressed == true){
                direction  = "right";
                x += speed;
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
        g2.drawImage(image, x, y, tj.tileSize, tj.tileSize, null);

    }

}
