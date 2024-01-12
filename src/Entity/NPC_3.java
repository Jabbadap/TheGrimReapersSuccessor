package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_3 extends Entity {

    public NPC_3(GamePanel gp) {
        super(gp);

        direction = "Down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        // Getting the right image for the right movement
        Up1 = setup("NPC/GrimmU", gp.tileSize, gp.tileSize);
        Up2 = setup("NPC/GrimmU", gp.tileSize, gp.tileSize);
        Down1 = setup("NPC/GrimmD", gp.tileSize, gp.tileSize);
        Down2 = setup("NPC/GrimmD", gp.tileSize, gp.tileSize);
        Left1 = setup("NPC/GrimmL", gp.tileSize, gp.tileSize);
        Left2 = setup("NPC/GrimmL", gp.tileSize, gp.tileSize);
        Right1 = setup("NPC/GrimmR", gp.tileSize, gp.tileSize);
        Right2 = setup("NPC/GrimmR", gp.tileSize, gp.tileSize);
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
