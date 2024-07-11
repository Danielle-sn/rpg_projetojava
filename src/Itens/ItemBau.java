package Itens;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemBau  extends SuperItens{
    public ItemBau(){
        name = "Baú";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/itens/chests.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
