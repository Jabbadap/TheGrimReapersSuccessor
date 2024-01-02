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

    // Set default variables
    public int worldX, worldY;
    public int speed;
    public BufferedImage Up1, Up2, Down1, Down2, Left1, Left2, Right1, Right2;
    public String direction;

    // Standard variables
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {

    }

    public void update() {
        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(!collisionOn) {
            switch (direction) {
                case "Up" -> worldY -= speed;
                case "Down" -> worldY += speed;
                case "Left" -> worldX -= speed;
                case "Right" -> worldX += speed;
            }
        }

        // Loop animatie
        spriteCounter++;
        if(spriteCounter > 12) {
            if(spriteNumber == 1) {
                spriteNumber = 2;
            } else if(spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
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
                    if (spriteNumber == 1) {
                        image = Up1;
                    }
                    if (spriteNumber == 2) {
                        image = Up2;
                    }
                }
                case "Down" -> {
                    if (spriteNumber == 1) {
                        image = Down1;
                    }
                    if (spriteNumber == 2) {
                        image = Down2;
                    }
                }
                case "Left" -> {
                    if (spriteNumber == 1) {
                        image = Left1;
                    }
                    if (spriteNumber == 2) {
                        image = Left2;
                    }
                }
                case "Right" -> {
                    if (spriteNumber == 1) {
                        image = Right1;
                    }
                    if (spriteNumber == 2) {
                        image = Right2;
                    }
                }
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }

    public BufferedImage setup(String imagePath) {
        // Reading the images
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + ".png")));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
