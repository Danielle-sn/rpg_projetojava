package Telas;

import Itens.ItemKey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class InterfaceUsuario {
    Tela tj;
    Graphics2D g2;
    Font arial40, arial80B;
    //BufferedImage chaveImage; //adicionar a imagem do item na contagem
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean finalJogo = false;
    public String currentDialogue ="";


    public InterfaceUsuario(Tela tj) {
        this.tj = tj;
        arial40 = new Font("Arial", Font.PLAIN, 40); // parâmetros: nome, estilo de fonte,tamanho da fonte
        arial80B = new Font("Arial", Font.PLAIN, 80);
        //ItemKey chave = new ItemKey(tj);
        //chaveImage = chave.image;

    }

    public void mostrarMensagem(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial40);
        g2.setColor(Color.white);

        //Estado do Jogador
        if (tj.gameState == tj.playState) {
            //later
        }
        //Estado pausa
        if (tj.gameState == tj.pauseState) {
            drawPauseScreen();
        }
        //Estado diálogo
         if(tj.gameState == tj.dialogueState){
             drawDialogueScreen();
         }
    }

    //        if (finalJogo){
//            g2.setFont(arial40);
//            g2.setColor(Color.white);
//            String text;
//            int textLength;
//            int x;
//            int y;
//
//            text = "Encontrou o tesouro!!";
//            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
//            x = tj.screenWidth/2 - textLength/2;
//            y = tj.screenHeight/2 + (tj.tileSize*4);
//            g2.drawString(text,x,y);
//
//            text = "tempo: " + dF.format(tempo) + "!";
//            textLength = (int)g2.getFontMetrics() .getStringBounds(text,g2).getWidth();
//            x = tj.screenWidth/2 - textLength/2;
//            y = tj.screenHeight/2 - (tj.tileSize*3);
//            g2.drawString(text,x,y);
//
//            g2.setFont(arial80B);
//            g2.setColor(Color.black);
//            text = "Parabéns!!";
//            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
//            x = tj.screenWidth/2 - textLength/2;
//            y = tj.screenHeight/2 + (tj.tileSize*2);
//            g2.drawString(text,x,y);
//
//            tj.gameThread = null;
//
//        }else{
//            g2.setFont(arial40);
//            g2.setColor(Color.white);
//            g2.drawImage(chaveImage, tj.tileSize/2, tj.tileSize/2, tj.tileSize, tj.tileSize,null);
//            g2.drawString("x " + tj.guerreiro.chaveColetada, 74, 65); // coordenadas funcionam diferente pra drawString, y baseline of the text
//
//            //tempo
//            tempo += (double)1/60; // 60 vezes por segundo
//            g2.drawString("Tempo: "+dF.format(tempo),tj.tileSize*11,65);
//            //mensagem
//            if(messageOn){
//                g2.setFont(g2.getFont().deriveFont(30F));
//                g2.drawString(message, tj.tileSize/2, tj.tileSize*5);
//
//                messageCounter++;
//                if(messageCounter >120){ //a mensagem vai desaparecer depois de dois segundos
//                    messageCounter = 0;
//                    messageOn = false;
//                }
//            }
//        }
//
    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,70F));
        String text = "PAUSADO";
        int x = getXCentroTexto(text);
        int y = tj.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen(){
        //WINDOW
        int x = tj.tileSize*2;
        int y =  tj.tileSize/2;
        int width = tj.screenWidth - (tj.tileSize*4);
        int height = tj.tileSize*3;
        drawSubWindow( x,  y ,  width,  height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,18));
        x += tj.tileSize;
        y += tj.tileSize;
        g2.drawString(currentDialogue,x,y);
    }
    public void drawSubWindow(int x, int y,int width, int height){
        Color c = new Color(0,0,0, 220);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height,25, 25);



    }


    public int getXCentroTexto(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tj.screenWidth / 2 - length / 2;
        return x;
    }


}
