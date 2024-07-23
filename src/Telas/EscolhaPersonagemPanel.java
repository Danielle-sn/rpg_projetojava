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

    Color brown = new Color(82, 37, 0);
    Color lightBrown = new Color(195, 142, 112);
    Color lightOrange = new Color(218, 126, 55);
    Color purple = new Color(83, 55, 69);
    Color lightPink = new Color(219, 168, 172);
    Color green1 = new Color(64, 145, 108);



    public EscolhaPersonagemPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout()); //BorderLayout: north, south, east, west, center


        Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        JLabel titulo = new JLabel("Escolha de Personagem", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setOpaque(true);
        messageLabel.setFont(titleFont);
        add(messageLabel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);


        try {
            //System.out.println("Entrou no try");
            guerreiroImage = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/Big_guerreiro2.png"));
            feiticeiraImage = ImageIO.read(getClass().getResourceAsStream("/Feiticeira/Big_alchemist.png"));

            /*if (guerreiroImage == null) {
                System.out.println("Imagem do guerreiro não encontrada dentro da escolha! Verifique o caminho.");
            } else {
                System.out.println("Imagem do guerreiro carregada com sucesso dentro da escolha.");
            }
            if (feiticeiraImage == null) {
                System.out.println("Imagem da feiticeira  não encontrada dentro da escolha! Verifique o caminho.");
            } else {
                System.out.println("Imagem da feiticeira carregada com sucesso dentro da escolha.");
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }


        // CARD 1 ---- GUERREIRO
        JPanel cardGuerreiro = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Desenha a imagem do guerreiro
                if (guerreiroImage != null) {
                    int guerreiroX = 60;
                    int guerreiroY = 160;
                    int imgWidth = guerreiroImage.getWidth();
                    int imgHeight = guerreiroImage.getHeight();

                    System.out.println("Desenhando a imagem do guerreiro: " + imgWidth + "x" + imgHeight);


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

                Font  font = new Font(Font.SANS_SERIF,  Font.BOLD, 30);
                g2d.setFont(font);

                // retângulo
                int rectX = getWidth() - 370;
                int rectY = 50;
                int rectWidth = 350;
                int rectHeight = 500;
                g2d.setColor(brown);
                g2d.fillRect(rectX, rectY, rectWidth, rectHeight);
                g2d.setColor(Color.WHITE);
                g2d.drawString("Guerreiro", 540 , 105);


                Font descriptionFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
                g2d.setFont(descriptionFont);

                // Desenhar o texto de descrição linha por linha
                String[] descriptionLines = {
                        "Guerreiros são mestres em",
                        "combate corpo a corpo.",
                        "",
                        "Nome: Chris",
                        "",
                        "Agilidade: 2",
                        "",
                        "Força: 5",
                        "",
                        "Defesa: 3"
                };

                int lineHeight = g2d.getFontMetrics().getHeight();
                int textY =  175; // Posição Y inicial para o texto de descrição

                for (String line : descriptionLines) {
                    g2d.drawString(line, 480, textY);
                    textY += lineHeight;
                }
            }
        };

        cardGuerreiro.setBackground(lightBrown);
        cardGuerreiro.setPreferredSize(new Dimension(800, 600));


        // CARD 2 ---- FEITICEIRA
        JPanel cardFeiticeira = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Desenha a imagem do guerreiro
                if (feiticeiraImage != null) {
                    int guerreiroX = 60;
                    int guerreiroY = 160;
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

                Font  font = new Font(Font.SANS_SERIF,  Font.BOLD, 30);
                g2d.setFont(font);

                // Desenha um retângulo
                int rectX = getWidth() - 390;
                int rectY = 50;
                int rectWidth = 350;
                int rectHeight = 500;
                g2d.setColor(purple);
                g2d.fillRect(rectX, rectY, rectWidth, rectHeight);
                g2d.setColor(Color.WHITE);
                g2d.drawString("Feiticeira", 520 , 105);

                // Configura a fonte para o texto de descrição
                Font descriptionFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
                g2d.setFont(descriptionFont);

                // Desenha o texto de descrição linha por linha
                String[] descriptionLines = {
                        "Feiticeiras são poderosas",
                        "em magia e feitiçaria. Isso ",
                        "lhe traz uma grande defesa",
                        "",
                        "Nome: Lyra",
                        "",
                        "Agilidade: 4",
                        "",
                        "Força: 3",
                        "",
                        "Defesa: 5"
                };

                int lineHeight = g2d.getFontMetrics().getHeight();
                int textY =  175; // Posição Y inicial para o texto de descrição

                for (String line : descriptionLines) {
                    g2d.drawString(line, 470, textY);
                    textY += lineHeight;
                }

            }
        };
        cardFeiticeira.setBackground(lightBrown);
        cardFeiticeira.setPreferredSize(new Dimension(800, 600));



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
                messageLabel.setBackground(green1);
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setText("Guerreiro Selecionado");
                messageLabel.setPreferredSize(new Dimension (300,100));
                selectedCharacter = "Guerreiro";
                gameFrame.getTela().setSelectedCharacter("Guerreiro");
            }
        });
        controlCardsButton.add(selectGuerreiroButton);

        JButton selectFeiticeiraButton = new JButton("Selecionar Feiticeira");
        selectFeiticeiraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCharacter = "Feiticeira";
                cardLayout.show(mainPanel, "Feiticeira");
                messageLabel.setBackground(green1);
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setText("Feiticeira Selecionada");
                messageLabel.setPreferredSize(new Dimension (300,100));
                selectedCharacter = "Feiticeira";
                gameFrame.getTela().setSelectedCharacter("Feiticeira");

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

            // imagem do guerreiro
            if (guerreiroImage != null) {
                int guerreiroX = 10;
                int guerreiroY = 50;
                g2d.drawImage(guerreiroImage, guerreiroX, guerreiroY, this);
            }

            // retângulo do outro lado
            int rectX = getWidth() - 210;
            int rectY = 50;
            int rectWidth = 200;
            int rectHeight = 300;
            g2d.setColor(Color.BLUE);
            g2d.fillRect(rectX, rectY, rectWidth, rectHeight);

            drawingPanel.setPreferredSize(new Dimension(300, 600));

            add(drawingPanel, BorderLayout.WEST); // Adiciona o painel de desenho ao lado dos cards
            //add(controlCardsButton, BorderLayout.SOUTH);
            add(mainPanel, BorderLayout.CENTER);
        }
    };

}
