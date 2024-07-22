package Tiles;

import Telas.Tela;
import main.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    Tela tj;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(Tela tj) {

        this.tj = tj;
        tile = new Tile[50];
        mapTileNum = new int[tj.maxWorldCol][tj.maxWorldRow];


        getTileImage();
        loadMap("/maps/map01.txt");
    }

    public void getTileImage() {

        configImagem(0, "deadgrass_lisa", false);
        configImagem(1, "deadgrass_lisa", false);
        configImagem(2, "deadgrass_lisa", false);
        configImagem(3, "deadgrass_lisa", false);
        configImagem(4, "deadgrass_lisa", false);
        configImagem(5, "deadgrass_lisa", false);
        configImagem(6, "deadgrass_lisa", false);
        configImagem(7, "deadgrass_lisa", false);
        configImagem(8, "deadgrass_lisa", false);
        configImagem(9, "deadgrass_lisa", false);
        configImagem(10, "deadgrass_n", false);
        configImagem(11, "grass_detalhe", false);
        configImagem(12, "grass_lisa", false);
        configImagem(13, "trees3", true);
        configImagem(14, "trunk", true);
        configImagem(15, "water_lisa", true);
        configImagem(16, "water_borda_id", true);
        configImagem(17, "water_borda_ie", true);
        configImagem(18, "water_borda_sd", true);
        configImagem(19, "water_borda_se", true);
        configImagem(20, "water_dinferior", true);
        configImagem(21, "water_dsuperior", true);
        configImagem(22, "water_einferior", true);
        configImagem(23, "water_esuperior", true);
        configImagem(24, "water_meiodireita", true);
        configImagem(25, "water_meioesquerdo", true);
        configImagem(26, "water_meioinferior", true);
        configImagem(27, "water_meiosuperior", true);
        configImagem(28, "water_textura", true);
        configImagem(29, "house", true);

    }

    //otimizando renderização do jogo
    public void configImagem(int index, String imageName, boolean collision){
        Utils ut = new Utils();

        try{
            tile[index]= new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/" + imageName + ".png")));
            tile[index].image = ut.scaleImage(tile[index].image,tj.tileSize, tj.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
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
                g2.drawImage(tile[tileNum].image, screenX, screenY,null);
                System.out.println("coluna:"+worldCol+"li"+worldRow+"ima"+tileNum);

            }
            worldCol++;
            if (worldCol == tj.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }


        }
    }
}