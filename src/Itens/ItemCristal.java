package Itens;

import Telas.Tela;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ItemCristal extends SuperItens{
        Tela tj;

        public ItemCristal (Tela tj){
            name = "Cristal Mágico";
            try{
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/itens/crystal.png")));
                ut.scaleImage(image,tj.tileSize,tj.tileSize);
            }catch(IOException e){
                e.printStackTrace();
            }
            collision = true;
        }

}
