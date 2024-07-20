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
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(Tela tj) {

        this.tj = tj;
        tile = new Tile[10];
        mapTileNum = new int[tj.maxWorldCol][tj.maxWorldRow];


        getTileImage();
        loadMap("/maps/map01.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass_n.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/deadgrass_n.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/trees3.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/trunk.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/rock2.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/rock3.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/brink.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        //ler o mapa
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < tj.maxWorldCol && row < tj.maxWorldRow) {
                String line = br.readLine();
                while (col < tj.maxWorldCol) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);//mudando de string para Integer
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == tj.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();


        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < tj.maxWorldCol && worldRow < tj.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * tj.tileSize;
            int worldY = worldRow * tj.tileSize;
            int screenX = worldX - tj.guerreiro.worldX + tj.guerreiro.screenX; // tirar a diferença entre as coordenadas da tela e do mapa
            int screenY = worldY - tj.guerreiro.worldY + tj.guerreiro.screenY;

            if (worldX + tj.tileSize > tj.guerreiro.worldX - tj.guerreiro.screenX &&
                    worldX - tj.tileSize < tj.guerreiro.worldX + tj.guerreiro.screenX &&
                    worldY + tj.tileSize > tj.guerreiro.worldY - tj.guerreiro.screenY &&
                    worldY - tj.tileSize < tj.guerreiro.worldY + tj.guerreiro.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, tj.tileSize, tj.tileSize, null);
            }
            worldCol++;
            if (worldCol == tj.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }


        }
    }
}