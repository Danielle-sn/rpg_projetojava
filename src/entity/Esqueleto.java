package entity;

import main.KeyHandler;
import main.Tela;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Esqueleto extends Inimigo {

//    public final int screenX;
//    public final int screenY;

    public Esqueleto(String nome, int saude, int nivel, int ataque, Tela tj, KeyHandler keyH) {
        super(nome, saude, nivel, ataque, tj, keyH);

        direction = "down";
        speed = 1;


//        screenX = tj.screenWidth/2 - (tj.tileSize/2);
//        screenY = tj.screenHeight/2 - (tj.tileSize/2);

        getEsqueleto();

    }

    public void getEsqueleto() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public void draw(Graphics2D g2){
//        //g2.setColor(Color.white);
//        //g2.fillRect(x, y, tj.tileSize, tj.tileSize);
//        BufferedImage image =  down1;
//
//        g2.drawImage(image, screenX, screenY, tj.tileSize, tj.tileSize, null);
//
//    }

}
