package entity;

public class Personagem {

    private String nome;
    private int saude;
    private int nivel;
    private int ataque;



    public Personagem(String nome, int saude, int nivel, int ataque) {
        this.nome = nome;
        this.saude = saude;
        this.nivel = nivel;
        this.ataque = ataque;
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
