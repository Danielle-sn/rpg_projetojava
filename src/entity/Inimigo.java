package entity;

public class Inimigo extends Personagem{

    private int saudeInimigo;

    public Inimigo(String nome, int saude, int nivel) {
        super(nome, saude, nivel,0);
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
