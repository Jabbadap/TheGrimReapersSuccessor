package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_KeyR extends Entity {

    public OBJ_KeyR(GamePanel gp) {
        super(gp);

        name = "KeyR";
        Down1 = setup("objects/KeyR");
    }
}
