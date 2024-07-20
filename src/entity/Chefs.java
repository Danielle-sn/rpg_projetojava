package entity;

import main.KeyHandler;
import Telas.Tela;

public class Chefs extends Inimigo{
    public Chefs(String nome, int saude, int nivel, int ataque, Tela tj, KeyHandler keyH) {
        super(nome, saude, nivel, ataque, tj, keyH);
    }
}
