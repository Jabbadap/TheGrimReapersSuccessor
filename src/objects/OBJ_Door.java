package objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Door extends Entity {

    public OBJ_Door(GamePanel gp) {
        super(gp);

        name = "Door";
        Down1 = setup("tiles/Furniture1", gp.tileSize, gp.tileSize);
        collision = true;
    }
}
