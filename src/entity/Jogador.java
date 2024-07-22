package entity;

import main.KeyHandler;
import Telas.Tela;

public class Jogador extends Entity {

    private String nome;
    private int saude;
    private int nivel;
    private int ataque;



    KeyHandler keyH;

    public Jogador(String nome, int saude, int nivel, int ataque, Tela tj, KeyHandler keyH) {
        super(tj);
        this.nome = nome;
        this.saude = saude;
        this.nivel = nivel;
        this.ataque = ataque;
        this.keyH = keyH;
    }

    public int nivelDeAtaque(){
        if(nivel == 1){
            ataque = 10;
        }
        else if (nivel == 2) {
            ataque = 20;
        }
        else if (nivel == 3) {
            ataque = 30;
        }
        else{
            ataque = 0;
        }
        return ataque;
    }



    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
