package entity;

import Telas.Tela;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Feiticeira extends Jogador {

    public final int screenX;
    public final int screenY;

    public Feiticeira(String nome, int forca, int agilidade, int dexterity, int ataque, int nivel, int saude, int exp, int nextLevelExp, int currentWeapon, Tela tj, KeyHandler keyH) {
        super(nome, forca, agilidade, dexterity, ataque, saude, exp, nivel, nextLevelExp, currentWeapon, tj, keyH);

        screenX = tj.screenWidth / 2 - (tj.tileSize / 2);
        screenY = tj.screenHeight / 2 - (tj.tileSize / 2);

        //area de colisão do jogador
        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 9;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;

        setDefaultValues();
        getFeiticeira();

    }

    public void getFeiticeira() {
        up1 = configImagem("/Feiticeira/Alchemist_up1");
        up2 = configImagem("/Feiticeira/Alchemist_up2");
        down1 = configImagem("/Feiticeira/Alchemist_down1");
        down2 = configImagem("/Feiticeira/Alchemist_down2");
        left1 = configImagem("/Feiticeira/Alchemist_left1");
        left2 = configImagem("/Feiticeira/Alchemist_left2");
        right1 = configImagem("/Feiticeira/Alchemist_right1");
        right2 = configImagem("/Feiticeira/Alchemist_right2");

    }

}



//    public Movimento mov;
//
//
//    public final int screenX;
//    public final int screenY;
//
//        public Feiticeira(String nome, int forca, int agilidade, int dexterity, int ataque, int nivel, int saude, int exp, int nextLevelExp, int currentWeapon, Tela tj, KeyHandler keyH) {
//            super(nome, forca, agilidade, dexterity, ataque, nivel, saude, exp, nextLevelExp, currentWeapon, tj,  keyH);
//
//
//            screenX = tj.screenWidth/2 - (tj.tileSize/2);
//            screenY = tj.screenHeight/2 - (tj.tileSize/2);
//
//
//            mov = new Movimento(tj, keyH, this);
//
//
//            //area de colisão do jogador
//            solidArea = new Rectangle();
//            solidArea.x = 9;
//            solidArea.y = 9;
//            solidAreaDefaultX = solidArea.x;
//            solidAreaDefaultY =  solidArea.y;
//            solidArea.width = 30;
//            solidArea.height = 30;
//
//            mov.setDefaultValues();
//            getFeiticeira();
//        }
//
//
//        public void getFeiticeira(){
//            try{
//                up1 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_up1.png"));
//                up2 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_up2.png"));
//                down1 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_down1.png"));
//                down2 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_down2.png"));
//                left1 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_left1.png"));
//                left2 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_left2.png"));
//                right1 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_right1.png"));
//                right2 = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_right2.png"));
//
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//        }
//
//        public void draw(Graphics2D g2){
//            //g2.setColor(Color.white);
//            //g2.fillRect(x, y, tj.tileSize, tj.tileSize);
//
//            BufferedImage image = null;
//
//            Movimento mov;
//            switch(direction){
//                case "up":
//                    if (spriteNum == 1){
//                        image = up1;
//                    }
//                    if (spriteNum == 2 ){
//                        image = up2;
//                    }
//                    break;
//                case "down":
//                    if (spriteNum == 1){
//                        image = down1;
//                    }
//                    if (spriteNum == 2){
//                        image = down2;
//                    }
//                    break;
//                case "left":
//                    if (spriteNum == 1){
//                        image = left1;
//                    }
//                    if (spriteNum == 2){
//                        image = left2;
//                    }
//                    break;
//                case "right":
//                    if (spriteNum == 1){
//                        image = right1;
//                    }
//                    if (spriteNum == 2){
//                        image = right2;
//                    }
//                    break;
//
//            }
//            g2.drawImage(image, screenX, screenY, tj.tileSize, tj.tileSize, null);
//
//        }



