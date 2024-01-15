package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {

    GamePanel gp;

    public BufferedImage Up1, Up2, Down1, Down2, Left1, Left2, Right1, Right2;
    public BufferedImage AttackU1, AttackU2, AttackD1, AttackD2,
            AttackL1, AttackL2, AttackR1, AttackR2;
    public BufferedImage image, image2, image3;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    String dialogues[] = new String[40];

    // STATE
    public int worldX, worldY;
    public String direction = "Down";
    public int spriteNumber = 1;
    int dialogueIndex = 0;
    public boolean collisionOn = false;
    public boolean invincible = false;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    boolean hpBarOn = false;

    // COUNTER
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;
    int dyingCounter = 0;
    int hpBarCounter = 0;

    // CHARACTER ATTRIBUTES
    public String name;
    public int type;
    public int speed;
    public int maxLife;
    public int life;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {}

    public void damageReaction() {}

    public void speak() {
        if(dialogues[dialogueIndex] == null) {
            dialogueIndex = 0; }

        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        if (dialogueIndex == 21) {
            gp.player.hasKeyG++;
            gp.ui.showMessage("You got a key!"); }

        switch (gp.player.direction) {
            case "Up" -> direction = "Down";
            case "Down" -> direction = "Up";
            case "Left" -> direction = "Right";
            case "Right" -> direction = "Left"; } }

    public void update() {
        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == 2 && contactPlayer) {
            if(!gp.player.invincible) {
                gp.player.life -= 1;
                gp.player.invincible = true;
            }
        }

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(!collisionOn) {
            switch (direction) {
                case "Up" -> worldY -= speed;
                case "Down" -> worldY += speed;
                case "Left" -> worldX -= speed;
                case "Right" -> worldX += speed; } }

        // Loop animatie
        spriteCounter++;
        if(spriteCounter > 12) {
            if(spriteNumber == 1) { spriteNumber = 2; }
            else if(spriteNumber == 2) { spriteNumber = 1; }
            spriteCounter = 0;
        }
        if(invincible) {
            invincibleCounter++;
            if(invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (direction) {
                case "Up" -> {
                    if (spriteNumber == 1) { image = Up1; }
                    if (spriteNumber == 2) { image = Up2; } }
                case "Down" -> {
                    if (spriteNumber == 1) { image = Down1; }
                    if (spriteNumber == 2) { image = Down2; } }
                case "Left" -> {
                    if (spriteNumber == 1) { image = Left1; }
                    if (spriteNumber == 2) { image = Left2; } }
                case "Right" -> {
                    if (spriteNumber == 1) { image = Right1; }
                    if (spriteNumber == 2) { image = Right2; } }
            }

            // Monster HP bar
            if(type == 2 && hpBarOn) {

                double oneScale = (double)gp.tileSize/maxLife;
                double hpBarValue = oneScale*life;

                g2.setColor(new Color(35,35,35));
                g2.fillRect(screenX-1, screenY-16, gp.tileSize+2,12);

                g2.setColor(new Color(255,0,30));
                g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);

                hpBarCounter++;

                if(hpBarCounter > 600) {
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }
            if(invincible) {
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4f);
            }
            if(dying) {
                dyingAnimation(g2);
            }

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            changeAlpha(g2, 1f);
        }
    }

    public void dyingAnimation(Graphics2D g2) {
        dyingCounter++;

        int i = 5;

        if(dyingCounter <= i) { changeAlpha(g2, 0f); }
        if(dyingCounter > i && dyingCounter <= i*2) { changeAlpha(g2, 1f); }
        if(dyingCounter > i*2 && dyingCounter <= i*3) { changeAlpha(g2, 0f); }
        if(dyingCounter > i*3 && dyingCounter <= i*4) { changeAlpha(g2, 1f); }
        if(dyingCounter > i*4 && dyingCounter <= i*5) { changeAlpha(g2, 0f); }
        if(dyingCounter > i*5 && dyingCounter <= i*6) { changeAlpha(g2, 1f); }
        if(dyingCounter > i*6 && dyingCounter <= i*7) { changeAlpha(g2, 0f); }
        if(dyingCounter > i*7 && dyingCounter <= i*8) { changeAlpha(g2, 1f); }
        if(dyingCounter > i*8) { dying = false;alive = false; }
    }

    public void changeAlpha(Graphics2D g2, float alphaValue) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }

    public BufferedImage setup(String imagePath, int width, int height) {
        // Reading the images
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + ".png")));
            image = uTool.scaleImage(image, width, height); }
        catch(IOException e) {
            e.printStackTrace(); }

        return image; }
}
