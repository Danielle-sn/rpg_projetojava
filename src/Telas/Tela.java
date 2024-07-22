package Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Itens.SuperItens;
import Tiles.TileManager;
import entity.*;
import main.ChecandoColisao;
import main.CriarItens;
import main.KeyHandler;

public class Tela extends JPanel implements Runnable{

        //SCREEN SETTINGS
        final int originalTileSize = 16; //16x16 tile
        final int scale =3;
        // acho que a gente vai ter que mudar esses atriburos pra private
        public final int tileSize = originalTileSize * scale; //48x48
        public final int maxScreenCol = 16;
        public final int maxScreenRow = 12;
        public final int screenWidth = tileSize * maxScreenCol; //768 pixels
        public final int screenHeight = tileSize * maxScreenRow; //576 pixels

        // WORLD SETTINGS
        public final int maxWorldCol = 50;
        public final int maxWorldRow = 50;
        public final int worldWitch = tileSize * maxWorldCol;
        public final int worldHeight = tileSize * maxWorldRow;



    //FPS
        int fps = 60;

        private Tela tj;
        public TileManager tileM = new TileManager(this);
        KeyHandler keyH = new KeyHandler();
        Thread gameThread; // iniciar o tempo no jogo, pode iniciar e parar, deixa o programa rodando até parar
        public ChecandoColisao checandoColisao = new ChecandoColisao(this);
        public CriarItens cItens = new CriarItens(this);
        public Guerreiro guerreiro;
        public Esqueleto esqueleto;
        public Feiticeira feiticeira;
        public Movimento mov;
        public SuperItens[] itens = new SuperItens[10];


        public Tela() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
            this.requestFocusInWindow();
        }
        public void setupGame(){
            cItens.setItem();

            guerreiro = new Guerreiro("Chris", 100, 1, 50, 5, 2, 5, 8, 9, 3, this, keyH);
            feiticeira = new Feiticeira("Lyra", 90, 1, 3, 4,5, 6, 7, 8, 8, this, keyH);
            esqueleto = new Esqueleto("esqueleto", 100, 1, 25, this, keyH);
            mov = new Movimento(this, keyH, guerreiro);

        }

        public void startGameThred() {

            gameThread = new Thread(this); //passando Telas.Tela para esse construtor
            gameThread.start(); //automaticamente chamar run method

        }

        @Override
        public void run() {

            double drawInterval = 1000000000/fps; // 0.01666
            double delta = 0;
            long lastTime =System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;
            //GAME LOOP

            while(gameThread != null) {

                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if(delta >= 1){
                    update(); // (UPDATE) atualizar informacao como as posicoes dos personagens
                    repaint();                // (DRAW) mostrar na tela essa atualizacao
                    delta --;
                    drawCount ++;
                }
                if(timer>= 1000000000){
                    System.out.println("FPS:"+ drawCount);
                    drawCount = 0;
                    timer = 0;
                }

            }
        }


        public void update(){
            if (mov != null) {
                mov.update();
            }

        }

        public void paintComponent(Graphics g){ //metodo padrao

            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;

            //tile
            tileM.draw(g2); //o fundo tem que ser desenhado antes do personagem
            //itens
            for(int i = 0; i < itens.length; i++){
                if(itens[i] != null){
                    itens[i].draw(g2,this);
                }
            }
            // jogador
            guerreiro.draw(g2);
            feiticeira.draw(g2);
            //inimigos
           //esqueleto.draw(g2);

            g2.dispose();
        }

    public void setVisible(boolean b) {
        super.setVisible(b);
        requestFocusInWindow(); // Foco painel (permite que  painel receba a entrada de taclas)
    }


}


