package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKeyR = 0;
    public int hasKeyY = 0;
    public int hasKeyB = 0;
    public int hasKey = 0;
    public int coins = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 15;
        solidArea.y = 21;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 18;
        solidArea.height = 27;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 33;
        worldY = gp.tileSize * 44;

        speed = 4;
        direction = "Down";
    }

    public void getPlayerImage() {
        Up1 = setup("Up1");
        Up2 = setup("Up2");
        Down1 = setup("Down1");
        Down2 = setup("Down2");
        Left1 = setup("Left1");
        Left2 = setup("Left2");
        Right1 = setup("Right1");
        Right2 = setup("Right2");
    }

    public BufferedImage setup(String imageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if(keyH.upPressed) {
                direction = "Up";
            } else if(keyH.downPressed) {
                direction = "Down";
            } else if(keyH.leftPressed) {
                direction = "Left";
            } else if(keyH.rightPressed) {
                direction = "Right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.CheckObject(this, true);
            pickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(!collisionOn) {
                switch (direction) {
                    case "Up" -> worldY -= speed;
                    case "Down" -> worldY += speed;
                    case "Left" -> worldX -= speed;
                    case "Right" -> worldX += speed;
                }
            }

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
    }

    public void pickUpObject(int index) {
        if(index != 999) {
            String objectName = gp.obj[index].name;

            switch (objectName) {
                case "KeyR":
                    hasKeyR++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "KeyY":
                    hasKeyY++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "KeyB":
                    hasKeyB++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "DoorR":
                    if(hasKeyR > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyR--;
                    }
                    else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "DoorY":
                    if(hasKeyY > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyY--;
                    }
                    else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "DoorB":
                    if(hasKeyB > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyB--;
                    }
                    else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "Chest":
                    if(hasKey > 0) {
                        gp.obj[index] = null;
                        coins = 100;
                        gp.ui.showMessage("You opened the chest! You received " + coins + " coins");
                        hasKey--;
                        gp.ui.gameFinished = true;
                    }
                    else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "Key":
                    gp.obj[index] = null;
                    hasKey++;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

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

        g2.drawImage(image, screenX, screenY,null);
    }
}
