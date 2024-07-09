package Tiles;

import main.Tela;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {

    Tela tj;
    Tile [] tile;
    int[][] mapTileNum;

    public TileManager(Tela tj){
        this.tj = tj;
        tile = new Tile[10];
        mapTileNum = new int[tj.maxWorldCol] [tj.maxWorldRow];
        getTileImage();
        loadMap("/res/maps/map01.txt");
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
            InputStream is = getClass().getResourceAsStream(filePath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (row < tj.maxWorldCol) {
                while (col < tj.maxWorldRow) {
                    String line = br.readLine();
                    while (col < tj.maxWorldCol) {
                        String[] numbers = line.split(" ");
                        //char numChar = line.charAt(col);
                        int num = Integer.parseInt(numbers[col]);
                        //int num = Character.getNumericValue(numChar);
                        mapTileNum[col][row] = num;
                        col++;
                    }
                    //if (col == tj.maxWorldCol) {
                        col = 0;
                        row++;
                    //}
                }
            }
            br.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
//  } catch (IOException e) {
        //     e.printStackTrace();
        // }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldRow < tj.maxWorldRow) {
            while (worldCol < tj.maxWorldCol) {
                int tileNum = mapTileNum[worldCol][worldRow];

                int worldX = worldCol * tj.tileSize;
                int worldY = worldRow * tj.tileSize;
                int screenX = worldX - tj.guerreiro.worldX + tj.guerreiro.screenX; // tirar a diferença entre as coordenadas da tela e do mapa
                int screenY = worldY - tj.guerreiro.worldY + tj.guerreiro.screenY;

                g2.drawImage(tile[tileNum].image, screenX, screenY, tj.tileSize, tj.tileSize, null);
                worldCol++;
                System.out.println(tileNum);
            }
            worldCol = 0;
            worldRow++;

        }


    }
}
