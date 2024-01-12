package Monster;

import Entity.Entity;
import Main.GamePanel;

import java.util.Random;

public class MON_Spider extends Entity {

    GamePanel gp;

    public MON_Spider(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = 2;
        name = "Spider";
        speed = 1;
        maxLife = 2;
        life = maxLife;

        solidArea.x = 0;
        solidArea.y = 21;
        solidArea.width = 48;
        solidArea.height = 27;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        Up1 = setup("monster/Spider1", gp.tileSize, gp.tileSize);
        Up2 = setup("monster/Spider2", gp.tileSize, gp.tileSize);
        Down1 = setup("monster/Spider1", gp.tileSize, gp.tileSize);
        Down2 = setup("monster/Spider2", gp.tileSize, gp.tileSize);
        Left1 = setup("monster/Spider1", gp.tileSize, gp.tileSize);
        Left2 = setup("monster/Spider2", gp.tileSize, gp.tileSize);
        Right1 = setup("monster/Spider1", gp.tileSize, gp.tileSize);
        Right2 = setup("monster/Spider2", gp.tileSize, gp.tileSize);
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
}
