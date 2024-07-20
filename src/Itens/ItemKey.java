package Itens;

import javax.imageio.ImageIO;
import java.io.IOException;
// no momento a chave é uma fireball --- trocar
public class ItemKey extends SuperItens {
    public ItemKey(){
        name = "Chave";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/itens/fireball.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

}
