package Itens;

import main.Tela;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperItens {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48); //a colisão será 16x16 com o objeto
    public int solidAreaDefaultX = 0;
    public int solidAreasDefaultY = 0;

    public void draw(Graphics2D g2, Tela tj){
        int screenX = worldX - tj.guerreiro.worldX + tj.guerreiro.screenX; // tirar a diferença entre as coordenadas da tela e do mapa
        int screenY = worldY - tj.guerreiro.worldY + tj.guerreiro.screenY;

        if(worldX + tj.tileSize > tj.guerreiro.worldX - tj.guerreiro.screenX &&
                worldX - tj.tileSize < tj.guerreiro.worldX + tj.guerreiro.screenX &&
                worldY  + tj.tileSize > tj.guerreiro.worldY - tj.guerreiro.screenY &&
                worldY - tj.tileSize< tj.guerreiro.worldY + tj.guerreiro.screenY) {
            g2.drawImage(image, screenX, screenY, tj.tileSize, tj.tileSize, null);
        }
    }
}
