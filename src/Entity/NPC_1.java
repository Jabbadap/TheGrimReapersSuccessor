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
        dialogues[2] = "I also found this key, you can have it!";
    }

    @Override
    public void dialogueAction() {
        if (dialogueIndex == 2 && !dialogueFinished) {
            gp.player.hasKeyG = 1;
            // gp.obj[0] = null;
            dialogueFinished = true;
        }
        if(gp.player.hasTeddybear == 1) {
            dialogueIndex = 0;
            if(gp.monster[0] != null) {
                dialogues[0] = "Thank you so much for finding my teddybear and not killing my friend!!";
                gp.player.karma = 1;
            }
            if(gp.monster[0] == null) {
                dialogues[0] = "You killed my friend...\nHow COULD you?";
                gp.player.karma = -1;
            }
            // if(gp.player.hasKeyG == 0) {
            //     gp.player.hasKeyG++;
            //     gp.ui.showMessage("You got a key!");
            // }
        }
    }

    public void speak() {
        super.speak();
    }
}
