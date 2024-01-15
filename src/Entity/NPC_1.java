package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_1 extends Entity {

    public NPC_1(GamePanel gp) {
        super(gp);

        direction = "Down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        // Getting the right image for the right movement
        Up1 = setup("NPC/NPC1WU1", gp.tileSize, gp.tileSize);
        Up2 = setup("NPC/NPC1WU2", gp.tileSize, gp.tileSize);
        Down1 = setup("NPC/NPC1WD1", gp.tileSize, gp.tileSize);
        Down2 = setup("NPC/NPC1WD2", gp.tileSize, gp.tileSize);
        Left1 = setup("NPC/NPC1WL1", gp.tileSize, gp.tileSize);
        Left2 = setup("NPC/NPC1WL2", gp.tileSize, gp.tileSize);
        Right1 = setup("NPC/NPC1WR1", gp.tileSize, gp.tileSize);
        Right2 = setup("NPC/NPC1WR2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0] = "Hello, my name is...";
        dialogues[1] = "And who are you?";
    }

    public void setAction() {
        actionLockCounter++;
        if(actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i <= 25) {
                direction = "Up";
            }
            if(i > 25 && i <= 50) {
                direction = "Down";
            }
            if(i > 50 && i <= 75) {
                direction = "Left";
            }
            if(i > 75) {
                direction = "Right";
            }
            actionLockCounter = 0;
        }
    }

    public void speak() {
        super.speak();
    }
}
