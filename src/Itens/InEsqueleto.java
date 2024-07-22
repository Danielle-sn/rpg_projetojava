package Itens;

import Telas.Tela;

import javax.imageio.ImageIO;
import java.io.IOException;

public class InEsqueleto extends SuperItens{
    Tela tj;

    public InEsqueleto(Tela tj){
        name = "esq";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_down1.png"));
            //ut.scaleImage(image,tj.tileSize,tj.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
