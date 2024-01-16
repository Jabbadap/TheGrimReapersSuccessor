package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_1 extends Entity {

    public NPC_1(GamePanel gp) {
        super(gp);

        direction = "Down";

        getImage();

        setDialogue();
    }

    public void getImage() {
        // Getting the right image for the right movement
        Up1 = setup("NPC/NPC1U", gp.tileSize, gp.tileSize);
        Up2 = setup("NPC/NPC1U", gp.tileSize, gp.tileSize);
        Down1 = setup("NPC/NPC1D", gp.tileSize, gp.tileSize);
        Down2 = setup("NPC/NPC1D", gp.tileSize, gp.tileSize);
        Left1 = setup("NPC/NPC1L", gp.tileSize, gp.tileSize);
        Left2 = setup("NPC/NPC1L", gp.tileSize, gp.tileSize);
        Right1 = setup("NPC/NPC1R", gp.tileSize, gp.tileSize);
        Right2 = setup("NPC/NPC1R", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0] = "Hi, I am Tommy!";
        dialogues[1] = "I lost my Teddybear :(\nCan you find him for me?\n" +
                "If you see my friend Bobby please don't hurt him." +
                "\nHe looks a bit scary but he is really nice!\n(If you don't hurt him)";
    }

    @Override
    public void dialogueAction() {
        if(gp.player.hasTeddybear == 1) {
            dialogueIndex = 0;
            if(gp.monster[0] != null) {
                dialogues[0] = "Thank you so much for finding my teddybear and not killing my friend!!";
                dialogues[1] = ":)";
                gp.player.karma = 1;
            }
            if(gp.monster[0] == null) {
                dialogues[0] = "You killed my friend...\nHow COULD you?";
                dialogues[1] = ":(";
                gp.player.karma = -1;
            }
            if(gp.player.hasKeyG == 0) {
                gp.player.hasKeyG++;
                gp.ui.showMessage("You got a key!");
                dialogueFinished = true;
            }
        }
    }

    public void speak() {
        super.speak();
    }
}
