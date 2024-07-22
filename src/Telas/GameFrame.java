package Telas;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel cards;
    private Tela telaJogo;

    public GameFrame(){
        //configura no tipo CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        //paineis
        telaJogo = new Tela();
        MainMenuPanel menu = new MainMenuPanel(cardLayout, cards);
        //OptionsPanel options = new OptionsPanel();

        //adicionando os paineis ao CardLayout
        cards.add(telaJogo, "Jogo");
        cards.add(menu, "Menu");
        //cards.add(options, "Opcoes");

        setLayout(new BorderLayout());
        add(cards, BorderLayout.CENTER);
        setSize(telaJogo.screenWidth, telaJogo.screenHeight);

        setResizable(false); // não vai ser resizable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Guardioes das Lendas Antigas");
        setLocationRelativeTo(null); // vai estar no centro

        pack();

        // Exibe a tela principal
        cardLayout.show(cards, "Menu");

        telaJogo.setupGame();
        telaJogo.startGameThred();





    }
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        telaJogo.requestFocusInWindow();  // Solicita foco após o JFrame ser visível
    }

}