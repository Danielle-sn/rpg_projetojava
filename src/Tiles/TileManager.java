package Tiles;

import main.Tela;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    Tela tj;
    Tile [] tile;
    int[][] mapTileNum;

    public TileManager(Tela tj){
        this.tj = tj;
        tile = new Tile[10];
        mapTileNum = new int[tj.maxWorldCol] [tj.maxWorldRow];
        getTileImage();
        loadMap("maps/map01.txt");
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass_n.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/deadgrass_n.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/trees3.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/trunk.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/rock2.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/rock3.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/brink.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (row < tj.maxScreenRow) {
                while (col < tj.maxScreenCol) {
                    String line = br.readLine();
                    while (col < tj.maxScreenCol) {
                        String numbers[] = line.split(" ");
                        int num = Integer.parseInt(numbers[col]);
                        mapTileNum[col][row] = num;
                        col++;
                    }
                    if (col == tj.maxScreenCol) {
                        col = 0;
                        row++;

                    }
                    br.close();
                }
            }
            }catch(Exception ignored){

            }
    }
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (row < tj.maxScreenRow) {
            while (col < tj.maxScreenCol) {
                int tileNum = mapTileNum[col][row];
                g2.drawImage(tile[tileNum].image, x, y, tj.tileSize, tj.tileSize, null);
                col++;
                x += tj.tileSize;
            }
            col = 0;
            x = 0;
            row++;
            y += tj.tileSize;
        }


    }
}
