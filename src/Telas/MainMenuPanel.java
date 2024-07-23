package Telas;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private GameFrame gameFrame;

    public MainMenuPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout()); //BorderLayout: north, south, east, west, center


        JLabel titulo = new JLabel("Menu", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        //Mais um painel para organizar os botoes em GridLayout
        JPanel buttonsPanel = new JPanel(new GridLayout(2,1));



        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(e -> gameFrame.showPanel("Jogo"));
        buttonsPanel.add(startButton);

        /*JButton battleButton = new JButton("Iniciar Batalha");
        battleButton.addActionListener(e -> gameFrame.showPanel("Batalha"));
        buttonsPanel.add(battleButton);*/

        JButton chooseButton = new JButton("Escolha seu Personagem");
        chooseButton.addActionListener(e -> gameFrame.showPanel("Escolha"));
        buttonsPanel.add(chooseButton);


        add(buttonsPanel, BorderLayout.CENTER);
    }



}