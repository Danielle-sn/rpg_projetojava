package entity;

import main.KeyHandler;
import Telas.Tela;
// acho que inimigo devia extender só de entity, não de personagem
public class Inimigo extends Jogador {

    private int saudeInimigo;

    public Inimigo(String nome, int saude, int nivel, int ataque, Tela tj, KeyHandler keyH){
        super(nome,saude,nivel, ataque, tj, keyH);

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
