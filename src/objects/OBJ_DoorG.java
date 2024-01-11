package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_DoorG extends Entity {

    public OBJ_DoorG(GamePanel gp) {
        super(gp);

        name = "DoorG";
        Down1 = setup("objects/DoorG");
        collision = true;
    }
}
