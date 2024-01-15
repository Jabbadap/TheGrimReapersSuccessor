package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_DoorR extends Entity {


    public OBJ_DoorR(GamePanel gp) {
        super(gp);

        name = "DoorR";
        Down1 = setup("objects/DoorR", gp.tileSize, gp.tileSize);
        collision = true;
    }
}
