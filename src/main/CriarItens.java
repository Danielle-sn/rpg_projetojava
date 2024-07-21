package main;

import Itens.InEsqueleto;
import Itens.ItemBau;
import Itens.ItemKey;
import Itens.ItemPorta;
import Telas.Tela;

public class CriarItens {
    Tela tj;
    public CriarItens(Tela tj){
        this.tj = tj;
    }
    public void setItem(){
        tj.itens[0] = new ItemKey(tj);
        tj.itens[0].worldX = 40 * tj.tileSize;
        tj.itens[0].worldY = 9 * tj.tileSize;

        tj.itens[1] = new ItemKey(tj);
        tj.itens[1].worldX = 25 * tj.tileSize;
        tj.itens[1].worldY = 25 * tj.tileSize;

        tj.itens[2] = new ItemPorta(tj);
        tj.itens[2].worldX = 36 * tj.tileSize;
        tj.itens[2].worldY = 32 * tj.tileSize;

        tj.itens[3] = new ItemBau(tj);
        tj.itens[3].worldX = 40 * tj.tileSize;
        tj.itens[3].worldY = 33 * tj.tileSize;

        tj.itens[4] = new InEsqueleto(tj);
        tj.itens[4].worldX = 23 * tj.tileSize;
        tj.itens[4].worldY = 23 * tj.tileSize;

    }
}
