package entity;

import Telas.Tela;
import main.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class NPC_fazendeiro extends Entity{

    public NPC_fazendeiro(Tela tj) {
        super(tj);

        direction = "down";
        speed = 1; //velocidade

        getNPCfazendeiro();
    }
    public void getNPCfazendeiro(){

        up1 = configImagem("/NPC_fazendeiro/npcf_up1");
        up2 = configImagem("/NPC_fazendeiro/npcf_up2");
        down1 = configImagem("/NPC_fazendeiro/npcf_down1");
        down2 = configImagem("/NPC_fazendeiro/npcf_down2");
        left1 =  configImagem("/NPC_fazendeiro/npcf_left1");
        left2 = configImagem("/NPC_fazendeiro/npcf_left2");
        right1 = configImagem("/NPC_fazendeiro/npcf_right1");
        right2 = configImagem("/NPC_fazendeiro/npcf_right2");
    }



}

