package Itens;

import javax.imageio.ImageIO;
import java.io.IOException;

// tem um trem aleatório alinhar com a história
public class ItemPorta extends SuperItens {
    public ItemPorta(){
            name = "Porta";
            try{
                image = ImageIO.read(getClass().getResourceAsStream("/itens/house_resources.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }


}
