package main;

import Telas.Tela;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler  implements KeyListener{
        Tela tj;
        public boolean upPressed, downPressed, leftPressed,rightPressed;
        //DEBUG
        public boolean  checkDrawTime = false;

        public KeyHandler(Tela tj){
            this.tj = tj;
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            int code = e.getKeyCode(); //retorna uma int da tecla pressionada
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P){
                if(tj.gameState == tj.playState){
                    tj.gameState = tj.pauseState;
                } else if (tj.gameState == tj.pauseState){
                    tj.gameState = tj.playState;
                }
            }
                //DEBUG
//            if (code == KeyEvent.VK_T) {
//                if (checkDrawTime == false) {
//                    checkDrawTime = true;
//                } else if (checkDrawTime == true) {
//                    checkDrawTime = false;
//                }
//            }

        }


            @Override
            public void keyReleased (KeyEvent e){

                int code = e.getKeyCode();

                if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    upPressed = false;
                }

                if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    downPressed = false;
                }

                if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                }

                if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }

            }

        }

