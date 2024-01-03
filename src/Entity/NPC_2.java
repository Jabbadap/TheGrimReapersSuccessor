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
        Up1 = setup("player/Up1");
        Up2 = setup("player/Up2");
        Down1 = setup("player/Down1");
        Down2 = setup("player/Down2");
        Left1 = setup("player/Left1");
        Left2 = setup("player/Left2");
        Right1 = setup("player/Right1");
        Right2 = setup("player/Right2");
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
