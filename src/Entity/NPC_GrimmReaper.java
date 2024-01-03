package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_GrimmReaper extends Entity {

    public NPC_GrimmReaper(GamePanel gp) {
        super(gp);

        direction = "Down";

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
        dialogues[0] = "Hello";
        dialogues[1] = "You died lol";
    }

    public void speak() {
        super.speak();
    }
}
