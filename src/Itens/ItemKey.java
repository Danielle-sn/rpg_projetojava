package Itens;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import Telas.Tela;

// no momento a chave é uma fireball --- trocar
public class ItemKey extends SuperItens {
    Tela tj;

    public ItemKey(Tela tj){
        name = "Chave";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/itens/fireball.png")));
            ut.scaleImage(image,tj.tileSize,tj.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

}
