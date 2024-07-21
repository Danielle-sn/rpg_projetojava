package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Utils {
    //método reutilizável para manipulação  das imagens
    public  BufferedImage scaleImage(BufferedImage original, int width, int height){

        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original,0,0, width,height, null);
        g2.dispose(); //liberar os recursos que estão sendo usados pelo contexto gráfico (Graphics ou Graphics2D).

        return scaledImage;
    }
}
