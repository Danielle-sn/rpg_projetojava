package entity;

import main.KeyHandler;
import Telas.Tela;
// acho que inimigo devia extender só de entity, não de personagem
public class Inimigo extends Entity {

    private int saudeInimigo;

    public Inimigo(String nome, int forca, int agilidade, int dexterity, int ataque, int nivel, int saude, int exp, int nextLevelExp, int currentWeapon, Tela tj, KeyHandler keyH) {
        super(nome, forca, agilidade, dexterity, ataque, nivel, saude, exp, nextLevelExp, currentWeapon, tj, keyH);

        definirAtaqueInimigo();
    }





    private void definirAtaqueInimigo(){
        int ataqueDoPersonagem = super.nivelDeAtaque();
        int ataqueDoInimigo = ataqueDoPersonagem - 5;
        if (ataqueDoPersonagem == 0) {
            ataqueDoInimigo = 10;
        }

        super.setAtaque(ataqueDoInimigo);
    }

    @Override
    public int nivelDeAtaque(){
        return super.getAtaque();
    }
}

