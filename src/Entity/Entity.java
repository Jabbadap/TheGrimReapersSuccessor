package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

    public Entity(GamePanel gp) {
        this.gp = gp;
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
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
