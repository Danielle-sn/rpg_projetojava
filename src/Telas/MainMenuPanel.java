package Telas;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;

    public MainMenuPanel(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        setLayout(new BorderLayout()); //BorderLayout: north, south, east, west, center


        JLabel titulo = new JLabel("Tela Principal", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        //Mais um painel para organizar os botoes em GridLayout
        JPanel buttonsPanel = new JPanel(new GridLayout(3,1));

        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(e -> cardLayout.show(cards, "Jogo"));
        buttonsPanel.add(startButton);



        add(buttonsPanel, BorderLayout.CENTER);
    }



}
