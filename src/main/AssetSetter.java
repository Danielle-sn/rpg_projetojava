package main;

import Telas.Tela;
import entity.Esqueleto;
import entity.NPC_fazendeiro;

public class AssetSetter {
    Tela tj;
    public AssetSetter(Tela tj){
        this.tj = tj;
    }
    public void setItem() {
//        tj.itens[0] = new ItemKey(tj);
//        tj.itens[0].worldX = 40 * tj.tileSize;
//        tj.itens[0].worldY = 9 * tj.tileSize;

//        tj.itens[1] = new ItemKey(tj);
//        tj.itens[1].worldX = 25 * tj.tileSize;
//        tj.itens[1].worldY = 25 * tj.tileSize;
//
//        tj.itens[2] = new ItemPorta(tj);
//        tj.itens[2].worldX = 36 * tj.tileSize;
//        tj.itens[2].worldY = 32 * tj.tileSize;
//
//        tj.itens[3] = new ItemBau(tj);
//        tj.itens[3].worldX = 40 * tj.tileSize;
//        tj.itens[3].worldY = 33 * tj.tileSize;
//
//        tj.itens[4] = new InEsqueleto(tj);
//        tj.itens[4].worldX = 23 * tj.tileSize;
//        tj.itens[4].worldY = 23 * tj.tileSize;
//
//        tj.itens[5] = new ItemCristal(tj);
//        tj.itens[5].worldX = 21 * tj.tileSize;
//        tj.itens[5].worldY = 20 * tj.tileSize;

    }
    public void setNPCfazendeiro(){
        tj.npc[0]= new NPC_fazendeiro(tj);
        tj.npc[0].worldX = tj.tileSize*21;
        tj.npc[0].worldY = tj.tileSize*21;
    }
    public void setEsqueleto(){
        tj.esqueleto[0] = new Esqueleto("esqueleto",100,1,25,tj, null);
        tj.esqueleto[0].worldX = tj.tileSize* 23;
        tj.esqueleto[0].worldY = tj.tileSize*36;

        tj.esqueleto[1] = new Esqueleto("esqueleto",100,1,25,tj, null);
        tj.esqueleto[1].worldX = tj.tileSize* 23;
        tj.esqueleto[1].worldY = tj.tileSize*37;

    }
}
