package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objects.OBJ_Key;
import objects.OBJ_KeyB;
import objects.OBJ_KeyR;
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

    public UserInterface(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;

        OBJ_KeyR keyR = new OBJ_KeyR(gp);
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
        if (gameFinished == true) {

            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.white);

            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize * 3);
            g2.drawString(text, x, y);

            gp.gameThread = null;
        }
        else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, 25, 20, gp.tileSize, gp.tileSize, null);
            g2.drawImage(keyImageR, 25, 80, gp.tileSize, gp.tileSize, null);
            g2.drawImage(keyImageB, 25, 140, gp.tileSize, gp.tileSize, null);
            g2.drawImage(keyImageY, 25, 200, gp.tileSize, gp.tileSize, null);
            g2.drawString("= " + gp.player.hasKey, 75, 55);
            g2.drawString("= " + gp.player.hasKeyR, 75, 115);
            g2.drawString("= " + gp.player.hasKeyB, 75, 175);
            g2.drawString("= " + gp.player.hasKeyY, 75, 235);

            // MESSAGE
            if(messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, 175, 55);

                messageCounter++;

                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

            this.g2 = g2;
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            if(gp.gameState == gp.playState) {
                // Do playstate stuff later
            }
            if(gp.gameState == gp.pauseState) {
                drawPauseScreen();
            }
        }
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN ,80F));
        String text = "PAUSED";
        int x = getXCenterText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public int getXCenterText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.getWidth()/2 - length/2;
        return x;
    }
}
