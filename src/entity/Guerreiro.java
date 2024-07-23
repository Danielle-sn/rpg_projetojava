package entity;

import Telas.Tela;
import main.KeyHandler;
import main.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Guerreiro extends Jogador {

    public final int screenX;
    public final int screenY;

    //public int chaveColetada = 0;
    //public int cristalColetado = 0;

    public Guerreiro(String nome, int forca, int dexterity, int ataque, int saude, int exp, Tela tj, KeyHandler keyH) {
        super(nome, forca, dexterity, ataque, saude, exp, tj, keyH);

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
        getGuerreiro();
    }

    //    public void setDefaultValues(){
//        worldX = tj.tileSize * 23;
//        worldY = tj.tileSize * 21;
//        speed = 4;
//        direction = "down";
//    }
    public void getGuerreiro() {

        up1 = configImagem("/Guerreiro/guerreiro_up1");
        up2 = configImagem("/Guerreiro/guerreiro_up2");
        down1 = configImagem("/Guerreiro/guerreiro_down1");
        down2 = configImagem("/Guerreiro/guerreiro_down2");
        left1 = configImagem("/Guerreiro/guerreiro_left1");
        left2 = configImagem("/Guerreiro/guerreiro_left2");
        right1 = configImagem("/Guerreiro/guerreiro_right1");
        right2 = configImagem("/Guerreiro/guerreiro_right2");
    }

    @Override
    public int getAtaque() {
        return super.getAtaque();
    }
}