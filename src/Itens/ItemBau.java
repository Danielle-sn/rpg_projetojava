package Itens;

import Telas.Tela;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemBau  extends SuperItens{
    Tela tj;

    public ItemBau(Tela tj){

        name = "Baú";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/itens/chests.png"));
            ut.scaleImage(image,tj.tileSize,tj.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
