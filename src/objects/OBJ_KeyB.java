package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_KeyB extends Entity {

    public OBJ_KeyB(GamePanel gp) {
        super(gp);

        name = "KeyB";
        Down1 = setup("objects/KeyB");
    }
}
