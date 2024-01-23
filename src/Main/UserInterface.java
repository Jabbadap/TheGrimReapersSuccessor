package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

import Entity.Entity;
import objects.*;

public class UserInterface {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage keyImageR;
    BufferedImage keyImageG;
    BufferedImage keyImageB;
    BufferedImage keyImageY;
    BufferedImage LifeFull, LifeHalf, LifeBlank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;

    public UserInterface(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        OBJ_KeyR keyR = new OBJ_KeyR(gp);
        keyImageR = keyR.Down1;

        OBJ_KeyG keyG = new OBJ_KeyG(gp);
        keyImageG = keyG.Down1;

        OBJ_KeyB keyB = new OBJ_KeyB(gp);
        keyImageB = keyB.Down1;

        OBJ_KeyY keyY = new OBJ_KeyY(gp);
        keyImageY = keyY.Down1;

        // CREATE HUD OBJECT
        Entity life = new OBJ_Life(gp);
        LifeFull = life.image;
        LifeHalf = life.image2;
        LifeBlank = life.image3;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished) {

            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawString("You finished the dungeon!", getXCenterText("You finished the dungeon!"),
                    gp.screenHeight/2 - (gp.tileSize * 3));

            g2.setFont(arial_80B);
            g2.setColor(Color.white);
            g2.drawString("Congratualations!", getXCenterText("Congratualations!")/5,
                    gp.screenHeight/2 + (gp.tileSize * 3));

            gp.gameThread = null;
        }
        else {
            if(gp.player.hasKeyR != 0) {
                g2.drawImage(keyImageR, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            }
            if(gp.player.hasKeyG != 0) {
                g2.drawImage(keyImageG,gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            }
            if(gp.player.hasKeyB != 0) {
                g2.drawImage(keyImageB, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            }
            if(gp.player.hasKeyY != 0) {
                g2.drawImage(keyImageY, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            }

            g2.setFont(arial_40);
            g2.setColor(Color.white);

            // MESSAGE
            if(messageOn) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, 80, 55);

                messageCounter++;

                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

            this.g2 = g2;
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            // TITLE STATE
            if(gp.gameState == gp.titleState) {
                drawTitleScreen();
            }

            // PLAY STATE
            if(gp.gameState == gp.playState) {
                drawPlayerLife();
            }

            // PAUSE STATE
            if(gp.gameState == gp.pauseState) {
                drawPlayerLife();
                drawPauseScreen();
            }

            // DIALOGUE STATE
            if(gp.gameState == gp.dialogueState) {
                drawPlayerLife();
                drawDialogueScreen();
            }

            // GAME OVER STATE
            if(gp.gameState == gp.gameOverState) {
                drawGameOverScreen();
            }
        }
    }

    public void drawPlayerLife() {
        int x = gp.tileSize*12;
        int y = gp.tileSize/2;
        int i = 0;

        // DRAW BLANK LIFE
        while (i < gp.player.maxLife/2) {
            g2.drawImage(LifeBlank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        // RESET
        x = gp.tileSize*12;
        y = gp.tileSize/2;
        i = 0;

        // DRAW CURRENT LIFE
        while (i < gp.player.life) {
            g2.drawImage(LifeHalf, x, y, null);
            i++;
            if(i < gp.player.life) {
                g2.drawImage(LifeFull, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawTitleScreen() {
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, gp.screenWidth,gp.screenHeight);

        // TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Successor";
        int x = getXCenterText(text);
        int y = gp.tileSize * 3;

        // SHADOW
        g2.setColor(Color.GRAY);
        g2.drawString(text, x+5, y+5);

        // MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        // PLAYER IMAGE
        x = gp.screenWidth/2 - gp.tileSize;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.Down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

        // MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXCenterText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">",x-gp.tileSize, y);
        }

        text = "QUIT";
        x = getXCenterText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">",x-gp.tileSize, y);
        }
    }

    public void drawPauseScreen() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

        text = "PAUSED";

        // Shadow
        g2.setColor(Color.black);
        x = getXCenterText(text);
        y = gp.tileSize*4;
        g2.drawString(text, x, y);

        // Main
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);

        // Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "RETRY";
        x = getXCenterText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        // Back to title screen
        text = "MENU";
        x = getXCenterText(text);
        y += 60;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x-gp.tileSize, y);
        }
    }

    public void drawDialogueScreen() {
        // WINDOW
        int x = gp.tileSize/2;
        int y = gp.tileSize * 7 + gp.tileSize/2;
        int width = gp.screenWidth - gp.tileSize;
        int height = gp.tileSize*4;
        drawSubWindow(x, y, width, height);

        // TEXT
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14F));
        x += gp.tileSize;
        y += gp.tileSize;
        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        // WINDOW
        Color c = new Color(0,0,0,190);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        // WHITE OUTLINE
        c = new Color(255,255,255, 180);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-1, 25, 25);
    }

    public int getXCenterText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.getWidth()/2 - length/2;
    }

    public void drawGameOverScreen() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

        text = "GAME OVER";

        // Shadow
        g2.setColor(Color.black);
        x = getXCenterText(text);
        y = gp.tileSize*4;
        g2.drawString(text, x, y);

        // Main
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);

        // Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "RETRY";
        x = getXCenterText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        // Back to title screen
        text = "MENU";
        x = getXCenterText(text);
        y += 60;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x-gp.tileSize, y);
        }
    }
}
