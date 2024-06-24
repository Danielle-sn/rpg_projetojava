package Tiles;

import main.Tela;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    Tela tj;
    Tile [] tile;

    public TileManager(Tela tj){
        this.tj = tj;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass_n.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Deadgrass_n.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < tj.maxScreenCol && row < tj.maxScreenRow){
            g2.drawImage(tile[0].image, 0,0, tj.tileSize, tj.tileSize,null);
            col ++;
            x += tj.tileSize;

            if (col == tj.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += tj.tileSize;
            }
        }

    }
}
