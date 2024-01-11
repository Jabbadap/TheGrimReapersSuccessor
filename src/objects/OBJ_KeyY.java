package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_KeyY extends Entity {

    public OBJ_KeyY(GamePanel gp) {
        super(gp);

        name = "KeyY";
        Down1 = setup("objects/KeyY");
    }
}
