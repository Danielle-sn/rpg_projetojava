package Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

import Itens.SuperItens;
import Tiles.TileManager;
import entity.*;
import main.ChecandoColisao;
import main.AssetSetter;
import main.KeyHandler;

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



    private String selectedCharacter = "Guerreiro";

    // Novo método para definir o personagem selecionado
    public void setSelectedCharacter(String character) {
        this.selectedCharacter = character;
    }


    //FPS
        int fps = 60;
    //SISTEMA
        public TileManager tileM = new TileManager(this);
        KeyHandler keyH = new KeyHandler(this);
        Thread gameThread; // iniciar o tempo no jogo, pode iniciar e parar, deixa o programa rodando até parar
        public ChecandoColisao checandoColisao = new ChecandoColisao(this);
        public AssetSetter aSetter = new AssetSetter(this);
        public InterfaceUsuario iu = new InterfaceUsuario(this);

        //ENTIDADE E ITENS
        public Guerreiro guerreiro = new Guerreiro("Chris", 100, 1, 50, 5, 2, 5, 8, 9, 3, this, keyH);
        public Feiticeira feiticeira = new Feiticeira("Lyra", 90, 1, 3, 4,5, 6, 7, 8, 8, this, keyH);
        //public Esqueleto esqueleto = new Esqueleto("esqueleto",100,1,25,this, keyH);
        public SuperItens[] itens = new SuperItens[10];
        public Entity[] npc = new Entity[10];
        public Entity[] esqueleto = new Entity[20];

        //ESTADO DO JOGO
        public int gameState;
        public final int playState = 1;
        public final int pauseState = 2;
        public final int dialogueState = 3;


        public Tela() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
            this.requestFocusInWindow();
        }
        public void setupGame(){
            aSetter.setItem();
            aSetter.setNPCfazendeiro();
            aSetter.setEsqueleto();
            gameState =  playState;

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
            if(gameState == playState){
                //jogador
                guerreiro.update();
                feiticeira.update();

                //npc
                for(int i = 0; i < npc.length; i++){
                    if(npc[i] != null){
                        npc[i].update();
                    }
                }
                for(int i = 0; i < esqueleto.length; i++){
                    if(esqueleto[i] != null){
                        esqueleto[i].update();
                    }
                }
            }
            if(gameState == playState){
                //
            }

        }

        public void paintComponent(Graphics g){ //metodo padrao

            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            //DEBUG
            long drawStart = 0;
            if(keyH.checkDrawTime ==true){
                drawStart = System.nanoTime();
            }


            //tile
            tileM.draw(g2); //o fundo tem que ser desenhado antes do personagem

            //itens
            for(int i = 0; i < itens.length; i++){
                if(itens[i] != null){
                    itens[i].draw(g2,this);
                }
            }
            //npc
            for(int i = 0; i<npc.length;i++){
                if (npc[i] != null) {
                    npc[i].draw(g2);
                }
                }
            // esqueleto
            for(int i = 0; i<esqueleto.length;i++){
                if (esqueleto[i] != null) {
                    esqueleto[i].draw(g2);
                }
            }
            // jogador
            //guerreiro.draw(g2);
            //feiticeira.draw(g2);

            if ("Guerreiro".equals(selectedCharacter)) {
                guerreiro.draw(g2);
            } else if ("Feiticeira".equals(selectedCharacter)) {
                feiticeira.draw(g2);
            }

            //interface
            iu.draw(g2);

            //DEBUG
            if(keyH.checkDrawTime == true) {
                long drawEnd = System.nanoTime();
                long passed = drawEnd - drawStart;
                g2.setColor(Color.white);
                g2.drawString("Draw Time:" + passed, 10, 400);
                System.out.println("Draw Time:" + passed);
            }
            //inimigos

           //esqueleto.draw(g2);

            g2.dispose();
        }

    public void setVisible(boolean b) {
        super.setVisible(b);
        requestFocusInWindow(); // Foco painel (permite que  painel receba a entrada de taclas)
    }


}


