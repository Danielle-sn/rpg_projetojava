package main;

import Itens.ItemKey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class InterfaceUsuario {
    Tela tj;
    Font arial40, arial80B;
    BufferedImage chaveImage; //adicionar a imagem do item na contagem
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean finalJogo = false;
    double tempo;
    DecimalFormat dF = new DecimalFormat("#0.00");


    public InterfaceUsuario(Tela tj){
        this.tj = tj;
        arial40 = new Font("Arial", Font.PLAIN, 40 ); // parâmetros: nome, estilo de fonte,tamanho da fonte
        arial80B = new Font("Arial", Font.PLAIN, 80 );
        ItemKey chave = new ItemKey();
        chaveImage = chave.image;

    }

    public void mostrarMensagem(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        if (finalJogo){
            g2.setFont(arial40);
            g2.setColor(Color.white);
            String text;
            int textLength;
            int x;
            int y;

            text = "Encontrou o tesouro!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = tj.screenWidth/2 - textLength/2;
            y = tj.screenHeight/2 + (tj.tileSize*4);
            g2.drawString(text,x,y);

            text = "tempo: " + dF.format(tempo) + "!";
            textLength = (int)g2.getFontMetrics() .getStringBounds(text,g2).getWidth();
            x = tj.screenWidth/2 - textLength/2;
            y = tj.screenHeight/2 - (tj.tileSize*3);
            g2.drawString(text,x,y);

            g2.setFont(arial80B);
            g2.setColor(Color.black);
            text = "Parabéns!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = tj.screenWidth/2 - textLength/2;
            y = tj.screenHeight/2 + (tj.tileSize*2);
            g2.drawString(text,x,y);

            tj.gameThread = null;

        }else{
            g2.setFont(arial40);
            g2.setColor(Color.white);
            g2.drawImage(chaveImage, tj.tileSize/2, tj.tileSize/2, tj.tileSize, tj.tileSize,null);
            g2.drawString("x " + tj.guerreiro.chaveColetada, 74, 65); // coordenadas funcionam diferente pra drawString, y baseline of the text

            //tempo
            tempo += (double)1/60; // 60 vezes por segundo
            g2.drawString("Tempo: "+dF.format(tempo),tj.tileSize*11,65);
            //mensagem
            if(messageOn){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, tj.tileSize/2, tj.tileSize*5);

                messageCounter++;
                if(messageCounter >120){ //a mensagem vai desaparecer depois de dois segundos
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }

    }

}
