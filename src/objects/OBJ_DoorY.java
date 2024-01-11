package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_DoorY extends Entity {

    public OBJ_DoorY(GamePanel gp) {
        super(gp);

        name = "DoorY";
        Down1 = setup("objects/DoorY");
        collision = true;
    }
}
