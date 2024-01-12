package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_KeyG extends Entity {

    public OBJ_KeyG(GamePanel gp) {
        super(gp);

        name = "KeyG";
        Down1 = setup("objects/KeyG", gp.tileSize, gp.tileSize);
    }
}
