package main;

import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {

                JFrame window = new JFrame();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false); // não vai ser resizable
                window.setTitle("Guardioes das Lendas Antigas");

                Tela tela = new Tela();
                window.add(tela);

                window.pack();

                window.setLocationRelativeTo(null); // vai estar no centro
                window.setVisible(true);

                tela.setupGame();
                tela.startGameThred();


            }
}

