package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_2 extends Entity {

    public NPC_2(GamePanel gp) {
        super(gp);

        direction = "Down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        // Getting the right image for the right movement
        Up1 = setup("NPC/GrimmU");
        Up2 = setup("NPC/GrimmU");
        Down1 = setup("NPC/GrimmD");
        Down2 = setup("NPC/GrimmD");
        Left1 = setup("NPC/GrimmL");
        Left2 = setup("NPC/GrimmL");
        Right1 = setup("NPC/GrimmR");
        Right2 = setup("NPC/GrimmR");
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
