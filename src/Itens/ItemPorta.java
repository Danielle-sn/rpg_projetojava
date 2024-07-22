package Itens;

import Telas.Tela;

import javax.imageio.ImageIO;
import java.io.IOException;

// tem um trem aleatório alinhar com a história
public class ItemPorta extends SuperItens {
    Tela tj;

    public ItemPorta(Tela tj){
            name = "Porta";
            try{
                image = ImageIO.read(getClass().getResourceAsStream("/itens/house_resources.png"));
               // ut.scaleImage(image,tj.tileSize,tj.tileSize);
            }catch(IOException e){
                e.printStackTrace();
            }
        }


}
