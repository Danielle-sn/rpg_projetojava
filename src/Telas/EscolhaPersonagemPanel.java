package Telas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class EscolhaPersonagemPanel extends JPanel {

    private GameFrame gameFrame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel messageLabel;

    private BufferedImage guerreiroImage;
    private BufferedImage feiticeiraImage;
    private String selectedCharacter;


    public EscolhaPersonagemPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout()); //BorderLayout: north, south, east, west, center


        JLabel titulo = new JLabel("Escolha de Personagem", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        messageLabel = new JLabel("Mensagem: ", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);


        try {
            System.out.println("Entrou no try");
            guerreiroImage = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/Teste_guerreiro.png"));
            feiticeiraImage = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Alchemist_down1.png"));

            if (guerreiroImage == null) {
                System.out.println("Imagem do guerreiro não encontrada dentro da escolha! Verifique o caminho.");
            } else {
                System.out.println("Imagem do guerreiro carregada com sucesso dentro da escolha.");
            }
            if (feiticeiraImage == null) {
                System.out.println("Imagem da feiticeira  não encontrada dentro da escolha! Verifique o caminho.");
            } else {
                System.out.println("Imagem da feiticeira carregada com sucesso dentro da escolha.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        // CARD 1 ---- GUERREIRO
        JPanel cardGuerreiro = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Desenhar a imagem do guerreiro
                if (guerreiroImage != null) {
                    int guerreiroX = 10; // Ajuste a posição X
                    int guerreiroY = 50; // Ajuste a posição Y
                    int imgWidth = guerreiroImage.getWidth();
                    int imgHeight = guerreiroImage.getHeight();

                    System.out.println("Desenhando a imagem do guerreiro: " + imgWidth + "x" + imgHeight);

                    // Ajusta o tamanho da imagem se necessário
                    if (imgWidth > getWidth()) {
                        imgWidth = getWidth();
                    }
                    if (imgHeight > getHeight()) {
                        imgHeight = getHeight();
                    }

                    g2d.drawImage(guerreiroImage, guerreiroX, guerreiroY, imgWidth, imgHeight, this);
                } else {
                    System.out.println("Imagem do guerreiro é nula.");
                }

                // Desenhar um retângulo
                int rectX = getWidth() - 210; // Ajuste a posição X
                int rectY = 50; // Ajuste a posição Y
                int rectWidth = 200;
                int rectHeight = 300;
                g2d.setColor(Color.BLUE);
                g2d.fillRect(rectX, rectY, rectWidth, rectHeight);
            }
        };
        cardGuerreiro.setBackground(Color.GREEN); // Defina a cor de fundo para o card do guerreiro
        cardGuerreiro.setPreferredSize(new Dimension(800, 600)); // Ajuste o tamanho do card conforme necessário


        // CARD 2 ---- FEITICEIRA
        JPanel cardFeiticeira = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Desenhar a imagem do guerreiro
                if (feiticeiraImage != null) {
                    int guerreiroX = 10; // Ajuste a posição X
                    int guerreiroY = 50; // Ajuste a posição Y
                    int imgWidth = feiticeiraImage.getWidth();
                    int imgHeight = feiticeiraImage.getHeight();

                    System.out.println("Desenhando a imagem do guerreiro: " + imgWidth + "x" + imgHeight);

                    // Ajusta o tamanho da imagem se necessário
                    if (imgWidth > getWidth()) {
                        imgWidth = getWidth();
                    }
                    if (imgHeight > getHeight()) {
                        imgHeight = getHeight();
                    }

                    g2d.drawImage(feiticeiraImage, guerreiroX, guerreiroY, imgWidth, imgHeight, this);
                } else {
                    System.out.println("Imagem do guerreiro é nula.");
                }

                // Desenhar um retângulo
                int rectX = getWidth() - 210; // Ajuste a posição X
                int rectY = 50; // Ajuste a posição Y
                int rectWidth = 200;
                int rectHeight = 300;
                g2d.setColor(Color.BLUE);
                g2d.fillRect(rectX, rectY, rectWidth, rectHeight);
            }
        };
        cardGuerreiro.setBackground(Color.GREEN); // Defina a cor de fundo para o card do guerreiro
        cardGuerreiro.setPreferredSize(new Dimension(800, 600)); // Ajuste o tamanho do card conforme necessário



        mainPanel.add(cardGuerreiro, "Guerreiro");
        mainPanel.add(cardFeiticeira, "Feiticeira");

        // Controles para mudar de card
        JPanel controlCardsButton = new JPanel(new GridLayout(2, 2));

        JButton menuButton = new JButton("Voltar ao Menu");
        controlCardsButton.add(menuButton);


        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.showPanel("Menu"); // Altera para o painel do menu
            }
        });


        /*JButton selectButton = new JButton("Selecionar Personagem");
        controlCardsButton.add(selectButton);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Personagem Selecionado");
                messageLabel.setPreferredSize(new Dimension (300,100));
            }
        });*/
        JButton selectGuerreiroButton = new JButton("Selecionar Guerreiro");
        selectGuerreiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCharacter = "Guerreiro";
                cardLayout.show(mainPanel, "Guerreiro");
                messageLabel.setText("Guerreiro Selecionado");
                messageLabel.setPreferredSize(new Dimension (300,100));
            }
        });
        controlCardsButton.add(selectGuerreiroButton);

        JButton selectFeiticeiraButton = new JButton("Selecionar Feiticeira");
        selectFeiticeiraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCharacter = "Feiticeira";
                cardLayout.show(mainPanel, "Feiticeira");
                messageLabel.setText("Feiticeira Selecionada");
                messageLabel.setPreferredSize(new Dimension (300,100));
            }
        });
        controlCardsButton.add(selectFeiticeiraButton);




    JButton prevButton = new JButton("Anterior");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(mainPanel);
            }
        });
        controlCardsButton.add(prevButton);

        JButton nextButton = new JButton("Próximo");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(mainPanel);
            }
        });
        controlCardsButton.add(nextButton);

        add(controlCardsButton, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);

    }


    private JPanel createCard(String name, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel(name));
        return panel;


    }

    JPanel drawingPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            System.out.println("Entrou no paint");

            // Desenhar a imagem do guerreiro
            if (guerreiroImage != null) {
                int guerreiroX = 10; // Ajuste a posição X
                int guerreiroY = 50; // Ajuste a posição Y
                g2d.drawImage(guerreiroImage, guerreiroX, guerreiroY, this);
            }

            // Desenhar um retângulo do outro lado
            int rectX = getWidth() - 210; // Ajuste a posição X
            int rectY = 50; // Ajuste a posição Y
            int rectWidth = 200;
            int rectHeight = 300;
            g2d.setColor(Color.BLUE);
            g2d.fillRect(rectX, rectY, rectWidth, rectHeight);

            drawingPanel.setPreferredSize(new Dimension(300, 600)); // Ajuste o tamanho conforme necessário

            add(drawingPanel, BorderLayout.WEST); // Adiciona o painel de desenho ao lado dos cards
            //add(controlCardsButton, BorderLayout.SOUTH);
            add(mainPanel, BorderLayout.CENTER);
        }
    };

}