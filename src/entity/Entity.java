package entity;

import Telas.Tela;
import main.KeyHandler;
import main.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Entity {
    Tela tj;

    public int worldX, worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);// area de colisao do jogador
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    String[] dialogues = new String[20];

    // ATRIBUTOS DE ENTITY
    protected String nome;
    protected int forca;
    protected int agilidade;
    protected int dexterity;
    protected int ataque;
    protected int nivel;
    protected int saude;
    protected int exp;
    protected int nextLevelExp;
    protected int currentWeapon;
    KeyHandler keyH;

    public void exibirAtributos(){
        System.out.println("Nome: " + nome);
        System.out.println("Força: " + forca);
        System.out.println("Agilidade: " + agilidade);
        System.out.println("Defesa: " + dexterity);
        System.out.println("Ataque: " + ataque);
        System.out.println("Nível: " + nivel);
        System.out.println("Saúde: " + saude);
        System.out.println("Experiencia: " + exp);
        System.out.println("Next level exp: " + nivel);
        System.out.println("arma atual: " + currentWeapon);
    }
    public Entity(String nome, int forca, int dexterity, int ataque, int saude, int exp, Tela tj, KeyHandler keyH) {

        this.nome = nome;
        this.forca = forca;
        this.dexterity = dexterity;
        this.ataque = ataque;
        this.saude = saude;
        this.exp = exp;
        this.tj = tj;
        this.keyH = keyH;
    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public int getAtaque() {
        return ataque = forca * ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getSaude() {
        return saude;
    }
    public void setSaude(int saude) {
        this.saude = saude;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    public void receberDano(int dano) {
        this.saude -= dano;
        if (this.saude < 0) {
            this.saude = 0;
        }
    }

    public int nivelDeAtaque(){
        if(nivel == 1){
            ataque = ataque *1;
        }
        else if (nivel == 2) {
            ataque = ataque * 3;
        }
        else if (nivel == 3) {
            ataque = ataque * 5;
        }
        else{
            ataque = ataque * 1;
        }
        return ataque;
    }


    public Entity(Tela tj) {
        this.tj = tj;
    }

    public void speak(){ }

    //public void setAction(){ }

    public void update() {
        setAction();
        collisionOn = false;
        tj.checandoColisao.checarTile(this);
        tj.checandoColisao.checarItem(this, false);
        tj.checandoColisao.checarEntity(this, tj.npc); //checando entre entidades
        tj.checandoColisao.checarEntity(this, tj.esqueleto);
        tj.checandoColisao.checarJogador(this);


        // se colisão é falsa, npc pode se mover
        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - tj.guerreiro.worldX + tj.guerreiro.screenX; // tirar a diferença entre as coordenadas da tela e do mapa
        int screenY = worldY - tj.guerreiro.worldY + tj.guerreiro.screenY;

        if (worldX + tj.tileSize > tj.guerreiro.worldX - tj.guerreiro.screenX &&
                worldX - tj.tileSize < tj.guerreiro.worldX + tj.guerreiro.screenX &&
                worldY + tj.tileSize > tj.guerreiro.worldY - tj.guerreiro.screenY &&
                worldY - tj.tileSize < tj.guerreiro.worldY + tj.guerreiro.screenY) {
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    break;

            }
        }
        g2.drawImage(image, screenX, screenY, tj.tileSize, tj.tileSize, null);
    }

    public BufferedImage configImagem(String imagePath) {
        Utils ut = new Utils();
        BufferedImage image = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath + ".png")));
            image = ut.scaleImage(image, tj.tileSize, tj.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void setAction() {
        actionLockCounter++;
        //ajuste para o npc ele se mover dentro de dois 2s //ficar mais devegar
        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // numero de 1 a 100

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75) {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }


}
