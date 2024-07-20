package Itens;

import javax.imageio.ImageIO;
import java.io.IOException;

public class InEsqueleto extends SuperItens{

    public InEsqueleto(){
        name = "esq";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Skeleton_down1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
