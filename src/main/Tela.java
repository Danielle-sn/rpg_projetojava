package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Tiles.TileManager;
import entity.Guerreiro;

public class Tela extends JPanel implements Runnable{

        //SCREE SETTINGS
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

        TileManager tileM = new TileManager(this);
        KeyHandler keyH = new KeyHandler();
        Thread gameThread; // iniciar o tempo no jogo, pode iniciar e parar, deixa o programa rodando até parar
        Guerreiro guerreiro = new Guerreiro("Chris",100,1,50,this, keyH);

        //posicao padrao player
        int playerX = 100;
        int playerY = 100;
        int playerSpeed =4; //quantidade de pixels para andar ou voltar




        public Tela() {

            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
        }

        public void startGameThred() {

            gameThread = new Thread(this); //passando main.Tela para esse construtor
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
            guerreiro.update();
        }

        public void paintComponent(Graphics g){ //metodo padrao

            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            tileM.draw(g2); //o fundo tem que ser desenhado antes do personagem
            guerreiro.draw(g2);

            g2.dispose();
        }




}


