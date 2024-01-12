package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_DoorB extends Entity {

    public OBJ_DoorB(GamePanel gp) {
        super(gp);

        name = "DoorB";
        Down1 = setup("objects/DoorB", gp.tileSize, gp.tileSize);
        collision = true;
    }
}
