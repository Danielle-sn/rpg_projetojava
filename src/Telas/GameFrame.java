package Telas;

import javax.swing.*;
import java.awt.*;
import entity.Guerreiro;
import entity.Feiticeira;
import entity.Esqueleto;
import main.KeyHandler;


public class GameFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel cards;
    private Tela telaJogo;
    private KeyHandler keyH;

    private String selectedCharacter;

    public GameFrame(){
        //configura no tipo CardLayout
        telaJogo = new Tela(this);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        Guerreiro guerreiro = new Guerreiro("Guerreiro", 10, 5, 3, 15, 5, telaJogo, keyH);
        Feiticeira feiticeira = new Feiticeira("Feiticeira", 10, 100, 0, 100, 1, telaJogo, keyH);
        Esqueleto esqueleto = new Esqueleto("Esqueleto", 10, 5, 3, 100, 1, telaJogo, keyH);



        //paineis
        MainMenuPanel menu = new MainMenuPanel(this);
        //OptionsPanel options = new OptionsPanel();
        TelaBatalha batalha = new TelaBatalha(this, guerreiro, feiticeira,esqueleto);
        EscolhaPersonagemPanel escolha = new EscolhaPersonagemPanel(this);

        //adicionando os paineis ao CardLayout
        cards.add(telaJogo, "Jogo");
        cards.add(menu, "Menu");
        //cards.add(options, "Opcoes");
        cards.add(batalha, "Batalha");
        cards.add(escolha,"Escolha");

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
    public void showPanel(String panelName) {
        cardLayout.show(cards, panelName);
    }
    

    public Tela getTela() {
        return telaJogo;
    }
}