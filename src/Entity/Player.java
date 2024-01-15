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

        attackArea.width = 36;
        attackArea.height = 36;


        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();}

    public void setDefaultValues() {
        /*
        Default waardes
         - worldX, worldY = Begin positie op de map
         - speed = Standaard loop snelheid
         - direction = Begin direction
         */

        worldX = gp.tileSize * 38;
        worldY = gp.tileSize * 50;

        speed = 4;
        direction = "Down";

        // PLAYER STATUS
        maxLife = 6;
        life = maxLife;
    }

    public void setDefaultPositions() {
        worldX = gp.tileSize * 38;
        worldY = gp.tileSize * 50;
        direction = "Down";
    }

    public void restoreLifeAndMana() {
        life = maxLife;
        // mana = maxMana;
        invincible = false;
    }

    // Later video 37 terugkijken voor inventory clear
    public void resetItems() {
        hasKeyG = 0;
        hasKeyY = 0;
        hasKeyB = 0;
        hasKeyR = 0;
    }

    public void getPlayerImage() {
        // Getting the right image for the right movement
        Up1 = setup("player/Up1", gp.tileSize, gp.tileSize);
        Up2 = setup("player/Up2", gp.tileSize, gp.tileSize);
        Down1 = setup("player/Down1", gp.tileSize, gp.tileSize);
        Down2 = setup("player/Down2", gp.tileSize, gp.tileSize);
        Left1 = setup("player/Left1", gp.tileSize, gp.tileSize);
        Left2 = setup("player/Left2", gp.tileSize, gp.tileSize);
        Right1 = setup("player/Right1", gp.tileSize, gp.tileSize);
        Right2 = setup("player/Right2", gp.tileSize, gp.tileSize); }

    public void getPlayerAttackImage() {
        // Getting the right image for the right movement
        AttackU1 = setup("player/AttackU1", gp.tileSize, gp.tileSize*2);
        AttackU2 = setup("player/AttackU2", gp.tileSize, gp.tileSize*2);
        AttackD1 = setup("player/AttackD1", gp.tileSize, gp.tileSize*2);
        AttackD2 = setup("player/AttackD2", gp.tileSize, gp.tileSize*2);
        AttackL1 = setup("player/AttackL1", gp.tileSize*2, gp.tileSize);
        AttackL2 = setup("player/AttackL2", gp.tileSize*2, gp.tileSize);
        AttackR1 = setup("player/AttackR1", gp.tileSize*2, gp.tileSize);
        AttackR2 = setup("player/AttackR2", gp.tileSize*2, gp.tileSize); }

    public void update() {

        if(attacking) {
            playerAttacking();
        }

        else if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.enterPressed) {

            if(keyH.upPressed) { direction = "Up"; }
            else if(keyH.downPressed) { direction = "Down"; }
            else if(keyH.leftPressed) { direction = "Left"; }
            else if(keyH.rightPressed) { direction = "Right"; }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            // CHECK EVENT
            gp.eHandler.checkEvent();

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(!collisionOn && !keyH.enterPressed) {
                switch (direction) {
                    case "Up" -> worldY -= speed;
                    case "Down" -> worldY += speed;
                    case "Left" -> worldX -= speed;
                    case "Right" -> worldX += speed; } }

            gp.keyH.enterPressed = false;

            // Loop animatie
            spriteCounter++;
            if(spriteCounter > 12) {
                if(spriteNumber == 1) { spriteNumber = 2; }
                else if(spriteNumber == 2) { spriteNumber = 1; }
                spriteCounter = 0; } }

        if(invincible) {
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0; } }

        if(life <= 0) {
            gp.gameState = gp.gameOverState;
        }

    }

    public void playerAttacking() {
        spriteCounter++;
        if(spriteCounter <= 5) {
            spriteNumber = 1;
        }
        if(spriteCounter > 5 && spriteCounter <= 25) {
            spriteNumber =2;

            // Save the current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            // Adjust player's worldX/Y for the attackArea
            switch (direction) {
                case "Up" -> worldY -= attackArea.height;
                case "Down" -> worldY += attackArea.height;
                case "Left" -> worldX -= attackArea.width;
                case "Right" -> worldX += attackArea.width;
            }

            // Attack area becomes soldArea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Check monster collision with the updated worldX, worldY and solidArea
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);

            // After checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spriteCounter > 25) {
            spriteNumber = 1;
            spriteCounter = 0;
            attacking = false;
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
                case "KeyG":
                    hasKeyG++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "DoorG":
                    if(hasKeyG > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyG--; }
                    else { gp.ui.showMessage("You need a key!"); }
                    break;
                case "DoorY":
                    if(hasKeyY > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyY--; }
                    else { gp.ui.showMessage("You need a key!"); }
                    break;
                case "DoorB":
                    if(hasKeyB > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened a door!");
                        hasKeyB--; }
                    else { gp.ui.showMessage("You need a key!"); }
                    break;
                case "DoorR":
                    if(hasKeyR > 0) {
                        gp.obj[index] = null;
                        gp.ui.showMessage("You opened the final door!");
                        hasKeyR--;
                        gp.ui.gameFinished = true; }
                    else { gp.ui.showMessage("You need a key!"); }
                    break; } } }

    public void interactNPC(int i) {
        if(gp.keyH.enterPressed) {
            if(i != 999) { gp.gameState = gp.dialogueState; gp.npc[i].speak(); }
            else { attacking = true; } } }

    public void contactMonster(int i) {
        if(i != 999) {
            if(!invincible) {
                life -= 1;
                invincible = true; }
        }
    }

    public void damageMonster(int i) {
        if (i != 999) {
            if (!gp.monster[i].invincible) {
                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();
                if (gp.monster[i].life <= 0) {
                    gp.monster[i].dying = true;
                }
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch (direction) {
            case "Up" -> {
                if (!attacking) {
                    if (spriteNumber == 1) { image = Up1; }
                    if (spriteNumber == 2) { image = Up2; } }
                if (attacking) {
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNumber == 1) { image = AttackU1; }
                    if (spriteNumber == 2) { image = AttackU2; } } }
            case "Down" -> {
                if (!attacking) {
                    if (spriteNumber == 1) { image = Down1; }
                    if (spriteNumber == 2) { image = Down2; } }
                if (attacking) {
                    if (spriteNumber == 1) { image = AttackD1; }
                    if (spriteNumber == 2) { image = AttackD2; } } }
            case "Left" -> {
                if (!attacking) {
                    if (spriteNumber == 1) { image = Left1; }
                    if (spriteNumber == 2) { image = Left2; } }
                if (attacking) {
                    tempScreenX = screenX - gp.tileSize;
                    if (spriteNumber == 1) { image = AttackL1; }
                    if (spriteNumber == 2) { image = AttackL2; } } }
            case "Right" -> {
                if (!attacking) {
                    if (spriteNumber == 1) { image = Right1; }
                    if (spriteNumber == 2) { image = Right2; } }
                if (attacking) {
                    if (spriteNumber == 1) { image = AttackR1; }
                    if (spriteNumber == 2) { image = AttackR2; } } } }

        if(invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, tempScreenX, tempScreenY,null);

        // RESET ALPHA
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
