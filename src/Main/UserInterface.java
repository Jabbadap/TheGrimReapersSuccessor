package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

import objects.OBJ_KeyR;
import objects.OBJ_KeyB;
import objects.OBJ_KeyG;
import objects.OBJ_KeyY;

public class UserInterface {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage keyImage;
    BufferedImage keyImageR;
    BufferedImage keyImageB;
    BufferedImage keyImageY;
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

        OBJ_KeyR key = new OBJ_KeyR(gp);
        keyImage = key.image;

        OBJ_KeyG keyR = new OBJ_KeyG(gp);
        keyImageR = keyR.image;

        OBJ_KeyB keyB = new OBJ_KeyB(gp);
        keyImageB = keyB.image;

        OBJ_KeyY keyY = new OBJ_KeyY(gp);
        keyImageY = keyY.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished) {

            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawString("You found the treasure!", getXCenterText("You found the treasure!"),
                    gp.screenHeight/2 - (gp.tileSize * 3));

            g2.setFont(arial_80B);
            g2.setColor(Color.white);
            g2.drawString("Congratualations!", getXCenterText("Congratualations!")/5,
                    gp.screenHeight/2 + (gp.tileSize * 3));

            gp.gameThread = null;
        }
        else {
            if(gp.player.hasKeyR != 0) {
                g2.drawImage(keyImage, 20, 20, gp.tileSize, gp.tileSize, null);
            }
            if(gp.player.hasKeyG != 0) {
                g2.drawImage(keyImageR, 20, 20, gp.tileSize, gp.tileSize, null);
            }
            if(gp.player.hasKeyB != 0) {
                g2.drawImage(keyImageB, 20, 20, gp.tileSize, gp.tileSize, null);
            }
            if(gp.player.hasKeyY != 0) {
                g2.drawImage(keyImageY, 20, 20, gp.tileSize, gp.tileSize, null);
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
                // Do playstate stuff later
            }

            // PAUSE STATE
            if(gp.gameState == gp.pauseState) {
                drawPauseScreen();
            }

            // DIALOGUE STATE
            if(gp.gameState == gp.dialogueState) {
                drawDialogueScreen();
            }
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

        text = "LOAD GAME";
        x = getXCenterText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">",x-gp.tileSize, y);
        }

        text = "QUIT GAME";
        x = getXCenterText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">",x-gp.tileSize, y);
        }
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN ,80F));
        String text = "PAUSED";
        int x = getXCenterText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
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
}
