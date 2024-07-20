package entity;

import Telas.Tela;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    Tela tj;

    public int worldX,worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1 ;
    public Rectangle solidArea = new Rectangle(0,0,48,48);// area de colisao do jogador
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public  Entity(Tela tj){
        this.tj = tj;
    }
}
