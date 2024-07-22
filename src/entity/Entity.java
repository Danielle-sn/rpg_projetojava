package entity;

import Telas.Tela;
import main.Utils;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException; //bia tirou
import java.util.Objects; //bia tirou

public class Entity {
    Tela tj;

    public int worldX,worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1 ;
    public Rectangle solidArea = new Rectangle(0,0,48,48);// area de colisao do jogador
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    public  Entity(Tela tj){
        this.tj = tj;
    }


    // ATRIBUTOS DE ENTITY
    private String nome;
    private int forca;
    private int agilidade;
    private int dexterity;
    private int ataque;
    private int nivel;
    private int saude;
    private int exp;
    private int nextLevelExp;
    private int currentWeapon;
    KeyHandler keyH;


    public Entity(String nome, int forca, int agilidade, int dexterity, int ataque, int nivel, int saude, int exp, int nextLevelExp, int currentWeapon, Tela tj, KeyHandler keyH) {
        this.nome = nome;
        this.forca = forca;
        this.agilidade = agilidade;
        this.dexterity = dexterity;
        this.ataque = ataque;
        this.nivel = nivel;
        this.saude = saude;
        this.exp = exp;
        this.nextLevelExp = nextLevelExp;
        this.currentWeapon = currentWeapon;
        this.tj = tj;
        this.keyH = keyH;
    }

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

    //public abstract void habilidadeEspecial();


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

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAtaque() {
        return ataque;
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

    public int getNextLevelExp() {
        return nextLevelExp;
    }

    public void setNextLevelExp(int nextLevelExp) {
        this.nextLevelExp = nextLevelExp;
    }

    public int getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(int currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


// tirar daqui
    public void setAction(){ }

    public void update() {
        setAction();
        collisionOn = false;
        tj.checandoColisao.checarTile(this);
        tj.checandoColisao.checarItem(this, false);
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
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX = worldX - tj.guerreiro.worldX + tj.guerreiro.screenX; // tirar a diferença entre as coordenadas da tela e do mapa
        int screenY = worldY - tj.guerreiro.worldY + tj.guerreiro.screenY;

        if(worldX + tj.tileSize > tj.guerreiro.worldX - tj.guerreiro.screenX &&
                worldX - tj.tileSize < tj.guerreiro.worldX + tj.guerreiro.screenX &&
                worldY  + tj.tileSize > tj.guerreiro.worldY - tj.guerreiro.screenY &&
                worldY - tj.tileSize< tj.guerreiro.worldY + tj.guerreiro.screenY) {
            switch(direction){
                case "up":
                    if (spriteNum == 1){
                        image = up1;
                    }
                    if (spriteNum == 2 ){
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1){
                        image = down1;
                    }
                    if (spriteNum == 2){
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1){
                        image = left1;
                    }
                    if (spriteNum == 2){
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1){
                        image = right1;
                    }
                    if (spriteNum == 2){
                        image = right2;
                    }
                    break;

            }
        }
            g2.drawImage(image, screenX, screenY, tj.tileSize, tj.tileSize, null);
    }

    public BufferedImage configImagem(String imagePath){
        Utils ut = new Utils();
        BufferedImage image = null;

        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath + ".png")));
            image = ut.scaleImage(image, tj.tileSize,tj.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
