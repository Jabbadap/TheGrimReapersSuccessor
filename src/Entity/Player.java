package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    /*
    Class van het personage dat gespeeld wordt door de gebruiker
     */

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    // Objecten die de speler heeft kan verbeterd worden
    public int hasKeyG = 0;
    public int hasKeyY = 0;
    public int hasKeyB = 0;
    public int hasKeyR = 0;
    public int coins = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);

        this.keyH = keyH;

        // Player size
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        // Solid area values
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
        /*
        Default waardes
         - worldX, worldY = Begin positie op de map
         - speed = Standaard loop snelheid
         - direction = Begin direction
         */

        worldX = gp.tileSize * 37;
        worldY = gp.tileSize * 49;

        speed = 4;
        direction = "Down";
    }

    public void getPlayerImage() {
        // Getting the right image for the right movement
        Up1 = setup("player/Up1");
        Up2 = setup("player/Up2");
        Down1 = setup("player/Down1");
        Down2 = setup("player/Down2");
        Left1 = setup("player/Left1");
        Left2 = setup("player/Left2");
        Right1 = setup("player/Right1");
        Right2 = setup("player/Right2");
    }

    public void update() {
        // Getting the right image for the right direction
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
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

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
    }

    public void pickUpObject(int index) {
        // Het oppakken van objecten
        if(index != 999) {

            // To delete
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
                case "DoorG":
                    if(hasKeyG > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyG--;
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
                    if(hasKeyR > 0) {
                        gp.obj[index] = null;
                        coins = 100;
                        gp.ui.showMessage("You opened the chest! You received " + coins + " coins");
                        hasKeyR--;
                        gp.ui.gameFinished = true;
                    }
                    else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
            }
        }
    }

    public void interactNPC(int i) {
        if(i != 999) {
            if(gp.keyH.enterPressed) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.keyH.enterPressed = false;
    }

    public void draw(Graphics2D g2) {
        // Rendering the right image
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
