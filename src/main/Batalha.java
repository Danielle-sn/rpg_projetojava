package main;


import entity.Jogador;
import entity.Inimigo;

public class Batalha {
    private Jogador guerreiro;
    private Inimigo esqueleto;

    public Batalha(Jogador guerreiro, Inimigo esqueleto) {
        this.guerreiro = guerreiro;
        this.esqueleto = esqueleto;
    }

    public void atacarJogador() {
        if (calcularChanceDeAcerto(esqueleto.getAgilidade(), guerreiro.getAgilidade())) {
            int dano = calcularDano(esqueleto.getForca(), esqueleto.nivelDeAtaque(), esqueleto.getDestreza());
            guerreiro.receberDano(dano);
            System.out.println("Guerreiro recebeu " + dano + " de dano. Vida restante: " + guerreiro.getSaude());
        } else {
            System.out.println("Esqueleto errou o ataque!");
        }
    }

    public void atacarInimigo() {
        if (calcularChanceDeAcerto(guerreiro.getAgilidade(), esqueleto.getAgilidade())) {
            int dano = calcularDano(guerreiro.getForca(), guerreiro.nivelDeAtaque(), guerreiro.getDestreza());
            esqueleto.receberDano(dano);
            System.out.println("Esqueleto recebeu " + dano + " de dano. Vida restante: " + esqueleto.getSaude());
        } else {
            System.out.println("Guerreiro errou o ataque!");
        }
    }

    private boolean calcularChanceDeAcerto(int agilidadeAtacante, int agilidadeDefensor) {
        double chance = (double) agilidadeAtacante / (agilidadeAtacante + agilidadeDefensor);
        return Math.random() < chance;
    }

    private int calcularDano(int forca, int ataque, int destreza) {
        int danoBase = forca + ataque;
        boolean critico = Math.random() < (double) destreza / 100;
        return critico ? danoBase * 2 : danoBase;
    }

    public boolean isGuerreiroVivo() {
        return guerreiro.getSaude() > 0;
    }

    public boolean isEsqueletoVivo() {
        return esqueleto.getSaude() > 0;
    }

    public Jogador getGuerreiro() {
        return guerreiro;
    }

    public Inimigo getEsqueleto() {
        return esqueleto;
    }
}
