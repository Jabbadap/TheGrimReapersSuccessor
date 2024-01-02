package Entity;

import Main.GamePanel;

public class NPC_1 extends Entity {

    public NPC_1(GamePanel gp) {
        super(gp);

        direction = "Down";
        speed = 1;

        getImage();
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
}
