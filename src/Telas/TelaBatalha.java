package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class TelaBatalha extends JPanel {
    private GameFrame gameFrame;
    private BufferedImage guerreiroImage;
    private BufferedImage esqueletoImage;
    private int gridSize = 50;

    private JLabel guerreiroVidaLabel;
    private JLabel esqueletoVidaLabel;

    public TelaBatalha(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout()); // BorderLayout: north, south, east, west, center

        JLabel titulo = new JLabel("Tela Batalha", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);


        // Mais um painel para organizar o centro da batalha
       /*JPanel gridPanel = new JPanel(new GridLayout(10, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int rows = 10;
                int cols = 10;
                int width = getWidth();
                int height = getHeight();
                int cellWidth = width / cols;
                int cellHeight = height / rows;

                // bordas horizontais
                g2d.setColor(Color.white);
                for (int i = 0; i <= rows; i++) {
                    g2d.drawLine(0, i * cellHeight, width, i * cellHeight);
                }

                // bordas verticais
                for (int i = 0; i <= cols; i++) {
                    g2d.drawLine(i * cellWidth, 0, i * cellWidth, height);
                }
            }
        };

        gridPanel.setBackground(Color.BLACK);
        add(gridPanel, BorderLayout.CENTER);*/

       // JPanel buttonsGrid = new JPanel(new GridLayout(1, 2));
        JPanel buttonsGrid = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 38));
        buttonsGrid.setPreferredSize(new Dimension(0, 150));

        buttonsGrid.setBackground(Color.BLACK);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 6);
        buttonsGrid.setBorder(border);

        JButton inventarioButton = new JButton("Inventário");
        inventarioButton.setPreferredSize(new Dimension(200, 70));
        inventarioButton.setBackground(Color.WHITE);
        inventarioButton.setOpaque(true);
        inventarioButton.setBorderPainted(true);
        Border inventarioButtonBorder = BorderFactory.createLineBorder(Color.WHITE, 4);
        inventarioButton.setBorder(inventarioButtonBorder);
        inventarioButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        inventarioButton.setForeground(Color.BLACK);

        JButton atacarButton = new JButton("ATACAR");
        atacarButton.setPreferredSize(new Dimension(450, 70));
        atacarButton.setBackground(Color.WHITE);
        atacarButton.setOpaque(true);
        atacarButton.setBorderPainted(true);
        Border atacarButtonBorder = BorderFactory.createLineBorder(Color.RED, 4); // Cor vermelha e espessura 4
        atacarButton.setBorder(atacarButtonBorder);
        atacarButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        atacarButton.setForeground(Color.BLACK);

        inventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventarioButton.setBackground(Color.BLACK);
                inventarioButton.setForeground(Color.WHITE);
            }
        });

        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atacarButton.setBackground(Color.RED);
                atacarButton.setForeground(Color.WHITE);

            }
        });


        buttonsGrid.add(inventarioButton);
        buttonsGrid.add(atacarButton); // Adicionar o botão de defender aqui

        add(buttonsGrid, BorderLayout.SOUTH);

        guerreiroVidaLabel = new JLabel("Hp Guerreiro: 100");
        esqueletoVidaLabel = new JLabel("Hp esqueleto: 100");

        JPanel valoresPanel = new JPanel();
        valoresPanel.setLayout(new GridLayout(2,1));
        valoresPanel.add(guerreiroVidaLabel);
        valoresPanel.add(esqueletoVidaLabel);
        add(valoresPanel, BorderLayout.EAST);

        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualiza os valores de vida (exemplo)
                guerreiroVidaLabel.setText("Vida do Guerreiro: " + (int) (Math.random() * 100));
                esqueletoVidaLabel.setText("Vida do Esqueleto: " + (int) (Math.random() * 100));
            }
        });





        // Carregar imagens
        try {
            System.out.println("Entrou no try");
            guerreiroImage = ImageIO.read(getClass().getResourceAsStream("/Guerreiro/Teste_guerreiro.png"));
            esqueletoImage = ImageIO.read(getClass().getResourceAsStream("/Esqueleto/Big_Skeleton.png"));
            repaint();
            if (guerreiroImage == null) {
                System.out.println("Imagem do guerreiro não encontrada! Verifique o caminho.");
            } else {
                System.out.println("Imagem do guerreiro carregada com sucesso.");
            }

            if (esqueletoImage == null) {
                System.out.println("Imagem do esqueleto não encontrada! Verifique o caminho.");
            } else {
                System.out.println("Imagem do esqueleto carregada com sucesso.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        System.out.println("Entrou no paint");

        /*g2d.setColor(Color.RED); // Define a cor do retângulo
        g2d.fillRect(50, 50, 100, 50); // Desenha um retângulo preenchido (x, y, largura, altura)

        // Desenho de um círculo
        g2d.setColor(Color.BLUE); // Define a cor do círculo
        g2d.fillOval(200, 50, 100, 100);*/
        // Desenhar o guerreiro na posição desejada

        // Desenhar o grid
        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.WHITE); // Cor das linhas do grid
        for (int x = 0; x < width; x += gridSize) {
            g2d.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += gridSize) {
            g2d.drawLine(0, y, width, y);
        }

        Font  font = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
        g2d.setFont(font);

        //espessura da borda
        g2d.setStroke(new BasicStroke(4));
        // Desenhar retângulo e texto para Guerreiro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(150, 70, 150, 60); // Desenha o retângulo (x, y, largura, altura)
        g2d.setColor(Color.WHITE);
        g2d.drawRect(150, 70, 150, 60);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Guerreiro", 180, 105); // Desenha o texto (texto, x, y)

        // Desenhar retângulo e texto para Esqueleto
        g2d.setColor(Color.BLACK);
        g2d.fillRect(450, 70, 150, 60); // Desenha o retângulo (x, y, largura, altura)
        g2d.setColor(Color.WHITE);
        g2d.drawRect(450, 70, 150, 60);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Esqueleto", 480, 105); // Desenha o texto (texto, x, y)

        //Retangulo do X
        g2d.setColor(Color.BLACK);
        g2d.fillRect(350, 70, 51, 60); // Desenha o retângulo (x, y, largura, altura)
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(350, 70, 51, 60);
        g2d.setColor(Color.WHITE);
        g2d.drawString("VS", 363, 105); // Desenha o texto (texto, x, y)

        if (guerreiroImage != null) {
            int guerreiroX = 100; // ajuste a posição X
            int guerreiroY = 100; // ajuste a posição Y
            g2d.drawImage(guerreiroImage, guerreiroX, guerreiroY, null);
        }

        // Desenhar o esqueleto na posição desejada
        if (esqueletoImage != null) {
            int esqueletoX = 400; // ajuste a posição X
            int esqueletoY = 100; // ajuste a posição Y
            g2d.drawImage(esqueletoImage, esqueletoX, esqueletoY, null);
        }
    }
}
