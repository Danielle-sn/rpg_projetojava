package entity;

import main.KeyHandler;
import Telas.Tela;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Esqueleto extends Inimigo {

//    public final int screenX;
//    public final int screenY;

    public Esqueleto(String nome, int forca, int dexterity, int ataque, int saude, int exp, Tela tj, KeyHandler keyH) {
        super(nome, forca, dexterity, ataque, saude, exp, tj, keyH);


        direction = "down";
        speed = 1;

        //area de colisão do jogador
        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 9;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY =  solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;


//        screenX = tj.screenWidth/2 - (tj.tileSize/2);
//        screenY = tj.screenHeight/2 - (tj.tileSize/2);

        getEsqueleto();

    }


    public void getEsqueleto() {

            up1 = configImagem("/Esqueleto/Skeleton_up1");
            up2 = configImagem("/Esqueleto/Skeleton_up2");
            down1 = configImagem("/Esqueleto/Skeleton_down1");
            down2 = configImagem("/Esqueleto/Skeleton_down2");
            left1 =  configImagem("/Esqueleto/Skeleton_left1");
            left2 = configImagem("/Esqueleto/Skeleton_left2");
            right1 = configImagem("/Esqueleto/Skeleton_right1");
            right2 = configImagem("/Esqueleto/Skeleton_right2");
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
